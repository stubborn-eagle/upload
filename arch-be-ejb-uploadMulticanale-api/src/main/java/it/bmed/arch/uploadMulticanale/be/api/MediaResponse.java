package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeResponse;

import java.util.List;

public class MediaResponse extends BaseBeResponse<MediaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MediaDTO result;
	private MediaDTO[] results;

	// private boolean Response;

	@Override
	public MediaDTO getResult() {
		return result;
	}

	@Override
	public void setResult(MediaDTO result) {
		this.result = result;
	}

	@Override
	public MediaDTO[] getResults() {
		// TODO Auto-generated method stub
		return this.results;
	}

	@Override
	public void setResults(MediaDTO[] results) {
		// TODO Auto-generated method stub
		this.results = results;
	}

	@Override
	public void setListResults(List<MediaDTO> results) {
		// TODO Auto-generated method stub
		if (results != null && results.size() > 0) {
			MediaDTO[] lista = results.toArray(new MediaDTO[results.size()]);
			this.results = lista;
		} else {
			results = null;
		}
	}

	/*
	 * public boolean getResponse() { return Response; }
	 * 
	 * public void setResponse(boolean response) { Response = response; }
	 */

}
