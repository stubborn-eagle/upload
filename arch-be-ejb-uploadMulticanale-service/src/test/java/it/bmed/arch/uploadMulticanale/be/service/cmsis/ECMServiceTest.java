package it.bmed.arch.uploadMulticanale.be.service.cmsis;

import it.bmed.arch.uploadMulticanale.be.service.cmis.AlfrescoConnector;
import it.bmed.arch.uploadMulticanale.be.service.cmis.FilenetConnector;
import it.bmed.asia.exception.AsiaException;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ECMServiceTest {
	private ApplicationContext context = null;
	private AlfrescoConnector alfrescoConnector = null;
	private FilenetConnector filenetConnector = null;
	private String fileId = null;
	private boolean connected = false;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("ecmconnectors-context.xml");
		alfrescoConnector = (AlfrescoConnector) context.getBean("alfrescoConnector");
		connected = alfrescoConnector.createConnection();
	}

	@After
	public void tearDown() throws Exception {
		alfrescoConnector = null;
		context = null;
	}

	@Test
	public void testECMService() {
		String filename = "alfrescoConnector.txt";
		String txtContent = "Halo Wars!";
		byte[] buffer = null;
		
		// check connection
		assertTrue(connected);

		try {
			buffer = txtContent.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// check createFile
		try {
			fileId = alfrescoConnector.createFile(buffer, "/upload-multicanale-dev", filename);
			assertNotNull(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// check downloadFile
		assertEquals(txtContent,
				convertStreamToString(alfrescoConnector.downloadFile(fileId)));
		// check removeFile
		boolean removed = false;
		try {
			removed = alfrescoConnector.removeFile(fileId);
			assertTrue(removed);
		} catch (AsiaException e) {
			e.printStackTrace();
		}
	}
	private static String convertStreamToString(InputStream is) {
		Scanner s = new Scanner(is).useDelimiter("\\A");
		return (s.hasNext() ? s.next() : "");
	}
}
