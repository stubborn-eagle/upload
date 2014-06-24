package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.asia.exception.TechnicalException;

public interface NASService {
	/**
	 * Delete the file with filename and the the provided path
	 * @param path
	 * @param filename
	 * @return The status of the operation as <b>boolean</b>
	 * @throws TechnicalException 
	 * @throws SecurityException, Exception 
	 */
	boolean deleteFile(String path, String filename) throws TechnicalException, Exception;

}
