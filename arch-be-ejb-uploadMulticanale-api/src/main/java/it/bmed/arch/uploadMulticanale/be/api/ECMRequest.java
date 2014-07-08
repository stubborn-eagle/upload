package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;

public class ECMRequest extends BaseBeRequest {
	private static final long serialVersionUID = 9170130458793882791L;
	
//	private RequestMetaData requestMetaData = null;
	private ECMFile ecmFile = null;
	/**
	 * @return the ecmFile
	 */
	public ECMFile getEcmFile() {
		return ecmFile;
	}
	/**
	 * @param ecmFile the ecmFile to set
	 */
	public void setEcmFile(ECMFile ecmFile) {
		this.ecmFile = ecmFile;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ECMRequest [ecmFile=" + ecmFile + "]";
	}		
}
