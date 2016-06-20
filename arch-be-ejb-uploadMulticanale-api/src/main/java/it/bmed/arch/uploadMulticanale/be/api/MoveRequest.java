package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(name="MoveRequestType")
public class MoveRequest extends BaseBeRequest {
	private static final long serialVersionUID = 4525337067809641516L;
	
//	private RequestMetaData requestMetaData = null;
	private ECMParam ecmParam = null;
	
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
		return "MoveRequest [ecmParam=" + ecmParam + "]";
	}
	
}
