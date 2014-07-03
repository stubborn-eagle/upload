package it.bmed.arch.uploadMulticanale.be.service.cmis;


public class DownloadRequest {
	private ObjectStore objectStore = null;
	private ObjectClass objectClass = null;
	private IndexDelete index = null;
	private Istituto istituto = null;
	private Matricola matricola = null;
	private Ruolo ruolo = null;
	private Filiale filiale = null;
	private PdfDisablePrint pdfDisablePrint = null;
	private Convert convert = null;
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
	 * @return the istituto
	 */
	public Istituto getIstituto() {
		return istituto;
	}
	/**
	 * @param istituto the istituto to set
	 */
	public void setIstituto(Istituto istituto) {
		this.istituto = istituto;
	}
	/**
	 * @return the matricola
	 */
	public Matricola getMatricola() {
		return matricola;
	}
	/**
	 * @param matricola the matricola to set
	 */
	public void setMatricola(Matricola matricola) {
		this.matricola = matricola;
	}
	/**
	 * @return the ruolo
	 */
	public Ruolo getRuolo() {
		return ruolo;
	}
	/**
	 * @param ruolo the ruolo to set
	 */
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	/**
	 * @return the filiale
	 */
	public Filiale getFiliale() {
		return filiale;
	}
	/**
	 * @param filiale the filiale to set
	 */
	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}
	/**
	 * @return the pdfDisablePrint
	 */
	public PdfDisablePrint getPdfDisablePrint() {
		return pdfDisablePrint;
	}
	/**
	 * @param pdfDisablePrint the pdfDisablePrint to set
	 */
	public void setPdfDisablePrint(PdfDisablePrint pdfDisablePrint) {
		this.pdfDisablePrint = pdfDisablePrint;
	}
	/**
	 * @return the convert
	 */
	public Convert getConvert() {
		return convert;
	}
	/**
	 * @param convert the convert to set
	 */
	public void setConvert(Convert convert) {
		this.convert = convert;
	}
	
}
