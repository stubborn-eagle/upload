package it.bmed.arch.uploadMulticanale.be.api;

import java.util.List;

import it.bmed.asia.api.*;

public class AzureResponse extends BaseBeResponse<AzureDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5632350072152464284L;

	private AzureDTO result;
	private AzureDTO []results;

	@Override
	public AzureDTO getResult() {
		return result;
	}

	@Override
	public void setResult(AzureDTO result) {
		this.result = result;
	}

	@Override
	public AzureDTO[] getResults() {
		return results;
	}

	@Override
	public void setResults(AzureDTO[] results) {
		this.results = results;
	}


	@Override
	public void setListResults(List<AzureDTO> results) {
		this.results = CommonUtils.listToArray(AzureDTO.class, results, true);
	}

	
}
