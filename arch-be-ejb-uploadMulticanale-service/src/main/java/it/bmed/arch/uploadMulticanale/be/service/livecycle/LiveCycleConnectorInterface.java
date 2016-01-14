package it.bmed.arch.uploadMulticanale.be.service.livecycle;

import it.bmed.asia.exception.AsiaException;

public interface LiveCycleConnectorInterface {
	byte[] generatePDF(String refId) throws AsiaException;
	
	byte[] generatePDFDynamic(String refId) throws AsiaException;
}
