package it.bmed.arch.uploadMulticanale.be.service.cmsis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import it.bmed.arch.uploadMulticanale.be.service.cmis.AlfrescoConnector;
import it.bmed.asia.exception.AsiaException;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ECMServiceTest {
	private ApplicationContext context = null;
	private AlfrescoConnector alfrescoConnector = null;
//	private FilenetConnector filenetConnector = null;
	private String fileId = null;
	private boolean connected = false;

	@Before
	public void setUp() throws Exception {
		try {
		context = new ClassPathXmlApplicationContext("ecmconnectors-context.xml");
		alfrescoConnector = (AlfrescoConnector) context.getBean("alfrescoConnector");
//		dataSource = (DataSource) context.getBean("dataSource");
//		System.out.println(dataSource.getClass().getName());
		connected = alfrescoConnector.createConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		alfrescoConnector = null;
		context = null;
	}

	@Test
	public void testECMService() {
		String filename = "alfrescoConnector";
		String type = "txt";
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
			fileId = alfrescoConnector.createFile(buffer, "", filename, type, "", "/upload-multicanale-dev", null);
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
