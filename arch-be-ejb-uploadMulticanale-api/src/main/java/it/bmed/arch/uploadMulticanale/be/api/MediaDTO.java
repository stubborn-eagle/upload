package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

public class MediaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4352132526659585898L;
	private String Canale;
	private String ContainerType;
	private String idFileECM;
	private String idUtente;
	private String nomeApp;
	private String nomeFile;
	private String Sorgente_Path;
	private String Destinazione_Path;
	private String Tipo;
	private String tipoUtente;
	private Integer ECMType;
	private Integer dominio;
	private Integer Stato;
	private Integer IdFile;

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

	public Integer getDominio() {
		return dominio;
	}

	public void setDominio(Integer dominio) {
		this.dominio = dominio;
	}

	public String getCanale() {
		return Canale;
	}

	public void setCanale(String canale) {
		Canale = canale;
	}

	public String getContainerType() {
		return ContainerType;
	}

	public void setContainerType(String containerType) {
		ContainerType = containerType;
	}

	public String getIdFileECM() {
		return idFileECM;
	}

	public void setIdFileECM(String idFileECM) {
		this.idFileECM = idFileECM;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public String getNomeApp() {
		return nomeApp;
	}

	public void setNomeApp(String nomeApp) {
		this.nomeApp = nomeApp;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getSorgente_Path() {
		return Sorgente_Path;
	}

	public void setSorgente_Path(String sorgente_Path) {
		Sorgente_Path = sorgente_Path;
	}

	public String getDestinazione_Path() {
		return Destinazione_Path;
	}

	public void setDestinazione_Path(String destinazione_Path) {
		Destinazione_Path = destinazione_Path;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getTipoUtente() {
		return tipoUtente;
	}

	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}

}
