
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for webid-service-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="webid-service-info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="busy-operators" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="free-operators" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="in-progress-users" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pending-users" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "webid-service-info", propOrder = {
    "timestamp",
    "busyOperators",
    "freeOperators",
    "inProgressUsers",
    "pendingUsers"
})
public class WebidServiceInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    @XmlElement(name = "busy-operators")
    protected int busyOperators;
    @XmlElement(name = "free-operators")
    protected int freeOperators;
    @XmlElement(name = "in-progress-users")
    protected int inProgressUsers;
    @XmlElement(name = "pending-users")
    protected int pendingUsers;

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the busyOperators property.
     * 
     */
    public int getBusyOperators() {
        return busyOperators;
    }

    /**
     * Sets the value of the busyOperators property.
     * 
     */
    public void setBusyOperators(int value) {
        this.busyOperators = value;
    }

    /**
     * Gets the value of the freeOperators property.
     * 
     */
    public int getFreeOperators() {
        return freeOperators;
    }

    /**
     * Sets the value of the freeOperators property.
     * 
     */
    public void setFreeOperators(int value) {
        this.freeOperators = value;
    }

    /**
     * Gets the value of the inProgressUsers property.
     * 
     */
    public int getInProgressUsers() {
        return inProgressUsers;
    }

    /**
     * Sets the value of the inProgressUsers property.
     * 
     */
    public void setInProgressUsers(int value) {
        this.inProgressUsers = value;
    }

    /**
     * Gets the value of the pendingUsers property.
     * 
     */
    public int getPendingUsers() {
        return pendingUsers;
    }

    /**
     * Sets the value of the pendingUsers property.
     * 
     */
    public void setPendingUsers(int value) {
        this.pendingUsers = value;
    }

}
