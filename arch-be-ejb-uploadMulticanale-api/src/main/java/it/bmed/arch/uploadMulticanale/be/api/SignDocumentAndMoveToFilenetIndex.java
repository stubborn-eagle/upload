package it.bmed.arch.uploadMulticanale.be.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(name="index")
public class SignDocumentAndMoveToFilenetIndex {
	private String name;
	
	private SignDocumentAndMoveToFilenetIndexValue values;
	
	private Boolean search;

	@XmlElement(required=true, nillable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(required=true, nillable=false)
	public SignDocumentAndMoveToFilenetIndexValue getValues() {
		return values;
	}

	public void setValues(SignDocumentAndMoveToFilenetIndexValue values) {
		this.values = values;
	}

	@XmlElement(required=false, nillable=false, defaultValue="false")
	public Boolean getSearch() {
		return search;
	}

	public void setSearch(Boolean search) {
		this.search = search;
	}
}
