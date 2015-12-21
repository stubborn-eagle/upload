package it.bmed.arch.uploadMulticanale.be.api;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

//@XmlType(name="indices")
public class SignDocumentAndMoveToFilenetIndices {
	
	private String documentCode;
	private List<SignDocumentAndMoveToFilenetIndex> index;
	
	@XmlElement(required=true, nillable=false)
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	@XmlElement(required=false)
	public List<SignDocumentAndMoveToFilenetIndex> getIndex() {
		return index;
	}
	public void setIndex(List<SignDocumentAndMoveToFilenetIndex> index) {
		this.index = index;
	}
}
