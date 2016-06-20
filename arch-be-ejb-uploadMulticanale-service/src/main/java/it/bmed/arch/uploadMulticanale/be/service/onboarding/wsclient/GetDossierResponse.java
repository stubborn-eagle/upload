
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDossierResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDossierResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dossier-info" type="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-info" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDossierResponse", namespace = "http://www.infocert.it/legalbus/cop/onboarding", propOrder = {
    "dossierInfo"
})
public class GetDossierResponse {

    @XmlElement(name = "dossier-info")
    protected DossierInfo dossierInfo;

    /**
     * Gets the value of the dossierInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DossierInfo }
     *     
     */
    public DossierInfo getDossierInfo() {
        return dossierInfo;
    }

    /**
     * Sets the value of the dossierInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierInfo }
     *     
     */
    public void setDossierInfo(DossierInfo value) {
        this.dossierInfo = value;
    }

}
