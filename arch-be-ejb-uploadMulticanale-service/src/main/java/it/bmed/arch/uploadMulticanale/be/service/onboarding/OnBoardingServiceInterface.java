package it.bmed.arch.uploadMulticanale.be.service.onboarding;

import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentToDossierInfocertRequestType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentToDossierInfocertResponseType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetRequestType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetResponseType;

import javax.activation.DataSource;

public interface OnBoardingServiceInterface {
	
//	String WS_REQUEST_TIMEOUT ="com.sun.xml.internal.ws.request.timeout";
//	String WS_CONNECT_TIMEOUT ="com.sun.xml.internal.ws.connect.timeout";
	MoveDossierIntoFilenetResponseType moveDossierIntoFilenet(MoveDossierIntoFilenetRequestType getDossier);
	String extractFileContent(Integer multicanaleReferenceId);
	AddDocumentToDossierInfocertResponseType addDocuments(AddDocumentToDossierInfocertRequestType request,	DataSource fileContent);
	
}
