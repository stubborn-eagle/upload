package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(name="filenet")
public class SignDocumentAndMoveToFilenetFilenetRequest implements Serializable{
	private static final long serialVersionUID = 6257799055514578610L;
	
	private String objectClass;
	private SignDocumentAndMoveToFilenetIndices indices;
	private String identificationNumber;
	private String role;
	private String agency;
	
	@XmlElement(required=true)
	public String getObjectClass() {
		return objectClass;
	}
	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}
	@XmlElement(required=true)
	public SignDocumentAndMoveToFilenetIndices getIndices() {
		return indices;
	}
	public void setIndices(SignDocumentAndMoveToFilenetIndices indices) {
		this.indices = indices;
	}
	@XmlElement(required=false)
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	@XmlElement(required=false)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@XmlElement(required=false)
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
}
