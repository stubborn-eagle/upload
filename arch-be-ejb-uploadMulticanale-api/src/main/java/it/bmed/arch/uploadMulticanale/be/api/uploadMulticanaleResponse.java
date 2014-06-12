package it.bmed.arch.uploadMulticanale.be.api;

import java.util.List;

import it.bmed.asia.api.*;

public class uploadMulticanaleResponse extends BaseBeResponse<uploadMulticanaleDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private uploadMulticanaleDTO result;
	private uploadMulticanaleDTO []results;

	@Override
	public uploadMulticanaleDTO getResult() {
		return result;
	}

	@Override
	public void setResult(uploadMulticanaleDTO result) {
		this.result = result;
	}

	@Override
	public uploadMulticanaleDTO[] getResults() {
		return results;
	}

	@Override
	public void setResults(uploadMulticanaleDTO[] results) {
		this.results = results;
	}


	@Override
	public void setListResults(List<uploadMulticanaleDTO> results) {
		this.results = CommonUtils.listToArray(uploadMulticanaleDTO.class, results, true);
	}

	
}
