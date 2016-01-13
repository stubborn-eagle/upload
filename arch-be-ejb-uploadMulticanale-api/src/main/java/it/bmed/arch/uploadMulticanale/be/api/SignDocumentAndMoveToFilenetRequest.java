package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;

import javax.xml.bind.annotation.XmlElement;

public class SignDocumentAndMoveToFilenetRequest extends BaseBeRequest {
	private static final long serialVersionUID = -2802902167917865126L;
	
	private SignDocumentAndMoveToFilenetSignatureDataRequest signatureData;
	private SignDocumentAndMoveToFilenetFilenetRequest filenet;
	private SignDocumentAndMoveToFilenetECMParamRequest ecmParams;
	
	@XmlElement(nillable=true, required=true)
	public SignDocumentAndMoveToFilenetSignatureDataRequest getSignatureData() {
		return signatureData;
	}
	public void setSignatureData(
			SignDocumentAndMoveToFilenetSignatureDataRequest signatureData) {
		this.signatureData = signatureData;
	}
	public SignDocumentAndMoveToFilenetFilenetRequest getFilenet() {
		return filenet;
	}
	public void setFilenet(SignDocumentAndMoveToFilenetFilenetRequest filenet) {
		this.filenet = filenet;
	}
	public SignDocumentAndMoveToFilenetECMParamRequest getEcmParams() {
		return ecmParams;
	}
	public void setEcmParams(SignDocumentAndMoveToFilenetECMParamRequest ecmParams) {
		this.ecmParams = ecmParams;
	}
}
