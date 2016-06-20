
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getWebidServiceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getWebidServiceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="company-group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWebidServiceInfo", namespace = "http://www.infocert.it/legalbus/cop/onboarding", propOrder = {
    "companyGroup"
})
public class GetWebidServiceInfo {

    @XmlElement(name = "company-group")
    protected String companyGroup;

    /**
     * Gets the value of the companyGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyGroup() {
        return companyGroup;
    }

    /**
     * Sets the value of the companyGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyGroup(String value) {
        this.companyGroup = value;
    }

}
