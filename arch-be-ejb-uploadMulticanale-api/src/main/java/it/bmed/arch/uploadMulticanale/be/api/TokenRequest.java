/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

/**
 * @author andrea.perrotta
 *
 */
public class TokenRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6857904066819584317L;
	
	private ECMParam ecmParam = null;
	

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
