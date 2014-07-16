package it.bmed.arch.uploadMulticanale.be.service.nas;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import it.bmed.arch.uploadMulticanale.be.api.ECMSource;
import it.bmed.asia.exception.TechnicalException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NASServiceTest {
	private NASService nasService = null;
	private final static String FILENAME = "pippo.txt";
	private final static String PATHNAME = ".\\";
	@Before
	public void setUp() throws Exception {
		nasService = new NASServiceImpl();
		createFile(PATHNAME, FILENAME);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteFile() {
		try {
			assertTrue(nasService.deleteFile(PATHNAME, FILENAME, ECMSource.INTERNET_BANKING));
		} catch (TechnicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createFile(String pathname, String filename) {
		File file = new File(pathname + filename);
		String contentTxt = "Halo wars!";
		byte[] buffer = contentTxt.getBytes();
		OutputStream os = null;
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			os = new FileOutputStream(file);
			try {
				os.write(buffer);
				os.flush();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
