package it.bmed.arch.uploadMulticanale.be.service.cmis;

import filenet.ws.client.WSGDIImpl;
import filenet.ws.client.WSGDIImplService;
import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientFactory;
import it.bmed.asia.utility.CommandServiceLocator;

import java.io.InputStream;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

//import arch.bmed.doqbus.be.api.MediaParam;

public class FilenetConnector extends AbstractECMConnector implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(FilenetConnector.class);
	@Autowired
	CommandServiceLocator ejbServiceLocator; // it.bmed.asia.utility.CommandServiceLocatorImpl

	@HandlerChain(file = "handler-chain-be.xml")
	public static class FileNetFactory extends WSGDIImplService implements AsiaWsClientFactory<WSGDIImpl> {
		public FileNetFactory() {
			// TODO Auto-generated constructor stub
			super();

		}

		public WSGDIImpl getPort() {
			return this.getWSGDIImpl();
		}

		@Override
		public QName getServiceName() {			
			return this.getServiceName();
		}
	}
	
	@Override
	public String createFile(byte[] buffer, String containerType, String filename, String fileExtension, String appName, String destinationPath, ECMFile ecmFile) {		
		logger.info("createFile call.");
		try {
			WSGDIImpl serviceFileNet = (WSGDIImpl) ejbServiceLocator.getWsClient(FileNetFactory.class);
			// Encoding file in base64 preparing the xml transformation
//			String encodeFile = (Util.encodeFileToBase64Binary(buffer));			
//			String xml = FilenetRequest.encodeXML(encodeFile, ecmFile);
//			serviceFileNet.addObject(xml);
		} catch (Exception e) {
			logger.error("createFile " + e.getMessage());			
		}
		
		return null;
	}

	@Override
	public boolean removeFile(String ecmFileId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InputStream downloadFile(String ecmFileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(ejbServiceLocator.getClass().getName());
	}


}
