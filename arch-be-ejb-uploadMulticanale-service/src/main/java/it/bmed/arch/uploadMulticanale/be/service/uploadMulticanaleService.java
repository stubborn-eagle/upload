package it.bmed.arch.uploadMulticanale.be.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.asia.exception.*;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface uploadMulticanaleService {

	// servizio per InsertMedia
	public MediaResponse InsertMedia(MediaRequest request) throws TechnicalException, Exception;
	public MediaResponse listMedia(MediaRequest request) throws TechnicalException, Exception;

	
	
	public MediaResponse uploadListFile(MediaRequest request) throws AsiaException, Exception;
	//public uploadMulticanaleResponse downloadFile(uploadMulticanaleRequest request) throws AsiaException, Exception;
	public uploadMulticanaleResponse moveFile(uploadMulticanaleRequest request) throws AsiaException, Exception;
	public uploadMulticanaleResponse getFilenetToken(uploadMulticanaleRequest request) throws AsiaException, Exception;
	public uploadMulticanaleResponse getAzureToken(uploadMulticanaleRequest request) throws AsiaException, Exception;
	public uploadMulticanaleResponse deleteFileECM(uploadMulticanaleRequest request) throws AsiaException, Exception;
	public boolean updateMedia(String idFile, String ecmType, String Stato) throws AsiaException, Exception;


}