package it.bmed.arch.uploadMulticanale.be.service;

import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.asia.exception.TechnicalException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UploadMulticanaleService {

	ECMResponse insertMedia(ECMRequest r) throws TechnicalException, Exception;

	ECMResponse listMedia(ECMRequest request) throws TechnicalException, Exception;

	boolean updateMedia(UpdateECMRequest request) throws TechnicalException, Exception;

	ECMResponse selectMedia(Integer refId) throws TechnicalException, Exception;

	ECMResponse listOlderMedia(int monthsAmount) throws TechnicalException, Exception;

}