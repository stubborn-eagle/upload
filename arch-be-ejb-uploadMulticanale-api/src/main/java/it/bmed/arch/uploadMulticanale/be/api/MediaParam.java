package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MediaParam implements Serializable {

	private static final long	serialVersionUID	= 8510896538787035504L;

	private String idFile;
	private String nomeFile;
	private String idECMFile;
	private String ecmType;
	private String tipo;
	private String nomeApp;
	private String canale;
	private String sorgente_path;
	private String destinazione_path;
	private String idUtente;
	private String tipoUtente;
	private String stato;
	private long dataInserimento;
	private long dataAggiornamento;
	private String containerType;

	private ArrayList<FileProperty> property;
	
	


	
	
	
	
	public String getIdFile()
	{
		return idFile;
	}
	public void setIdFile(String idFile)
	{
		this.idFile = idFile;
	}
	public String getNomeFile()
	{
		return nomeFile;
	}
	public void setNomeFile(String nomeFile)
	{
		this.nomeFile = nomeFile;
	}
	public String getIdECMFile()
	{
		return idECMFile;
	}
	public void setIdECMFile(String idECMFile)
	{
		this.idECMFile = idECMFile;
	}
	public String getTipo()
	{
		return tipo;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public String getNomeApp()
	{
		return nomeApp;
	}
	public void setNomeApp(String nomeApp)
	{
		this.nomeApp = nomeApp;
	}
	public String getCanale()
	{
		return canale;
	}
	public void setCanale(String canale)
	{
		this.canale = canale;
	}
	public String getSorgente_path()
	{
		return sorgente_path;
	}
	public void setSorgente_path(String sorgente_path)
	{
		this.sorgente_path = sorgente_path;
	}
	public String getDestinazione_path()
	{
		return destinazione_path;
	}
	public void setDestinazione_path(String destinazione_path)
	{
		this.destinazione_path = destinazione_path;
	}
	public String getIdUtente()
	{
		return idUtente;
	}
	public void setIdUtente(String idUtente)
	{
		this.idUtente = idUtente;
	}
	public String getTipoUtente()
	{
		return tipoUtente;
	}
	public void setTipoUtente(String tipoUtente)
	{
		this.tipoUtente = tipoUtente;
	}
	public String getStato()
	{
		return stato;
	}
	public void setStato(String stato)
	{
		this.stato = stato;
	}
	public long getDataInserimento()
	{
		return dataInserimento;
	}
	public void setDataInserimento(long dataInserimento)
	{
		this.dataInserimento = dataInserimento;
	}
	public long getDataAggiornamento()
	{
		return dataAggiornamento;
	}
	public void setDataAggiornamento(long dataAggiornamento)
	{
		this.dataAggiornamento = dataAggiornamento;
	}
	public String getContainerType()
	{
		return containerType;
	}
	public void setContainerType(String containerType)
	{
		this.containerType = containerType;
	}
	public ArrayList<FileProperty> getProperty()
	{
		return property;
	}
	public void setProperty(ArrayList<FileProperty> property)
	{
		this.property = property;
	}
	public String getEcmType()
	{
		return ecmType;
	}
	public void setEcmType(String ecmType)
	{
		this.ecmType = ecmType;
	}
	
	
	
	
	
	
}
