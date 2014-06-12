package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;
import it.bmed.asia.api.CommonUtils;
import it.bmed.asia.api.RequestMetaData;

import java.util.ArrayList;
import java.util.List;

public class MoveRequest extends BaseBeRequest {

	// GENERATE THIS USING ECLIPSE WIZARDS
	// private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RequestMetaData requestMetaData = null;

	private List<MediaParam> params;

	@Override
	public RequestMetaData getMetadata() {
		if (requestMetaData == null)
			requestMetaData = new RequestMetaData();
		return requestMetaData;
	}

	public String toString() {
		return CommonUtils.bean2string(this);
	}

	@Override
	public void setMetadata(RequestMetaData requestMetaData) {
		// TODO Auto-generated method stub

	}

	public List<MediaParam> getParams() {
		return params;
	}

	public void setParams(List<MediaParam> params) {
		this.params = params;
	}
	
	public void addParam(MediaParam param){
		if(this.params == null)
			this.params = new ArrayList<MediaParam>();
		params.add(param);
		
	}

}
