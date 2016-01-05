package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.asia.exception.AsiaException;

public interface SignConnectorInterface {
	String firmaCades(String documentoDaFirmare, String dominio, String alias, String pin, String otp) throws AsiaException;
	
	String firmaPades(String documentoDaFirmare, String firmatari) throws AsiaException;
}
