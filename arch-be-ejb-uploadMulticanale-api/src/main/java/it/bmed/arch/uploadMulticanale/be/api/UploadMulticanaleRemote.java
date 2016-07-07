package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentToDossierInfocertRequestType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentToDossierInfocertResponseType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.ExtractFileContentRequestType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.ExtractFileContentResponseType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetRequestType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetResponseType;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.schema.common.v1.HeaderInputType;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;



@WebService(targetNamespace=APIParams.DEFINITION_NAMESPACE, name=APIParams.PORTTYPE_NAME) 
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface UploadMulticanaleRemote extends Remote {

		@WebMethod(operationName = "insertMedia")
		ECMResponse insertMedia(ECMRequest request, @WebParam(header=true) HeaderInputType  stringa) throws  SystemFault, RemoteException, Exception;
		
		
		@WebMethod(operationName = "listMedia")
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
	    String getVersione () throws SystemFault, RemoteException, Exception;
		
		@WebMethod(operationName = "generatePDF")
		String generatePDF(java.lang.String arg0, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;
		
		@WebMethod(operationName = "generatePDFDynamic")
		String generatePDFDynamic(java.lang.String arg0, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "signFilenetDocument")
		String signFilenetDocument(SignDocumentAndMoveToFilenetRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;
		
		@WebMethod(operationName = "moveFileWithMetadata")		
		MoveResponse moveFileWithMetadata(MoveRequest request, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "generatePDFAsynch")
		String generatePDFAsynch(java.lang.String arg0, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;
		
		@WebMethod(operationName = "generatePDFDynamicAsynch")
		String generatePDFDynamicAsynch(java.lang.String arg0, @WebParam(header=true) HeaderInputType  stringa) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "generatePDFAsynchStatus")
		String generatePDFAsynchStatus(String refId) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "deleteOlderFilesNAS")
		boolean deleteOlderFilesNAS() throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "moveAlfrescoToECM")
		MoveResponse moveAlfrescoToECM(MoveRequest request, @WebParam(header=true) HeaderInputType stringa) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "addDocumentToDossierInfocert")
		AddDocumentToDossierInfocertResponseType addDocumentToDossierInfocert(AddDocumentToDossierInfocertRequestType request) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "moveDossierIntoFilenet")
		MoveDossierIntoFilenetResponseType moveDossierIntoFilenet(MoveDossierIntoFilenetRequestType request) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "extractFileContent")
		ExtractFileContentResponseType extractFileContent(ExtractFileContentRequestType request) throws SystemFault, RemoteException, Exception;

		@WebMethod(operationName = "generatePDFWithSource")
		String generatePDFWithSource(String xml, HeaderInputType string, ECMOrigin origin) throws SystemFault, RemoteException, Exception;

		
}
