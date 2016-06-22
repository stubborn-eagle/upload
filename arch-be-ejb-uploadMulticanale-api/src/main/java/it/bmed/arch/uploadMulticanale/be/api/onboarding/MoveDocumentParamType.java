package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MoveDocumentParamType")
public class MoveDocumentParamType implements Serializable {

	private static final long serialVersionUID = 1L;

	private String infocertDocumentId;
	private String filenetObjectClass;
	private IndexValueListType indexValueListType;
	/**
	 * @return the infocertDocumentId
	 */
	public String getInfocertDocumentId() {
		return infocertDocumentId;
	}
	/**
	 * @param infocertDocumentId the infocertDocumentId to set
	 */
	public void setInfocertDocumentId(String infocertDocumentId) {
		this.infocertDocumentId = infocertDocumentId;
	}
	/**
	 * @return the filenetObjectClass
	 */
	public String getFilenetObjectClass() {
		return filenetObjectClass;
	}
	/**
	 * @param filenetObjectClass the filenetObjectClass to set
	 */
	public void setFilenetObjectClass(String filenetObjectClass) {
		this.filenetObjectClass = filenetObjectClass;
	}
	/**
	 * @return the indexValueListType
	 */
	public IndexValueListType getIndexValueListType() {
		return indexValueListType;
	}
	/**
	 * @param indexValueListType the indexValueListType to set
	 */
	public void setIndexValueListType(IndexValueListType indexValueListType) {
		this.indexValueListType = indexValueListType;
	}


}
