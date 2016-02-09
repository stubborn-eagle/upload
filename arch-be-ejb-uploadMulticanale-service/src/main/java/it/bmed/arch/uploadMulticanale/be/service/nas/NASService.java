package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMSource;
import it.bmed.arch.uploadMulticanale.be.api.SignatureData;
import it.bmed.asia.exception.TechnicalException;

import java.io.InputStream;

public interface NASService {
	/**
	 * Delete the file with filename and the the provided path
	 * @param path
	 * @param filename
	 * @param source
	 * @return The status of the operation as <b>boolean</b>
	 * @throws TechnicalException 
	 * @throws SecurityException, Exception 
	 */
	boolean deleteFile(String path, String filename, ECMSource source) throws TechnicalException, Exception;
	
	/**
	 * Phisically Delete the file with filename and the the provided path
	 * @param path
	 * @param filename
	 * @param source
	 * @return The status of the operation as <b>boolean</b>
	 * @throws TechnicalException 
	 * @throws SecurityException, Exception 
	 */
	boolean deleteFilePhisical(String path, String filename, ECMSource source) throws TechnicalException, Exception;

	/**
	 * Load the  file with filename and the the provided path, returning a byte array stream   
	 * @param path
	 * @param filename
	 * @return The byte array stream
	 * @throws TechnicalException
	 * @throws Exception
	 */
	byte[] loadFile(String path, String filename, ECMSource source) throws TechnicalException, Exception;
	
	/**
	 * Save the InputStream into the NAS filesystem root, with respsective filename and appended extension 
	 * @param resultStream
	 * @param nameFile
	 * @throws TechnicalException
	 * @throws Exception
	 */
	void saveFile(InputStream resultStream, String nameFile, ECMSource source, String sourcePath) throws TechnicalException, Exception;

	ECMFile getEcmFileLiveCyclePdf(String refId, boolean isDynamic) throws TechnicalException;
	
	String firmaCades(String documentoDaFirmare, String dominio, String alias, String pin, String otp) throws TechnicalException;
	
	String firmaPades(String documentoDaFirmare, String firmatari) throws TechnicalException;
	
	String firmaCadesInfocert(String documentoDaFirmare, String dominio, String alias, String pin, String otp) throws TechnicalException;
	
	String firmaPadesInfocert(String documentoDaFirmare, String firmatari, String idDocumento) throws TechnicalException;

	SignatureData getSignatureData() throws TechnicalException;
}
