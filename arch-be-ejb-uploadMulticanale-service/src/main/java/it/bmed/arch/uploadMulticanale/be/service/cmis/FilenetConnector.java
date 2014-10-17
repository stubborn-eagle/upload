package it.bmed.arch.uploadMulticanale.be.service.cmis;

import static it.bmed.arch.uploadMulticanale.be.service.cmis.FilenetRequestType.CREATE_REQUEST;
import static it.bmed.arch.uploadMulticanale.be.service.cmis.FilenetRequestType.DELETE_REQUEST;
import static it.bmed.arch.uploadMulticanale.be.service.cmis.FilenetRequestType.DOWNLOAD_REQUEST;
import filenet.ws.client.WSGDIImpl;
import filenet.ws.client.WSGDIImplService;
import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientBuilder;
import it.bmed.asia.utility.AsiaWsClientFactory;
import it.bmed.asia.utility.CommandServiceLocator;

import java.io.IOException;
import java.io.StringReader;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.BindingProvider;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FilenetConnector extends AbstractECMConnector implements
		InitializingBean {
	private static final Logger logger = LoggerFactory
			.getLogger(FilenetConnector.class);
	@Autowired
	private CommandServiceLocator ejbServiceLocator; // it.bmed.asia.utility.CommandServiceLocatorImpl
	private String filenetUrl = null;

	@HandlerChain(file = "handler-chain-be.xml")
	public static class FileNetFactory extends WSGDIImplService implements
			AsiaWsClientFactory<WSGDIImpl> {
		public FileNetFactory() {
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
	public String createFile(byte[] buffer, ECMFile ecmFile, ECMParam ecmParam) {
		String idFilenet = null;
		logger.info("createFile call.");
		try {
			WSGDIImpl serviceFileNet = (WSGDIImpl) getWsClient(FileNetFactory.class);
			// Encoding file in base64 preparing the xml transformation
			String encodeFile = (Util.encodeFileToBase64Binary(buffer));
			String xml = Util.encodeXML(CREATE_REQUEST, encodeFile, ecmFile, ecmParam);
			logger.debug("createFile xml"+xml);
			String response = serviceFileNet.addObject(xml);
			idFilenet = getIdFilenet(response);
		} catch (Exception e) {
			logger.error("createFile " + e.getMessage());
			e.printStackTrace();
			for(int i=0; i < e.getStackTrace().length; i++){
				logger.error("STACK"+e.getStackTrace()[i]);
			}
			
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "createFile error", e);
		}
		return idFilenet;
	}
	
	
	public <SERVICE,FACT extends AsiaWsClientFactory<SERVICE>> SERVICE getWsClient(Class<FACT> factoryClass)  throws Exception {
		
		FACT realService = factoryClass.newInstance();
		SERVICE port = (SERVICE) realService.getPort();
		BindingProvider bp = (BindingProvider) port;
		String url = getFilenetUrl(); 
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		bp.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 15000); // inserire altre due variabili nel web.xml
		bp.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 5000);  //


		return port;
	}

	@Override
	public boolean removeFile(String ecmFileId) {		
		logger.info("removeFile call.");
		ECMFile ecmFile = new ECMFile();
		ECMParam ecmParam = new ECMParam();
		try {
			WSGDIImpl serviceFileNet = (WSGDIImpl) getWsClient(FileNetFactory.class);

			String xml = Util.encodeXML(DELETE_REQUEST, null, ecmFile, null);
			serviceFileNet.deleteObject(xml);
			return true;
		} catch (Exception e) {
			logger.error("removeFile " + e.getMessage());
//			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "removeFile error", e);
		}
		return false;
	}
	
	
	public boolean removeFile(String ecmFileId, String containerType) {
		logger.info("removeFile call.");
		ECMFile ecmFile = new ECMFile();
		ecmFile.setContainerType(containerType);
		ecmFile.setIdFileECM(ecmFileId);				
		try {
			WSGDIImpl serviceFileNet = (WSGDIImpl) getWsClient(FileNetFactory.class);

			String xml = Util.encodeXML(DELETE_REQUEST, null, ecmFile, null);
			serviceFileNet.deleteObject(xml);
			return true;
		} catch (Exception e) {
			logger.error("removeFile " + e.getMessage());
//			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "removeFile error", e);
		}
		return false;
	}

	@Override
	public String downloadFile(String ecmFileId) {
		String downloadedFile = null;
		try {
			ECMFile ecmFile = new ECMFile();
			WSGDIImpl serviceFileNet = (WSGDIImpl) getWsClient(FileNetFactory.class);
			String xml = Util.encodeXML(DOWNLOAD_REQUEST, null, ecmFile, null); 
			String response = serviceFileNet.getDocumentContent(xml);
			downloadedFile = getDocContentFromResponse(response);
		} catch (Exception e) {
			logger.error("downloadFile " + e.getMessage());
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "downloadFile error", e);
		}
		return downloadedFile;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("ejbServiceLocator injected with " + ejbServiceLocator.getClass().getName());
	}

	private String getIdFilenet(String response) {
		// String response =
		// "<Response><ReturnCode>0</ReturnCode><ReturnValue><Object id=\"{1178EC68-BBD5-4469-8DFA-929DF8C66B8E}\" objectstore=\"CED088\" class=\"DISPOSIZIONIANOMALE\" basetype=\"Document\"><Readers/><Link><Value>/WSGDI/View?sessionId=j%2BGXDzZ4g7Yw1YvezbEmk55YsG4VroSKKVCZRuM9I%2F9Gvl5D2SpeQIH%2FrF6AkfNZ3ZJgWdrEb10%3D&amp;docId=j%2BGXDzZ4g7Yw1YvezbEmk55YsG4VroSKKVCZRuM9I%2F8szEfv25KoIA%3D%3D&amp;os=tKgBgM2BPqg%3D</Value></Link></Object></ReturnValue></Response>";
		try {
			XPathFactory xpathFact = XPathFactory.newInstance();
			XPath xpath = xpathFact.newXPath();
			String pathId = "Response/ReturnValue/Object/@id";
			DocumentBuilderFactory xmlFact = DocumentBuilderFactory
					.newInstance();
			xmlFact.setNamespaceAware(false);
			DocumentBuilder builder = xmlFact.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(
					response)));
			String id = xpath.compile(pathId)
					.evaluate(doc, XPathConstants.STRING).toString();
			return id;
		} catch (Exception e) {
			logger.error("Errore nel recuperare l'id", e);
			return "";
		}
	}
	
	/**
	 * Retrieve the document content from the xml response
	 * @author donatello.boccaforno
	 * @param response
	 * @return The document content as <b>String</b> 
	 */
	private String getDocContentFromResponse(String response) {
		String documentContent = null;
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();
		String expression = "Response/DocContent";
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(false);
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new InputSource(new StringReader(response)));
			documentContent = xPath.compile(expression).evaluate(document, XPathConstants.STRING).toString();
		} catch (ParserConfigurationException e) {
			logger.error("getDocContentFromResponse " + e.getMessage());
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "getDocContentFromResponse ParseConfigurationException", e);
		} catch (SAXException e) {
			logger.error("getDocContentFromResponse " + e.getMessage());
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "getDocContentFromResponse SAXException", e);
		} catch (IOException e) {
			logger.error("getDocContentFromResponse " + e.getMessage());
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "getDocContentFromResponse IOException", e);
		} catch (XPathExpressionException e) {
			logger.error("getDocContentFromResponse " + e.getMessage());
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "getDocContentFromResponse XPathExpressionException", e);
		}
		return documentContent;
	}


	@Override
	public String getECMToken(String request) throws AsiaException {
		// TODO Auto-generated method stub
		return null;
	}


	public String getFilenetUrl() {
		return filenetUrl;
	}


	public void setFilenetUrl(String filenetUrl) {
		this.filenetUrl = filenetUrl;
	}

}
