package it.bmed.arch.uploadMulticanale.be.service.livecycle;

import it.bmed.asia.exception.AsiaException;

public interface LiveCycleConnectorInterface {
	public byte[] generatePDF(String refId) throws AsiaException;
	
	public byte[] generatePDFDynamic(String refId) throws AsiaException;
}
