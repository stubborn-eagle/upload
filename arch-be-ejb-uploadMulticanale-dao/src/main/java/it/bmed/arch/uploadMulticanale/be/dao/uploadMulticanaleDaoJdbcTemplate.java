package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.asia.exception.*;


/**
 * The uploadMulticanale DAO for JDBC access
 * 
 * @author generated automaticallu by bmed-asia-be-archetype 
 * 
 */
public interface uploadMulticanaleDaoJdbcTemplate {

	public MediaResponse InsertMedia(MediaRequest request) throws ApplicationException, Exception;
	public MediaResponse listMedia( MediaRequest request) throws ApplicationException, Exception;		
	public boolean updateMedia( UpdateMediaRequest request) throws ApplicationException,Exception;
	
}
