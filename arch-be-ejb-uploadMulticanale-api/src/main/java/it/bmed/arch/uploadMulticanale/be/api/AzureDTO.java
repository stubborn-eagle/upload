package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Request DTO for token generation
 * @author raffaele.picardi
 *
 */
@XmlType(name="AzureDTOType")
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
	
	@XmlElement(nillable=false, required=true)
	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}
	@XmlElement(nillable=false, required=true)
	public String getResourceBlobFile() {
		return resourceBlobFile;
	}

	public void setResourceBlobFile(String resourceBlobFile) {
		this.resourceBlobFile = resourceBlobFile;
	}
	@XmlElement(nillable=false, required=true)
	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	@XmlElement(nillable=false, required=true)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@XmlElement(nillable=false, required=true)
	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}
	@XmlElement(nillable=false, required=true)
	public String getSAS() {
		return SAS;
	}

	public void setSAS(String sAS) {
		SAS = sAS;
	}
	

	
}
