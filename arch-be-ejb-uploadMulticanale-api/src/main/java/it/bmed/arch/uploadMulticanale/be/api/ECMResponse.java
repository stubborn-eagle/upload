package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(name="ECMResponseType")
public class ECMResponse extends BaseBeResponse<ECMFile> {
	private static final long serialVersionUID = 3955575612448558222L;
	private ECMFile result = null;
	private ECMFile[] results = null;

	public ECMResponse() {
		super();
		this.result = new ECMFile();
	}

	@Override
	@XmlElement(nillable=false, required=true)
	public ECMFile getResult() {	
		return result;
	}

	@Override
	public void setResult(ECMFile result) {
		this.result = result;
	}

	@Override
	@XmlElement(nillable=true, required=true)
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
