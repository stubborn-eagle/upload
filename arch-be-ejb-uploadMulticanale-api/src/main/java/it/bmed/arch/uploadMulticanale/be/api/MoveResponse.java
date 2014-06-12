package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeResponse;

import java.util.List;

/**
 * The Class MoveResponse.
 */
public class MoveResponse extends BaseBeResponse<MoveDTO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The result. */
	private MoveDTO result;
	
	/** The results. */
	private MoveDTO[] results;
	

	/* (non-Javadoc)
	 * @see it.bmed.asia.api.AsiaDTOResponse#getResult()
	 */
	@Override
	public MoveDTO getResult() {
		return result;
	}

	/* (non-Javadoc)
	 * @see it.bmed.asia.api.AsiaDTOResponse#setResult(java.lang.Object)
	 */
	@Override
	public void setResult(MoveDTO result) {
		this.result = result;
	}

	/* (non-Javadoc)
	 * @see it.bmed.asia.api.AsiaDTOResponse#getResults()
	 */
	@Override
	public MoveDTO[] getResults() {
		return this.results;
	}

	/* (non-Javadoc)
	 * @see it.bmed.asia.api.AsiaDTOResponse#setResults(T[])
	 */
	@Override
	public void setResults(MoveDTO[] results) {
		this.results = results;
	}

	/* (non-Javadoc)
	 * @see it.bmed.asia.api.AsiaDTOResponse#setListResults(java.util.List)
	 */
	@Override
	public void setListResults(List<MoveDTO> results) {
		
	}

}
