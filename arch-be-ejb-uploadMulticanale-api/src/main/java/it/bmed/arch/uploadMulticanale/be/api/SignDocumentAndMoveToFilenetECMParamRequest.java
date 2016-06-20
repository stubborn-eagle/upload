package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
//@XmlType(name="ecmParams")
public class SignDocumentAndMoveToFilenetECMParamRequest  implements Serializable {
	private static final long serialVersionUID = -8466453819653526954L;

	private Integer idFile = null;
	
	private Boolean removeFromNAS = false;
	
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
	 * @return the removeFromNAS
	 */
	@XmlElement(nillable=false, required=false, defaultValue="false")
	public Boolean getRemoveFromNAS() {
		return removeFromNAS;
	}
	/**
	 * @param removeFromNAS the removeFromNAS to set
	 */
	public void setRemoveFromNAS(Boolean removeFromNAS) {
		this.removeFromNAS = removeFromNAS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFile == null) ? 0 : idFile.hashCode());
		result = prime * result + ((removeFromNAS == null) ? 0 : removeFromNAS.hashCode());
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
		SignDocumentAndMoveToFilenetECMParamRequest other = (SignDocumentAndMoveToFilenetECMParamRequest) obj;
		if (idFile == null) {
			if (other.idFile != null)
				return false;
		} else if (!idFile.equals(other.idFile))
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
		return "ECMParam [idFile=" + idFile + ", removeFromNAS=" + removeFromNAS + "]";
	}
	
}
