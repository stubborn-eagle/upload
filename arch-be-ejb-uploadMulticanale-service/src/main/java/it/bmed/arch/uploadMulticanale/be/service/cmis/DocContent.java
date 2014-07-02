package it.bmed.arch.uploadMulticanale.be.service.cmis;


public class DocContent {

	private String fileName;
	private String mimetype;
	//FILE CODIFICATO CHE VIENE SETTATO NEL FILE XML
	private String filecod;
	/**
	 * @return the filecod
	 */
	public String getFilecod() {
		return filecod;
	}
	/**
	 * @param filecod the filecod to set
	 */
	public void setFilecod(String filecod) {
		this.filecod = filecod;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @return the mimetype
	 */
	public String getMimetype() {
		return mimetype;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @param mimetype the mimetype to set
	 */
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	

	
}