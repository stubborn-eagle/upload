package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.exception.jaxws.SystemFault;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;



@WebService
@SOAPBinding(style = Style.RPC)
public interface UploadMulticanaleRemote extends Remote {

		@WebMethod(operationName = "insertMedia")
		@WebResult(name = "response")
		ECMResponse insertMedia(@WebParam(name = "request") ECMRequest request) throws  SystemFault, RemoteException, Exception;
		
		
		@WebMethod(operationName = "listMedia")
		@WebResult(name = "response")
		ECMResponse listMedia(@WebParam(name = "request")  ECMRequest request) throws SystemFault, RemoteException, Exception;
	
			
		@WebMethod(operationName = "updateMedia")
		@WebResult(name = "response")
		boolean updateMedia(@WebParam(name = "request") UpdateECMRequest request) throws SystemFault, RemoteException, Exception;
	
		/**
		 * Remove a file in the NAS using a specific path, and making a backup copy in a provided repository
		 * @param idFile
		 * @return The status of the operation as <b>boolean</b>
		 */
		@WebMethod(operationName = "deleteFileNAS")
		@WebResult(name = "response")
		boolean deleteFileNAS(@WebParam(name = "request") ECMRequest request) throws RemoteException, Exception;


		/**
		 * Remote method used to delete a file from the ECM
		 * @param request
		 * @return The operation's result as <b>boolean</b>
		 * @throws RemoteException
		 * @throws Exception
		 */
		@WebMethod(operationName = "deleteFileECM")
		@WebResult(name = "response")
		boolean deleteFileECM(@WebParam(name = "request") ECMRequest request) throws RemoteException, Exception;

		/**
		 * Retrieve the Azure's token
		 * @param request
		 * @return The azure's token
		 * @throws RemoteException
		 * @throws Exception
		 */
		@WebMethod(operationName = "getAzureToken")
		@WebResult(name = "response")		
		AzureResponse getAzureToken(@WebParam(name = "request") AzureRequest request) throws RemoteException, Exception;
				
//		Not required	
//		@WebMethod(operationName = "getECMToken")
//		@WebResult(name = "response")
//		UploadMulticanaleResponse getECMToken(@WebParam(name = "request") UploadMulticanaleRequest request) throws RemoteException, Exception;
		
		/**
		 * Move a file from NAS to a specific ECM
		 * @param request
		 * @param remove
		 * @return The move operation result as <b>MoveResonse</b>
		 * @throws RemoteException
		 * @throws Exception
		 */
		@WebMethod(operationName = "moveFile")
		@WebResult(name = "response")
		MoveResponse moveFile(@WebParam(name = "request") MoveRequest request) throws RemoteException, Exception;
		
		@WebMethod(operationName = "convertToPDF")
		@WebResult(name = "response")
		MoveResponse convertToPDF(@WebParam(name = "request") MoveRequest request) throws RemoteException, Exception;
}
