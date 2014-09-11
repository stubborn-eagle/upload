package it.bmed.arch.uploadMulticanale.be.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import it.bmed.asia.api.BaseBeRequest;

@XmlType(name="ECMRequestType")
public class ECMRequest extends BaseBeRequest {
	private static final long serialVersionUID = 9170130458793882791L;
	private ECMFile ecmFile = null;
	
	
	public ECMRequest() {
		super();
		this.ecmFile = new ECMFile();
	}
	/**
	 * @return the ecmFile
	 */
	@XmlElement(nillable=true, required=true)
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
