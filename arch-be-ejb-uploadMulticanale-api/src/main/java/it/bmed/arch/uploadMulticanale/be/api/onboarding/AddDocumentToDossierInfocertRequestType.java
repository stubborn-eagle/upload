package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AddDocumentToDossierInfocertRequestType")
public class AddDocumentToDossierInfocertRequestType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer ecmFileId;

	private String dossierId;
    
	private DocumentType document;

	/**
	 * @return the ecmFileId
	 */
	public Integer getEcmFileId() {
		return ecmFileId;
	}

	/**
	 * @param ecmFileId the ecmFileId to set
	 */
	@XmlElement(name = "ecmFileId", required = true, nillable = false)
	public void setEcmFileId(Integer ecmFileId) {
		this.ecmFileId = ecmFileId;
	}

	/**
	 * @return the dossierId
	 */
	public String getDossierId() {
		return dossierId;
	}

	/**
	 * @param dossierId the dossierId to set
	 */
	@XmlElement(name = "dossierId", required = true, nillable = false)
	public void setDossierId(String dossierId) {
		this.dossierId = dossierId;
	}

	/**
	 * @return the document
	 */
	public DocumentType getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(DocumentType document) {
		this.document = document;
	}

	
	
	
}
