package it.bmed.arch.uploadMulticanale.be.service.cmis;

import filenet.ws.client.WSGDIImpl;
import filenet.ws.client.WSGDIImplService;
import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientFactory;
import it.bmed.asia.utility.CommandServiceLocator;

import java.io.InputStream;
import java.io.StringReader;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class FilenetConnector extends AbstractECMConnector implements
		InitializingBean {
	private static final Logger logger = LoggerFactory
			.getLogger(FilenetConnector.class);
	@Autowired
	CommandServiceLocator ejbServiceLocator; // it.bmed.asia.utility.CommandServiceLocatorImpl

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
			WSGDIImpl serviceFileNet = (WSGDIImpl) ejbServiceLocator
					.getWsClient(FileNetFactory.class);
			// Encoding file in base64 preparing the xml transformation
			String encodeFile = (Util.encodeFileToBase64Binary(buffer));
			String xml = Util.encodeXML(encodeFile, ecmFile, ecmParam);
			String response = serviceFileNet.addObject(xml);
			idFilenet = getIdFilenet(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("createFile " + e.getMessage());
		}
		return idFilenet;
	}

	@Override
	public boolean removeFile(String ecmFileId) {
		logger.info("removeFile call.");
		ECMFile ecmFile = new ECMFile();
		ECMParam ecmParam = new ECMParam();
		try {
			WSGDIImpl serviceFileNet = (WSGDIImpl) ejbServiceLocator.getWsClient(FileNetFactory.class);
			String xml = Util.encodeXML(ecmFile);
			serviceFileNet.deleteObject(xml);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("removeFile " + e.getMessage());
		}
		return false;
	}

	@Override
	public InputStream downloadFile(String ecmFileId) {
		// TODO Auto-generated method stub
		return null;
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

}
