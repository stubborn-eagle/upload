package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SignatureFieldType")
public class SignatureFieldType implements Serializable {

	private static final long serialVersionUID = 1L;
	private String reason;
	private String location;
	private String signerId;
	private String name;
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the signerId
	 */
	public String getSignerId() {
		return signerId;
	}
	/**
	 * @param signerId the signerId to set
	 */
	public void setSignerId(String signerId) {
		this.signerId = signerId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
