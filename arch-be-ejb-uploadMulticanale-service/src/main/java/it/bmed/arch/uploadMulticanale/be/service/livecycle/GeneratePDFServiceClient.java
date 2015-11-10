package it.bmed.arch.uploadMulticanale.be.service.livecycle;

import it.bmed.asia.exception.AsiaException;

import java.io.InputStream;

/**
 * Stub for livecycle client
 * @author donatello.boccaforno
 *
 */
public interface GeneratePDFServiceClient {
	/**
	 * Wrapper method
	 * @param inputUrl
	 * @return The pdf document as <b>InputStream</b>
	 */
	InputStream htmlToPDF2(String inputUrl);

	String createHTMLDocument(String encodedFile);
	
	byte[] generatePDF(String refId) throws AsiaException;
	
	byte[] generatePDFDynamic(String refId) throws AsiaException;
	
}
