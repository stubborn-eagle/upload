package it.bmed.arch.uploadMulticanale.be.service.cmis;
/**
 * Filenet deleteObject request DOM
 * @author donatello.boccaforno
 *
 */
public class DeleteRequest {

	private ObjectStore objectStore = null;
	private ObjectClass objectClass = null;
	private IndexDelete index = null;
	private ForceDeleteSubDocuments forceDeleteSubDocuments = null;
	/**
	 * @return the objectStore
	 */
	public ObjectStore getObjectStore() {
		return objectStore;
	}
	/**
	 * @param objectStore the objectStore to set
	 */
	public void setObjectStore(ObjectStore objectStore) {
		this.objectStore = objectStore;
	}
	/**
	 * @return the objectClass
	 */
	public ObjectClass getObjectClass() {
		return objectClass;
	}
	/**
	 * @param objectClass the objectClass to set
	 */
	public void setObjectClass(ObjectClass objectClass) {
		this.objectClass = objectClass;
	}
	/**
	 * @return the index
	 */
	public IndexDelete getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(IndexDelete index) {
		this.index = index;
	}
	/**
	 * @return the forceDeleteSubDocuments
	 */
	public ForceDeleteSubDocuments getForceDeleteSubDocuments() {
		return forceDeleteSubDocuments;
	}
	/**
	 * @param forceDeleteSubDocuments the forceDeleteSubDocuments to set
	 */
	public void setForceDeleteSubDocuments(
			ForceDeleteSubDocuments forceDeleteSubDocuments) {
		this.forceDeleteSubDocuments = forceDeleteSubDocuments;
	}
	
}