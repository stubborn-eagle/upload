package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(name="signatureData")
public class SignDocumentAndMoveToFilenetSignatureDataRequest implements Serializable{
	
	private String domain = null;
	
	private String alias = null;
	
	private String pin = null;
	
	private Integer otp = null;
	
	private String signers = null;

	@XmlElement(nillable=true, required=false)
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@XmlElement(nillable=true, required=false)
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	@XmlElement(nillable=true, required=false)
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@XmlElement(nillable=true, required=false)
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	@XmlElement(nillable=true, required=false)
	public String getSigners() {
		return signers;
	}
	public void setSigners(String signers) {
		this.signers = signers;
	}
}
