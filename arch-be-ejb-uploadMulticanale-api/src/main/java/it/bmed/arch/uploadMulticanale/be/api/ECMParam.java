package it.bmed.arch.uploadMulticanale.be.api;

/**
 * Required by Move operation 
 * @author donatello.boccaforno
 *
 */
public enum ECMParam {
	NOT_REMOVE(0),
	REMOVE(1);
	
	private final Integer value;
	
	private ECMParam(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
