
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="policy" type="{http://www.infocert.it/legalbus/cop/onboarding/model}document-policy"/>
 *         &lt;element name="signer-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="content" type="{http://www.infocert.it/legalbus/cop/onboarding/model}content" minOccurs="0"/>
 *         &lt;element name="composition-policy" type="{http://www.infocert.it/legalbus/cop/onboarding/model}composition-policy" minOccurs="0"/>
 *         &lt;element name="signature-policy" type="{http://www.infocert.it/legalbus/cop/onboarding/model}signature-policy" minOccurs="0"/>
 *         &lt;element name="archiving-policy" type="{http://www.infocert.it/legalbus/cop/onboarding/model}archiving-policy" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "document", propOrder = {
    "policy",
    "signerId",
    "content",
    "compositionPolicy",
    "signaturePolicy",
    "archivingPolicy"
})
public class Document {

    @XmlElement(required = true)
    protected DocumentPolicy policy;
    @XmlElement(name = "signer-id")
    protected String signerId;
    protected Content content;
    @XmlElement(name = "composition-policy")
    protected CompositionPolicy compositionPolicy;
    @XmlElement(name = "signature-policy")
    protected SignaturePolicy signaturePolicy;
    @XmlElement(name = "archiving-policy")
    protected ArchivingPolicy archivingPolicy;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "type", required = true)
    protected String type;

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentPolicy }
     *     
     */
    public DocumentPolicy getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentPolicy }
     *     
     */
    public void setPolicy(DocumentPolicy value) {
        this.policy = value;
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
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link Content }
     *     
     */
    public Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link Content }
     *     
     */
    public void setContent(Content value) {
        this.content = value;
    }

    /**
     * Gets the value of the compositionPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link CompositionPolicy }
     *     
     */
    public CompositionPolicy getCompositionPolicy() {
        return compositionPolicy;
    }

    /**
     * Sets the value of the compositionPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompositionPolicy }
     *     
     */
    public void setCompositionPolicy(CompositionPolicy value) {
        this.compositionPolicy = value;
    }

    /**
     * Gets the value of the signaturePolicy property.
     * 
     * @return
     *     possible object is
     *     {@link SignaturePolicy }
     *     
     */
    public SignaturePolicy getSignaturePolicy() {
        return signaturePolicy;
    }

    /**
     * Sets the value of the signaturePolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignaturePolicy }
     *     
     */
    public void setSignaturePolicy(SignaturePolicy value) {
        this.signaturePolicy = value;
    }

    /**
     * Gets the value of the archivingPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link ArchivingPolicy }
     *     
     */
    public ArchivingPolicy getArchivingPolicy() {
        return archivingPolicy;
    }

    /**
     * Sets the value of the archivingPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArchivingPolicy }
     *     
     */
    public void setArchivingPolicy(ArchivingPolicy value) {
        this.archivingPolicy = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
