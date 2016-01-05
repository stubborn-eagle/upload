
package it.bmed.ib.uploadmulticanale.file.be.wsclient.sign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for firmaPADES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="firmaPADES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentoDaFirmare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firmatari" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "firmaPADES", propOrder = {
    "documentoDaFirmare",
    "firmatari"
})
public class FirmaPADES {

    protected String documentoDaFirmare;
    protected String firmatari;

    /**
     * Gets the value of the documentoDaFirmare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoDaFirmare() {
        return documentoDaFirmare;
    }

    /**
     * Sets the value of the documentoDaFirmare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoDaFirmare(String value) {
        this.documentoDaFirmare = value;
    }

    /**
     * Gets the value of the firmatari property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmatari() {
        return firmatari;
    }

    /**
     * Sets the value of the firmatari property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmatari(String value) {
        this.firmatari = value;
    }

}
