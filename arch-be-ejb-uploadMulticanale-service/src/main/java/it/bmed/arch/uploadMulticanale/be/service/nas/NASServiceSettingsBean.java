package it.bmed.arch.uploadMulticanale.be.service.nas;

public class NASServiceSettingsBean {
	private String nasInternetBankingPath = null;
	private String nasReteDiVenditaPath = null;
	private String nasPortaleDiSedePath = null;
	private String nasInternetBankingDeletedPath = null;
	private String nasReteDiVenditaDeletedPath = null;
	private String nasPortaleDiSedeDeletedPath = null;
	/**
	 * @return the nasInternetBankingPath
	 */
	public String getNasInternetBankingPath() {
		return nasInternetBankingPath;
	}
	/**
	 * @param nasInternetBankingPath the nasInternetBankingPath to set
	 */
	public void setNasInternetBankingPath(String nasInternetBankingPath) {
		this.nasInternetBankingPath = nasInternetBankingPath;
	}
	/**
	 * @return the nasReteDiVenditaPath
	 */
	public String getNasReteDiVenditaPath() {
		return nasReteDiVenditaPath;
	}
	/**
	 * @param nasReteDiVenditaPath the nasReteDiVenditaPath to set
	 */
	public void setNasReteDiVenditaPath(String nasReteDiVenditaPath) {
		this.nasReteDiVenditaPath = nasReteDiVenditaPath;
	}
	/**
	 * @return the nasPortaleDiSedePath
	 */
	public String getNasPortaleDiSedePath() {
		return nasPortaleDiSedePath;
	}
	/**
	 * @param nasPortaleDiSedePath the nasPortaleDiSedePath to set
	 */
	public void setNasPortaleDiSedePath(String nasPortaleDiSedePath) {
		this.nasPortaleDiSedePath = nasPortaleDiSedePath;
	}
	/**
	 * @return the nasInternetBankingDeletedPath
	 */
	public String getNasInternetBankingDeletedPath() {
		return nasInternetBankingDeletedPath;
	}
	/**
	 * @param nasInternetBankingDeletedPath the nasInternetBankingDeletedPath to set
	 */
	public void setNasInternetBankingDeletedPath(
			String nasInternetBankingDeletedPath) {
		this.nasInternetBankingDeletedPath = nasInternetBankingDeletedPath;
	}
	/**
	 * @return the nasReteDiVenditaDeletedPath
	 */
	public String getNasReteDiVenditaDeletedPath() {
		return nasReteDiVenditaDeletedPath;
	}
	/**
	 * @param nasReteDiVenditaDeletedPath the nasReteDiVenditaDeletedPath to set
	 */
	public void setNasReteDiVenditaDeletedPath(String nasReteDiVenditaDeletedPath) {
		this.nasReteDiVenditaDeletedPath = nasReteDiVenditaDeletedPath;
	}
	/**
	 * @return the nasPortaleDiSedeDeletedPath
	 */
	public String getNasPortaleDiSedeDeletedPath() {
		return nasPortaleDiSedeDeletedPath;
	}
	/**
	 * @param nasPortaleDiSedeDeletedPath the nasPortaleDiSedeDeletedPath to set
	 */
	public void setNasPortaleDiSedeDeletedPath(String nasPortaleDiSedeDeletedPath) {
		this.nasPortaleDiSedeDeletedPath = nasPortaleDiSedeDeletedPath;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((nasInternetBankingDeletedPath == null) ? 0
						: nasInternetBankingDeletedPath.hashCode());
		result = prime
				* result
				+ ((nasInternetBankingPath == null) ? 0
						: nasInternetBankingPath.hashCode());
		result = prime
				* result
				+ ((nasPortaleDiSedeDeletedPath == null) ? 0
						: nasPortaleDiSedeDeletedPath.hashCode());
		result = prime
				* result
				+ ((nasPortaleDiSedePath == null) ? 0 : nasPortaleDiSedePath
						.hashCode());
		result = prime
				* result
				+ ((nasReteDiVenditaDeletedPath == null) ? 0
						: nasReteDiVenditaDeletedPath.hashCode());
		result = prime
				* result
				+ ((nasReteDiVenditaPath == null) ? 0 : nasReteDiVenditaPath
						.hashCode());
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
		NASServiceSettingsBean other = (NASServiceSettingsBean) obj;
		if (nasInternetBankingDeletedPath == null) {
			if (other.nasInternetBankingDeletedPath != null)
				return false;
		} else if (!nasInternetBankingDeletedPath
				.equals(other.nasInternetBankingDeletedPath))
			return false;
		if (nasInternetBankingPath == null) {
			if (other.nasInternetBankingPath != null)
				return false;
		} else if (!nasInternetBankingPath.equals(other.nasInternetBankingPath))
			return false;
		if (nasPortaleDiSedeDeletedPath == null) {
			if (other.nasPortaleDiSedeDeletedPath != null)
				return false;
		} else if (!nasPortaleDiSedeDeletedPath
				.equals(other.nasPortaleDiSedeDeletedPath))
			return false;
		if (nasPortaleDiSedePath == null) {
			if (other.nasPortaleDiSedePath != null)
				return false;
		} else if (!nasPortaleDiSedePath.equals(other.nasPortaleDiSedePath))
			return false;
		if (nasReteDiVenditaDeletedPath == null) {
			if (other.nasReteDiVenditaDeletedPath != null)
				return false;
		} else if (!nasReteDiVenditaDeletedPath
				.equals(other.nasReteDiVenditaDeletedPath))
			return false;
		if (nasReteDiVenditaPath == null) {
			if (other.nasReteDiVenditaPath != null)
				return false;
		} else if (!nasReteDiVenditaPath.equals(other.nasReteDiVenditaPath))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NASServiceSettings [nasInternetBankingPath="
				+ nasInternetBankingPath + ", nasReteDiVenditaPath="
				+ nasReteDiVenditaPath + ", nasPortaleDiSedePath="
				+ nasPortaleDiSedePath + ", nasInternetBankingDeletedPath="
				+ nasInternetBankingDeletedPath
				+ ", nasReteDiVenditaDeletedPath="
				+ nasReteDiVenditaDeletedPath
				+ ", nasPortaleDiSedeDeletedPath="
				+ nasPortaleDiSedeDeletedPath + "]";
	}
	
	
}
