package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.asia.exception.AsiaException;

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

	String createFile(byte[] byteStream, ECMFile ecmFile, ECMParam ecmParam)
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
	 * @return The downloaded file as encoded <b>String</b> 
	 * @throws AsiaException
	 * @throws Exception
	 */
	String downloadFile(ECMType ecmType, String ecmFileId) throws AsiaException, Exception;
}