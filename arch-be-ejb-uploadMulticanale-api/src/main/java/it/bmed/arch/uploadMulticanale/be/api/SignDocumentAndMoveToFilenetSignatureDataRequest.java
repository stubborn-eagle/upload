package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(name="signatureData")
public class SignDocumentAndMoveToFilenetSignatureDataRequest implements Serializable{
	private static final long serialVersionUID = 6309405016747178298L;

	private String ndg1 = null;
	private String ndg2 = null;
	private String ndg3 = null;
	private String codClient = null;
	private String codDocument = null;
	private String referenceDate = null;
	
	private SignDocumentAndMoveToFilenetSignatureDataSigners signers = null;

	@XmlElement(required=false)
	public String getNdg1() {
		return ndg1;
	}

	public void setNdg1(String ndg1) {
		this.ndg1 = ndg1;
	}

	@XmlElement(required=false)
	public String getNdg2() {
		return ndg2;
	}

	public void setNdg2(String ndg2) {
		this.ndg2 = ndg2;
	}

	@XmlElement(required=false)
	public String getNdg3() {
		return ndg3;
	}

	public void setNdg3(String ndg3) {
		this.ndg3 = ndg3;
	}

	@XmlElement(required=false)
	public String getCodClient() {
		return codClient;
	}

	public void setCodClient(String codClient) {
		this.codClient = codClient;
	}

	@XmlElement(required=false)
	public String getCodDocument() {
		return codDocument;
	}

	public void setCodDocument(String codDocument) {
		this.codDocument = codDocument;
	}

	@XmlElement(required=false)
	public String getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	public SignDocumentAndMoveToFilenetSignatureDataSigners getSigners() {
		return signers;
	}

	public void setSigners(SignDocumentAndMoveToFilenetSignatureDataSigners signers) {
		this.signers = signers;
	}
}
