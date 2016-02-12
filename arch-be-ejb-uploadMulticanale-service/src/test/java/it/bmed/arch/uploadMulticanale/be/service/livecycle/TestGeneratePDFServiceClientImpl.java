/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.service.livecycle;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author donatello.boccaforno
 *
 */
public class TestGeneratePDFServiceClientImpl {
	private GeneratePDFServiceClient generatePDFServiceClient = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		generatePDFServiceClient = new GeneratePDFServiceClientImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		generatePDFServiceClient = null;
	}

	/**
	 * Test method for {@link it.bmed.arch.uploadMulticanale.be.service.livecycle.GeneratePDFServiceClientImpl#htmlToPDF2(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testHtmlToPDF2() {
		assertEquals(FileInputStream.class, generatePDFServiceClient.htmlToPDF2(null).getClass());
		
	}

}
