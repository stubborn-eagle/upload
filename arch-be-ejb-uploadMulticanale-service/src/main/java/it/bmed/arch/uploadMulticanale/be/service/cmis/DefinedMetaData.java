package it.bmed.arch.uploadMulticanale.be.service.cmis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class DefinedMetaData {
	@Autowired
	private HashMap<String, String> metadata;

	public HashMap<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(HashMap<String, String> metadata) {
		this.metadata = metadata;
	}
}
