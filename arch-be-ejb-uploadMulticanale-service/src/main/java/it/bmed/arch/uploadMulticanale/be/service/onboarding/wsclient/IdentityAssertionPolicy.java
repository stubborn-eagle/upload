
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for identity-assertion-policy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="identity-assertion-policy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="inline"/>
 *     &lt;enumeration value="wait"/>
 *     &lt;enumeration value="attached"/>
 *     &lt;enumeration value="existing"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "identity-assertion-policy")
@XmlEnum
public enum IdentityAssertionPolicy {

    @XmlEnumValue("inline")
    INLINE("inline"),
    @XmlEnumValue("wait")
    WAIT("wait"),
    @XmlEnumValue("attached")
    ATTACHED("attached"),
    @XmlEnumValue("existing")
    EXISTING("existing"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    IdentityAssertionPolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IdentityAssertionPolicy fromValue(String v) {
        for (IdentityAssertionPolicy c: IdentityAssertionPolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
