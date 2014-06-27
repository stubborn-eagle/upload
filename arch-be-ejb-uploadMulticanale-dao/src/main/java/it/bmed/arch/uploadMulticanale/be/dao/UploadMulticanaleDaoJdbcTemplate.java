package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.MediaRequest;
import it.bmed.arch.uploadMulticanale.be.api.MediaResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.asia.exception.ApplicationException;

/**
 * The uploadMulticanale DAO for JDBC access
 * 
 * @author generated automaticallu by bmed-asia-be-archetype
 * 
 */
public interface UploadMulticanaleDaoJdbcTemplate {

	public ECMResponse insertMedia(ECMRequest request)
			throws ApplicationException, Exception;

	public ECMResponse listMedia(ECMRequest request)
			throws ApplicationException, Exception;

	public boolean updateMedia(UpdateECMRequest request)
			throws ApplicationException, Exception;

}
