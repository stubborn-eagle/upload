package it.bmed.arch.uploadMulticanale.be.service.cmis;

public class Request {

	private ObjectStore objectStore;
	private ObjectClass objectClass;
	private Index index;
	private Istituto istituto;
	private Matricola matricola;
	private Ruolo ruolo;
	private Filiale filiale;
	private SearchAction searchAction;
	private DocContent docContent;
	/**
	 * @return the objectStore
	 */
	public ObjectStore getObjectStore() {
		return objectStore;
	}
	/**
	 * @return the objectClass
	 */
	public ObjectClass getObjectClass() {
		return objectClass;
	}
	/**
	 * @return the index
	 */
	public Index getIndex() {
		return index;
	}
	/**
	 * @return the istituto
	 */
	public Istituto getIstituto() {
		return istituto;
	}
	/**
	 * @return the filiale
	 */
	public Filiale getFiliale() {
		return filiale;
	}
	/**
	 * @return the searchAction
	 */
	public SearchAction getSearchAction() {
		return searchAction;
	}
	/**
	 * @return the docContent
	 */
	public DocContent getDocContent() {
		return docContent;
	}
	/**
	 * @param objectStore the objectStore to set
	 */
	public void setObjectStore(ObjectStore objectStore) {
		this.objectStore = objectStore;
	}
	/**
	 * @param objectClass the objectClass to set
	 */
	public void setObjectClass(ObjectClass objectClass) {
		this.objectClass = objectClass;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(Index index) {
		this.index = index;
	}
	/**
	 * @param istituto the istituto to set
	 */
	public void setIstituto(Istituto istituto) {
		this.istituto = istituto;
	}
		/**
	 * @param filiale the filiale to set
	 */
	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}
	/**
	 * @param searchAction the searchAction to set
	 */
	public void setSearchAction(SearchAction searchAction) {
		this.searchAction = searchAction;
	}
	/**
	 * @param docContent the docContent to set
	 */
	public void setDocContent(DocContent docContent) {
		this.docContent = docContent;
	}
	/**
	 * @return the matricola
	 */
	public Matricola getMatricola() {
		return matricola;
	}
	/**
	 * @return the ruolo
	 */
	public Ruolo getRuolo() {
		return ruolo;
	}
	/**
	 * @param matricola the matricola to set
	 */
	public void setMatricola(Matricola matricola) {
		this.matricola = matricola;
	}
	/**
	 * @param ruolo the ruolo to set
	 */
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	
}