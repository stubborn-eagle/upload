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

import org.apache.commons.codec.binary.Base64;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Util {

	static Logger log = LoggerFactory.getLogger(Util.class);

	public static String encodeXML(String fileCodificato, ECMFile ecmFile, ECMParam ecmParam ) {
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

		for (FileProperty prop : ecmParam.getProperty()) {
			if ("ObjectClass".equals(prop.getName())) {
				objectClass.setValue(ecmFile.getContainerType());
			}
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

		// objectClass.setValue("");
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
		log.debug("Request filenet {} ", CommonUtils.bean2string(request));
		// System.out.println("TOXML: ");
		fileToXML = xStream.toXML(request);
		// log.debug("XML {} ",fileToXML);

		return fileToXML;

		// Request requestFromXML = (Request)
		// xStream.fromXML(xStream.toXML(request));
		// System.out.println(requestFromXML);

	}
	/**
	 * encodeXML method for deleteObject
	 * @param ecmFile
	 * @return
	 */
	public static String encodeXML(ECMFile ecmFile) {
		DeleteRequest request = new DeleteRequest();
		String fileToXML;
		// DICHIARATI TUTTI QUI PER GESTIRE SETTAGGIO DEL VALUE
		ObjectStore objectStore = new ObjectStore();
		ObjectClass objectClass = new ObjectClass();
		IndexDelete index = new IndexDelete();

		// Initializing variables
		objectClass.setValue(ecmFile.getContainerType());
		objectStore.setValue("CED088");
		
		index.setName("ID");
		index.setOperator("=");
		index.setValue(ecmFile.getIdFileECM());

		// Initializing request
		request.setObjectStore(objectStore);
		request.setObjectClass(objectClass);
		request.setIndex(index);

		XStream xStream = new XStream(new DomDriver());
		xStream.registerConverter(new DeleteRequestConverter());
		xStream.alias("DeleteRequest", DeleteRequest.class);
		log.debug("Request filenet {} ", CommonUtils.bean2string(request));
		// System.out.println("TOXML: ");
		fileToXML = xStream.toXML(request);
		// log.debug("XML {} ",fileToXML);
		return fileToXML;
	}

	public static String encodeFileToBase64Binary(byte[] stream)
			throws Exception {

		byte[] encoded = Base64.encodeBase64(stream);
		String encodedString = new String(encoded);

		return encodedString;

	}

	public static byte[] readFile(File file) throws IOException, Exception {

		// *************************************************************************
		// Inizializzo le variabili
		// *************************************************************************
		log.debug("Nome file {} ", file.getPath());

		InputStream is = null;
		byte[] bytes;

		try {

			// *************************************************************************
			// Leggo il file
			// *************************************************************************

			is = new FileInputStream(file);
			long length = file.length();
			if (length > Integer.MAX_VALUE) {

				// File is too large

				// TODO

			}

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