package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeResponse;
import it.bmed.asia.api.CommonUtils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(name="MoveResponseType")
public class MoveResponse extends BaseBeResponse<MoveDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5632350072152464284L;

	private MoveDTO result;
	private MoveDTO []results;

	public MoveResponse() {
		super();
		this.result = new MoveDTO();
	}

	@Override
	@XmlElement(nillable=false, required=true)
	public MoveDTO getResult() {
		return result;
	}

	@Override
	public void setResult(MoveDTO result) {
		this.result = result;
	}

	@Override
	@XmlElement(nillable=true, required=true)
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
