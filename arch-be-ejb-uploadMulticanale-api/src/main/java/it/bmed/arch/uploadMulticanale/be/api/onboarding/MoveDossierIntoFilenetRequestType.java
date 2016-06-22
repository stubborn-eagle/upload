package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MoveDossierIntoFilenetRequestType")
public class MoveDossierIntoFilenetRequestType implements Serializable {

	private static final long serialVersionUID = 1L;
    private String dossierId;
    private String ecmFiliale;
    private String ecmIstituto;
    private String ecmMatricola;
    private String ecmRuolo;
    private MoveDocumentParamListType documentParamListType;
    
	/**
	 * @return the dossierId
	 */
	public String getDossierId() {
		return dossierId;
	}
	/**
	 * @param dossierId the dossierId to set
	 */
	public void setDossierId(String dossierId) {
		this.dossierId = dossierId;
	}
	/**
	 * @return the ecmFiliale
	 */
	public String getEcmFiliale() {
		return ecmFiliale;
	}
	/**
	 * @param ecmFiliale the ecmFiliale to set
	 */
	public void setEcmFiliale(String ecmFiliale) {
		this.ecmFiliale = ecmFiliale;
	}
	/**
	 * @return the ecmIstituto
	 */
	public String getEcmIstituto() {
		return ecmIstituto;
	}
	/**
	 * @param ecmIstituto the ecmIstituto to set
	 */
	public void setEcmIstituto(String ecmIstituto) {
		this.ecmIstituto = ecmIstituto;
	}
	/**
	 * @return the ecmMatricola
	 */
	public String getEcmMatricola() {
		return ecmMatricola;
	}
	/**
	 * @param ecmMatricola the ecmMatricola to set
	 */
	public void setEcmMatricola(String ecmMatricola) {
		this.ecmMatricola = ecmMatricola;
	}
	/**
	 * @return the ecmRuolo
	 */
	public String getEcmRuolo() {
		return ecmRuolo;
	}
	/**
	 * @param ecmRuolo the ecmRuolo to set
	 */
	public void setEcmRuolo(String ecmRuolo) {
		this.ecmRuolo = ecmRuolo;
	}
	/**
	 * @return the documentParamListType
	 */
	public MoveDocumentParamListType getDocumentParamListType() {
		return documentParamListType;
	}
	/**
	 * @param documentParamListType the documentParamListType to set
	 */
	public void setDocumentParamListType(MoveDocumentParamListType documentParamListType) {
		this.documentParamListType = documentParamListType;
	}
}
