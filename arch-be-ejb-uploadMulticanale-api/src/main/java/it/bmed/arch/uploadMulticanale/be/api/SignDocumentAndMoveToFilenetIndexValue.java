package it.bmed.arch.uploadMulticanale.be.api;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(name="value")
public class SignDocumentAndMoveToFilenetIndexValue {
	private List<String> value;

	@XmlElement(required=true)
	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}
}
