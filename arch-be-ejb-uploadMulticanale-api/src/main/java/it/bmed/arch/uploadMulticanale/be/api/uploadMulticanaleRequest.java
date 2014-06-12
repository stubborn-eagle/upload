package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.*;

import java.io.Serializable;
import java.util.Calendar;

public class uploadMulticanaleRequest extends BaseBeRequest {

	private static final long	serialVersionUID	= 6318382642673711080L;
	
	
	private RequestMetaData requestMetaData =null;
	

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
	
	
	
}
