package it.bmed.arch.uploadMulticanale.be.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import it.bmed.asia.api.BaseBeRequest;
@XmlType(name="UpdateECMRequestType")
public class UpdateECMRequest extends BaseBeRequest {
	private static final long serialVersionUID = 487891423675206263L;
	private Integer idFile;
	private ECMType ecmType;
	private ECMState state;
	private String destinationPath;
	private String idFileECM;
	private String containerType;
	private String nameApp;
	
	
	public UpdateECMRequest() {
		super();
		destinationPath = "";
		idFileECM = "";
		containerType = "";
		nameApp = "";
	}
	/**
	 * @return the idFile
	 */
	@XmlElement(nillable=false, required=true)
	public Integer getIdFile() {
		return idFile;
	}
	/**
	 * @param idFile the idFile to set
	 */
	public void setIdFile(Integer idFile) {
		this.idFile = idFile;
	}
	/**
	 * @return the ecmType
	 */
	@XmlElement(nillable=false, required=true)
	public ECMType getEcmType() {
		return ecmType;
	}
	/**
	 * @param ecmType the ecmType to set
	 */
	public void setEcmType(ECMType ecmType) {
		this.ecmType = ecmType;
	}
	/**
	 * @return the state
	 */
	@XmlElement(nillable=false, required=true)
	public ECMState getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(ECMState state) {
		this.state = state;
	}
	/**
	 * @return the destinationPath
	 */
	@XmlElement(nillable=false, required=true)
	public String getDestinationPath() {
		return destinationPath;
	}
	/**
	 * @param destinationPath the destinationPath to set
	 */
	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}
	/**
	 * @return the idFileECM
	 */
	@XmlElement(nillable=false, required=true)
	public String getIdFileECM() {
		return idFileECM;
	}
	/**
	 * @param idFileECM the idFileECM to set
	 */
	public void setIdFileECM(String idFileECM) {
		this.idFileECM = idFileECM;
	}
	/**
	 * @return the containerType
	 */
	@XmlElement(nillable=false, required=true)
	public String getContainerType() {
		return containerType;
	}
	/**
	 * @param containerType the containerType to set
	 */
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	/**
	 * @return the nameApp
	 */
	@XmlElement(nillable=false, required=true)
	public String getNameApp() {
		return nameApp;
	}
	/**
	 * @param nameApp the nameApp to set
	 */
	public void setNameApp(String nameApp) {
		this.nameApp = nameApp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((containerType == null) ? 0 : containerType.hashCode());
		result = prime * result
				+ ((destinationPath == null) ? 0 : destinationPath.hashCode());
		result = prime * result + ((ecmType == null) ? 0 : ecmType.hashCode());
		result = prime * result + ((idFile == null) ? 0 : idFile.hashCode());
		result = prime * result
				+ ((idFileECM == null) ? 0 : idFileECM.hashCode());
		result = prime * result + ((nameApp == null) ? 0 : nameApp.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateECMRequest other = (UpdateECMRequest) obj;
		if (containerType == null) {
			if (other.containerType != null)
				return false;
		} else if (!containerType.equals(other.containerType))
			return false;
		if (destinationPath == null) {
			if (other.destinationPath != null)
				return false;
		} else if (!destinationPath.equals(other.destinationPath))
			return false;
		if (ecmType != other.ecmType)
			return false;
		if (idFile == null) {
			if (other.idFile != null)
				return false;
		} else if (!idFile.equals(other.idFile))
			return false;
		if (idFileECM == null) {
			if (other.idFileECM != null)
				return false;
		} else if (!idFileECM.equals(other.idFileECM))
			return false;
		if (nameApp == null) {
			if (other.nameApp != null)
				return false;
		} else if (!nameApp.equals(other.nameApp))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateECMRequest [idFile=" + idFile + ", ecmType=" + ecmType
				+ ", state=" + state + ", destinationPath=" + destinationPath
				+ ", idFileECM=" + idFileECM + ", containerType="
				+ containerType + ", nameApp=" + nameApp + "]";
	}

	

}
