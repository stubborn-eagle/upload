package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;
import java.util.ArrayList;

public class MoveParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idMediaBus;
	private String type;
	private ArrayList<FileProperty> property;

	public String getIdMediaBus() {
		return idMediaBus;
	}

	public void setIdMediaBus(String idMediaBus) {
		this.idMediaBus = idMediaBus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<FileProperty> getProperty() {
		return property;
	}

	public void setProperty(ArrayList<FileProperty> property) {
		this.property = property;
	}

}
