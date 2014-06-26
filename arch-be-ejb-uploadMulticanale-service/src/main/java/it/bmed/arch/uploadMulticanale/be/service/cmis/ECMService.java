package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.arch.uploadMulticanale.be.api.MediaDTO;
import it.bmed.asia.exception.AsiaException;

import java.io.InputStream;

public interface ECMService {
	/**
	 * Does the ECM connect
	 * 
	 * @param ecmType
	 * @param user
	 * @param password
	 * @return The created file Id as <b>String</b> 
	 * @throws AsiaException
	 * @throws Exception
	 */

	String createFile(ECMType ecmType, byte[] byteStream, String containerType, String filename,
			String fileExtension, String appName, String destinationPath, MediaDTO mediaDTO)
			throws AsiaException, Exception;

	/**
	 * Delete a file from the ECM using it's respective file Id
	 * 
	 * @param ecmType
	 * @param ecmFileId
	 * @return The operation's status as <b>boolean</b>
	 * @throws AsiaException
	 * @throws Exception
	 */
	boolean removeFile(ECMType ecmType, String ecmFileId) throws AsiaException,
			Exception;

	/**
	 * Downloads a file from the ECM using it's respective file Id
	 * 
	 * @param ecmType
	 * @param ecmFileId
	 * @return The input stream
	 * @throws AsiaException
	 * @throws Exception
	 */
	InputStream downloadFile(ECMType ecmType, String ecmFileId) throws AsiaException, Exception;
}