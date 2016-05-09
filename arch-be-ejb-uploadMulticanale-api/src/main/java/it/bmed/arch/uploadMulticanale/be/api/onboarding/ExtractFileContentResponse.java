package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

public class ExtractFileContentResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String fileContent;

	/**
	 * @return the fileContent
	 */
	public String getFileContent() {
		return fileContent;
	}

	/**
	 * @param fileContent the fileContent to set
	 */
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
}
