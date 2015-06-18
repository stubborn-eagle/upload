package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeResponse;
import it.bmed.asia.api.CommonUtils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(name="AzureResponseType")
public class AzureResponse extends BaseBeResponse<AzureDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5632350072152464284L;

	private AzureDTO result;
	private AzureDTO []results;

	@Override
	@XmlElement(nillable=false, required=true)
	public AzureDTO getResult() {
		return result;
	}

	@Override
	public void setResult(AzureDTO result) {
		this.result = result;
	}

	@Override
	@XmlElement(nillable=true, required=true)
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
