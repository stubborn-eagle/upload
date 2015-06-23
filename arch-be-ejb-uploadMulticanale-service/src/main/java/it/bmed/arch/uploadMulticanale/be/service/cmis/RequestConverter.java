package it.bmed.arch.uploadMulticanale.be.service.cmis;

import java.util.HashMap;
import java.util.Map;

import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import it.bmed.arch.uploadMulticanale.be.api.FileProperty;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;



import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


public class RequestConverter implements Converter {

	public boolean canConvert(Class test) {		
		return test.equals(Request.class);
	}

	static Logger log = LoggerFactory.getLogger(RequestConverter.class);
	
//	@Autowired
//	private DefinedMetaData metadata;
	/**
	 * LISTA DI METADATI COME COMUNICATA DA ROBERTA PATERLINI IL 9 FEBBRAIO 2015
	 */
	private Map<String, String> properties;
	{
		properties = new HashMap<String, String>();
		properties.put("CODICEFISCALE", "CODICEFISCALE");
		properties.put("CODICEDOC", "CODICEDOC");
		properties.put("DATARIF", "DATARIF");
		properties.put("ISTITUTO", "ISTITUTO");
		properties.put("NDG", "NDG");
		properties.put("LETTO", "LETTO");
		properties.put("TIPO MIME", "TIPO MIME");
		properties.put("RAPPORTO", "RAPPORTO");
		properties.put("TITOLO DOCUMENTO", "TITOLO DOCUMENTO");
		properties.put("LAYOUTLETTO", "LAYOUTLETTO");
		properties.put("STATODOCUMENTO", "STATODOCUMENTO");
		properties.put("DATAVARIAZIONESTATO", "DATAVARIAZIONESTATO");
		properties.put("DESCRCODICESOTTOCLASSE", "DESCRCODICESOTTOCLASSE");
		properties.put("CODICESOTTOCLASSE", "CODICESOTTOCLASSE");
		properties.put("NOMECLASSE", "NOMECLASSE");
		properties.put("STATER", "STATER");
		properties.put("ANNO", "ANNO");
		properties.put("AZIENDA", "AZIENDA");
		properties.put("CATEGORIA", "CATEGORIA");
		properties.put("CODAGENTE", "CODAGENTE");
		properties.put("CODPRODOTTO", "CODPRODOTTO");
		properties.put("COMIDDOC", "COMIDDOC");
		properties.put("COMIDLAVORO", "COMIDLAVORO");
		properties.put("DATAPROD", "DATAPROD");
		properties.put("DESCRDOC", "DESCRDOC");
		properties.put("DOCIDIS", "DOCIDIS");
		properties.put("FILIALE", "FILIALE");
		properties.put("FILIALECEDACRI", "FILIALECEDACRI");
		properties.put("FORNITARCHFISICA", "FORNITARCHFISICA");
		properties.put("FORNITIMMAGINI", "FORNITIMMAGINI");
		properties.put("IDDOCCLIENTE", "IDDOCCLIENTE");
		properties.put("IDLAVORO", "IDLAVORO");
		properties.put("IDLOTTOCLIENTE", "IDLOTTOCLIENTE");
		properties.put("MESE", "MESE");
		properties.put("NOMINATIVO", "NOMINATIVO");
		properties.put("NUMEROSCATOLA", "NUMEROSCATOLA");
		properties.put("NUMPAG", "NUMPAG");
		properties.put("ORIGINE", "ORIGINE");
		properties.put("PROFILO", "PROFILO");
		properties.put("PROGISTR", "PROGISTR");
		properties.put("PROGRESSIVO", "PROGRESSIVO");
		properties.put("PROPINFORETE", "PROPINFORETE");
		properties.put("PROPOSTA", "PROPOSTA");
		properties.put("SERVIZIO", "SERVIZIO");
		properties.put("SOTTOSISTEMA", "SOTTOSISTEMA");
		properties.put("TIPO", "TIPO");
		properties.put("TIPOOPERAZ", "TIPOOPERAZ");
		properties.put("TIPOPROD", "TIPOPROD");
		properties.put("TOKEN", "TOKEN");
		properties.put("VISIBILITA", "VISIBILITA");
		properties.put("CONTENTID", "CONTENTID");
		properties.put("NOMEDOC", "NOMEDOC");
		properties.put("FLAGSRACCOMANDATA", "FLAGSRACCOMANDATA");
		properties.put("NUMASS", "NUMASS");
		properties.put("ABIASS", "ABIASS");
		properties.put("CABASS", "CABASS");
		properties.put("NUMTICKET", "NUMTICKET");
		properties.put("DESCRWEB", "DESCRWEB");
		properties.put("FILIALENUM", "FILIALENUM");
		properties.put("NUMCONTO", "NUMCONTO");
		properties.put("PREKIT", "PREKIT");
		properties.put("IDCENTERA", "IDCENTERA");
		properties.put("ADOBEDOCID", "ADOBEDOCID");
		properties.put("NUMEROPRIT", "NUMEROPRIT");
		properties.put("CODICEDOCACCESSO", "CODICEDOCACCESSO");
		properties.put("DOCINORIGINALE", "DOCINORIGINALE");
		properties.put("FIRMAINORIGINALE", "FIRMAINORIGINALE");
		properties.put("PROGRESSIVODOCINPRIT", "PROGRESSIVODOCINPRIT");
		properties.put("PROGRESSIVODOCPINZATOA", "PROGRESSIVODOCPINZATOA");
		properties.put("BARCODE", "BARCODE");
		properties.put("PROTOCOLLO", "PROTOCOLLO");
		properties.put("FLAGESTRAZIONEFIRMA", "FLAGESTRAZIONEFIRMA");
		properties.put("IBAN", "IBAN");
		properties.put("IDPRATICA", "IDPRATICA");
		properties.put("IDPRATICAWF", "IDPRATICAWF");
		properties.put("FATTURA", "FATTURA");
		properties.put("NUMORDINE", "NUMORDINE");
		properties.put("AMBITO", "AMBITO");
		properties.put("FILIALEOLD", "FILIALEOLD");
		properties.put("RAPPORTOOLD", "RAPPORTOOLD");
		properties.put("UTENTECREATORE", "UTENTECREATORE");
		properties.put("UTENTEMODIFICATORE", "UTENTEMODIFICATORE");
		properties.put("NOMINATIVO_AGENTE", "NOMINATIVO_AGENTE");
		properties.put("PROGPROTOCOLLO", "PROGPROTOCOLLO");
	}

	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		// System.out.println("MARSHAL -->");
		Request request = (Request) value;

