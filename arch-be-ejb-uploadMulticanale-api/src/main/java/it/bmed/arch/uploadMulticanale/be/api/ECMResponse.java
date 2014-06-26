package it.bmed.arch.uploadMulticanale.be.api;

import java.util.List;

import it.bmed.asia.api.BaseBeResponse;

public class ECMResponse extends BaseBeResponse<ECMFile> {
	private static final long serialVersionUID = 3955575612448558222L;
	private ECMFile result = null;
	private ECMFile[] results = null;
	@Override
	public ECMFile getResult() {	
		return result;
	}

	@Override
	public void setResult(ECMFile result) {
		this.result = result;
	}

	@Override
	public ECMFile[] getResults() {
		return results;
	}

	@Override
	public void setResults(ECMFile[] results) {
		this.results = results;
	}

	@Override
	public void setListResults(List<ECMFile> results) {
		if (results != null && results.size() > 0) {
			ECMFile[] lista = results.toArray(new ECMFile[results.size()]);
			this.results = lista;
		} else {
			results = null;
		}
	}

}
