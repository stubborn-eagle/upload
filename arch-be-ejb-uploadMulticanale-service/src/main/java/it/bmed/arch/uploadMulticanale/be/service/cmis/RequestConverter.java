package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.FileProperty;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class RequestConverter
  implements Converter
{
  public boolean canConvert(Class test)
  {
    return test.equals(Request.class);
  }
  
  static Logger log = LoggerFactory.getLogger(RequestConverter.class);
  private Map<String, String> properties;
  
  public RequestConverter()
  {
    this.properties = new HashMap();
    this.properties.put("CODICEFISCALE", "CODICEFISCALE");
    this.properties.put("CODICEDOC", "CODICEDOC");
    this.properties.put("DATARIF", "DATARIF");
    this.properties.put("ISTITUTO", "ISTITUTO");
    this.properties.put("NDG", "NDG");
    this.properties.put("LETTO", "LETTO");
    this.properties.put("TIPO MIME", "TIPO MIME");
    this.properties.put("RAPPORTO", "RAPPORTO");
    this.properties.put("TITOLO DOCUMENTO", "TITOLO DOCUMENTO");
    this.properties.put("LAYOUTLETTO", "LAYOUTLETTO");
    this.properties.put("STATODOCUMENTO", "STATODOCUMENTO");
    this.properties.put("DATAVARIAZIONESTATO", "DATAVARIAZIONESTATO");
    this.properties.put("DESCRCODICESOTTOCLASSE", "DESCRCODICESOTTOCLASSE");
    this.properties.put("CODICESOTTOCLASSE", "CODICESOTTOCLASSE");
    this.properties.put("NOMECLASSE", "NOMECLASSE");
    this.properties.put("STATER", "STATER");
    this.properties.put("ANNO", "ANNO");
    this.properties.put("AZIENDA", "AZIENDA");
    this.properties.put("CATEGORIA", "CATEGORIA");
    this.properties.put("CODAGENTE", "CODAGENTE");
    this.properties.put("CODPRODOTTO", "CODPRODOTTO");
    this.properties.put("COMIDDOC", "COMIDDOC");
    this.properties.put("COMIDLAVORO", "COMIDLAVORO");
    this.properties.put("DATAPROD", "DATAPROD");
    this.properties.put("DESCRDOC", "DESCRDOC");
    this.properties.put("DOCIDIS", "DOCIDIS");
    this.properties.put("FILIALE", "FILIALE");
    this.properties.put("FILIALECEDACRI", "FILIALECEDACRI");
    this.properties.put("FORNITARCHFISICA", "FORNITARCHFISICA");
    this.properties.put("FORNITIMMAGINI", "FORNITIMMAGINI");
    this.properties.put("IDDOCCLIENTE", "IDDOCCLIENTE");
    this.properties.put("IDLAVORO", "IDLAVORO");
    this.properties.put("IDLOTTOCLIENTE", "IDLOTTOCLIENTE");
    this.properties.put("MESE", "MESE");
    this.properties.put("NOMINATIVO", "NOMINATIVO");
    this.properties.put("NUMEROSCATOLA", "NUMEROSCATOLA");
    this.properties.put("NUMPAG", "NUMPAG");
    this.properties.put("ORIGINE", "ORIGINE");
    this.properties.put("PROFILO", "PROFILO");
    this.properties.put("PROGISTR", "PROGISTR");
    this.properties.put("PROGRESSIVO", "PROGRESSIVO");
    this.properties.put("PROPINFORETE", "PROPINFORETE");
    this.properties.put("PROPOSTA", "PROPOSTA");
    this.properties.put("SERVIZIO", "SERVIZIO");
    this.properties.put("SOTTOSISTEMA", "SOTTOSISTEMA");
    this.properties.put("TIPO", "TIPO");
    this.properties.put("TIPOOPERAZ", "TIPOOPERAZ");
    this.properties.put("TIPOPROD", "TIPOPROD");
    this.properties.put("TOKEN", "TOKEN");
    this.properties.put("VISIBILITA", "VISIBILITA");
    this.properties.put("CONTENTID", "CONTENTID");
    this.properties.put("NOMEDOC", "NOMEDOC");
    this.properties.put("FLAGSRACCOMANDATA", "FLAGSRACCOMANDATA");
    this.properties.put("NUMASS", "NUMASS");
    this.properties.put("ABIASS", "ABIASS");
    this.properties.put("CABASS", "CABASS");
    this.properties.put("NUMTICKET", "NUMTICKET");
    this.properties.put("DESCRWEB", "DESCRWEB");
    this.properties.put("FILIALENUM", "FILIALENUM");
    this.properties.put("NUMCONTO", "NUMCONTO");
    this.properties.put("PREKIT", "PREKIT");
    this.properties.put("IDCENTERA", "IDCENTERA");
    this.properties.put("ADOBEDOCID", "ADOBEDOCID");
    this.properties.put("NUMEROPRIT", "NUMEROPRIT");
    this.properties.put("CODICEDOCACCESSO", "CODICEDOCACCESSO");
    this.properties.put("DOCINORIGINALE", "DOCINORIGINALE");
    this.properties.put("FIRMAINORIGINALE", "FIRMAINORIGINALE");
    this.properties.put("PROGRESSIVODOCINPRIT", "PROGRESSIVODOCINPRIT");
    this.properties.put("PROGRESSIVODOCPINZATOA", "PROGRESSIVODOCPINZATOA");
    this.properties.put("BARCODE", "BARCODE");
    this.properties.put("PROTOCOLLO", "PROTOCOLLO");
    this.properties.put("FLAGESTRAZIONEFIRMA", "FLAGESTRAZIONEFIRMA");
    this.properties.put("IBAN", "IBAN");
    this.properties.put("IDPRATICA", "IDPRATICA");
    this.properties.put("IDPRATICAWF", "IDPRATICAWF");
    this.properties.put("FATTURA", "FATTURA");
    this.properties.put("NUMORDINE", "NUMORDINE");
    this.properties.put("AMBITO", "AMBITO");
    this.properties.put("FILIALEOLD", "FILIALEOLD");
    this.properties.put("RAPPORTOOLD", "RAPPORTOOLD");
    this.properties.put("UTENTECREATORE", "UTENTECREATORE");
    this.properties.put("UTENTEMODIFICATORE", "UTENTEMODIFICATORE");
    this.properties.put("NOMINATIVO_AGENTE", "NOMINATIVO_AGENTE");
    this.properties.put("PROGPROTOCOLLO", "PROGPROTOCOLLO");
  }
  
  public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context)
  {
    Request request = (Request)value;
    if (request.getObjectStore().getValue() != null && request.getObjectStore().getValue().length() > 0)
    {
      writer.startNode("ObjectStore");
      writer.addAttribute("value", request.getObjectStore().getValue());
      writer.endNode();
    }
    else
    {
      writer.startNode("ObjectStore");
      writer.addAttribute("value", "");
      writer.endNode();
    }
    if (request.getObjectClass().getValue() != null && request.getObjectClass().getValue().length() > 0)
    {
      writer.startNode("ObjectClass");
      writer.addAttribute("value", request.getObjectClass().getValue());
      writer.endNode();
    }
    else
    {
      writer.startNode("ObjectClass");
      writer.addAttribute("value", "");
      writer.endNode();
    }
    HashMap<String, String> settedMetadati = new HashMap();
    if (request != null && request.getProperty() != null && request.getProperty().size() > 0) {
      for (FileProperty metadato : request.getProperty())
      {
        log.debug("PROPERTY NAME: " + metadato.getName(), new Object[0]);
        log.debug("PROPERTY VALUE: " + metadato.getValue(), new Object[0]);
        if (this.properties.containsKey(metadato.getName().toUpperCase()))
        {
          writer.startNode("Index");
          writer.addAttribute("name", metadato.getName());
          writer.addAttribute("search", "true");
          writer.startNode("Value");
          writer.setValue(metadato.getValue() != null ? metadato.getValue() : "");
          writer.endNode();
          writer.endNode();
          settedMetadati.put(metadato.getName().toUpperCase(), metadato.getValue());
        }
      }
    }
    try
    {
      if (settedMetadati.containsKey("ISTITUTO"))
      {
        writer.startNode("Istituto");
        writer.addAttribute("value", (String)settedMetadati.get("ISTITUTO"));
        writer.endNode();
      }
      else
      {
        writer.startNode("Istituto");
        writer.addAttribute("value", "");
        writer.endNode();
      }
    }
    catch (Exception e)
    {
      log.warn("Errore nel creare il nodo {} ", new Object[] { "Index" });
    }
    try
    {
      if (settedMetadati.containsKey("MATRICOLA"))
      {
        writer.startNode("Matricola");
        writer.addAttribute("value", request.getMatricola().getValue());
        writer.endNode();
      }
      else
      {
        writer.startNode("Matricola");
        writer.addAttribute("value", "0");
        writer.endNode();
      }
    }
    catch (Exception e)
    {
      log.warn("Errore nel creare il nodo {} ", new Object[] { "Matricola" });
    }
    try
    {
      if (settedMetadati.containsKey("RUOLO"))
      {
        writer.startNode("Ruolo");
        writer.addAttribute("value", request.getRuolo().getValue());
        writer.endNode();
      }
      else
      {
        writer.startNode("Ruolo");
        writer.addAttribute("value", "0");
        writer.endNode();
      }
    }
    catch (Exception e)
    {
      log.warn("Errore nel creare il nodo {} ", new Object[] { "Ruolo" });
    }
    try
    {
      if (settedMetadati.containsKey("FILIALE"))
      {
        writer.startNode("Filiale");
        writer.addAttribute("value", (String)settedMetadati.get("FILIALE"));
        writer.endNode();
      }
      else
      {
        writer.startNode("Filiale");
        writer.addAttribute("value", "");
        writer.endNode();
      }
    }
    catch (Exception e)
    {
      log.error("Errore nel creare il nodo {} ", new Object[] { "Filiale" }, e);
    }
    if (request.getSearchAction().getValue() != null && request.getSearchAction().getValue().length() > 0)
    {
      writer.startNode("SearchAction");
      writer.addAttribute("value", request.getSearchAction().getValue());
      writer.endNode();
    }
    else
    {
      writer.startNode("SearchAction");
      writer.addAttribute("value", " ");
      writer.endNode();
    }
    try
    {
      writer.startNode("DocContent");
      writer.addAttribute("filename", (request.getDocContent().getFileName() != null) && (request.getDocContent().getFileName().length() > 0) ? request.getDocContent().getFileName() : "");
      writer.addAttribute("mimetype", (request.getDocContent().getMimetype() != null) && (request.getDocContent().getMimetype().length() > 0) ? request.getDocContent().getMimetype() : "");
      writer.setValue(request.getDocContent().getFilecod());
      writer.endNode();
    }
    catch (Exception e)
    {
      log.warn("Errore nel creare il nodo {} ", new Object[] { "DocContent" });
    }
  }
  
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context)
  {
    System.out.println("unmarshal");
    System.out.println("reader -" + reader.getNodeName());
    Request request = new Request();
    reader.moveDown();
    
    request.getObjectStore().setValue(reader.getValue());
    reader.moveUp();
    
    return request;
  }
}