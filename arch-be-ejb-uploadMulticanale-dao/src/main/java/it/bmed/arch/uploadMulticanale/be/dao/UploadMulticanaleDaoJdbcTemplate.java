package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.asia.exception.ApplicationException;

/**
 * The uploadMulticanale DAO for JDBC access
 * 
 * @author generated automaticallu by bmed-asia-be-archetype
 * 
 */
public interface UploadMulticanaleDaoJdbcTemplate {

	ECMResponse insertMedia(ECMRequest request)
			throws ApplicationException, Exception;

	ECMResponse listMedia(ECMRequest request)
			throws ApplicationException, Exception;

	boolean updateMedia(UpdateECMRequest request)
			throws ApplicationException, Exception;

}
