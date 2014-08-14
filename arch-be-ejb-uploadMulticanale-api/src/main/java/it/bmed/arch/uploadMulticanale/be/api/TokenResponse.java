/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

/**
 * @author andrea.perrotta
 *
 */
public class TokenResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 290233134378194505L;
	
	protected String token = "";

	/**
	 * @return the token
	 */
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
