package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

public class MoveDossierIntoFilenetRequest implements Serializable {

	private static final long serialVersionUID = 1L;
    private String dossierId;
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
