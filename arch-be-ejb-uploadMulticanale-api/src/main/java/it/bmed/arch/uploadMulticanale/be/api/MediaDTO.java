package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;
import java.util.Date;

public class MediaDTO implements Serializable {

	private static final long	serialVersionUID	= 1227450135455809188L;
	
	
	private String Canale;
	private String ContainerType;
	private Date DataInserimento;
	private String idFileECM;
	private String ECMType;
	private String idUtente;
	private String nomeApp;	
	private String nomeFile;	
	private String Sorgente_Path;	
	private String Destinazione_Path;	
	private String Stato;	
	private String Tipo;	
	private String tipoUtente;	
	private String dominio;	

	
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
	public Date getDataInserimento() {
		return DataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		DataInserimento = dataInserimento;
	}
	public String getIdFileECM() {
		return idFileECM;
	}
	public void setIdFileECM(String idFileECM) {
		this.idFileECM = idFileECM;
	}
	public String getECMType() {
		return ECMType;
	}
	public void setECMType(String eCMType) {
		ECMType = eCMType;
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
	public String getStato() {
		return Stato;
	}
	public void setStato(String stato) {
		Stato = stato;
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
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	
	
	

}
