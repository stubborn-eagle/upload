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

	private final Integer ecmName;
	
	private ECMType(final Integer ecmName) {
		this.ecmName = ecmName;
	}
	
	public Integer getEcmName() {
		return ecmName;
	}
	
}