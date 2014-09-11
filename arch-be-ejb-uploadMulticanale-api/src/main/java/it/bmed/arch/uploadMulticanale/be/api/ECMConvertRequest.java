package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="ECMConvertRequestType")
public class ECMConvertRequest extends BaseBeRequest {
	private static final long serialVersionUID = 7885155237251899750L;
	
//	private RequestMetaData requestMetaData = null;
	private Integer idFile;
	private ECMFile ecmFile;
	private ECMParam ecmParam;
//	/**
//	 * @return the requestMetaData
//	 */
//	public RequestMetaData getRequestMetaData() {
//		return requestMetaData;
//	}
//	/**
//	 * @param requestMetaData the requestMetaData to set
//	 */
//	public void setRequestMetaData(RequestMetaData requestMetaData) {
//		this.requestMetaData = requestMetaData;
//	}
	/**
	 * @return the idFile
	 */
	@XmlElement(nillable=true, required=true)
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
	/**
	 * @return the ecmParam
	 */
	@XmlElement(nillable=true, required=true)
	public ECMParam getEcmParam() {
		return ecmParam;
	}
	/**
	 * @param ecmParam the ecmParam to set
	 */
	public void setEcmParam(ECMParam ecmParam) {
		this.ecmParam = ecmParam;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ECMConvertRequest [idFile=" + idFile + ", ecmFile=" + ecmFile + ", ecmParam="
				+ ecmParam + "]";
	}
	
}
