package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.exception.jaxws.SystemFault;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

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
		
		
	
		/*
		@WebMethod(operationName = "moveFile")
		@WebResult(name = "response")
		uploadMulticanaleResponse moveFile(@WebParam(name = "request") uploadMulticanaleRequest request) throws RemoteException, Exception;
		*/
		
		@WebMethod(operationName = "getFilenetToken")
		@WebResult(name = "response")
		MediaResponse getFilenetToken(@WebParam(name = "request") MediaRequest request) throws RemoteException, Exception;
		
		@WebMethod(operationName = "getAzureToken")
		@WebResult(name = "response")
		AzureResponse getAzureToken(@WebParam(name = "request") AzureRequest request) throws RemoteException, Exception;
		

		@WebMethod(operationName = "deleteFileECM")
		@WebResult(name = "response")
		boolean deleteFileECM(@WebParam(name = "request") MediaRequest request) throws RemoteException, Exception;
		
		@WebMethod(operationName = "deleteFileNAS")
		@WebResult(name = "response")
		boolean deleteFileNAS(@WebParam(name = "request") MediaRequest request) throws RemoteException, Exception;
		
		/*
		@WebMethod(operationName = "updateMedia")
		@WebResult(name = "response")
		boolean updateMedia(@WebParam(name = "request") String idFile, String ecmType, String Stato ) throws RemoteException, Exception;
		*/
		
}
