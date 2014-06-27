package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

public class ECMParam  implements Serializable {
	private static final long serialVersionUID = -2006320181477501366L;
	
	private Integer idFile = null;
	private ECMType ecmType = null;
	private String nameApp = null;
	private String destinationPath = null;
	private String containerType = null;
	private RemoveFromNAS removeFromNAS = null;
	
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
	 * @return the removeFromNAS
	 */
	public RemoveFromNAS getRemoveFromNAS() {
		return removeFromNAS;
	}
	/**
	 * @param removeFromNAS the removeFromNAS to set
	 */
	public void setRemoveFromNAS(RemoveFromNAS removeFromNAS) {
		this.removeFromNAS = removeFromNAS;
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
		result = prime * result + ((nameApp == null) ? 0 : nameApp.hashCode());
		result = prime * result
				+ ((removeFromNAS == null) ? 0 : removeFromNAS.hashCode());
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
		ECMParam other = (ECMParam) obj;
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
		if (nameApp == null) {
			if (other.nameApp != null)
				return false;
		} else if (!nameApp.equals(other.nameApp))
			return false;
		if (removeFromNAS != other.removeFromNAS)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ECMParam [idFile=" + idFile + ", ecmType=" + ecmType
				+ ", nameApp=" + nameApp + ", destinationPath="
				+ destinationPath + ", containerType=" + containerType
				+ ", removeFromNAS=" + removeFromNAS + "]";
	}
	
}
