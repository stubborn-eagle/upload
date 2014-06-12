package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.asia.api.*;
import it.bmed.asia.exception.*;

import java.util.List;

/**
 * The uploadMulticanale DAO for JDBC access
 * 
 * @author generated automaticallu by bmed-asia-be-archetype 
 * 
 */
public interface uploadMulticanaleDaoJdbcTemplate {

	public MediaResponse InsertMedia(MediaRequest request) throws TechnicalException, Exception;
	public MediaResponse listMedia( MediaRequest request) throws TechnicalException, Exception;	
	
//	public MediaResponse updateMedia( MediaRequest request) throws TechnicalException, Exception;
	
	
	
	public MediaResponse uploadListFile(MediaRequest request) throws AsiaException, Exception;	
	
   //public uploadMulticanaleResponse downloadFile(uploadMulticanaleRequest request) throws AsiaException, Exception;
	
	public uploadMulticanaleResponse moveFile(uploadMulticanaleRequest request) throws AsiaException, Exception;
	
	public uploadMulticanaleResponse getFilenetToken(uploadMulticanaleRequest request) throws AsiaException, Exception;
	
	public uploadMulticanaleResponse getAzureToken(uploadMulticanaleRequest request) throws AsiaException, Exception;
	
	public uploadMulticanaleResponse deleteFileECM(uploadMulticanaleRequest request) throws AsiaException, Exception;

	public boolean updateMedia(String idFile, String ecmType, String Stato) throws AsiaException, Exception;


}
