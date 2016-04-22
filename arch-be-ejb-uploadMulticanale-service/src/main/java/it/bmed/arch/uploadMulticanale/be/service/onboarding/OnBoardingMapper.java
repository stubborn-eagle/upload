package it.bmed.arch.uploadMulticanale.be.service.onboarding;

import javax.activation.DataSource;

import it.bmed.arch.uploadMulticanale.be.api.onboarding.Document;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents;

public interface OnBoardingMapper {

	Documents mapECMDocumentForWSRequest(Document documentoECM, DataSource fileContent);

}
