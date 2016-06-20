
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getWebidServiceInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getWebidServiceInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="webid-service-info" type="{http://www.infocert.it/legalbus/cop/onboarding/model}webid-service-info" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWebidServiceInfoResponse", namespace = "http://www.infocert.it/legalbus/cop/onboarding", propOrder = {
    "webidServiceInfo"
})
public class GetWebidServiceInfoResponse {

    @XmlElement(name = "webid-service-info")
    protected WebidServiceInfo webidServiceInfo;

    /**
     * Gets the value of the webidServiceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link WebidServiceInfo }
     *     
     */
    public WebidServiceInfo getWebidServiceInfo() {
        return webidServiceInfo;
    }

    /**
     * Sets the value of the webidServiceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebidServiceInfo }
     *     
     */
    public void setWebidServiceInfo(WebidServiceInfo value) {
        this.webidServiceInfo = value;
    }

}
