package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.exceptions.CmisConnectionException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisContentAlreadyExistsException;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;

public class AlfrescoConnector extends AbstractECMConnector {
	private static final Logger logger = LoggerFactory.getLogger(AlfrescoConnector.class);
	
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
		properties.put(PropertyIds.NAME, ecmFile.getNameFile());
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
			folder = (Folder) session.getObjectByPath(ecmFile.getDestinationPath());
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
			return convertStreamToString(stream);			
		} catch (Exception e) {
			logger.error("downloadFile " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", e.getMessage());
		}
	}
}
