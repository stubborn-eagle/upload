
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDossiersByBusinessIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDossiersByBusinessIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result-set" type="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-result-set" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDossiersByBusinessIdResponse", namespace = "http://www.infocert.it/legalbus/cop/onboarding", propOrder = {
    "resultSet"
})
public class GetDossiersByBusinessIdResponse {

    @XmlElement(name = "result-set")
    protected DossierResultSet resultSet;

    /**
     * Gets the value of the resultSet property.
     * 
     * @return
     *     possible object is
     *     {@link DossierResultSet }
     *     
     */
    public DossierResultSet getResultSet() {
        return resultSet;
    }

    /**
     * Sets the value of the resultSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierResultSet }
     *     
     */
    public void setResultSet(DossierResultSet value) {
        this.resultSet = value;
    }

}
