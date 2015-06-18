/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.api;


/**
 * @author andrea.perrotta
 *
 */

public class APIParams {
    /* Variabili da valorizzare  [start] */
    //info per WSDL
    private static final String WSDL_NomeLogicoServizio = "UploadMulticanale"; //Deve iniziare con una lettera maiuscola
    private static final String WSDL_DominioApplicativo = "UploadMulticanaleDomApp"; //Deve iniziare con una lettera maiuscola
    
    //info per XSD contenente oggetti custom 
    private static final String XSD_NomeLogicoOggetto = "UploadMulticanaleDom"; //Deve iniziare con una lettera maiuscola
    private static final String XSD_Area = ".AreaUploadMulticanale"; //il punto iniziale deve essere sempre presente se il parametro Area è valorizzato
    
    //info comuni a wsdl e xsd
    private static final String GEN_MajorVersion = "1";
    private static final String GEN_MinorVersion = "0";
    /* Variabili da valorizzare  [end] */
        
    public static final String PORTTYPE_NAME = WSDL_NomeLogicoServizio + "PortType_v" + GEN_MajorVersion;
    public static final String DEFINITION_NAMESPACE = "http://" + WSDL_DominioApplicativo + ".service.bmed.it/v" + GEN_MajorVersion;
    public static final String SERVICE_NAME = WSDL_NomeLogicoServizio + "Service_v" + GEN_MajorVersion;
    public static final String PORT_NAME = WSDL_NomeLogicoServizio + "ServicePort";
    public static final String VERSION = GEN_MajorVersion + "." + GEN_MinorVersion;
    public static final String XSD_CUSTOM_NAMESPACE = "http://" + XSD_NomeLogicoOggetto + XSD_Area + ".schema.bmed.it/v" + GEN_MajorVersion;
}

