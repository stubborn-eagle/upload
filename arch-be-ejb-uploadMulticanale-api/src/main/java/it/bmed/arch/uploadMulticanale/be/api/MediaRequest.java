package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;
import it.bmed.asia.api.CommonUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="MediaRequestType")
public class MediaRequest extends BaseBeRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MediaDTO mediaDTO;

	public MediaRequest() {
		super();
		this.mediaDTO = new MediaDTO();
	}

	@XmlElement(nillable=false, required=true)
	public MediaDTO getMediaDTO() {
		return mediaDTO;
	}

	public void setMediaDTO(MediaDTO mediaDTO) {
		this.mediaDTO = mediaDTO;
	}

	public String toString() {
		return CommonUtils.bean2string(this);
	}

	/*
	 * public MediaParam getParam() { return param; }
	 * 
	 * public void setParam(MediaParam param) { this.param = param; }
	 * 
	 * 
	 * 
	 * public List<MediaParam> getParams() { return params; }
	 * 
	 * public void setParams(List<MediaParam> params) { this.params = params; }
	 * 
	 * public void addParam(MediaParam param) { if (this.params == null)
	 * this.params = new ArrayList<MediaParam>(); params.add(param);
	 * 
	 * }
	 */

}
