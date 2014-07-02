package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

public class FilenetRequest {
	private static final Logger log = LoggerFactory.getLogger(FilenetRequest.class);
	  public static String encodeXML(String fileCodificato,ECMFile ecmFile) {
		  ECMRequest request = new ECMRequest();
		  String fileToXML;
		  /*
		  //DICHIARATI TUTTI QUI PER GESTIRE SETTAGGIO DEL VALUE
		  ObjectStore objectStore = new ObjectStore();
		  ObjectClass objectClass = new ObjectClass();
		  Index index = new Index();
		  Value value = new Value();
		  Istituto istituto = new Istituto();
		  Matricola  matricola = new  Matricola();
		  Ruolo ruolo=new  Ruolo();
		  Filiale  filiale = new  Filiale();
		  SearchAction  searchAction = new  SearchAction();
		  DocContent  docContent = new  DocContent();
		  */
		  //°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
		  /*
		  for (FileProperty prop: tmpParam.getProperty()){
			  if("ObjectClass".equals(prop.getName())){
				  objectClass.setValue("DISPOSIZIONIANOMALE");
			  }
//			  if("ObjectStore".equalsIgnoreCase(prop.getName())){
////				  objectStore.setValue(prop.getValue());
//				  //DEVE ESSERE IL SEGUENTE??
//				  objectStore.setValue("CED088");
//			  }
			  if("Istituto".equalsIgnoreCase(prop.getName())){
				  istituto.setValue(prop.getValue());
			  }
			  if("Matricola".equalsIgnoreCase(prop.getName())){
				  matricola.setValue(prop.getValue());
			  }
			  if("Ruolo".equalsIgnoreCase(prop.getName())){
				  ruolo.setValue(prop.getValue());
			  }
			  if("Filiale".equalsIgnoreCase(prop.getName())){
				  filiale.setValue(prop.getValue());
			  }
//			  if("SearchAction".equalsIgnoreCase(prop.getName())){
////				  searchAction.setValue(prop.getValue());
//				  //DEVE ESSERE IL SEGUENTE??
//				  searchAction.setValue("AddVersion");
//			  }  
		  }
		  
		  
		  objectStore.setValue("CED088");
		  request.setObjectStore(objectStore);
				 
		  //objectClass.setValue("");
		  request.setObjectClass(objectClass);
		  searchAction.setValue("AddVersion");
		  
		  
		  index.setName("CODICEDOC");
		  index.setSearch("false");
		  value.setValue("");
		  index.setValue(value);
		  request.setIndex(index);
		  
		  
		  //istituto.setValue("");
		  request.setIstituto(istituto);
		  
		  
		  //matricola.setValue("");
		  request.setMatricola(matricola);
		  
		  
		  //ruolo.setValue("");
		  request.setRuolo(ruolo);
		  
		 
		  //filiale.setValue("");
		  request.setFiliale(filiale);
		  
		 
		  //searchAction.setValue("AddVersion");
		  request.setSearchAction(searchAction);
		  
		 
		  docContent.setFileName(tmpParam.getIdMediaBus());
		  docContent.setMimetype(tmpParam.getType());
		  //SETTO IL FILECODIFICATO IN BASE64 PER CREARE XML
		  docContent.setFilecod(fileCodificato);
		  request.setDocContent(docContent);
		 */ 
		  
		 /*

          XStream xStream = new XStream(new DomDriver());
          xStream.registerConverter(new RequestConverter());
          xStream.alias("Request", Request.class);
          log.debug("Request filenet {} ", CommonUtils.bean2string(request));
//          System.out.println("TOXML: ");
          fileToXML=xStream.toXML(request);
//          log.debug("XML {} ",fileToXML);
          */
//          return fileToXML;
		  return null;
       
          
         // Request requestFromXML = (Request) xStream.fromXML(xStream.toXML(request));
         // System.out.println(requestFromXML);
          
        
  }
}
