
package it.bmed.arch.uploadMulticanale.be.livecycle.ws.client;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updatePDFDocument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePDFDocument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePDFDocument", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class UpdatePDFDocument {

    protected BigInteger arg0;
    protected long arg1;
    protected String arg2;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setArg0(BigInteger value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     */
    public long getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     */
    public void setArg1(long value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg2(String value) {
        this.arg2 = value;
    }

}
