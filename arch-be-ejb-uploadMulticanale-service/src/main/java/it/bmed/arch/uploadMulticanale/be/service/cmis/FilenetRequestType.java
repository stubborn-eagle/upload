package it.bmed.arch.uploadMulticanale.be.service.cmis;

public enum FilenetRequestType {
	CREATE_REQUEST("Filenet create request"),
	DELETE_REQUEST("Filenet delete request"),
	DOWNLOAD_REQUEST("Filenet download request");
	
	private String description = null;

	FilenetRequestType(String description) {
		this.description  = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
