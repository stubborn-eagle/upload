
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDossierStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDossierStatusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dossier-status" type="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-status" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDossierStatusResponse", namespace = "http://www.infocert.it/legalbus/cop/onboarding", propOrder = {
    "dossierStatus"
})
public class GetDossierStatusResponse {

    @XmlElement(name = "dossier-status")
    protected DossierStatus dossierStatus;

    /**
     * Gets the value of the dossierStatus property.
     * 
     * @return
     *     possible object is
     *     {@link DossierStatus }
     *     
     */
    public DossierStatus getDossierStatus() {
        return dossierStatus;
    }

    /**
     * Sets the value of the dossierStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierStatus }
     *     
     */
    public void setDossierStatus(DossierStatus value) {
        this.dossierStatus = value;
    }

}
