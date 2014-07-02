package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.arch.uploadMulticanale.be.api.ECMType;
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
	public InputStream downloadFile(ECMType ecmType, String ecmFileId) throws AsiaException, Exception {		
		if(ecmType == ECMType.IBM_FILENET) {
			return filenetConnector.downloadFile(ecmFileId);
		} else if(ecmType == ECMType.ALFRESCO) {
			return filenetConnector.downloadFile(ecmFileId);
		} else {
			throw new AsiaException("error code", "ECM_TYPE not reconized.");
		}
	}
}
