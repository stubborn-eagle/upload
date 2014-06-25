package it.bmed.arch.uploadMulticanale.be.api;

/**
 * Required by Move operation 
 * @author donatello.boccaforno
 *
 */
public enum RemoveFromNAS {
	NOT_REMOVE(0),
	REMOVE(1);
	
	private final Integer value;
	
	private RemoveFromNAS(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
