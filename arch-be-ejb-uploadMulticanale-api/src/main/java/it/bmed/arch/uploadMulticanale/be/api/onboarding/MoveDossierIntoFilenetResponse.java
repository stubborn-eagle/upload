package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;
import java.util.List;

public class MoveDossierIntoFilenetResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<FilenetDossierMoveResult> filenetResults;

	/**
	 * @return the filenetResults
	 */
	public List<FilenetDossierMoveResult> getFilenetResults() {
		return filenetResults;
	}

	/**
	 * @param filenetResults the filenetResults to set
	 */
	public void setFilenetResults(List<FilenetDossierMoveResult> filenetResults) {
		this.filenetResults = filenetResults;
	}
}
