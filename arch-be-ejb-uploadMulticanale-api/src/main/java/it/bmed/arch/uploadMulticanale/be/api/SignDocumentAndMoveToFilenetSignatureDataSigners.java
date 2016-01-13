package it.bmed.arch.uploadMulticanale.be.api;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class SignDocumentAndMoveToFilenetSignatureDataSigners implements Serializable {
	private static final long serialVersionUID = 3427611574651363244L;
	
	private List<SignDocumentAndMoveToFilenetSignatureDataSigner> signer;

	@XmlElement
	public List<SignDocumentAndMoveToFilenetSignatureDataSigner> getSigner() {
		return signer;
	}

	public void setSigner(List<SignDocumentAndMoveToFilenetSignatureDataSigner> signer) {
		this.signer = signer;
	}
}
