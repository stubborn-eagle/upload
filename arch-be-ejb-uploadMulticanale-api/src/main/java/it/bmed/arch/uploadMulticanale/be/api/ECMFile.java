/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

/**
 * @author donatello.boccaforno
 *
 */
public class ECMFile implements Serializable {
	private static final long serialVersionUID = 5155691486395220554L;
	
	private String channel;
	private String containerType;
	private String idFileECM;
	private String userId;
	private String nameApp;
	private String nameFile;
	private String sourcePath;
	private String destinationPath;
	private String type;
	private String userType;
	private ECMType ecmType;
	private ECMSource source;
	private ECMState state;
	private Integer idFile;
	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * @return the source
	 */
	public ECMSource getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(ECMSource source) {
		this.source = source;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * @return the containerType
	 */
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
	 * @return the idFileECM
	 */
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the nameApp
	 */
	public String getNameApp() {
		return nameApp;
	}
	/**
	 * @param nameApp the nameApp to set
	 */
	public void setNameApp(String nameApp) {
		this.nameApp = nameApp;
	}
	/**
	 * @return the nameFile
	 */
	public String getNameFile() {
		return nameFile;
	}
	/**
	 * @param nameFile the nameFile to set
	 */
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	/**
	 * @return the sourcePath
	 */
	public String getSourcePath() {
		return sourcePath;
	}
	/**
	 * @param sourcePath the sourcePath to set
	 */
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	/**
	 * @return the destinationPath
	 */
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the ecmType
	 */
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
	 * @return the idFile
	 */
	public Integer getIdFile() {
		return idFile;
	}
	/**
	 * @param idFile the idFile to set
	 */
	public void setIdFile(Integer idFile) {
		this.idFile = idFile;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result
				+ ((containerType == null) ? 0 : containerType.hashCode());
		result = prime * result
				+ ((destinationPath == null) ? 0 : destinationPath.hashCode());
		result = prime * result + ((ecmType == null) ? 0 : ecmType.hashCode());
		result = prime * result + ((idFile == null) ? 0 : idFile.hashCode());
		result = prime * result
				+ ((idFileECM == null) ? 0 : idFileECM.hashCode());
		result = prime * result + ((nameApp == null) ? 0 : nameApp.hashCode());
		result = prime * result
				+ ((nameFile == null) ? 0 : nameFile.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result
				+ ((sourcePath == null) ? 0 : sourcePath.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
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
		ECMFile other = (ECMFile) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
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
		if (nameFile == null) {
			if (other.nameFile != null)
				return false;
		} else if (!nameFile.equals(other.nameFile))
			return false;
		if (source != other.source)
			return false;
		if (sourcePath == null) {
			if (other.sourcePath != null)
				return false;
		} else if (!sourcePath.equals(other.sourcePath))
			return false;
		if (state != other.state)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ECMFile [channel=" + channel + ", containerType="
				+ containerType + ", idFileECM=" + idFileECM + ", userId="
				+ userId + ", nameApp=" + nameApp + ", nameFile=" + nameFile
				+ ", sourcePath=" + sourcePath + ", destinationPath="
				+ destinationPath + ", type=" + type + ", userType=" + userType
				+ ", ecmType=" + ecmType + ", source=" + source + ", state="
				+ state + ", idFile=" + idFile + "]";
	}
}
