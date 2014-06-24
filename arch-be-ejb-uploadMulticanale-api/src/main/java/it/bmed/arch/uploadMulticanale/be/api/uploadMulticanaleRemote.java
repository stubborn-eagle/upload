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

		@WebMethod(operationName = "InsertMedia")
		@WebResult(name = "response")
		MediaResponse InsertMedia(@WebParam(name = "request") MediaRequest request) throws  SystemFault, RemoteException, Exception;
		
		
		@WebMethod(operationName = "ListMedia")
		@WebResult(name = "response")
		MediaResponse ListMedia(@WebParam(name = "request")  MediaRequest request) throws SystemFault, RemoteException, Exception;
	
			
		@WebMethod(operationName = "UpdateMedia")
		@WebResult(name = "response")
		boolean UpdateMedia(@WebParam(name = "request") UpdateMediaRequest request) throws SystemFault, RemoteException, Exception;
	
	
	/*	
		@WebMethod(operationName = "uploadListFile")
		@WebResult(name = "response")
		MediaResponse uploadListFile(@WebParam(name = "request") MediaRequest request) throws RemoteException, Exception;
	*/
		
		
	
		
//		@WebMethod(operationName = "moveFile")
//		@WebResult(name = "response")
//		UploadMulticanaleResponse moveFile(@WebParam(name = "request") UploadMulticanaleRequest request) throws RemoteException, Exception;
//		
//		@WebMethod(operationName = "getFilenetToken")
//		@WebResult(name = "response")
//		UploadMulticanaleResponse getFilenetToken(@WebParam(name = "request") UploadMulticanaleRequest request) throws RemoteException, Exception;
//		
		/**
		 * Retrieve the Azure's token
		 * @param request
		 * @return The azure's token
		 * @throws RemoteException
		 * @throws Exception
		 */
//		@WebMethod(operationName = "getAzureToken")
//		@WebResult(name = "response")
//		MediaResponse getAzureToken(@WebParam(name = "request") MediaRequest request) throws RemoteException, Exception;
		@WebMethod(operationName = "getAzureToken")
		@WebResult(name = "response")		
		AzureResponse getAzureToken(@WebParam(name = "request") AzureRequest request) throws RemoteException, Exception;
		
		/**
		 * Remove a file in the NAS using a specific path, and making a backup copy in a provided repository
		 * @param request
		 * @return The status of the operation as <b>boolean</b>
		 */
		@WebMethod(operationName = "deleteFileNAS")
		@WebResult(name = "response")
		boolean deleteFileNAS(@WebParam(name = "request") MediaRequest request);
		
		/**
		 * Remote method used to delete a file from the ECM
		 * @param request
		 * @return The operation's result as <b>boolean</b>
		 * @throws RemoteException
		 * @throws Exception
		 */
		@WebMethod(operationName = "deleteFileECM")
		@WebResult(name = "response")
		boolean deleteFileECM(@WebParam(name = "request") MediaRequest request) throws RemoteException, Exception;
//	
//		@WebMethod(operationName = "updateMedia")
//		@WebResult(name = "response")
//		boolean updateMedia(@WebParam(name = "request") String idFile, String ecmType, String Stato ) throws RemoteException, Exception;	
		
}
