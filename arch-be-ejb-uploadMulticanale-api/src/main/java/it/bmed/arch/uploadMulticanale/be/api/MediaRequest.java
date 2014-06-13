package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;
import it.bmed.asia.api.CommonUtils;
import it.bmed.asia.api.RequestMetaData;

import java.util.ArrayList;
import java.util.List;

public class MediaRequest extends BaseBeRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RequestMetaData requestMetaData = null;

	private MediaDTO mediaDTO;

	public MediaDTO getMediaDTO() {
		return mediaDTO;
	}
	public void setMediaDTO(MediaDTO mediaDTO) {
		this.mediaDTO = mediaDTO;
	}
	

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
		this.requestMetaData = requestMetaData;
	}

	
	/*
	public MediaParam getParam() {
		return param;
	}

	public void setParam(MediaParam param) {
		this.param = param;
	}

	

	public List<MediaParam> getParams() {
		return params;
	}

	public void setParams(List<MediaParam> params) {
		this.params = params;
	}

	public void addParam(MediaParam param) {
		if (this.params == null)
			this.params = new ArrayList<MediaParam>();
		params.add(param);

	}
	*/
	
	
	
	

}
