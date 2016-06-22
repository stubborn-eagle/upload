package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SignaturePolicyType")
public class SignaturePolicyType implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<KeywordSignatureFieldType> keywordSignatureFieldList;
	private List<PositionSignatureFieldType> positionSignatureFieldList;
	private List<SignatureFieldType> signatureFieldList;
	
	/**
	 * @return the keywordSignatureFieldList
	 */
	public List<KeywordSignatureFieldType> getKeywordSignatureFieldList() {
		return keywordSignatureFieldList;
	}
	/**
	 * @param keywordSignatureFieldList the keywordSignatureFieldList to set
	 */
	public void setKeywordSignatureFieldList(List<KeywordSignatureFieldType> keywordSignatureFieldList) {
		this.keywordSignatureFieldList = keywordSignatureFieldList;
	}
	/**
	 * @return the positionSignatureFieldList
	 */
	public List<PositionSignatureFieldType> getPositionSignatureFieldList() {
		return positionSignatureFieldList;
	}
	/**
	 * @param positionSignatureFieldList the positionSignatureFieldList to set
	 */
	public void setPositionSignatureFieldList(List<PositionSignatureFieldType> positionSignatureFieldList) {
		this.positionSignatureFieldList = positionSignatureFieldList;
	}
	/**
	 * @return the signatureFieldList
	 */
	public List<SignatureFieldType> getSignatureFieldList() {
		return signatureFieldList;
	}
	/**
	 * @param signatureFieldList the signatureFieldList to set
	 */
	public void setSignatureFieldList(List<SignatureFieldType> signatureFieldList) {
		this.signatureFieldList = signatureFieldList;
	}
}
