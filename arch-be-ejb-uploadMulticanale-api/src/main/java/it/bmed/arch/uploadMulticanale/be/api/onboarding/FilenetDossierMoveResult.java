package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

public class FilenetDossierMoveResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String dossierId;
	private String dossierFileId;
	private String filenetId;
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
	 * @return the dossierFileId
	 */
	public String getDossierFileId() {
		return dossierFileId;
	}
	/**
	 * @param dossierFileId the dossierFileId to set
	 */
	public void setDossierFileId(String dossierFileId) {
		this.dossierFileId = dossierFileId;
	}
	/**
	 * @return the filenetId
	 */
	public String getFilenetId() {
		return filenetId;
	}
	/**
	 * @param filenetId the filenetId to set
	 */
	public void setFilenetId(String filenetId) {
		this.filenetId = filenetId;
	}
	
}
