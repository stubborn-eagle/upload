package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

//@XmlType(name="index")
public class SignDocumentAndMoveToFilenetIndex implements Serializable{
	private static final long serialVersionUID = 3865092048747397610L;

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
