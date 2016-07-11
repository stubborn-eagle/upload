package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MoveDossierIntoFilenetResponseType")
public class MoveDossierIntoFilenetResponseType implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<FilenetDossierMoveResultType> filenetResults;

	/**
	 * @return the filenetResults
	 */
	public List<FilenetDossierMoveResultType> getFilenetResults() {
		return filenetResults;
	}

	/**
	 * @param filenetResults the filenetResults to set
	 */
	public void setFilenetResults(List<FilenetDossierMoveResultType> filenetResults) {
		this.filenetResults = filenetResults;
	}
}
