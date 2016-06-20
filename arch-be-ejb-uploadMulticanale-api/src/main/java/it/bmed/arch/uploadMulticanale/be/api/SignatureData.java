package it.bmed.arch.uploadMulticanale.be.api;

public class SignatureData {
	private String signFirmatariDominio;
	private String signFirmatariAlias;
	private String signFirmatariPin;
	private String signFirmatariOtp;
	
	public SignatureData(String signFirmatariDominio, String signFirmatariAlias, String signFirmatariPin, String signFirmatariOtp) {
		this.signFirmatariDominio = signFirmatariDominio;
		this.signFirmatariAlias = signFirmatariAlias;
		this.signFirmatariPin = signFirmatariPin;
		this.signFirmatariOtp = signFirmatariOtp;
	}
	public String getSignFirmatariDominio() {
		return signFirmatariDominio;
	}
	public void setSignFirmatariDominio(String signFirmatariDominio) {
		this.signFirmatariDominio = signFirmatariDominio;
	}
	public String getSignFirmatariAlias() {
		return signFirmatariAlias;
	}
	public void setSignFirmatariAlias(String signFirmatariAlias) {
		this.signFirmatariAlias = signFirmatariAlias;
	}
	public String getSignFirmatariPin() {
		return signFirmatariPin;
	}
	public void setSignFirmatariPin(String signFirmatariPin) {
		this.signFirmatariPin = signFirmatariPin;
	}
	public String getSignFirmatariOtp() {
		return signFirmatariOtp;
	}
	public void setSignFirmatariOtp(String signFirmatariOtp) {
		this.signFirmatariOtp = signFirmatariOtp;
	}
	
	
}
