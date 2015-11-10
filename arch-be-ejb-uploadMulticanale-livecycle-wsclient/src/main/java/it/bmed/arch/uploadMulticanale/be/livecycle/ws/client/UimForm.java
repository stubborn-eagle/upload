
package it.bmed.arch.uploadMulticanale.be.livecycle.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for uimForm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uimForm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="externalDepartmentID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formReleaseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="formVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uimForm", propOrder = {
    "description",
    "externalDepartmentID",
    "formCategory",
    "formID",
    "formPath",
    "formReleaseDate",
    "formVersion"
})
public class UimForm {

    protected String description;
    protected String externalDepartmentID;
    protected String formCategory;
    protected String formID;
    protected String formPath;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar formReleaseDate;
    protected String formVersion;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the externalDepartmentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalDepartmentID() {
        return externalDepartmentID;
    }

    /**
     * Sets the value of the externalDepartmentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalDepartmentID(String value) {
        this.externalDepartmentID = value;
    }

    /**
     * Gets the value of the formCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormCategory() {
        return formCategory;
    }

    /**
     * Sets the value of the formCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormCategory(String value) {
        this.formCategory = value;
    }

    /**
     * Gets the value of the formID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormID() {
        return formID;
    }

    /**
     * Sets the value of the formID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormID(String value) {
        this.formID = value;
    }

    /**
     * Gets the value of the formPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormPath() {
        return formPath;
    }

    /**
     * Sets the value of the formPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormPath(String value) {
        this.formPath = value;
    }

    /**
     * Gets the value of the formReleaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFormReleaseDate() {
        return formReleaseDate;
    }

    /**
     * Sets the value of the formReleaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFormReleaseDate(XMLGregorianCalendar value) {
        this.formReleaseDate = value;
    }

    /**
     * Gets the value of the formVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormVersion() {
        return formVersion;
    }

    /**
     * Sets the value of the formVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormVersion(String value) {
        this.formVersion = value;
    }

}
