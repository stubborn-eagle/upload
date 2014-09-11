package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(name="MediaDTOType")
public class MediaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4352132526659585898L;
	private String Canale = "";
	private String ContainerType = "";
	private String idFileECM = "";
	private String idUtente = "";
	private String nomeApp = "";
	private String nomeFile = "";
	private String Sorgente_Path = "";
	private String Destinazione_Path = "";
	private String Tipo = "";
	private String tipoUtente = "";
	private Integer ECMType;
	private Integer dominio;
	private Integer Stato;
	private Integer IdFile;
	
	@XmlElement(nillable=false, required=true)
	public Integer getIdFile() {
		return IdFile;
	}

	public void setIdFile(Integer idFile) {
		IdFile = idFile;
	}
	
	@XmlElement(nillable=false, required=true)
	public Integer getECMType() {
		return ECMType;
	}

	public void setECMType(Integer eCMType) {
		ECMType = eCMType;
	}
	
	@XmlElement(nillable=false, required=true)
	public Integer getStato() {
		return Stato;
	}

	public void setStato(Integer stato) {
		Stato = stato;
	}
	
	@XmlElement(nillable=false, required=true)
	public Integer getDominio() {
		return dominio;
	}

	public void setDominio(Integer dominio) {
		this.dominio = dominio;
	}
	
	@XmlElement(nillable=false, required=true)
	public String getCanale() {
		return Canale;
	}

	public void setCanale(String canale) {
		Canale = canale;
	}
	
	@XmlElement(nillable=false, required=true)
	public String getContainerType() {
		return ContainerType;
	}

	public void setContainerType(String containerType) {
		ContainerType = containerType;
	}
	
	@XmlElement(nillable=false, required=true)
	public String getIdFileECM() {
		return idFileECM;
	}

	@XmlElement(nillable=false, required=true)
	public void setIdFileECM(String idFileECM) {
		this.idFileECM = idFileECM;
	}

	@XmlElement(nillable=false, required=true)
	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}
	
	@XmlElement(nillable=false, required=true)
	public String getNomeApp() {
		return nomeApp;
	}

	public void setNomeApp(String nomeApp) {
		this.nomeApp = nomeApp;
	}

	@XmlElement(nillable=false, required=true)
	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	@XmlElement(nillable=false, required=true)
	public String getSorgente_Path() {
		return Sorgente_Path;
	}

	public void setSorgente_Path(String sorgente_Path) {
		Sorgente_Path = sorgente_Path;
	}

	
	@XmlElement(nillable=false, required=true)
	public String getDestinazione_Path() {
		return Destinazione_Path;
	}

	public void setDestinazione_Path(String destinazione_Path) {
		Destinazione_Path = destinazione_Path;
	}

	@XmlElement(nillable=false, required=true)
	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	@XmlElement(nillable=false, required=true)
	public String getTipoUtente() {
		return tipoUtente;
	}

	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}

}
