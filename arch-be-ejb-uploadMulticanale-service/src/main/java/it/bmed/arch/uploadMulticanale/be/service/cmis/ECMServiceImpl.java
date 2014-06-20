package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.arch.uploadMulticanale.be.api.MediaDTO;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.InputStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class ECMServiceImpl implements ECMService, InitializingBean {
	
	private AlfrescoConnector alfrescoConnector = null;	
	private FilenetConnector filenetConnector = null;
	
	private static final Logger logger = LoggerFactory.getLogger(ECMServiceImpl.class);
	

	/**
	 * @param alfrescoConnector the alfrescoConnector to set
	 */
	@Autowired
	public void setAlfrescoConnector(AlfrescoConnector alfrescoConnector) {
		this.alfrescoConnector = alfrescoConnector;
	}

	/**
	 * @param filenetConnector the filenetConnector to set
	 */
	@Autowired
	public void setFilenetConnector(FilenetConnector filenetConnector) {
		this.filenetConnector = filenetConnector;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		if (alfrescoConnector == null) {
			throw new Exception("ERROR: alfrescoConnector not injected");
		} else {
			alfrescoConnector.createConnection();
		}
		if (filenetConnector == null) {
			throw new Exception("ERROR: filenetConnector not injected");
		} else {
			filenetConnector.createConnection();
		}
	}
	
	@Override
	public String createFile(ECMType ecmType, byte[] byteStream,
			String containerType, String filename, String fileExtension,
			String appName, String destinationPath, MediaDTO mediaDTO)
			throws AsiaException, Exception {		
		switch (ecmType) {
		case ALFRESCO:
			return alfrescoConnector.createFile(byteStream, destinationPath, filename);
		case IBM_FILENET:
			return filenetConnector.createFile(byteStream, destinationPath, filename);
		default:
			break;
		}
		throw new AsiaException("error code", "ECM_TYPE not reconized.");
	}

	@Override
	public boolean removeFile(ECMType ecmType, String ecmFileId)
			throws AsiaException, Exception {
		// TODO Auto-generated method stub
		switch (ecmType) {
		case ALFRESCO:
			return alfrescoConnector.removeFile(ecmFileId);
		case IBM_FILENET:
			return filenetConnector.removeFile(ecmFileId);
		default:
			break;
		}
		throw new AsiaException("error code", "ECM_TYPE not reconized.");
	}

	@Override
	public InputStream downloadFile(ECMType ecmType, String ecmFileId) throws AsiaException, Exception {		
		switch (ecmType) {
		case ALFRESCO:
			return alfrescoConnector.downloadFile(ecmFileId);
		case IBM_FILENET:
			return filenetConnector.downloadFile(ecmFileId);
		default:
			break;
		}
		throw new AsiaException("error code", "ECM_TYPE not reconized.");
	}
}
