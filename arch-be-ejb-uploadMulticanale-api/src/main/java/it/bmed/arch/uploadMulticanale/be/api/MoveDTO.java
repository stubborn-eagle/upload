package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

/**
 * Request DTO for Move operation
 * @author donatello.boccaforno
 *
 */
public class MoveDTO implements Serializable {
	private static final long serialVersionUID = -4035052721772232075L;	

	private String ecmFileId = null;
	private Integer fileId = null;
	
	
	public MoveDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the ecmFileId
	 */
	public String getEcmFileId() {
		return ecmFileId;
	}
	/**
	 * @param ecmFileId the ecmFileId to set
	 */
	public void setEcmFileId(String ecmFileId) {
		this.ecmFileId = ecmFileId;
	}
	/**
	 * @return the fileId
	 */
	public Integer getFileId() {
		return fileId;
	}
	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ecmFileId == null) ? 0 : ecmFileId.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
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
		MoveDTO other = (MoveDTO) obj;
		if (ecmFileId == null) {
			if (other.ecmFileId != null)
				return false;
		} else if (!ecmFileId.equals(other.ecmFileId))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MoveDTO [ecmFileId=" + ecmFileId + ", fileId=" + fileId + "]";
	} 

	
}
