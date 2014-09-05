package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.exception.jaxws.HeaderInputType;
import it.bmed.asia.exception.jaxws.SystemFault;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

import org.hibernate.type.TrueFalseType;



@WebService(targetNamespace=APIParams.DEFINITION_NAMESPACE, name=APIParams.PORTTYPE_NAME) 
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface UploadMulticanaleRemote extends Remote {

		@WebMethod(operationName = "insertMedia")
		@WebResult(name = "response")
		ECMResponse insertMedia(ECMRequest request, @WebParam(header=true) HeaderInputType  stringa) throws  SystemFault, RemoteException, Exception;
		
		
		@WebMethod(operationName = "listMedia")
		@WebResult(name = "response")
		ECMResponse listMedia(  ECMRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;
	
			
		@WebMethod(operationName = "updateMedia")
		
		boolean updateMedia(UpdateECMRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;
	
		/**
		 * Remove a file in the NAS using a specific path, and making a backup copy in a provided repository
		 * @param idFile
		 * @return The status of the operation as <b>boolean</b>
		 */
		@WebMethod(operationName = "deleteFileNAS")
		boolean deleteFileNAS(ECMRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;


		/**
		 * Remote method used to delete a file from the ECM
		 * @param request
		 * @return The operation's result as <b>boolean</b>
		 * @throws RemoteException
		 * @throws Exception
		 */
		@WebMethod(operationName = "deleteFileECM")
		boolean deleteFileECM(ECMRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;

		/**
		 * Retrieve the Azure's token
		 * @param request
		 * @return The azure's token
		 * @throws RemoteException
		 * @throws Exception
		 */
		@WebMethod(operationName = "getAzureToken")
		AzureResponse getAzureToken( AzureRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;
				
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
		MoveResponse moveFile(MoveRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;
		
		@WebMethod(operationName = "convertToPDF")
		ECMResponse convertToPDF(ECMConvertRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "getECMToken")
		TokenResponse getToken( TokenRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;
		
		@WebMethod(operationName = "getVersione")
	    public String getVersione () throws SystemFault, RemoteException, Exception;;

}
