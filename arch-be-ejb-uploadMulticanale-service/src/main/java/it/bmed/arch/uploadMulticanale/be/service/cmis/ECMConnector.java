/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;

import java.io.InputStream;
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
	String createFile(byte[] buffer, String containerType, String filename,
			String fileExtension, String appName, String destinationPath, ECMFile ecmFile);
	
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
	InputStream downloadFile(String ecmFileId);
}
