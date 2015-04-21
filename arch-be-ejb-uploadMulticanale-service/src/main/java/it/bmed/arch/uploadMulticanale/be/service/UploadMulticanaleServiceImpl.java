package it.bmed.arch.uploadMulticanale.be.service;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.dao.UploadMulticanaleDaoJdbcTemplate;
import it.bmed.asia.exception.ApplicationException;
import it.bmed.asia.exception.IErrorCode;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UploadMulticanaleService")
public class UploadMulticanaleServiceImpl implements UploadMulticanaleService,
		InitializingBean {
	Logger log = LoggerFactory.getLogger(UploadMulticanaleServiceImpl.class);

	@Autowired
	UploadMulticanaleDaoJdbcTemplate uploadMulticanaleDaoJdbcTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("uploadMulticanaleDaoJdbcTemplate: " + uploadMulticanaleDaoJdbcTemplate.getClass().getName());
		if (uploadMulticanaleDaoJdbcTemplate == null)
			throw new Exception(
					"ERROR: uploadMulticanaleDaoJdbcTemplate not injected");
	}

	@Override
	public ECMResponse insertMedia(ECMRequest request) throws TechnicalException, Exception {
		ECMResponse response = new ECMResponse();
		try {
			// check required parameters
			checkRequiredParametersInsertMedia(request);
			// check parameters max length
			checkParametersLengthInsertMedia(request);

			log.debug(" insertMedia: parametri  corretti.");
			
			response = uploadMulticanaleDaoJdbcTemplate.insertMedia(request);
			return response;
		} catch (ApplicationException e) {
			log.error("insertMedia: errorCode " + e.getErrorCode() + ", errorDescription " + e.getErrorDescription());
			throw e;

		} catch (RuntimeException e) {
			log.error("insertMedia: " + e.getMessage());
			throw e;
		} 

	}

	@Override
	public ECMResponse listMedia(ECMRequest request) throws TechnicalException, Exception {
		try {
			
			checkRequiredParametersListMedia(request);
			
			checkParametersLengthListMedia(request);
						
			ECMResponse response = new ECMResponse();
			response = uploadMulticanaleDaoJdbcTemplate.listMedia(request);

			return response;

		} catch (ApplicationException e) {
			log.error("Errore  listMedia getErrorCode {}_getErrorDescription {}  "
					+ e.getErrorCode() + "_" + e.getErrorDescription());
			throw e;

		} catch (RuntimeException e) {
			log.error("Errore listMedia in Servizio");
			throw e;
		}

	}

	@Override
	public boolean updateMedia(UpdateECMRequest request) throws TechnicalException, Exception {
		try {
			boolean res;

			// controllo campi obbligatori
			checkRequiredParametersUpdateMedia(request);

			// controllo lunghezza del campo di input stato
			checkParametersLengthUpdateMedia(request);
			
			res = uploadMulticanaleDaoJdbcTemplate.updateMedia(request);
			return res;

		} catch (ApplicationException e) {

			log.error("Errore updateMedia:    ApplicationException ");
			throw e;

		} catch (RuntimeException e) {
			log.error("Errore updateMedia in Servizio");
			log.error("Errore getJdbcTemplate() RuntimeException");
			throw e;
		}

	}
	
	/**
	 * Check where required parameters are null and throws TechnicalException
	 * @param request as <b>UpdateECMRequest</b>
	 * @throws TechnicalException
	 */
	private void checkRequiredParametersInsertMedia(ECMRequest request) throws TechnicalException {
		final String methodName = "checkRequiredParametersInsertMedia";
		final String cause = "Parameter cannot be null.";
		
		if(request == null) {
			parameterError(methodName, "ECMRequest", cause);
		}
		
		ECMFile ecmFile = request.getEcmFile();
		if(ecmFile == null) {
			parameterError("checkRequiredParametersInsertMedia", "ECMFile", cause);
		}
		
		if(ecmFile.getChannel() == null) {	// length is not checked here
			parameterError(methodName, "channel", cause);
		}
		
		if (ecmFile.getUserId() == null) {
			parameterError(methodName, "userId", cause);
		}
		
		if (ecmFile.getNameApp() == null) {
			parameterError(methodName, "nameApp", cause);
		}
		
		if (ecmFile.getNameFile() == null) {
			parameterError(methodName, "nameFile", cause);
		}
		
		if (ecmFile.getSourcePath() == null ) {
			parameterError(methodName, "sourcePath", cause);
		}
		
		if (ecmFile.getSource() == null) {
			parameterError(methodName, "source", cause);
		}
		
		if (ecmFile.getState() == null) {
			parameterError(methodName, "state", cause);
		}		
	}
	
	/**
	 * Check where required parameters exceed max length and throws TechnicalException 
	 * @param request
	 * @throws TechnicalException
	 */
	private void checkParametersLengthInsertMedia(ECMRequest request) throws TechnicalException {
		final String method = "checkParametersLengthInsertMedia";
		final String emptyCause = "Parameter cannot be empty.";
		final String exeedCause = "Parameter max length exceeded.";
		
		ECMFile ecmFile = request.getEcmFile();
		
		// Required field
		if (ecmFile.getChannel().isEmpty()) {
			parameterError(method, "channel", emptyCause);
		}
		if (ecmFile.getChannel().length() > 15) {
			parameterError(method, "channel", exeedCause);
		}
		
		// Not required field		
//		if (ecmFile.getContainerType().isEmpty()) {
//			parameterError(method, "containerType", emptyCause);
//		}		
		if (ecmFile.getContainerType() != null && ecmFile.getContainerType().length() > 30) {
			parameterError(method, "containerType", exeedCause);
		}
		
		if (ecmFile.getIdFileECM() != null && ecmFile.getIdFileECM().length() > 500) {
			parameterError(method, "idFileECM", exeedCause);
		}
		
		if (ecmFile.getUserId().isEmpty()) {
			parameterError(method, "userId", emptyCause);
		}
		if (ecmFile.getUserId().length() > 16) {
			parameterError(method, "userId", exeedCause);
		}
		
		if(ecmFile.getNameApp().isEmpty()) {
			parameterError(method, "nameApp", emptyCause);
		}
		if(ecmFile.getNameApp().length() > 100) {
			parameterError(method, "nameApp", exeedCause);
		}
		
		if(ecmFile.getNameFile().isEmpty()) {
			parameterError(method, "nameFile", emptyCause);
		}
		if(ecmFile.getNameFile().length() > 100) {
			parameterError(method, "nameFile", exeedCause);
		}
		
		if(ecmFile.getSourcePath() != null && ecmFile.getSourcePath().length() > 500) {
			parameterError(method, "sourcePath", exeedCause);
		}
		
		if(ecmFile.getDestinationPath() != null && ecmFile.getDestinationPath().length() > 200) {
			parameterError(method, "destinationPath", exeedCause);
		}		
				
	}
	
	/**
	 * Check where required parameters exceed max length and throws TechnicalException 
	 * @param request
	 * @throws TechnicalException
	 */
	private void checkParametersLengthListMedia(ECMRequest request) throws TechnicalException {
		final String method = "checkParametersLengthListMedia";
		final String cause = "Parameter max length exceeded.";
		ECMFile ecmFile = request.getEcmFile();
			
		if (ecmFile.getChannel() != null && ecmFile.getChannel().length() > 15) {
			parameterError(method, "channel", cause);
		} 
		
		if (ecmFile.getUserId() != null && ecmFile.getUserId().length() > 16) {
			parameterError(method, "userId", cause);
		}
		
		if (ecmFile.getUserType() != null && ecmFile.getUserType().length() > 50) {
			parameterError(method, "userType", cause);
		}		
		
		if (ecmFile.getIdFileECM() != null && ecmFile.getIdFileECM().length() > 500) {
			parameterError(method, "idFileECM", cause);
		}
	}

	/**
	 * Check where required parameters are null and throws TechnicalException
	 * @param request as <b>UpdateECMRequest</b>
	 * @throws TechnicalException
	 */
	private void checkRequiredParametersListMedia(ECMRequest request) throws TechnicalException {
		final String method = "checkRequiredParametersListMedia";
		final String cause = "Parameter cannot be null.";
		
		if(request == null) {
			parameterError(method, ECMRequest.class.getName(), cause);
		}
		
		if(request.getEcmFile() == null) {
			parameterError(method, ECMFile.class.getName(), cause);
		}
		
		
	}
	
	/**
	 * Check where required parameters exceed max length and throws TechnicalException 
	 * @param request
	 * @throws TechnicalException
	 */
	private void checkParametersLengthUpdateMedia(final UpdateECMRequest request) throws TechnicalException {
		final String methodNAme = "checkParametersLengthUpdateMedia";
		final String cause = "Parameter max length exceeded.";
	
		if(request.getIdFileECM().length() > 500) {
			parameterError(methodNAme, "idFileECM", cause);
		}
		
		if(request.getContainerType().length() > 50) {
			parameterError(methodNAme, "ContainerType", cause);
		}
		
		if (request.getDestinationPath().length() > 200) {
			parameterError(methodNAme, "DestinationPath", cause);
		}
		
		if (request.getNameApp().length() > 100) {
			parameterError(methodNAme, "NAmeApp", cause);
		}					
	}
	
	/**
	 * Check where required parameters are null and throws TechnicalException
	 * @param request as <b>UpdateECMRequest</b>
	 * @throws TechnicalException
	 */
	private void checkRequiredParametersUpdateMedia(UpdateECMRequest request) throws TechnicalException {
		final String methodName = "checkRequiredParametersUpdateMedia";
		final String cause = "Parameter cannot be null.";
		
		if (request.getIdFile() == null || request.getIdFile() <= 0) {
			parameterError(methodName, "idFile", cause);
		}
		
		if (request.getState() == null ) {
			parameterError(methodName, "State", cause);
		}
		
		if (request.getNameApp().isEmpty()) {
			parameterError(methodName, "NameApp", cause);
		}
	}
	
	/**
	 * Logs and throws TechnocalExceptions, based on called method and parameter name
	 * @param method as <b>String</b>
	 * @param parameter as <b>String</b> 
	 * @throws TechnicalException
	 */
	private void parameterError(String method, String parameter, String cause) throws TechnicalException {
		log.error(method + ": " + parameter +" parameter error. " + cause);
		IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
		TechnicalException tec = new TechnicalException(er);
		throw tec;
	}

}
