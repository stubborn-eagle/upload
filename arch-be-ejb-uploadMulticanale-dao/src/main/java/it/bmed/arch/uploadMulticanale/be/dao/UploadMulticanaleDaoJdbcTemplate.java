package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.MediaRequest;
import it.bmed.arch.uploadMulticanale.be.api.MediaResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateMediaRequest;
import it.bmed.asia.exception.ApplicationException;

/**
 * The uploadMulticanale DAO for JDBC access
 * 
 * @author generated automaticallu by bmed-asia-be-archetype
 * 
 */
public interface UploadMulticanaleDaoJdbcTemplate {

	public MediaResponse insertMedia(MediaRequest request)
			throws ApplicationException, Exception;

	public MediaResponse listMedia(MediaRequest request)
			throws ApplicationException, Exception;

	public boolean updateMedia(UpdateMediaRequest request)
			throws ApplicationException, Exception;

}
