package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

public class SignDocumentAndMoveToFilenetSignatureDataSigner implements Serializable{
	private static final long serialVersionUID = 2922103696028196248L;

	private String alias = null;
	
	private String domain = null;
		
	private String pin = null;
	
	private Integer otp = null;
	
	private SignDocumentAndMoveToFilenetSignatureDataSignerFields fields;

	@XmlElement(required=false)
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@XmlElement(required=false)
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@XmlElement(required=false)
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	@XmlElement(required=false)
	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public SignDocumentAndMoveToFilenetSignatureDataSignerFields getFields() {
		return fields;
	}

	public void setFields(SignDocumentAndMoveToFilenetSignatureDataSignerFields fields) {
		this.fields = fields;
	}
}
