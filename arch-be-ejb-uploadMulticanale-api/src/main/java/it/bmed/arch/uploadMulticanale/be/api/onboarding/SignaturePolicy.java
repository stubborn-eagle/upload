package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;
import java.util.List;

public class SignaturePolicy implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<KeywordSignatureField> keywordSignatureFieldList;
	private List<PositionSignatureField> positionSignatureFieldList;
	private List<SignatureField> signatureFieldList;
	
	/**
	 * @return the keywordSignatureFieldList
	 */
	public List<KeywordSignatureField> getKeywordSignatureFieldList() {
		return keywordSignatureFieldList;
	}
	/**
	 * @param keywordSignatureFieldList the keywordSignatureFieldList to set
	 */
	public void setKeywordSignatureFieldList(List<KeywordSignatureField> keywordSignatureFieldList) {
		this.keywordSignatureFieldList = keywordSignatureFieldList;
	}
	/**
	 * @return the positionSignatureFieldList
	 */
	public List<PositionSignatureField> getPositionSignatureFieldList() {
		return positionSignatureFieldList;
	}
	/**
	 * @param positionSignatureFieldList the positionSignatureFieldList to set
	 */
	public void setPositionSignatureFieldList(List<PositionSignatureField> positionSignatureFieldList) {
		this.positionSignatureFieldList = positionSignatureFieldList;
	}
	/**
	 * @return the signatureFieldList
	 */
	public List<SignatureField> getSignatureFieldList() {
		return signatureFieldList;
	}
	/**
	 * @param signatureFieldList the signatureFieldList to set
	 */
	public void setSignatureFieldList(List<SignatureField> signatureFieldList) {
		this.signatureFieldList = signatureFieldList;
	}
}
