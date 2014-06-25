package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeResponse;
import it.bmed.asia.api.CommonUtils;

import java.util.List;

public class MoveResponse extends BaseBeResponse<MoveDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5632350072152464284L;

	private MoveDTO result;
	private MoveDTO []results;

	@Override
	public MoveDTO getResult() {
		return result;
	}

	@Override
	public void setResult(MoveDTO result) {
		this.result = result;
	}

	@Override
	public MoveDTO[] getResults() {
		return results;
	}

	@Override
	public void setResults(MoveDTO[] results) {
		this.results = results;
	}


	@Override
	public void setListResults(List<MoveDTO> results) {
		this.results = CommonUtils.listToArray(MoveDTO.class, results, true);
	}

	
}
