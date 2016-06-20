package it.bmed.arch.uploadMulticanale.be.service.onboarding;

import it.bmed.arch.uploadMulticanale.be.api.onboarding.Document;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents;

import javax.activation.DataSource;

public interface OnBoardingMapper {

	Documents mapECMDocumentForWSRequest(Document documentoECM, DataSource fileContent);

}
