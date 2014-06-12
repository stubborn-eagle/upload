package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;

public class MoveDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idFilenet;
	private String idMediaBus;

	public String getIdFilenet() {
		return idFilenet;
	}

	public void setIdFilenet(String idFilenet) {
		this.idFilenet = idFilenet;
	}

	public String getIdMediaBus() {
		return idMediaBus;
	}

	public void setIdMediaBus(String idMediaBus) {
		this.idMediaBus = idMediaBus;
	}

}
