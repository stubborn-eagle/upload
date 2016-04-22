package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

public class GetDossier implements Serializable{

	private static final long serialVersionUID = 1L;
	private String companyId;
    private String dossierId;
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

}
