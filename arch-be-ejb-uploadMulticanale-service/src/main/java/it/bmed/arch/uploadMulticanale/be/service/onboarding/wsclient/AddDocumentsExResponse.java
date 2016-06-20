
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addDocumentsExResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addDocumentsExResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documents-info" type="{http://www.infocert.it/legalbus/cop/onboarding/model}documents-info" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addDocumentsExResponse", namespace = "http://www.infocert.it/legalbus/cop/onboarding", propOrder = {
    "documentsInfo"
})
public class AddDocumentsExResponse {

    @XmlElement(name = "documents-info")
    protected DocumentsInfo documentsInfo;

    /**
     * Gets the value of the documentsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentsInfo }
     *     
     */
    public DocumentsInfo getDocumentsInfo() {
        return documentsInfo;
    }

    /**
     * Sets the value of the documentsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentsInfo }
     *     
     */
    public void setDocumentsInfo(DocumentsInfo value) {
        this.documentsInfo = value;
    }

}
