
package it.bmed.ib.uploadmulticanale.file.be.wsclient.sign.infocert;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.bmed.ib.uploadmulticanale.file.be.wsclient.sign.infocert package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FirmaCADESResponse_QNAME = new QName("http://firma.webservice.ncfr.infocert.it/", "firmaCADESResponse");
    private final static QName _FirmaCADES_QNAME = new QName("http://firma.webservice.ncfr.infocert.it/", "firmaCADES");
    private final static QName _FirmaPADESResponse_QNAME = new QName("http://firma.webservice.ncfr.infocert.it/", "firmaPADESResponse");
    private final static QName _FirmaPADES_QNAME = new QName("http://firma.webservice.ncfr.infocert.it/", "firmaPADES");
    private final static QName _FirmaWSException_QNAME = new QName("http://firma.webservice.ncfr.infocert.it/", "FirmaWSException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.bmed.ib.uploadmulticanale.file.be.wsclient.sign.infocert
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FirmaPADES }
     * 
     */
    public FirmaPADES createFirmaPADES() {
        return new FirmaPADES();
    }

    /**
     * Create an instance of {@link FirmaWSException }
     * 
     */
    public FirmaWSException createFirmaWSException() {
        return new FirmaWSException();
    }

    /**
     * Create an instance of {@link FirmaCADESResponse }
     * 
     */
    public FirmaCADESResponse createFirmaCADESResponse() {
        return new FirmaCADESResponse();
    }

    /**
     * Create an instance of {@link FirmaCADES }
     * 
     */
    public FirmaCADES createFirmaCADES() {
        return new FirmaCADES();
    }

    /**
     * Create an instance of {@link FirmaPADESResponse }
     * 
     */
    public FirmaPADESResponse createFirmaPADESResponse() {
        return new FirmaPADESResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirmaCADESResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://firma.webservice.ncfr.infocert.it/", name = "firmaCADESResponse")
    public JAXBElement<FirmaCADESResponse> createFirmaCADESResponse(FirmaCADESResponse value) {
        return new JAXBElement<FirmaCADESResponse>(_FirmaCADESResponse_QNAME, FirmaCADESResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirmaCADES }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://firma.webservice.ncfr.infocert.it/", name = "firmaCADES")
    public JAXBElement<FirmaCADES> createFirmaCADES(FirmaCADES value) {
        return new JAXBElement<FirmaCADES>(_FirmaCADES_QNAME, FirmaCADES.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirmaPADESResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://firma.webservice.ncfr.infocert.it/", name = "firmaPADESResponse")
    public JAXBElement<FirmaPADESResponse> createFirmaPADESResponse(FirmaPADESResponse value) {
        return new JAXBElement<FirmaPADESResponse>(_FirmaPADESResponse_QNAME, FirmaPADESResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirmaPADES }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://firma.webservice.ncfr.infocert.it/", name = "firmaPADES")
    public JAXBElement<FirmaPADES> createFirmaPADES(FirmaPADES value) {
        return new JAXBElement<FirmaPADES>(_FirmaPADES_QNAME, FirmaPADES.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirmaWSException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://firma.webservice.ncfr.infocert.it/", name = "FirmaWSException")
    public JAXBElement<FirmaWSException> createFirmaWSException(FirmaWSException value) {
        return new JAXBElement<FirmaWSException>(_FirmaWSException_QNAME, FirmaWSException.class, null, value);
    }

}
