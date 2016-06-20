
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="legal-id" type="{http://www.infocert.it/legalbus/cop/onboarding/model}legal-id" minOccurs="0"/>
 *         &lt;element name="personal-data" type="{http://www.infocert.it/legalbus/cop/onboarding/model}personal-data"/>
 *         &lt;element name="contact-details" type="{http://www.infocert.it/legalbus/cop/onboarding/model}contact-details"/>
 *         &lt;element name="address" type="{http://www.infocert.it/legalbus/cop/onboarding/model}address"/>
 *         &lt;element name="identity-document-info" type="{http://www.infocert.it/legalbus/cop/onboarding/model}identity-document-data"/>
 *       &lt;/sequence>
 *       &lt;attribute name="identified" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = {
    "legalId",
    "personalData",
    "contactDetails",
    "address",
    "identityDocumentInfo"
})
public class Person {

    @XmlElement(name = "legal-id")
    protected LegalId legalId;
    @XmlElement(name = "personal-data", required = true)
    protected PersonalData personalData;
    @XmlElement(name = "contact-details", required = true)
    protected ContactDetails contactDetails;
    @XmlElement(required = true)
    protected Address address;
    @XmlElement(name = "identity-document-info", required = true)
    protected IdentityDocumentData identityDocumentInfo;
    @XmlAttribute(name = "identified", required = true)
    protected boolean identified;

    /**
     * Gets the value of the legalId property.
     * 
     * @return
     *     possible object is
     *     {@link LegalId }
     *     
     */
    public LegalId getLegalId() {
        return legalId;
    }

    /**
     * Sets the value of the legalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalId }
     *     
     */
    public void setLegalId(LegalId value) {
        this.legalId = value;
    }

    /**
     * Gets the value of the personalData property.
     * 
     * @return
     *     possible object is
     *     {@link PersonalData }
     *     
     */
    public PersonalData getPersonalData() {
        return personalData;
    }

    /**
     * Sets the value of the personalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonalData }
     *     
     */
    public void setPersonalData(PersonalData value) {
        this.personalData = value;
    }

    /**
     * Gets the value of the contactDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDetails }
     *     
     */
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    /**
     * Sets the value of the contactDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDetails }
     *     
     */
    public void setContactDetails(ContactDetails value) {
        this.contactDetails = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the identityDocumentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link IdentityDocumentData }
     *     
     */
    public IdentityDocumentData getIdentityDocumentInfo() {
        return identityDocumentInfo;
    }

    /**
     * Sets the value of the identityDocumentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentityDocumentData }
     *     
     */
    public void setIdentityDocumentInfo(IdentityDocumentData value) {
        this.identityDocumentInfo = value;
    }

    /**
     * Gets the value of the identified property.
     * 
     */
    public boolean isIdentified() {
        return identified;
    }

    /**
     * Sets the value of the identified property.
     * 
     */
    public void setIdentified(boolean value) {
        this.identified = value;
    }

}
