package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;
import it.bmed.asia.api.RequestMetaData;

public class MoveRequest extends BaseBeRequest {
	private static final long serialVersionUID = 4525337067809641516L;
	
	private RequestMetaData requestMetaData = null;
	private ECMParam ecmParam = null;
	private RemoveFromNAS removeFromNAS = null;
	
	/**
	 * @return the requestMetaData
	 */
	public RequestMetaData getRequestMetaData() {
		return requestMetaData;
	}
	/**
	 * @param requestMetaData the requestMetaData to set
	 */
	public void setRequestMetaData(RequestMetaData requestMetaData) {
		this.requestMetaData = requestMetaData;
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
	/**
	 * @return the ecmParam
	 */
	public ECMParam getEcmParam() {
		return ecmParam;
	}
	/**
	 * @param ecmParam the ecmParam to set
	 */
	public void setEcmParam(ECMParam ecmParam) {
		this.ecmParam = ecmParam;
	}	
}
