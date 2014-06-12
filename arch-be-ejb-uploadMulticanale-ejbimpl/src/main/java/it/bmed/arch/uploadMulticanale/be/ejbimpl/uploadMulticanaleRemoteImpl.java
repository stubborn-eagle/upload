package it.bmed.arch.uploadMulticanale.be.ejbimpl;

import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.arch.uploadMulticanale.be.service.*;
import it.bmed.asia.api.*;
import it.bmed.asia.log.*;
import it.bmed.asia.exception.*;
import it.bmed.asia.exception.*;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.utility.*;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
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

	
	
//	InsertMedia
	
	
	@Override
	public MediaResponse InsertMedia(MediaRequest r) throws SystemFault,RemoteException, Exception
	{			
		MediaResponse resp= null;
			
		try
		{	
			
			resp =  uploadMulticanaleService.InsertMedia(r);
		
		}catch(TechnicalException tec){
			
		//	log.error("Errore TechnicalException.getMessage() "+ tec.getMessage());
		//	log.error("Errore TechnicalException getErrorCode {}   getErrorDescription {}  " + tec.getErrorCode()+ "_" + tec.getErrorDescription());
	     
			 SystemFault fault = ExceptionToFaultConversionUtil.toFault(tec);
			 fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode());
			 fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getDescription());
			 fault.getFaultInfo().setTechnical(true);  
			 
		//	 log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
		//	 log.error("Errore TechnicalException getErrorCode {}   getErrorDescription {}  " + tec.getErrorCode()+ "_" + tec.getErrorDescription());	
			
			throw fault;
	        
	    }catch(RuntimeException runtimeException){
	    	
	    	  
	    	//  TechnicalException	applicationException =	new TechnicalException(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")  );			
	        SystemFault fault = ExceptionToFaultConversionUtil.toFault(runtimeException);
	        fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false);  	
	    	  
	    	 
	   // 	log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
	    		
	    	throw fault;
	        
	    } catch (Exception app) {
	    	
	    	  TechnicalException	applicationException =	new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")  );			
	    	  SystemFault fault = ExceptionToFaultConversionUtil.toFault(applicationException);
	    	  fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode());
			  fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getDescription());
			  fault.getFaultInfo().setTechnical(true);  
	    	  
	    //	  log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
		//	  log.error("Errore  getErrorCode {}   getErrorDescription {}  " + applicationException.getErrorCode()+ "_" + applicationException.getErrorDescription());	
			 
			  throw fault;
		}
		
		 return resp;
		
		
	}
		
	
	/*
	@Override
	public MediaResponse uploadListFile(MediaRequest r) throws RemoteException, Exception
	{
		try
		{
			return uploadMulticanaleService.uploadListFile(r);
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}
	*/	
	
	
	
	
	
//	ListMedia
	
	@Override
   public MediaResponse ListMedia(MediaRequest request) throws SystemFault,RemoteException, Exception
   {		
		MediaResponse resp= null; 
		
		try
		{
			resp = uploadMulticanaleService.listMedia(request);
			
		}catch(TechnicalException tec){
			
		//	log.error("Errore TechnicalException.getMessage() "+ tec.getMessage());
		//	log.error("Errore TechnicalException getErrorCode {}   getErrorDescription {}  " + tec.getErrorCode()+ "_" + tec.getErrorDescription());
	     
			 SystemFault fault = ExceptionToFaultConversionUtil.toFault(tec);
			 fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode());
			 fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getDescription());
			 fault.getFaultInfo().setTechnical(true);  
			 
		//	 log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
		//	 log.error("Errore TechnicalException getErrorCode {}   getErrorDescription {}  " + tec.getErrorCode()+ "_" + tec.getErrorDescription());	
			
			throw fault;
	        
	    }catch(RuntimeException runtimeException){
	    	
	    	  
	    	//  TechnicalException	applicationException =	new TechnicalException(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")  );			
	        SystemFault fault = ExceptionToFaultConversionUtil.toFault(runtimeException);
	        fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false);  	
	    	  
	    	 
	    //	log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
	    		
	    	throw fault;
	        
	    } catch (Exception app) {
	    	
	    	  TechnicalException	applicationException =	new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")  );			
	    	  SystemFault fault = ExceptionToFaultConversionUtil.toFault(applicationException);
	    	  fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode());
			  fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getDescription());
			  fault.getFaultInfo().setTechnical(true);  
	    	  
	    //	  log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
		//	  log.error("Errore  getErrorCode {}   getErrorDescription {}  " + applicationException.getErrorCode()+ "_" + applicationException.getErrorDescription());	
			 
			  throw fault;
		}
		
		 return resp;	
		
		
	} 

	/*
	 * 
	 * }catch(TechnicalException tec){
			
			log.error("Errore TechnicalException.getMessage() "+ tec.getMessage());
			log.error("Errore TechnicalException getErrorCode {}   getErrorDescription {}  " + tec.getErrorCode()+ "_" + tec.getErrorDescription());
	     
			 SystemFault fault = ExceptionToFaultConversionUtil.toFault(tec);
			 fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode());
			 fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getDescription());
			 fault.getFaultInfo().setTechnical(true);  
			 
			 log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
			 log.error("Errore TechnicalException getErrorCode {}   getErrorDescription {}  " + tec.getErrorCode()+ "_" + tec.getErrorDescription());	
			
			throw fault;
	        
	    }catch(RuntimeException runtimeException){
	    	
	    	  
	    	//  TechnicalException	applicationException =	new TechnicalException(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")  );			
	        SystemFault fault = ExceptionToFaultConversionUtil.toFault(runtimeException);
	        fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false);  	
	    	  
	    	 
	    	log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
	    		
	    	throw fault;
	        
	    } 
		catch (Exception e)
		{
			// ???????
			IErrorCode tc = UploadMulticanaleErrorCodeEnums.TCH_SQL_ERROR;
			TechnicalException tec = new TechnicalException(tc);
			//TechnicalException	applicationException =	new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")  );			

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(tec);
			fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getErrorCode()+"_"+UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(true);  

			log.error("Errore  fault:   " + fault.getMessage()+" "+fault.getFaultInfo().getCodice()+"  "+ fault.getFaultInfo().getMessaggio());	
			log.error("Errore  getErrorCode {}   getErrorDescription {}  " + tec.getErrorCode()+ "_" + tec.getErrorDescription());	

			throw fault;
		}
	 * 
	 * */
	
	
	
	
	
	
	
	/*
	@Override
	public uploadMulticanaleResponse moveFile(uploadMulticanaleRequest r) throws RemoteException, Exception
	{
		try
		{
			return uploadMulticanaleService.moveFile(r);
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}*/
	
	
	/*
	@Override
	public uploadMulticanaleResponse getFilenetToken(uploadMulticanaleRequest r) throws RemoteException, Exception
	{
		try
		{
			return uploadMulticanaleService.getFilenetToken(r);
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}  */		

	
	/*
	@Override
	public uploadMulticanaleResponse getAzureToken(uploadMulticanaleRequest r) throws RemoteException, Exception
	{
		try
		{
			return uploadMulticanaleService.getAzureToken(r);
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}	*/	
	
	
	/*
	@Override
	public uploadMulticanaleResponse deleteFileECM(uploadMulticanaleRequest r) throws RemoteException, Exception
	{
		try
		{
			return uploadMulticanaleService.deleteFileECM(r);
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	} */		
	

	/*
	@Override
	public boolean updateMedia(String idFile, String ecmType, String Stato) throws RemoteException, Exception
	{
		try
		{
			return uploadMulticanaleService.updateMedia(idFile, ecmType, Stato);
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}	*/	
	
	
	
}