		// writer.setValue(request.getObjectStore().getValue());
//		try {
			if (request.getObjectStore().getValue() != null && request.getObjectStore().getValue().length() > 0) {
				writer.startNode("ObjectStore");
				writer.addAttribute("value", request.getObjectStore().getValue());
				writer.endNode();
			} else {
				writer.startNode("ObjectStore");
				writer.addAttribute("value", "");
				writer.endNode();
			}
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "value");
//		}

//		try {
			if (request.getObjectClass().getValue() != null && request.getObjectClass().getValue().length() > 0) {
				writer.startNode("ObjectClass");
				writer.addAttribute("value", request.getObjectClass().getValue());
				writer.endNode();
			} else {
				writer.startNode("ObjectClass");
				writer.addAttribute("value", "");
				writer.endNode();
			}
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "ObjectClass");
//		}
//		try {

//			writer.startNode("Index");
//			writer.addAttribute("name", (request.getIndex().getName() != null && request.getIndex().getName().length() > 0) ? request.getIndex().getName() : "");
//			writer.addAttribute("search", (request.getIndex().getSearch() != null && request.getIndex().getSearch().length() > 0 ) ? request.getIndex().getSearch() : "");
//			writer.startNode("Value");
//			writer.setValue((request.getIndex().getValue().getValue() != null && request.getIndex().getValue().getValue() .length() > 0)?request.getIndex().getValue().getValue() : "");
//			writer.endNode();
//			writer.endNode();
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "Index");
//		}
			HashMap<String, String> settedMetadati = new  HashMap<String, String>();
			if(request!=null && request.getProperty()!=null && request.getProperty().size()>0){
				for(FileProperty metadato : request.getProperty()){
					log.debug("PROPERTY NAME: "+metadato.getName());
					log.debug("PROPERTY VALUE: "+metadato.getValue());
					if(properties.containsKey(metadato.getName().toUpperCase())){
//						writer.startNode(metadato.getName());
//						writer.addAttribute("value", metadato.getValue());
//						writer.endNode();
						writer.startNode("Index");
						writer.addAttribute("name", metadato.getName());
						writer.addAttribute("search", "true");
						writer.startNode("Value");
						writer.setValue(metadato.getValue() != null ?metadato.getValue() : "");
						writer.endNode();
						writer.endNode();
						settedMetadati.put(metadato.getName().toUpperCase(), metadato.getValue());
					}
					
				}
			}

		try {
			if (settedMetadati.containsKey("ISTITUTO")) {
				writer.startNode("Istituto");
				writer.addAttribute("value",settedMetadati.get("ISTITUTO"));
				writer.endNode();
			} else {
				writer.startNode("Istituto");
				writer.addAttribute("value", "");
				writer.endNode();
			}
		} catch (Exception e) {
			log.warn("Errore nel creare il nodo {} ", "Index");
		}
		/**
		 * Attualmente non è previsto un metadato "MATRICOLA", così come da lista comunicata
		 */
		try {
			if (settedMetadati.containsKey("MATRICOLA")) {
				writer.startNode("Matricola");
				writer.addAttribute("value", request.getMatricola().getValue());
				writer.endNode();
			} else {
				writer.startNode("Matricola");
				writer.addAttribute("value", "0");
				writer.endNode();
			}
		} catch (Exception e) {
			log.warn("Errore nel creare il nodo {} ", "Matricola");
		}
		/**
		 * Attualmente non è previsto un metadato "RUOLO", così come da lista comunicata
		 */
		try {
			if (settedMetadati.containsKey("RUOLO")) {
				writer.startNode("Ruolo");
				writer.addAttribute("value", request.getRuolo().getValue());
				writer.endNode();
			} else {
				writer.startNode("Ruolo");
				writer.addAttribute("value", "0");
				writer.endNode();
			}
		} catch (Exception e) {
			log.warn("Errore nel creare il nodo {} ", "Ruolo");
		}
		try {
			if (settedMetadati.containsKey("FILIALE")) {
				writer.startNode("Filiale");
				writer.addAttribute("value", settedMetadati.get("FILIALE"));
				writer.endNode();
			} else {
				writer.startNode("Filiale");
				writer.addAttribute("value", "");
				writer.endNode();
			}
		} catch (Exception e) {
			log.warn("Errore nel creare il nodo {} ", "Filiale");
		}
