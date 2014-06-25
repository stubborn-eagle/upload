package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;

public class UpdateMediaRequest extends BaseBeRequest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7089630504774213849L;
	private String IdFile;
	private String ECMType;
	private String Stato;
	private String Destinazione_path;
	private String idFileECM;
	private String Container_type;
	
	public String getIdFile() {
		return IdFile;
	}
	public void setIdFile(String idFile) {
		IdFile = idFile;
	}
	public String getECMType() {
		return ECMType;
	}
	public void setECMType(String eCMType) {
		ECMType = eCMType;
	}
	public String getStato() {
		return Stato;
	}
	public void setStato(String stato) {
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
