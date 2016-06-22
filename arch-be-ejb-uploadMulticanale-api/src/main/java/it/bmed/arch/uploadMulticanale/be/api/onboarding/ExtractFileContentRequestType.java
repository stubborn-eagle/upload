package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ExtractFileContentRequestType")
public class ExtractFileContentRequestType implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer multicanaleReferenceId;

	/**
	 * @return the multicanaleReferenceId
	 */
	public Integer getMulticanaleReferenceId() {
		return multicanaleReferenceId;
	}

	/**
	 * @param multicanaleReferenceId the multicanaleReferenceId to set
	 */
	public void setMulticanaleReferenceId(Integer multicanaleReferenceId) {
		this.multicanaleReferenceId = multicanaleReferenceId;
	}
}
