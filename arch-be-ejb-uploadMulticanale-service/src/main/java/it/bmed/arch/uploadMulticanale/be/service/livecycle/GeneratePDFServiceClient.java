package it.bmed.arch.uploadMulticanale.be.service.livecycle;

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
	
}
