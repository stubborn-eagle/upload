
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createDossierResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createDossierResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dossier-creation-info" type="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-creation-info" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDossierResponse", namespace = "http://www.infocert.it/legalbus/cop/onboarding", propOrder = {
    "dossierCreationInfo"
})
public class CreateDossierResponse {

    @XmlElement(name = "dossier-creation-info")
    protected DossierCreationInfo dossierCreationInfo;

    /**
     * Gets the value of the dossierCreationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DossierCreationInfo }
     *     
     */
    public DossierCreationInfo getDossierCreationInfo() {
        return dossierCreationInfo;
    }

    /**
     * Sets the value of the dossierCreationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierCreationInfo }
     *     
     */
    public void setDossierCreationInfo(DossierCreationInfo value) {
        this.dossierCreationInfo = value;
    }

}
