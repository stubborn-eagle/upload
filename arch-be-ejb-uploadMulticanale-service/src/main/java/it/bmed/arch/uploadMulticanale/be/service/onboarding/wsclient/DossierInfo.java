
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dossier-info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dossier-info">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.infocert.it/legalbus/cop/onboarding/model}dossier-status">
 *       &lt;sequence>
 *         &lt;element name="signers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="signers" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signer-info" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="documents">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="documents" type="{http://www.infocert.it/legalbus/cop/onboarding/model}document-info" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dossier-info", propOrder = {
    "signers",
    "documents"
})
public class DossierInfo
    extends DossierStatus
{

    @XmlElement(required = true)
    protected DossierInfo.Signers signers;
    @XmlElement(required = true)
    protected DossierInfo.Documents documents;

    /**
     * Gets the value of the signers property.
     * 
     * @return
     *     possible object is
     *     {@link DossierInfo.Signers }
     *     
     */
    public DossierInfo.Signers getSigners() {
        return signers;
    }

    /**
     * Sets the value of the signers property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierInfo.Signers }
     *     
     */
    public void setSigners(DossierInfo.Signers value) {
        this.signers = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link DossierInfo.Documents }
     *     
     */
    public DossierInfo.Documents getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierInfo.Documents }
     *     
     */
    public void setDocuments(DossierInfo.Documents value) {
        this.documents = value;
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
     *         &lt;element name="documents" type="{http://www.infocert.it/legalbus/cop/onboarding/model}document-info" maxOccurs="unbounded" minOccurs="0"/>
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
        "documents"
    })
    public static class Documents {

        @XmlElement(nillable = true)
        protected List<DocumentInfo> documents;

        /**
         * Gets the value of the documents property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the documents property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocuments().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentInfo }
         * 
         * 
         */
        public List<DocumentInfo> getDocuments() {
            if (documents == null) {
                documents = new ArrayList<DocumentInfo>();
            }
            return this.documents;
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
     *         &lt;element name="signers" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signer-info" maxOccurs="unbounded" minOccurs="0"/>
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
        "signers"
    })
    public static class Signers {

        @XmlElement(nillable = true)
        protected List<SignerInfo> signers;

        /**
         * Gets the value of the signers property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the signers property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSigners().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SignerInfo }
         * 
         * 
         */
        public List<SignerInfo> getSigners() {
            if (signers == null) {
                signers = new ArrayList<SignerInfo>();
            }
            return this.signers;
        }

    }

}
