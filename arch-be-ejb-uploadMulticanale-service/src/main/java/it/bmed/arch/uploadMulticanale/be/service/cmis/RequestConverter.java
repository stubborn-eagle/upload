package it.bmed.arch.uploadMulticanale.be.service.cmis;

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

			writer.startNode("Index");
			writer.addAttribute("name", request.getIndex().getName() != null && request.getIndex().getName().length() > 0 ? request.getIndex().getName() : "");
			writer.addAttribute("search", request.getIndex().getSearch() != null && request.getIndex().getSearch().length() > 0  ? request.getIndex().getSearch() : "");
			writer.startNode("Value");
			writer.setValue(request.getIndex().getValue().getValue() != null && request.getIndex().getValue().getValue() .length() > 0?request.getIndex().getValue().getValue() : "");
			writer.endNode();
			writer.endNode();
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "Index");
//		}

//		try {
			if (request.getIstituto().getValue() != null && request.getIstituto().getValue().length() > 0) {
				writer.startNode("Istituto");
				writer.addAttribute("value", request.getIstituto().getValue());
				writer.endNode();
			} else {
				writer.startNode("Istituto");
				writer.addAttribute("value", "");
				writer.endNode();
			}
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "Index");
//		}

//		try {
			if (request.getMatricola().getValue() != null && request.getMatricola().getValue().length() > 0) {
				writer.startNode("Matricola");
				writer.addAttribute("value", request.getMatricola().getValue());
				writer.endNode();
			} else {
				writer.startNode("Matricola");
				writer.addAttribute("value", "");
				writer.endNode();
			}
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "Matricola");
//		}
//		try {
			if (request.getRuolo().getValue() != null && request.getRuolo().getValue().length() > 0) {
				writer.startNode("Ruolo");
				writer.addAttribute("value", request.getRuolo().getValue());
				writer.endNode();
			} else {
				writer.startNode("Ruolo");
				writer.addAttribute("value", "");
				writer.endNode();
			}
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "Ruolo");
//		}
//		try {
			if (request.getFiliale().getValue() != null && request.getFiliale().getValue().length() > 0) {
				writer.startNode("Filiale");
				writer.addAttribute("value", request.getFiliale().getValue());
				writer.endNode();
			} else {
				writer.startNode("Filiale");
				writer.addAttribute("value", "");
				writer.endNode();
			}
//		} catch (Exception e) {
//			log.warn("Errore nel creare il nodo {} ", "Filiale");
//		}
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
			writer.addAttribute("filename", request.getDocContent().getFileName() != null && request.getDocContent().getFileName().length()> 0 ? request.getDocContent().getFileName() : "");
			writer.addAttribute("mimetype", request.getDocContent().getMimetype() != null && request.getDocContent().getMimetype().length() > 0  ? request.getDocContent().getMimetype() : "");
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
