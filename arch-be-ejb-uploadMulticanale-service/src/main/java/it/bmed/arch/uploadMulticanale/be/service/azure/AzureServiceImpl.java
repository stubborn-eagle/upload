package it.bmed.arch.uploadMulticanale.be.service.azure;

import it.bmed.arch.uploadMulticanale.be.api.AzureDTO;
import it.bmed.arch.uploadMulticanale.be.api.AzureRequest;
import it.bmed.arch.uploadMulticanale.be.service.azure.exception.InvalidAzureContainerException;
import it.bmed.arch.uploadMulticanale.be.service.azure.exception.InvalidAzureExpirationTimeException;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.microsoft.windowsazure.services.blob.client.CloudBlobClient;
import com.microsoft.windowsazure.services.blob.client.CloudBlobContainer;
import com.microsoft.windowsazure.services.blob.client.CloudBlockBlob;
import com.microsoft.windowsazure.services.blob.client.SharedAccessBlobPermissions;
import com.microsoft.windowsazure.services.blob.client.SharedAccessBlobPolicy;
import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;

/**
 * Integration class for Azure Token generation It also provides methods for
 * azure url creation and upload/download blob
 * 
 */
@Service("azureService")
public class AzureServiceImpl implements AzureService {
	private static final Logger log = LoggerFactory.getLogger(AzureServiceImpl.class);
	/**
	 * Limit of expiration time
	 */
	private Integer safeOffestMinutes = null;
	private Integer azureMaxExpirationTime = null;
	private String connectionString = null;
//	private static final int SAFE_OFFSET_MINUTES = Integer.parseInt(AzureMessages.getString("AzureServiceImpl.SafeOffsetStartTimeMinutes")); 
//	private static final int AZURE_MAX_EXPIRATION_TIME = Integer.parseInt(AzureMessages.getString("AzureServiceImpl.MaxExpirationTimeMinutes")); 	
//	private String connectionString = AzureMessages.getString("AzureServiceImpl.Azure.ConnectionString"); //$NON-NLS-1$
	

	@Override
	public AzureDTO generateToken(AzureRequest parameters) throws AsiaException, Exception {

		// VALIDATION CHECK
		if (parameters.getTargetContainer() == null) { 
			throw new InvalidAzureContainerException (AzureMessages.getString("AzureServiceImpl.ContainerCannotBeNull")); //$NON-NLS-1$
		}
		if (parameters.getExpirationTime() == null) { 
			throw new InvalidAzureExpirationTimeException(AzureMessages.getString("AzureServiceImpl.ExpirationTimeCannotBeNull")); //$NON-NLS-1$
		}
		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC")); //$NON-NLS-1$
		calendar.setTime(new Date());

		if (parameters.getExpirationTime().getTime() - calendar.getTimeInMillis() > azureMaxExpirationTime * 60 * 1000) {
			throw new InvalidAzureExpirationTimeException(AzureMessages.getString("AzureServiceImpl.ExpirationTimeExceedsMaximumTimeAllowed") //$NON-NLS-1$
							+ azureMaxExpirationTime
							+ AzureMessages.getString("AzureServiceImpl.strMinutes")); //$NON-NLS-1$
		}

		try {
			if (parameters.isSafeOffset()) {				
				calendar.add(Calendar.MINUTE, - safeOffestMinutes); // safe range due to clock skew
			}
			// TOKEN GENERATION
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(connectionString);
			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
			CloudBlobContainer container = blobClient.getContainerReference(parameters.getTargetContainer()); //$NON-NLS-1$
			SharedAccessBlobPolicy policy = new SharedAccessBlobPolicy();
			policy.setSharedAccessStartTime(calendar.getTime()); // Immediately
			policy.setSharedAccessExpiryTime(parameters.getExpirationTime());

			if (parameters.isReadOnly()) {
				policy.setPermissions(EnumSet.of(SharedAccessBlobPermissions.READ)); // SAS grants																// READ ONLY
			} else {
				policy.setPermissions(EnumSet.of(SharedAccessBlobPermissions.READ, SharedAccessBlobPermissions.WRITE)); // SAS grants READ/WRITE
			}

			String sas = null;
			CloudBlockBlob cloudBlockBlob = null;
			
			if (parameters.getResourceBlobFile() != null) {				
				cloudBlockBlob = container.getBlockBlobReference(parameters.getResourceBlobFile());
				sas = cloudBlockBlob.generateSharedAccessSignature(policy, null);
			} else {
				sas = container.generateSharedAccessSignature(policy, null);
			}

			// RESPONSE GENERATION

			AzureDTO azureDTO = new AzureDTO();
			azureDTO.setSAS(sas);
			azureDTO.setExpiredTime(policy.getSharedAccessExpiryTime());
			azureDTO.setStartTime(policy.getSharedAccessStartTime());
			azureDTO.setContainer(parameters.getTargetContainer());
			
			if (parameters.getResourceBlobFile() != null) {
				azureDTO.setResourceBlobFile(parameters.getResourceBlobFile());
				azureDTO.setURI(cloudBlockBlob.getUri() + "?" + sas);
			} else {
				azureDTO.setURI(container.getUri() + "?" + sas);
			}

			log.debug("AZURE Token generated successfully for container: " + azureDTO.getContainer() + AzureMessages.getString("AzureServiceImpl.strExpireDate") + azureDTO.getExpiredTime() +  " URI = " + azureDTO.getURI()); //$NON-NLS-1$ //$NON-NLS-2$
			return azureDTO;

		} catch (Exception e) {
			log.error("AZURE Token generation error", e.getMessage()); //$NON-NLS-1$
			throw new AsiaException(
					"AZURE001", "AZURE Token generation error:" + e.getMessage()); //$NON-NLS-1$ //$NON-NLS-2$
		}

	}


	/**
	 * @param safeOffestMinutes the safeOffestMinutes to set
	 */
	public void setSafeOffestMinutes(Integer safeOffestMinutes) {
		this.safeOffestMinutes = safeOffestMinutes;
	}


	/**
	 * @param azureMaxExpirationTime the azureMaxExpirationTime to set
	 */
	public void setAzureMaxExpirationTime(Integer azureMaxExpirationTime) {
		this.azureMaxExpirationTime = azureMaxExpirationTime;
	}


	/**
	 * @param connectionString the connectionString to set
	 */
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

}
