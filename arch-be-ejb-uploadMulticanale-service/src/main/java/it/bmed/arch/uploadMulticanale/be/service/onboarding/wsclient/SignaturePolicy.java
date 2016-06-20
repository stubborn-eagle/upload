
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signature-policy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signature-policy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="signature-fields" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="signature-field" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signature-field" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="keyword-signature-fields" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="keyword-signature-field" type="{http://www.infocert.it/legalbus/cop/onboarding/model}keyword-signature-field" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="position-signature-fields" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="position-signature-field" type="{http://www.infocert.it/legalbus/cop/onboarding/model}position-signature-field" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signature-policy", propOrder = {
    "signatureFields",
    "keywordSignatureFields",
    "positionSignatureFields"
})
public class SignaturePolicy {

    @XmlElement(name = "signature-fields")
    protected SignaturePolicy.SignatureFields signatureFields;
    @XmlElement(name = "keyword-signature-fields")
    protected SignaturePolicy.KeywordSignatureFields keywordSignatureFields;
    @XmlElement(name = "position-signature-fields")
    protected SignaturePolicy.PositionSignatureFields positionSignatureFields;

    /**
     * Gets the value of the signatureFields property.
     * 
     * @return
     *     possible object is
     *     {@link SignaturePolicy.SignatureFields }
     *     
     */
    public SignaturePolicy.SignatureFields getSignatureFields() {
        return signatureFields;
    }

    /**
     * Sets the value of the signatureFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignaturePolicy.SignatureFields }
     *     
     */
    public void setSignatureFields(SignaturePolicy.SignatureFields value) {
        this.signatureFields = value;
    }

    /**
     * Gets the value of the keywordSignatureFields property.
     * 
     * @return
     *     possible object is
     *     {@link SignaturePolicy.KeywordSignatureFields }
     *     
     */
    public SignaturePolicy.KeywordSignatureFields getKeywordSignatureFields() {
        return keywordSignatureFields;
    }

    /**
     * Sets the value of the keywordSignatureFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignaturePolicy.KeywordSignatureFields }
     *     
     */
    public void setKeywordSignatureFields(SignaturePolicy.KeywordSignatureFields value) {
        this.keywordSignatureFields = value;
    }

    /**
     * Gets the value of the positionSignatureFields property.
     * 
     * @return
     *     possible object is
     *     {@link SignaturePolicy.PositionSignatureFields }
     *     
     */
    public SignaturePolicy.PositionSignatureFields getPositionSignatureFields() {
        return positionSignatureFields;
    }

    /**
     * Sets the value of the positionSignatureFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignaturePolicy.PositionSignatureFields }
     *     
     */
    public void setPositionSignatureFields(SignaturePolicy.PositionSignatureFields value) {
        this.positionSignatureFields = value;
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
     *         &lt;element name="keyword-signature-field" type="{http://www.infocert.it/legalbus/cop/onboarding/model}keyword-signature-field" maxOccurs="unbounded" minOccurs="0"/>
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
        "keywordSignatureField"
    })
    public static class KeywordSignatureFields {

        @XmlElement(name = "keyword-signature-field")
        protected List<KeywordSignatureField> keywordSignatureField;

        /**
         * Gets the value of the keywordSignatureField property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the keywordSignatureField property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeywordSignatureField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KeywordSignatureField }
         * 
         * 
         */
        public List<KeywordSignatureField> getKeywordSignatureField() {
            if (keywordSignatureField == null) {
                keywordSignatureField = new ArrayList<KeywordSignatureField>();
            }
            return this.keywordSignatureField;
        }

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
     *         &lt;element name="position-signature-field" type="{http://www.infocert.it/legalbus/cop/onboarding/model}position-signature-field" maxOccurs="unbounded" minOccurs="0"/>
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
        "positionSignatureField"
    })
    public static class PositionSignatureFields {

        @XmlElement(name = "position-signature-field")
        protected List<PositionSignatureField> positionSignatureField;

        /**
         * Gets the value of the positionSignatureField property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the positionSignatureField property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPositionSignatureField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PositionSignatureField }
         * 
         * 
         */
        public List<PositionSignatureField> getPositionSignatureField() {
            if (positionSignatureField == null) {
                positionSignatureField = new ArrayList<PositionSignatureField>();
            }
            return this.positionSignatureField;
        }

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
     *         &lt;element name="signature-field" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signature-field" maxOccurs="unbounded" minOccurs="0"/>
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
        "signatureField"
    })
    public static class SignatureFields {

        @XmlElement(name = "signature-field")
        protected List<SignatureField> signatureField;

        /**
         * Gets the value of the signatureField property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the signatureField property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSignatureField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SignatureField }
         * 
         * 
         */
        public List<SignatureField> getSignatureField() {
            if (signatureField == null) {
                signatureField = new ArrayList<SignatureField>();
            }
            return this.signatureField;
        }

    }

}
