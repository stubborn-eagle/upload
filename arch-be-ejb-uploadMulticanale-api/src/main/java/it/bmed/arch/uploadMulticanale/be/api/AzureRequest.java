package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;
import it.bmed.asia.api.CommonUtils;
import it.bmed.asia.api.RequestMetaData;

import java.util.Date;

/**
 * 
 * DTO for Azure Token Generation request
 *
 */
public class AzureRequest extends BaseBeRequest {
	

	private static final long serialVersionUID = 1L;
	private RequestMetaData requestMetaData =null;

	/**
	 * The target Azure Container containing  files that the token will allow access to.
	 */
	private String targetContainer;
	
	/**
	 * Generates a read only token to access blob contents of Azure target container 
	 * default: false; 
	 */
	private boolean readOnly = true;
	
	/**
	 * if true it set the start time of the token to be at least 15 minutes ago of current request date
	 * default: true; 
	 */
	private boolean safeOffset = true;
	
	
	/**
	 * The expiration time of token requested
	 */
	private Date expirationTime;
	
	/**
	 * The target Azure Blob  file that the token will allow access to. If it is null then the token generated will give access to all targetContainer structure
	 */
	private String resourceBlobFile;
	
	
	public String getResourceBlobFile() {
		return resourceBlobFile;
	}

	public void setResourceBlobFile(String resourceBlobFile) {
		this.resourceBlobFile = resourceBlobFile;
	}

	public String getTargetContainer() {
		return targetContainer;
	}

	public void setTargetContainer(String targetContainer) {
		this.targetContainer = targetContainer;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
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
		this.requestMetaData = requestMetaData;
	}

	public boolean isSafeOffset() {
		return safeOffset;
	}

	public void setSafeOffset(boolean safeOffset) {
		this.safeOffset = safeOffset;
	}

	
}
