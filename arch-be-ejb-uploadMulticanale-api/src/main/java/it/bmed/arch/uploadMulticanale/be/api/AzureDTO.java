package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;
import java.util.Date;

/**
 * Request DTO for token generation
 * @author raffaele.picardi
 *
 */
public class AzureDTO implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4348967037880500002L;

	private String SAS;

	/**
	 * Expired time for token generated
	 * 
	 */
	private Date expiredTime;
	
	/**
	 * Start time for token generated
	 */
	private Date startTime;
	
	/**
	 * Azure container
	 */
	private String container;
	
	
	
	/**
	 * Resource Blob file
	 */
	private String resourceBlobFile;
	
	
	/**
	 * complete URI to access to the file
	 */
	private String URI;
	
	
	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

	public String getResourceBlobFile() {
		return resourceBlobFile;
	}

	public void setResourceBlobFile(String resourceBlobFile) {
		this.resourceBlobFile = resourceBlobFile;
	}

	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getSAS() {
		return SAS;
	}

	public void setSAS(String sAS) {
		SAS = sAS;
	}
	

	
}
