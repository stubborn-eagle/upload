package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "DocumentParamType")
public class IndexValueListType implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<IndexValueType> indexValueType;


	/**
	 * @return the indexValueType
	 */
	public List<IndexValueType> getIndexValueType() {
		return indexValueType;
	}

	/**
	 * @param indexValueType the indexValueType to set
	 */
	public void setIndexValueType(List<IndexValueType> indexValueType) {
		this.indexValueType = indexValueType;
	}

	
}
