/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author andrea.perrotta
 *
 */
@XmlType(name="TokenResponse")
public class TokenResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 290233134378194505L;
	
	protected String token = "";

	/**
	 * @return the token
	 */
	@XmlElement(nillable=false, required=true)
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
