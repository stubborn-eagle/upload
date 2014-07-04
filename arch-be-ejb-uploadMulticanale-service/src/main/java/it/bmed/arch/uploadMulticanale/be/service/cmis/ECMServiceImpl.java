package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import org.springframework.beans.factory.InitializingBean;

public class ECMServiceImpl implements ECMService, InitializingBean {
	
	private AlfrescoConnector alfrescoConnector = null;	
	private FilenetConnector filenetConnector = null;
	
	private static final Logger logger = LoggerFactory.getLogger(ECMServiceImpl.class);
	

	/**
	 * @param alfrescoConnector the alfrescoConnector to set
	 */
	public void setAlfrescoConnector(AlfrescoConnector alfrescoConnector) {
		this.alfrescoConnector = alfrescoConnector;
		logger.info("alfrescoConnectore injected with " + alfrescoConnector.getClass().getName());
	}

	/**
	 * @param filenetConnector the filenetConnector to set
	 */
	public void setFilenetConnector(FilenetConnector filenetConnector) {		
		this.filenetConnector = filenetConnector;
		logger.info("filenetConnector injected with " + filenetConnector.getClass().getName());
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		if (alfrescoConnector == null) {
			throw new Exception("ERROR: alfrescoConnector not injected");
		} else {
			try {
				alfrescoConnector.createConnection();
			} catch (Exception e) {
				logger.error("afterPropertiesSet: alfrescoConnector cannot create connection. " + e.getMessage());
				throw e;
			}
		}
		if (filenetConnector == null) {
			throw new Exception("ERROR: filenetConnector not injected");
		} /* 
		else {
			try {
				filenetConnector.createConnection();
			} catch (Exception e) {
				logger.error("afterPropertiesSet: filenetConnector cannot create connection. " + e.getMessage());
				throw e;
			}
		}*/
	}
	
	@Override
	public String createFile(byte[] byteStream, ECMFile ecmFile, ECMParam ecmParam)
			throws AsiaException, Exception {
		
		if( ecmFile.getEcmType() == ECMType.IBM_FILENET ) {		
			return filenetConnector.createFile(byteStream, ecmFile, ecmParam);
		} else if( ecmFile.getEcmType() == ECMType.ALFRESCO) {
			return alfrescoConnector.createFile(byteStream, ecmFile, ecmParam);
		} else {			
			throw new AsiaException("error code", "ECM_TYPE not reconized.");			
		}
	}

	@Override
	public boolean removeFile(ECMType ecmType, String ecmFileId) throws AsiaException, Exception {
		if( ecmType == ECMType.IBM_FILENET) {
			return filenetConnector.removeFile(ecmFileId);
		} else if( ecmType == ECMType.ALFRESCO) {
			return alfrescoConnector.removeFile(ecmFileId);
		} else {
			throw new AsiaException("error code", "ECM_TYPE not reconized.");
		}
	}

	@Override
	public String downloadFile(ECMType ecmType, String ecmFileId) throws AsiaException, Exception {		
		if(ecmType == ECMType.IBM_FILENET) {
			return filenetConnector.downloadFile(ecmFileId);
		} else if(ecmType == ECMType.ALFRESCO) {
			return filenetConnector.downloadFile(ecmFileId);
		} else {
			throw new AsiaException("error code", "ECM_TYPE not reconized.");
		}
	}
}
