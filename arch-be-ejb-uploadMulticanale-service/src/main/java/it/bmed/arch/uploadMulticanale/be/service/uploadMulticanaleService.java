package it.bmed.arch.uploadMulticanale.be.service;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.asia.exception.*;
import it.bmed.asia.exception.jaxws.SystemFault;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UploadMulticanaleService {

	public MediaResponse InsertMedia(MediaRequest request) throws TechnicalException, Exception;
	public MediaResponse listMedia(MediaRequest request) throws TechnicalException, Exception;
	public boolean updateMedia(UpdateMediaRequest request) throws SystemFault, Exception;
	

}