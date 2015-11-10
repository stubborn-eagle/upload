
package it.bmed.arch.uploadMulticanale.be.livecycle.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uimQueue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uimQueue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="departmentID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="queueDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="queueID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="queueTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="queueTypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uimQueue", propOrder = {
    "departmentID",
    "queueDescription",
    "queueID",
    "queueTypeDescription",
    "queueTypeID"
})
public class UimQueue {

    protected int departmentID;
    protected String queueDescription;
    protected int queueID;
    protected String queueTypeDescription;
    protected int queueTypeID;

    /**
     * Gets the value of the departmentID property.
     * 
     */
    public int getDepartmentID() {
        return departmentID;
    }

    /**
     * Sets the value of the departmentID property.
     * 
     */
    public void setDepartmentID(int value) {
        this.departmentID = value;
    }

    /**
     * Gets the value of the queueDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueDescription() {
        return queueDescription;
    }

    /**
     * Sets the value of the queueDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueDescription(String value) {
        this.queueDescription = value;
    }

    /**
     * Gets the value of the queueID property.
     * 
     */
    public int getQueueID() {
        return queueID;
    }

    /**
     * Sets the value of the queueID property.
     * 
     */
    public void setQueueID(int value) {
        this.queueID = value;
    }

    /**
     * Gets the value of the queueTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueTypeDescription() {
        return queueTypeDescription;
    }

    /**
     * Sets the value of the queueTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueTypeDescription(String value) {
        this.queueTypeDescription = value;
    }

    /**
     * Gets the value of the queueTypeID property.
     * 
     */
    public int getQueueTypeID() {
        return queueTypeID;
    }

    /**
     * Sets the value of the queueTypeID property.
     * 
     */
    public void setQueueTypeID(int value) {
        this.queueTypeID = value;
    }

}
