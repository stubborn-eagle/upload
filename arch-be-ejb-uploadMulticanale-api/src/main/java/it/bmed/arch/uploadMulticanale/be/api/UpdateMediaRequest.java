package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;

public class UpdateMediaRequest extends BaseBeRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 487891423675206263L;
	private Integer IdFile;
	private Integer ECMType;
	private Integer Stato;
	private String Destinazione_path;
	private String idFileECM;
	private String Container_type;
	private String nameApp;

	public String getNameApp() {
		return nameApp;
	}

	public void setNameApp(String nameApp) {
		this.nameApp = nameApp;
	}

	public Integer getIdFile() {
		return IdFile;
	}

	public void setIdFile(Integer idFile) {
		IdFile = idFile;
	}

	public Integer getECMType() {
		return ECMType;
	}

	public void setECMType(Integer eCMType) {
		ECMType = eCMType;
	}

	public Integer getStato() {
		return Stato;
	}

	public void setStato(Integer stato) {
		Stato = stato;
	}

	public String getDestinazione_path() {
		return Destinazione_path;
	}

	public void setDestinazione_path(String destinazione_path) {
		Destinazione_path = destinazione_path;
	}

	public String getIdFileECM() {
		return idFileECM;
	}

	public void setIdFileECM(String idFileECM) {
		this.idFileECM = idFileECM;
	}

	public String getContainer_type() {
		return Container_type;
	}

	public void setContainer_type(String container_type) {
		Container_type = container_type;
	}

}
