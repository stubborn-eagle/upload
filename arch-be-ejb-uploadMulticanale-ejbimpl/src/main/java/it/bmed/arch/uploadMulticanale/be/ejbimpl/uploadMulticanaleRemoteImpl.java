package it.bmed.arch.uploadMulticanale.be.ejbimpl;

import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.arch.uploadMulticanale.be.service.*;
import it.bmed.asia.log.*;
import it.bmed.asia.exception.*;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.asia.exception.TechnicalException;
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
@Remote(uploadMulticanaleRemote.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)

public class uploadMulticanaleRemoteImpl implements uploadMulticanaleRemote {

	Logger log = LoggerFactory.getLogger(uploadMulticanaleRemoteImpl.class);
	@Autowired
	uploadMulticanaleService uploadMulticanaleService;

	
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
	
	
	
}
