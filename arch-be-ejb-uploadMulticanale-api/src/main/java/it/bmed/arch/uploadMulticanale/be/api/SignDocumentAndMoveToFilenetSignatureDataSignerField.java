package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class SignDocumentAndMoveToFilenetSignatureDataSignerField implements Serializable {
	private static final long serialVersionUID = -6284659317982481030L;
	
	private String name = null;
	private String reason = null;
	private String location = null;
	
	@XmlElement(required=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(required=false)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@XmlElement(required=false)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
