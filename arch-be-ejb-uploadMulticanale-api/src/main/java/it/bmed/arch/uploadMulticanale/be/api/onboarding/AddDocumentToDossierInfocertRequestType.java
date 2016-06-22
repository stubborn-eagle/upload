package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AddDocumentToDossierInfocertRequestType")
public class AddDocumentToDossierInfocertRequestType implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer ecmFileId;
	private String companyId;
    private String dossierId;
    private DocumentType document;
    
	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	public void setDossierId(String dossierId) {
		this.dossierId = dossierId;
	}

	/**
	 * @return the ecmFileId
	 */
	public Integer getEcmFileId() {
		return ecmFileId;
	}
	/**
	 * @param ecmFileId the ecmFileId to set
	 */
	public void setEcmFileId(Integer ecmFileId) {
		this.ecmFileId = ecmFileId;
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
