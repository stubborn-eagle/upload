
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for identity-assertion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identity-assertion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model}legal-id">
 *       &lt;sequence>
 *         &lt;element name="claimer" type="{http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion}claimer"/>
 *         &lt;element ref="{http://www.infocert.it/legalbus/cop/onboarding/model}person"/>
 *         &lt;element name="external-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statements" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="statement" type="{http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion}statement" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion}identity-assertion-type use="required""/>
 *       &lt;attribute name="identified" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="assertion-date" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="person-data-modified" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identity-assertion", namespace = "http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion", propOrder = {
    "claimer",
    "person",
    "externalId",
    "statements"
})
public class IdentityAssertion
    extends LegalId
{

    @XmlElement(required = true)
    protected Claimer claimer;
    @XmlElement(namespace = "http://www.infocert.it/legalbus/cop/onboarding/model", required = true)
    protected Person person;
    @XmlElement(name = "external-id")
    protected String externalId;
    protected IdentityAssertion.Statements statements;
    @XmlAttribute(name = "identity-assertion-type", namespace = "http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion", required = true)
    protected String identityAssertionType;
    @XmlAttribute(name = "identified", required = true)
    protected boolean identified;
    @XmlAttribute(name = "assertion-date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assertionDate;
    @XmlAttribute(name = "person-data-modified", required = true)
    protected boolean personDataModified;

    /**
     * Gets the value of the claimer property.
     * 
     * @return
     *     possible object is
     *     {@link Claimer }
     *     
     */
    public Claimer getClaimer() {
        return claimer;
    }

    /**
     * Sets the value of the claimer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Claimer }
     *     
     */
    public void setClaimer(Claimer value) {
        this.claimer = value;
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
     * Gets the value of the externalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the value of the externalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalId(String value) {
        this.externalId = value;
    }

    /**
     * Gets the value of the statements property.
     * 
     * @return
     *     possible object is
     *     {@link IdentityAssertion.Statements }
     *     
     */
    public IdentityAssertion.Statements getStatements() {
        return statements;
    }

    /**
     * Sets the value of the statements property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentityAssertion.Statements }
     *     
     */
    public void setStatements(IdentityAssertion.Statements value) {
        this.statements = value;
    }

    /**
     * Gets the value of the identityAssertionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityAssertionType() {
        return identityAssertionType;
    }

    /**
     * Sets the value of the identityAssertionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityAssertionType(String value) {
        this.identityAssertionType = value;
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

    /**
     * Gets the value of the assertionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAssertionDate() {
        return assertionDate;
    }

    /**
     * Sets the value of the assertionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAssertionDate(XMLGregorianCalendar value) {
        this.assertionDate = value;
    }

    /**
     * Gets the value of the personDataModified property.
     * 
     */
    public boolean isPersonDataModified() {
        return personDataModified;
    }

    /**
     * Sets the value of the personDataModified property.
     * 
     */
    public void setPersonDataModified(boolean value) {
        this.personDataModified = value;
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
     *         &lt;element name="statement" type="{http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion}statement" maxOccurs="unbounded" minOccurs="0"/>
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
        "statement"
    })
    public static class Statements {

        protected List<Statement> statement;

        /**
         * Gets the value of the statement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the statement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStatement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Statement }
         * 
         * 
         */
        public List<Statement> getStatement() {
            if (statement == null) {
                statement = new ArrayList<Statement>();
            }
            return this.statement;
        }

    }

}
