package it.bmed.arch.uploadMulticanale.be.ejbimpl;

import it.bmed.arch.uploadMulticanale.be.api.AzureDTO;
import it.bmed.arch.uploadMulticanale.be.api.AzureRequest;
import it.bmed.arch.uploadMulticanale.be.api.AzureResponse;
import it.bmed.arch.uploadMulticanale.be.api.MediaDTO;
import it.bmed.arch.uploadMulticanale.be.api.MediaRequest;
import it.bmed.arch.uploadMulticanale.be.api.MediaResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateMediaRequest;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleRemote;
import it.bmed.arch.uploadMulticanale.be.service.UploadMulticanaleService;
import it.bmed.arch.uploadMulticanale.be.service.azure.AzureService;
import it.bmed.arch.uploadMulticanale.be.service.cmis.ECMService;
import it.bmed.arch.uploadMulticanale.be.service.nas.NASService;
import it.bmed.asia.exception.ApplicationException;
import it.bmed.asia.exception.AsiaApplicationException;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.exception.ExceptionToFaultConversionUtil;
import it.bmed.asia.exception.IErrorCode;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.rmi.RemoteException;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;


@Stateless(name = "uploadMulticanaleDaoWS", mappedName = "ejb/", description = "")
@WebService(
		serviceName = "uploadMulticanaleBS", 
		name = "uploadMulticanaleBS", 
		portName = "uploadMulticanaleBS", 
		endpointInterface = "it.bmed.arch.uploadMulticanale.be.api.uploadMulticanaleRemote")
@Remote(UploadMulticanaleRemote.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)

public class UploadMulticanaleRemoteImpl implements UploadMulticanaleRemote {

	Logger log = LoggerFactory.getLogger(UploadMulticanaleRemoteImpl.class);
	
	@Autowired
	UploadMulticanaleService uploadMulticanaleService;
	
	@Autowired
	ECMService ecmService;
	
	@Autowired
	AzureService azureService;
	
	@Autowired
	NASService nasService;

	
	@Override
	public MediaResponse InsertMedia(MediaRequest r) throws SystemFault,RemoteException, Exception
	{			
		MediaResponse resp= null;
			
		try
		{				
			resp =  uploadMulticanaleService.InsertMedia(r);
		
		}catch(ApplicationException e){
			
			SystemFault fault = ExceptionToFaultConversionUtil.toFault(e);			
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice()+"_"+fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setTechnical(true);  
			
			throw fault;
	        
		}catch(RuntimeException runtimeException){

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(runtimeException);
			fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setLayer(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false); 
			/*
			log.error("Errore e.getMessage() "+ runtimeException.getMessage());
			log.error("Errore e.getFaultInfo().getCodice() "+ fault.getFaultInfo().getCodice());
			log.error("Errore e.getFaultInfo().getMessaggio() "+ fault.getFaultInfo().getMessaggio());
			log.error("Errore e.getFaultInfo().getMessaggio() "+ fault.getFaultInfo().isTechnical());
			*/
			throw fault;


		} catch (Exception app) {

			IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			TechnicalException  applicationException = new TechnicalException( er );	
			SystemFault fault = ExceptionToFaultConversionUtil.toFault(applicationException);
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice()+"_"+fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setTechnical(false);  
			/*
			log.error("Errore e.getMessage() "+ fault.getMessage());
			log.error("Errore e.getFaultInfo().getCodice() "+ fault.getFaultInfo().getCodice());
			log.error("Errore e.getFaultInfo().getMessaggio() "+ fault.getFaultInfo().getMessaggio());
			log.error("Errore e.getFaultInfo().getMessaggio() "+ fault.getFaultInfo().isTechnical());
			*/
		}
		
		 return resp;		 
	}
	
	
   @Override
   public MediaResponse ListMedia(MediaRequest request) throws SystemFault,RemoteException, Exception
   {		
		MediaResponse resp= null; 
		
		try
		{
			resp = uploadMulticanaleService.listMedia(request);

		}catch(ApplicationException e){

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(e);			
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice()+"_"+fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setTechnical(true);  

			throw fault;

		}catch(RuntimeException runtimeException){

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(runtimeException);
			fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setLayer(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false); 

			throw fault;

		} catch (Exception app) {

			IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			TechnicalException  applicationException = new TechnicalException( er );	
			SystemFault fault = ExceptionToFaultConversionUtil.toFault(applicationException);
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice()+"_"+fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setTechnical(false);  

		}		
		 return resp;			
	} 	

	
	@Override
	public boolean UpdateMedia( UpdateMediaRequest request ) throws SystemFault, RemoteException, Exception
	{
		boolean resp= false; 

		try
		{
			resp = uploadMulticanaleService.updateMedia(request);

		}catch(ApplicationException e){

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(e);			
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice()+"_"+fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio() );
			
			throw fault;

		}catch(RuntimeException runtimeException){

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(runtimeException);
			fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false); 
			
			throw fault;

		} catch (Exception e) {

			IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			TechnicalException  applicationException = new TechnicalException( er );	
			SystemFault fault = ExceptionToFaultConversionUtil.toFault(applicationException);			
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice()+"_"+fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio() );
			fault.getFaultInfo().setTechnical(false);  

			throw fault;
		}
		return resp;	

	}


	@Override
	public boolean deleteFileECM(MediaRequest request) throws RemoteException, Exception {
		boolean result = false;
		MediaResponse response = null;
		try {
			log.info("deleteFileECM params: " + response);
		} catch (NullPointerException e) {
			log.error("deleteFileECM: request argument cannot be null.");
			throw new AsiaApplicationException("TCH_ECM_ERROR", "deleteFileECM: request argument cannot be null.");
		}
		
		try {
			response = ListMedia(request);
			if(response == null) {
				log.error("deleteFileECM: ListMedia cannot be null. ");
				throw new AsiaApplicationException("TCH_ECM_ERROR", "deleteFileECM: ListMedia cannot be null. ");
			}
		} catch (Exception e) {
			log.error("deleteFileECM: SQLException. " + e.getMessage());
			throw new AsiaApplicationException("TCH_ECM_ERROR", "deleteFileECM: SQLException. " + e.getMessage());
		}
		
		try {
			result = ecmService.removeFile(response.getResult().getECMType(), response.getResult().getIdFileECM());
		} catch (Exception e) {
			log.error("deleteFileECM " + e.getMessage());
			throw new AsiaApplicationException("TCH_ECM_ERROR", "deleteFileECM: " + e.getMessage());
		}
		log.info("deleteFileECM returns: " + result);
		return result;
	}


	@Override
	public boolean deleteFileNAS(MediaRequest request) {
		boolean response = false;
		MediaResponse mediaResponse = null;
		if(request == null) {
			log.error("deleteFileNAS: request cannot be null.");
			throw new AsiaException("deleteFileNAS: request cannot be null.");
		}

		try {
			mediaResponse = ListMedia(request);
			response = nasService.deleteFile(mediaResponse.getResult().getSorgente_Path(), mediaResponse.getResult().getIdFile());
			log.info("deleteFileNAS: operation succesfully returned.");
		} catch (Exception e) {
			log.error("deleteFileNAS: " + e.getMessage());
			throw new AsiaException("TCH_ECM_ERROR", "deleteFileNAS: " + e.getMessage());
		}
		return response;
	}


	@Override
	public AzureResponse getAzureToken(AzureRequest request) throws RemoteException, Exception {
		AzureResponse azureResponse = new AzureResponse();
		AzureDTO azureDTO = null;
		azureDTO = azureService.generateToken(request);
		azureResponse.setResult(azureDTO);
		return azureResponse;
	}
}
