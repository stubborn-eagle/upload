
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for document-policy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="document-policy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="compose" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="sign" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="archive" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "document-policy")
public class DocumentPolicy {

    @XmlAttribute(name = "compose", required = true)
    protected boolean compose;
    @XmlAttribute(name = "sign", required = true)
    protected boolean sign;
    @XmlAttribute(name = "archive", required = true)
    protected boolean archive;

    /**
     * Gets the value of the compose property.
     * 
     */
    public boolean isCompose() {
        return compose;
    }

    /**
     * Sets the value of the compose property.
     * 
     */
    public void setCompose(boolean value) {
        this.compose = value;
    }

    /**
     * Gets the value of the sign property.
     * 
     */
    public boolean isSign() {
        return sign;
    }

    /**
     * Sets the value of the sign property.
     * 
     */
    public void setSign(boolean value) {
        this.sign = value;
    }

    /**
     * Gets the value of the archive property.
     * 
     */
    public boolean isArchive() {
        return archive;
    }

    /**
     * Sets the value of the archive property.
     * 
     */
    public void setArchive(boolean value) {
        this.archive = value;
    }

}
