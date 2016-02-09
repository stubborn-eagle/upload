package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.arch.uploadMulticanale.be.api.FileProperty;
import it.bmed.asia.api.CommonUtils;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Util {

	static Logger logger = LoggerFactory.getLogger(Util.class);

	public static String encodeXML(FilenetRequestType requestType, String base64FileContent, ECMFile ecmFile, ECMParam ecmParam) throws Exception {
		logger.info("encodeXML for " + requestType.toString());
		String xml = null;		
		switch (requestType) {		
		case CREATE_REQUEST:
			if (base64FileContent != null && base64FileContent.length() > 0 && ecmFile != null && ecmParam != null) {
				xml = encodeXMLToCreate(base64FileContent, ecmFile, ecmParam);
			} else {
				throw new IllegalArgumentException("Arguments cannot be null in Filenet create operation.");
			}
			break;
		case CREATE_REQUEST_WITH_METADATA:
			if (base64FileContent != null && base64FileContent.length() > 0 && ecmFile != null && ecmParam != null) {
				xml = encodeXMLToCreateWithMetadata(base64FileContent, ecmFile, ecmParam);
			} else {
				throw new IllegalArgumentException("Arguments cannot be null in Filenet create operation.");
			}
			break;
		
		case DELETE_REQUEST:
			if (ecmFile != null) {
				xml = encodeXMLToDelete(ecmFile);
			} else {
				throw new IllegalArgumentException("ECMFile cannot be null in Filenet delete operation.");
			}			
			break;
		
		case DOWNLOAD_REQUEST:
			if (ecmFile != null) {
				xml = encodeXMLToDownload(ecmFile);
			} else {
				throw new IllegalArgumentException("ECMFile cannot be null in Filenet download operation.");
			}
			break;
		
		default:
			xml = "";
			break;
		}
		
		return xml;
	}
	
	private static String encodeXMLToDownload(ECMFile ecmFile) {
		logger.info("encodeXMLToDownload params: " + ecmFile);
		DownloadRequest request = new DownloadRequest();				
		String fileToXML = null;
		ObjectStore objectStore = new ObjectStore();
		ObjectClass objectClass = new ObjectClass();
		IndexDelete index = new IndexDelete();
		Istituto istituto = new Istituto();
		Matricola matricola = new Matricola();
		Ruolo ruolo = new Ruolo();
		Filiale filiale = new Filiale();
		PdfDisablePrint pdfDisablePrint = new PdfDisablePrint();
		Convert convert = new Convert();

		// Initializing variables
		objectClass.setValue(ecmFile.getContainerType());
		objectStore.setValue("CED088");

		index.setName("ID");
		index.setOperator("=");
		index.setValue(ecmFile.getIdFileECM());
		
		istituto.setValue("");
		matricola.setValue("");
		ruolo.setValue("");
		filiale.setValue("");
		pdfDisablePrint.setValue("false");
		convert.setValue("");

		// Initializing request
		request.setObjectStore(objectStore);
		request.setObjectClass(objectClass);
		request.setIndex(index);
		request.setIstituto(istituto);
		request.setMatricola(matricola);
		request.setRuolo(ruolo);
		request.setFiliale(filiale);
		request.setPdfDisablePrint(pdfDisablePrint);
		request.setConvert(convert);

		XStream xStream = new XStream(new DomDriver());
		xStream.registerConverter(new DownloadRequestConverter());
		xStream.alias("DownloadRequest", DownloadRequest.class);
		logger.debug("Request filenet {} ", CommonUtils.bean2string(request));
		fileToXML = xStream.toXML(request);
		logger.debug("encodeXML: XML {} ",fileToXML);
		return fileToXML;
	}

	private static String encodeXMLToCreate(String fileCodificato, ECMFile ecmFile,
			ECMParam ecmParam) throws Exception {
		logger.info("encodeXML call.");
		Request request = new Request();
		String fileToXML;
		// DICHIARATI TUTTI QUI PER GESTIRE SETTAGGIO DEL VALUE
		ObjectStore objectStore = new ObjectStore();
		ObjectClass objectClass = new ObjectClass();
		Index index = new Index();
		Value value = new Value();
		Istituto istituto = new Istituto();
		Matricola matricola = new Matricola();
		Ruolo ruolo = new Ruolo();
		Filiale filiale = new Filiale();
		SearchAction searchAction = new SearchAction();
		DocContent docContent = new DocContent();
		// °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
		try {
			for (FileProperty prop : ecmParam.getProperty()) {
				// if("ObjectStore".equalsIgnoreCase(prop.getName())){
				// // objectStore.setValue(prop.getValue());
				// //DEVE ESSERE IL SEGUENTE??
				// objectStore.setValue("CED088");
				// }
				if ("Istituto".equalsIgnoreCase(prop.getName())) {
					istituto.setValue(prop.getValue());
				}
				if ("Matricola".equalsIgnoreCase(prop.getName())) {
					matricola.setValue(prop.getValue());
				}
				if ("Ruolo".equalsIgnoreCase(prop.getName())) {
					ruolo.setValue(prop.getValue());
				}
				if ("Filiale".equalsIgnoreCase(prop.getName())) {
					filiale.setValue(prop.getValue());
				}
				// if("SearchAction".equalsIgnoreCase(prop.getName())){
				// // searchAction.setValue(prop.getValue());
				// //DEVE ESSERE IL SEGUENTE??
				// searchAction.setValue("AddVersion");
				// }
			}

			objectStore.setValue("CED088");
			request.setObjectStore(objectStore);
			
			
			objectClass.setValue(ecmParam.getContainerType());
			request.setObjectClass(objectClass);
			
			searchAction.setValue("AddVersion");

			index.setName("CODICEDOC");
			index.setSearch("false");
			value.setValue("");
			index.setValue(value);
			request.setIndex(index);

			// istituto.setValue("");
			request.setIstituto(istituto);

			// matricola.setValue("");
			request.setMatricola(matricola);

			// ruolo.setValue("");
			request.setRuolo(ruolo);

			// filiale.setValue("");
			request.setFiliale(filiale);

			// searchAction.setValue("AddVersion");
			request.setSearchAction(searchAction);

			docContent.setFileName(ecmFile.getIdFile().toString());
			docContent.setMimetype(ecmFile.getType());
			// SETTO IL FILECODIFICATO IN BASE64 PER CREARE XML
			docContent.setFilecod(fileCodificato);
			request.setDocContent(docContent);

			XStream xStream = new XStream(new DomDriver());
			xStream.registerConverter(new RequestConverter());
			xStream.alias("Request", Request.class);
			logger.debug("Request filenet {} ",
					CommonUtils.bean2string(request));
			// System.out.println("TOXML: ");
			fileToXML = xStream.toXML(request);
			// log.debug("XML {} ",fileToXML);

			return fileToXML;
		} catch (Exception e) {
			logger.error("encodeXML " + e.getMessage());
			throw e;
		}
		// Request requestFromXML = (Request)
		// xStream.fromXML(xStream.toXML(request));
		// System.out.println(requestFromXML);

	}
	
	private static String encodeXMLToCreateWithMetadata(String fileCodificato, ECMFile ecmFile, ECMParam ecmParam) throws Exception {
		logger.info("encodeXML call.");
		RequestWithMetadata request = new RequestWithMetadata();
		String fileToXML;
		// DICHIARATI TUTTI QUI PER GESTIRE SETTAGGIO DEL VALUE
		ObjectStore objectStore = new ObjectStore();
		ObjectClass objectClass = new ObjectClass();
		Istituto istituto = new Istituto();
		Matricola matricola = new Matricola();
		Ruolo ruolo = new Ruolo();
		Filiale filiale = new Filiale();
		SearchAction searchAction = new SearchAction();
		DocContent docContent = new DocContent();
		// °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
		try {
			List<Index> indexes = new ArrayList<Index>();
			for (FileProperty prop : ecmParam.getProperty()) {
				// if("ObjectStore".equalsIgnoreCase(prop.getName())){
				// // objectStore.setValue(prop.getValue());
				// //DEVE ESSERE IL SEGUENTE??
				// objectStore.setValue("CED088");
				// }
				if ("Istituto".equalsIgnoreCase(prop.getName())) {
					istituto.setValue(prop.getValue());
				}else if ("Matricola".equalsIgnoreCase(prop.getName())) {
					matricola.setValue(prop.getValue());
				}else if ("Ruolo".equalsIgnoreCase(prop.getName())) {
					ruolo.setValue(prop.getValue());
				}else if ("Filiale".equalsIgnoreCase(prop.getName())) {
					filiale.setValue(prop.getValue());
				}
				else if(!"SearchAction".equalsIgnoreCase(prop.getName())){
					Index index = new Index();
					index.setName(prop.getName());
					index.setSearch("false");
					Value value = new Value();
					value.setValue(prop.getValue());
					index.setValue(value);
					indexes.add(index);
				}
				// if("SearchAction".equalsIgnoreCase(prop.getName())){
				// // searchAction.setValue(prop.getValue());
				// //DEVE ESSERE IL SEGUENTE??
				// searchAction.setValue("AddVersion");
				// }
			}

			objectStore.setValue("CED088");
			request.setObjectStore(objectStore);
			
			
			objectClass.setValue(ecmParam.getContainerType());
			request.setObjectClass(objectClass);
			
			searchAction.setValue("AddVersion");

//			Index indexCodiceDoc = new Index();
//			indexCodiceDoc.setName("CODICEDOC");
//			indexCodiceDoc.setSearch("false");
//			Value value = new Value();
//			value.setValue("");
//			indexCodiceDoc.setValue(value);
//			indexes.add(indexCodiceDoc);
			request.setIndexes(indexes);

			// istituto.setValue("");
			request.setIstituto(istituto);

			// matricola.setValue("");
			request.setMatricola(matricola);

			// ruolo.setValue("");
			request.setRuolo(ruolo);

			// filiale.setValue("");
			request.setFiliale(filiale);

			// searchAction.setValue("AddVersion");
			request.setSearchAction(searchAction);

			docContent.setFileName(ecmFile.getIdFile().toString());
			docContent.setMimetype(ecmFile.getType());
			// SETTO IL FILECODIFICATO IN BASE64 PER CREARE XML
			docContent.setFilecod(fileCodificato);
			request.setDocContent(docContent);

			XStream xStream = new XStream(new DomDriver());
			xStream.registerConverter(new RequestConverterWithMetadata());
			xStream.alias("Request", RequestWithMetadata.class);
			logger.debug("Request filenet {} ",
					CommonUtils.bean2string(request));
			// System.out.println("TOXML: ");
			fileToXML = xStream.toXML(request);
			// log.debug("XML {} ",fileToXML);

			return fileToXML;
		} catch (Exception e) {
			logger.error("encodeXML " + e.getMessage());
			throw e;
		}
		// Request requestFromXML = (Request)
		// xStream.fromXML(xStream.toXML(request));
		// System.out.println(requestFromXML);

	}
	
	public static void main(String[] args) throws Exception{
		String fileCodificato = "aaaContentaaa";
		ECMFile ecmFile = new ECMFile();
		ecmFile.setIdFile(111);
		ecmFile.setType("typePDF");
		ECMParam ecmParam = new ECMParam();
		ecmParam.setContainerType("containerTypePDF");
		ArrayList<FileProperty> property = new ArrayList<FileProperty>();
		FileProperty propertyIstituto = new FileProperty();
		propertyIstituto.setName("Istituto");
		propertyIstituto.setValue("IstitutoPDF");
		property.add(propertyIstituto);
		FileProperty propertyMatricola = new FileProperty();
		propertyMatricola.setName("Matricola");
		propertyMatricola.setValue("MatricolaPDF");
		property.add(propertyMatricola);
		FileProperty propertyRuolo = new FileProperty();
		propertyRuolo.setName("Ruolo");
		propertyRuolo.setValue("RuoloPDF");
		property.add(propertyRuolo);
		FileProperty propertyFiliale = new FileProperty();
		propertyFiliale.setName("Filiale");
		propertyFiliale.setValue("FilialePDF");
		property.add(propertyFiliale);
		ecmParam.setProperty(property);
		
		FileProperty property1 = new FileProperty();
		property1.setName("property1");
		property1.setValue("property1Value");
		property.add(property1);
		FileProperty property2 = new FileProperty();
		property2.setName("property2");
		property2.setValue("property2Value");
		property.add(property2);
		FileProperty property3 = new FileProperty();
		property3.setName("property3");
		property3.setValue("property3Value");
		property.add(property3);
		
		System.out.println("encodeXMLToCreate:"+encodeXMLToCreateWithMetadata(fileCodificato, ecmFile, ecmParam));
	}

	/**
	 * encodeXML method for deleteObject
	 * @author donatello.boccaforno
	 * @param ecmFile
	 * @return The requst mashalled xml as <b>String</b>
	 */
	private static String encodeXMLToDelete(ECMFile ecmFile) {
		DeleteRequest request = new DeleteRequest();
		
		logger.info("encodeXML params: " + ecmFile);
		String fileToXML;
		ObjectStore objectStore = new ObjectStore();
		ObjectClass objectClass = new ObjectClass();
		IndexDelete index = new IndexDelete();
		ForceDeleteSubDocuments force = new ForceDeleteSubDocuments();
		

		// Initializing variables
		objectClass.setValue(ecmFile.getContainerType());
		objectStore.setValue("CED088");

		index.setName("ID");
		index.setOperator("=");
		index.setValue(ecmFile.getIdFileECM());
		
		force.setValue("false");

		// Initializing request
		request.setObjectStore(objectStore);
		request.setObjectClass(objectClass);
		request.setIndex(index);
		request.setForceDeleteSubDocuments(force);

		XStream xStream = new XStream(new DomDriver());
		xStream.registerConverter(new DeleteRequestConverter());
		xStream.alias("DeleteRequest", DeleteRequest.class);
		logger.debug("Request filenet {} ", CommonUtils.bean2string(request));
		fileToXML = xStream.toXML(request);
		logger.debug("encodeXML: XML {} ",fileToXML);
		return fileToXML;
	}

	public static String encodeFileToBase64Binary(byte[] stream)
			throws Exception {

		byte[] encoded = Base64.encodeBase64(stream);
		String encodedString = new String(encoded);

		return encodedString;

	}
	
	public static byte[] decodeBase64ToFile(String base64) throws Exception {

		return Base64.decodeBase64(base64);

	}

	public static byte[] readFile(File file) throws IOException, Exception {

		// *************************************************************************
		// Inizializzo le variabili
		// *************************************************************************
		logger.debug("Nome file {} ", file.getPath());

		InputStream is = null;
		byte[] bytes;

		try {

			// *************************************************************************
			// Leggo il file
			// *************************************************************************

			is = new FileInputStream(file);
			long length = file.length();
//			if (length > Integer.MAX_VALUE) {
//
//				// File is too large
//
//				// TODO
//
//			}

			bytes = new byte[(int) length];

			// *************************************************************************
			// Verifica
			// *************************************************************************

			int offset = 0;
			int numRead = 0;

			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {

				offset += numRead;

			}

			if (offset < bytes.length) {

				throw new IOException("Could not completely read file "
						+ file.getName());

			}

		} finally {

			if (is != null)
				is.close();

		}

		// *************************************************************************

		// response

		// *************************************************************************

		return bytes;

	}

}