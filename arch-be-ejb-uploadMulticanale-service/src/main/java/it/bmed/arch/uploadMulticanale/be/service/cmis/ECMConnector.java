/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.asia.exception.AsiaException;

import java.rmi.RemoteException;

/**
 * @author donatello.boccaforno
 *
 */
public interface ECMConnector {
	
	/**
	 * Does the ECM connect
	 * @return The operation's status as <b>boolean</b>
	 * @throws RemoteException
	 * @throws Exception
	 */
	boolean createConnection();
	
	/**
	 * Upload a file into the ECM
	 * @param fileName
	 * @param byteStream
	 * @param streamContent
	 * @param propertyDTO
	 * @return The ECM's file identifier as <b>String</b>
	 * @throws RemoteException
	 * @throws Exception
	 */
//	String createFile(byte[] buffer, String destinationPath, String filename, String type);
	String createFile(byte[] buffer, ECMFile ecmFile, ECMParam ecmParam);
	String createFileWithMetadata(byte[] buffer, ECMFile ecmFile, ECMParam ecmParam);
	
	/**
	 * Delete a file from the ECM using it's respective file Id
	 * @param ecmFileId
	 * @return The operation's status as <b>boolean</b>
	 * @throws RemoteException
	 * @throws Exception
	 */
	
	boolean removeFile(String ecmFileId);
	
	/**
	 * Downloads a file from the ECM using it's respective file Id
	 * @param ecmFileId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	String downloadFile(String ecmFileId);
	
	/**
	 * Get Token for Connector
	 * @param request Depends from connector
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	String getECMToken(String request) throws AsiaException;
}
