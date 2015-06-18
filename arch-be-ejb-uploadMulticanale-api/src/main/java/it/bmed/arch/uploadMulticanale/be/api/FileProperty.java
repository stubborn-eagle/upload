package it.bmed.arch.uploadMulticanale.be.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="FilePropertyType")
public class FileProperty {

	private String name = "";
	private String value = "";
	@XmlElement(nillable=false, required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(nillable=false, required=true)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
