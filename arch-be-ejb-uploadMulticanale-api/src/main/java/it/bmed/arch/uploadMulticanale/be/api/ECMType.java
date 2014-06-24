/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.api;

/**
 * @author donatello.boccaforno
 *
 */
public enum ECMType {
	IBM_FILENET(1),
	ALFRESCO(2),
	AZURE(3);

	private final Integer value;
	
	private ECMType(final Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
}