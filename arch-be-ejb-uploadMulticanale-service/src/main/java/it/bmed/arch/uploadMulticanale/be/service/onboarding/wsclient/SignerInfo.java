
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signer-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signer-info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="personal-data-updated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="address-updated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="identity-document-info-updated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="contact-info-updated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="person" type="{http://www.infocert.it/legalbus/cop/onboarding/model}person"/>
 *         &lt;element name="clauses" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="clause-result" type="{http://www.infocert.it/legalbus/cop/onboarding/model}clause-result" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="signer-id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signer-info", propOrder = {
    "identified",
    "personalDataUpdated",
    "addressUpdated",
    "identityDocumentInfoUpdated",
    "contactInfoUpdated",
    "person",
    "clauses"
})
public class SignerInfo {

    protected boolean identified;
    @XmlElement(name = "personal-data-updated")
    protected boolean personalDataUpdated;
    @XmlElement(name = "address-updated")
    protected boolean addressUpdated;
    @XmlElement(name = "identity-document-info-updated")
    protected boolean identityDocumentInfoUpdated;
    @XmlElement(name = "contact-info-updated")
    protected boolean contactInfoUpdated;
    @XmlElement(required = true)
    protected Person person;
    protected SignerInfo.Clauses clauses;
    @XmlAttribute(name = "signer-id", required = true)
    protected String signerId;

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

    /**
     * Gets the value of the personalDataUpdated property.
     * 
     */
    public boolean isPersonalDataUpdated() {
        return personalDataUpdated;
    }

    /**
     * Sets the value of the personalDataUpdated property.
     * 
     */
    public void setPersonalDataUpdated(boolean value) {
        this.personalDataUpdated = value;
    }

    /**
     * Gets the value of the addressUpdated property.
     * 
     */
    public boolean isAddressUpdated() {
        return addressUpdated;
    }

    /**
     * Sets the value of the addressUpdated property.
     * 
     */
    public void setAddressUpdated(boolean value) {
        this.addressUpdated = value;
    }

    /**
     * Gets the value of the identityDocumentInfoUpdated property.
     * 
     */
    public boolean isIdentityDocumentInfoUpdated() {
        return identityDocumentInfoUpdated;
    }

    /**
     * Sets the value of the identityDocumentInfoUpdated property.
     * 
     */
    public void setIdentityDocumentInfoUpdated(boolean value) {
        this.identityDocumentInfoUpdated = value;
    }

    /**
     * Gets the value of the contactInfoUpdated property.
     * 
     */
    public boolean isContactInfoUpdated() {
        return contactInfoUpdated;
    }

    /**
     * Sets the value of the contactInfoUpdated property.
     * 
     */
    public void setContactInfoUpdated(boolean value) {
        this.contactInfoUpdated = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

    /**
     * Gets the value of the clauses property.
     * 
     * @return
     *     possible object is
     *     {@link SignerInfo.Clauses }
     *     
     */
    public SignerInfo.Clauses getClauses() {
        return clauses;
    }

    /**
     * Sets the value of the clauses property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignerInfo.Clauses }
     *     
     */
    public void setClauses(SignerInfo.Clauses value) {
        this.clauses = value;
    }

    /**
     * Gets the value of the signerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerId() {
        return signerId;
    }

    /**
     * Sets the value of the signerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerId(String value) {
        this.signerId = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="clause-result" type="{http://www.infocert.it/legalbus/cop/onboarding/model}clause-result" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "clauseResult"
    })
    public static class Clauses {

        @XmlElement(name = "clause-result")
        protected List<ClauseResult> clauseResult;

        /**
         * Gets the value of the clauseResult property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the clauseResult property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getClauseResult().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ClauseResult }
         * 
         * 
         */
        public List<ClauseResult> getClauseResult() {
            if (clauseResult == null) {
                clauseResult = new ArrayList<ClauseResult>();
            }
            return this.clauseResult;
        }

    }

}
