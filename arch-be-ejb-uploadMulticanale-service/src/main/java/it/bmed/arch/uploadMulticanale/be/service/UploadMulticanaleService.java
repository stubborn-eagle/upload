package it.bmed.arch.uploadMulticanale.be.service;

import it.bmed.arch.uploadMulticanale.be.api.MediaRequest;
import it.bmed.arch.uploadMulticanale.be.api.MediaResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateMediaRequest;
import it.bmed.asia.exception.TechnicalException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UploadMulticanaleService {

	public MediaResponse insertMedia(MediaRequest request)
			throws TechnicalException, Exception;

	public MediaResponse listMedia(MediaRequest request)
			throws TechnicalException, Exception;

	public boolean updateMedia(UpdateMediaRequest request)
			throws TechnicalException, Exception;

}