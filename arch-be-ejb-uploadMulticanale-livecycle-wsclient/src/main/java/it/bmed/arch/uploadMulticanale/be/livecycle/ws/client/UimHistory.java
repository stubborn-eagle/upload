
package it.bmed.arch.uploadMulticanale.be.livecycle.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for uimHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uimHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="historyEntry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historyEntryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uimHistory", propOrder = {
    "historyEntry",
    "historyEntryDate"
})
public class UimHistory {

    protected String historyEntry;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar historyEntryDate;

    /**
     * Gets the value of the historyEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHistoryEntry() {
        return historyEntry;
    }

    /**
     * Sets the value of the historyEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHistoryEntry(String value) {
        this.historyEntry = value;
    }

    /**
     * Gets the value of the historyEntryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHistoryEntryDate() {
        return historyEntryDate;
    }

    /**
     * Sets the value of the historyEntryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHistoryEntryDate(XMLGregorianCalendar value) {
        this.historyEntryDate = value;
    }

}
