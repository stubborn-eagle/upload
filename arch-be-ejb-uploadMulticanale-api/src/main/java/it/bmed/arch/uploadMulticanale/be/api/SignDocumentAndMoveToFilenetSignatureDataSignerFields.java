package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;
import java.util.List;

public class SignDocumentAndMoveToFilenetSignatureDataSignerFields implements Serializable{
	private static final long serialVersionUID = 233402674838358060L;
	
	private List<SignDocumentAndMoveToFilenetSignatureDataSignerField> field;

	public List<SignDocumentAndMoveToFilenetSignatureDataSignerField> getField() {
		return field;
	}

	public void setField(List<SignDocumentAndMoveToFilenetSignatureDataSignerField> field) {
		this.field = field;
	}
}