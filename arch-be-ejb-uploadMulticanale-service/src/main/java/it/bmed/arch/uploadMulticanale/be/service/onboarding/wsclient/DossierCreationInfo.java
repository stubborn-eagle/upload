
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dossier-creation-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dossier-creation-info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tokens">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tokens" type="{http://www.infocert.it/legalbus/cop/onboarding/model}token" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "dossier-creation-info", propOrder = {
    "tokens"
})
public class DossierCreationInfo {

    @XmlElement(required = true)
    protected DossierCreationInfo.Tokens tokens;

    /**
     * Gets the value of the tokens property.
     * 
     * @return
     *     possible object is
     *     {@link DossierCreationInfo.Tokens }
     *     
     */
    public DossierCreationInfo.Tokens getTokens() {
        return tokens;
    }

    /**
     * Sets the value of the tokens property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierCreationInfo.Tokens }
     *     
     */
    public void setTokens(DossierCreationInfo.Tokens value) {
        this.tokens = value;
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
     *         &lt;element name="tokens" type="{http://www.infocert.it/legalbus/cop/onboarding/model}token" maxOccurs="unbounded" minOccurs="0"/>
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
        "tokens"
    })
    public static class Tokens {

        @XmlElement(nillable = true)
        protected List<Token> tokens;

        /**
         * Gets the value of the tokens property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tokens property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTokens().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Token }
         * 
         * 
         */
        public List<Token> getTokens() {
            if (tokens == null) {
                tokens = new ArrayList<Token>();
            }
            return this.tokens;
        }

    }

}
