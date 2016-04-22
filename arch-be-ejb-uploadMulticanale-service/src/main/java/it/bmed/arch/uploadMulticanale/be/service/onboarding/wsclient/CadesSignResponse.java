
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cadesSignResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cadesSignResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="signed-content" type="{http://www.infocert.it/legalbus/cop/onboarding/model}content" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadesSignResponse", namespace = "http://www.infocert.it/legalbus/cop/onboarding", propOrder = {
    "signedContent"
})
public class CadesSignResponse {

    @XmlElement(name = "signed-content")
    protected Content signedContent;

    /**
     * Gets the value of the signedContent property.
     * 
     * @return
     *     possible object is
     *     {@link Content }
     *     
     */
    public Content getSignedContent() {
        return signedContent;
    }

    /**
     * Sets the value of the signedContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Content }
     *     
     */
    public void setSignedContent(Content value) {
        this.signedContent = value;
    }

}
