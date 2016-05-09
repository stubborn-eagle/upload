package it.bmed.arch.uploadMulticanale.be.service.onboarding;

import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentsRequest;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentsResponse;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetRequest;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetResponse;

public interface OnBoardingServiceInterface {
	
	String WS_REQUEST_TIMEOUT ="com.sun.xml.internal.ws.request.timeout";
	String WS_CONNECT_TIMEOUT ="com.sun.xml.internal.ws.connect.timeout";
	AddDocumentsResponse addDocuments(AddDocumentsRequest request);
	MoveDossierIntoFilenetResponse moveDossierIntoFilenet(MoveDossierIntoFilenetRequest getDossier);
	String extractFileContent(Integer multicanaleReferenceId);
	
}
