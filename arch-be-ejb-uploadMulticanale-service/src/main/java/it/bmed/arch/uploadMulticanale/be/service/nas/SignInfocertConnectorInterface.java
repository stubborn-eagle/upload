package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.asia.exception.AsiaException;

public interface SignInfocertConnectorInterface {
	String firmaCades(String documentoDaFirmare, String dominio, String alias, String pin, String otp) throws AsiaException;
	
	String firmaPades(String documentoDaFirmare, String firmatari) throws AsiaException;
	
	String getSignInfocertUrl();
	void setSignInfocertUrl(String signInfocertUrl);
	String getSignFirmatariDominio();
	void setSignFirmatariDominio(String signFirmatariDominio);
	String getSignFirmatariAlias();
	void setSignFirmatariAlias(String signFirmatariAlias);
	String getSignFirmatariPin();
	void setSignFirmatariPin(String signFirmatariPin);
	String getSignFirmatariOtp();
	void setSignFirmatariOtp(String signFirmatariOtp);
}
