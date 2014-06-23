package it.bmed.arch.uploadMulticanale.be.service.azure;

import it.bmed.arch.uploadMulticanale.be.api.AzureDTO;
import it.bmed.arch.uploadMulticanale.be.api.AzureRequest;
import it.bmed.asia.exception.AsiaException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface AzureService {

	AzureDTO generateToken(AzureRequest parameters) throws AsiaException, Exception;

}