package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;
import java.util.List;

public class ArchivingPolicy implements Serializable{

	private static final long serialVersionUID = 1L;
	private String documentClass;
	private List<Attribute> attributes;
	/**
	 * @return the documentClass
	 */
	public String getDocumentClass() {
		return documentClass;
	}
	/**
	 * @param documentClass the documentClass to set
	 */
	public void setDocumentClass(String documentClass) {
		this.documentClass = documentClass;
	}
	/**
	 * @return the attributes
	 */
	public List<Attribute> getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
}
