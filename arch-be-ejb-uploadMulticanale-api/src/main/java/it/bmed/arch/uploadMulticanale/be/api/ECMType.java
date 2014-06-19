/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.api;

/**
 * @author donatello.boccaforno
 *
 */
public enum ECMType {
	FNT("Filenet"),
	ALF("Alfresco");

	private String connectorName;
	
	private ECMType(String connectorName) {
		this.connectorName = connectorName;
	}
	
	@Override
	public String toString() {
		return connectorName;
	}
}
