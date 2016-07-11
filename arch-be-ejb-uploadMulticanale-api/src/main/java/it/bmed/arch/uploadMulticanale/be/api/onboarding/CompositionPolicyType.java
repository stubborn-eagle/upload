package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CompositionPolicyType")
public class CompositionPolicyType implements Serializable{

	private static final long serialVersionUID = 1L;
	private String parameters;
	private String templateName;
	/**
	 * @return the parameters
	 */
	public String getParameters() {
		return parameters;
	}
	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	 
	 
}
