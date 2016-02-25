package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.arch.uploadMulticanale.be.api.FileProperty;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.exceptions.CmisConnectionException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisContentAlreadyExistsException;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;
import org.springframework.beans.factory.InitializingBean;
import org.xml.sax.InputSource;

public class AlfrescoConnector extends AbstractECMConnector implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(AlfrescoConnector.class);
	
	  
	  private static final String WEBSRIPT_LOGIN_URL = "/alfresco/service/api/login";
	
	
	public AlfrescoConnector() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String createFile(byte[] buffer, ECMFile ecmFile, ECMParam ecmParam) throws AsiaException {

		// throw new AsiaException("TCH_ECM_ERROR", "createFile - argument cannot be null!");
		logger.debug("createFile: creating " + ecmFile.getNameFile() + "." + ecmFile.getType());

		String fileId = "";
		Document document = null;
//		ObjectId folderId = null;
//		Folder rootFolder = null;
		Folder folder = null;
		ContentStream contentStream = null;
//		final String mimetype = "text/plain; charset=UTF-8";
		
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
		properties.put(PropertyIds.NAME, ecmFile.getNameFile()+ "." + ecmFile.getType());
		//properties.put(PropertyIds.CREATED_BY, "cmis:")
	
		// check connection
		if (session == null) {
			logger.warn("createFile: session timeout.");
			try {
				// re-initialise session
				createConnection();				
			} catch (CmisConnectionException cce) {
				logger.error("createFile - connection error.");
				throw new AsiaException("TCH_ECM_ERROR", cce.getMessage());
			} catch (Exception e) {
				logger.error("createFile: " + e.getMessage());				
				throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
			}
		}
		try {
			//rootFolder = session.getRootFolder();
			String pathWithSlash = "/"+ecmParam.getDestinationPath();
			folder = (Folder) session.getObjectByPath(pathWithSlash);
			InputStream inputStream = new ByteArrayInputStream(buffer);
			contentStream = new ContentStreamImpl(ecmFile.getNameFile() + "." + ecmFile.getType(), BigInteger.valueOf(buffer.length), "", inputStream);
			// document = (Document) session.getObjectByPath(destinationPath + "/" + filename);
			document = folder.createDocument(properties, contentStream, VersioningState.MAJOR);
			fileId  = document.getId();
			logger.debug("createFile: created file with id " + fileId);
			//System.out.println("Connection created: rootFolderId = " + folderId);
		} catch (CmisContentAlreadyExistsException e) {
			logger.debug("createFile: " + e.getMessage() + "'" + session.getObjectByPath(ecmFile.getDestinationPath() + "/" + ecmFile.getNameFile() + "." + ecmFile.getType()).getId() + "'");
		} catch (Exception e) {
			logger.error("createFile: " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
		}
		return fileId;
	}
	
	@Override
	public String createFileWithMetadata(byte[] buffer, ECMFile ecmFile, ECMParam ecmParam) throws AsiaException {

		// throw new AsiaException("TCH_ECM_ERROR", "createFile - argument cannot be null!");
		logger.debug("createFile: creating " + ecmFile.getNameFile() + "." + ecmFile.getType());

		String fileId = "";
		Document document = null;
//		ObjectId folderId = null;
//		Folder rootFolder = null;
		Folder folder = null;
		ContentStream contentStream = null;
//		final String mimetype = "text/plain; charset=UTF-8";
		
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
		properties.put(PropertyIds.NAME, ecmFile.getNameFile()+ "." + ecmFile.getType());
		for(FileProperty fileProperty : ecmParam.getProperty()){
			if(!fileProperty.getName().equalsIgnoreCase(PropertyIds.OBJECT_TYPE_ID) && !fileProperty.getName().equalsIgnoreCase(PropertyIds.NAME)){
				properties.put(fileProperty.getName(), fileProperty.getValue());
			}
		}
		//properties.put(PropertyIds.CREATED_BY, "cmis:")
	
		// check connection
		if (session == null) {
			logger.warn("createFile: session timeout.");
			try {
				// re-initialise session
				createConnection();				
			} catch (CmisConnectionException cce) {
				logger.error("createFile - connection error.");
				throw new AsiaException("TCH_ECM_ERROR", cce.getMessage());
			} catch (Exception e) {
				logger.error("createFile: " + e.getMessage());				
				throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
			}
		}
		try {
			//rootFolder = session.getRootFolder();
			String pathWithSlash = "/"+ecmParam.getDestinationPath();
			folder = (Folder) session.getObjectByPath(pathWithSlash);
			InputStream inputStream = new ByteArrayInputStream(buffer);
			contentStream = new ContentStreamImpl(ecmFile.getNameFile() + "." + ecmFile.getType(), BigInteger.valueOf(buffer.length), "", inputStream);
			// document = (Document) session.getObjectByPath(destinationPath + "/" + filename);
			document = folder.createDocument(properties, contentStream, VersioningState.MAJOR);
			fileId  = document.getId();
			logger.debug("createFile: created file with id " + fileId);
			//System.out.println("Connection created: rootFolderId = " + folderId);
		} catch (CmisContentAlreadyExistsException e) {
			logger.debug("createFile: " + e.getMessage() + "'" + session.getObjectByPath(ecmFile.getDestinationPath() + "/" + ecmFile.getNameFile() + "." + ecmFile.getType()).getId() + "'");
		} catch (Exception e) {
			logger.error("createFile: " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
		}
		return fileId;
	}

	@Override
	public boolean removeFile(String ecmFileId) throws AsiaException {
		logger.debug("Alfresco Connector removeFile: Entering");
		if(ecmFileId == null || ecmFileId.length() == 0) {
			logger.error("removeFile - The argument cannot be null ore empty.");
			throw new AsiaException("TCH_ECM_ERROR", "The argument cannot be null or empty.");
		}
		logger.debug("removeFile " + ecmFileId);
		boolean result = false;
		try {
			Document doc = (Document) session.getObject(ecmFileId);
			doc.delete();
			result = true;
		} catch (Exception e) {
			logger.error("removeFile - " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
		}
		logger.debug("removeFile - removed = " + result);
		logger.debug("Alfresco Connector removeFile: Exiting");
		return result;
	}
	@Override
	public String downloadFile(String ecmFileId) throws AsiaException {
		InputStream stream = null;
		Document document = null;		
		try {					
			logger.debug("downloadFile " + ecmFileId);
			document = (Document) session.getObject(ecmFileId);
			stream = document.getContentStream().getStream();
			logger.debug("downloadFile returned successfully");
			String result = convertStreamToString(stream);
			if(result!=null){
				logger.debug("result size : "+result.length());
			}
			return result;			
		} catch (Exception e) {
			logger.error("downloadFile " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
		}
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet: " + getClass().getName());
	}
	@Override
	public String getECMToken(String request) throws AsiaException {

		String response = ""; //$NON-NLS-1$
		try
		{
			String data = getLoginData();
			String urlTmp = alfrescoUrl + WEBSRIPT_LOGIN_URL + data;

			URL url = new URL(urlTmp);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET"); //$NON-NLS-1$
			conn.setRequestProperty("Content-Type", "application/json"); //$NON-NLS-1$ //$NON-NLS-2$
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output;
			while ((output = br.readLine()) != null) {
				response = response + output;
			}
			conn.disconnect();
			return extractTicket(response);
		}
		catch (MalformedURLException e)
		{
			logger.error("getECMToken " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
		}
		catch (IOException e)
		{
			logger.error("getECMToken " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
		} catch (Exception e) {
			logger.error("getECMToken " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
		}
		
	}


	
	
		private  String extractTicket(String ticket) throws Exception
		  {
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    InputSource is = new InputSource(new StringReader(ticket));
		    return builder.parse(is).getFirstChild().getTextContent();
		  }
		  
		  private  String getLoginData()
		  {
		    String data = "?u=" + user + "&pw=" + password; //$NON-NLS-1$ //$NON-NLS-2$
		    return data;
		  }
}
