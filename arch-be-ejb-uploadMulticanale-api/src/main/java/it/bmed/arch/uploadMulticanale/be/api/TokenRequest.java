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
@XmlType(name="TokenRequestType")

public class TokenRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6857904066819584317L;
	
	private ECMParam ecmParam = null;
	

	/**
	 * @return the ecmParam
	 */
	@XmlElement(nillable=false, required=true)
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
