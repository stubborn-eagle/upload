
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="office" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="certificate-domain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="certificate-alias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="certificate-pin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rao", propOrder = {
    "username",
    "password",
    "office",
    "certificateDomain",
    "certificateAlias",
    "certificatePin"
})
public class Rao {

    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String office;
    @XmlElement(name = "certificate-domain", required = true)
    protected String certificateDomain;
    @XmlElement(name = "certificate-alias", required = true)
    protected String certificateAlias;
    @XmlElement(name = "certificate-pin", required = true)
    protected String certificatePin;

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the office property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffice() {
        return office;
    }

    /**
     * Sets the value of the office property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffice(String value) {
        this.office = value;
    }

    /**
     * Gets the value of the certificateDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateDomain() {
        return certificateDomain;
    }

    /**
     * Sets the value of the certificateDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateDomain(String value) {
        this.certificateDomain = value;
    }

    /**
     * Gets the value of the certificateAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateAlias() {
        return certificateAlias;
    }

    /**
     * Sets the value of the certificateAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateAlias(String value) {
        this.certificateAlias = value;
    }

    /**
     * Gets the value of the certificatePin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificatePin() {
        return certificatePin;
    }

    /**
     * Sets the value of the certificatePin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificatePin(String value) {
        this.certificatePin = value;
    }

}