//		try {
			if (request.getSearchAction().getValue() != null && request.getSearchAction().getValue().length() > 0) {
				writer.startNode("SearchAction");
				writer.addAttribute("value", request.getSearchAction().getValue());
				writer.endNode();
			} else {
				writer.startNode("SearchAction");
				writer.addAttribute("value", " ");
				writer.endNode();
			}
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "SearchAction");
//		}
		// File f = new File("C://DevRootMediolanum//test.txt");
		// System.out.println("FILE : "+f.toString());
		// byte[] stream;
		// String encodeFile="";
		// try {
		// stream = Util.readFile(f);
		// encodeFile =(Util.encodeFileToBase64Binary(stream));
		// System.out.println("CODIFICA FILE"+encodeFile);
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		try {
			writer.startNode("DocContent");
			writer.addAttribute("filename", (request.getDocContent().getFileName() != null && request.getDocContent().getFileName().length()> 0)? request.getDocContent().getFileName() : "");
			writer.addAttribute("mimetype", (request.getDocContent().getMimetype() != null && request.getDocContent().getMimetype().length() > 0 ) ? request.getDocContent().getMimetype() : "");
			writer.setValue(request.getDocContent().getFilecod());
			writer.endNode();
		} catch (Exception e) {
			log.warn("Errore nel creare il nodo {} ", "DocContent");
		}

	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		System.out.println("unmarshal");
		System.out.println("reader -" + reader.getNodeName());
		Request request = new Request();
		reader.moveDown();
		// if(!"Request".equals(reader.getNodeName())){
		request.getObjectStore().setValue(reader.getValue());
		reader.moveUp();
		// }
		return request;
	}

}
