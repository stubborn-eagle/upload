
package it.bmed.arch.uploadMulticanale.be.livecycle.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LookupCanaliAnagrafe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LookupCanaliAnagrafe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rapporto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodiceClient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodiceDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookupCanaliAnagrafe", propOrder = {
    "rapporto",
    "codiceClient",
    "codiceDocumento"
})
public class LookupCanaliAnagrafe {

    @XmlElement(name = "Rapporto")
    protected String rapporto;
    @XmlElement(name = "CodiceClient")
    protected String codiceClient;
    @XmlElement(name = "CodiceDocumento")
    protected String codiceDocumento;

    /**
     * Gets the value of the rapporto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRapporto() {
        return rapporto;
    }

    /**
     * Sets the value of the rapporto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRapporto(String value) {
        this.rapporto = value;
    }

    /**
     * Gets the value of the codiceClient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceClient() {
        return codiceClient;
    }

    /**
     * Sets the value of the codiceClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceClient(String value) {
        this.codiceClient = value;
    }

    /**
     * Gets the value of the codiceDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceDocumento() {
        return codiceDocumento;
    }

    /**
     * Sets the value of the codiceDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceDocumento(String value) {
        this.codiceDocumento = value;
    }

}
