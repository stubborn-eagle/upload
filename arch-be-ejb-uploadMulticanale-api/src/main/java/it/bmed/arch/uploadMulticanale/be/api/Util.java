package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;

public class Util {
	private static final Logger log = LoggerFactory.getLogger(Util.class);
	

	public static String encodeFileToBase64Binary(byte[] stream) throws Exception {

		byte[] encoded = Base64.encodeBase64(stream);
		String encodedString = new String(encoded);

		return encodedString;

	}

	public static byte[] readFile(File file) throws IOException, Exception {

		// *************************************************************************
		// Inizializzo le variabili
		// *************************************************************************
		log.debug("Nome file {} ", file.getPath());
		
		InputStream is = null;
		byte[] bytes;

		try {

			// *************************************************************************
			// Leggo il file
			// *************************************************************************

			is = new FileInputStream(file);
			long length = file.length();
			if (length > Integer.MAX_VALUE) {

				// File is too large

				// TODO

			}

			bytes = new byte[(int) length];

			// *************************************************************************
			// Verifica
			// *************************************************************************

			int offset = 0;
			int numRead = 0;

			while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {

				offset += numRead;

			}

			if (offset < bytes.length) {

				throw new IOException("Could not completely read file " + file.getName());

			}

		} finally {

			if (is != null)
				is.close();

		}

		// *************************************************************************

		// response

		// *************************************************************************

		return bytes;

	}

}