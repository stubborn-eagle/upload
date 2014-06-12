package it.bmed.arch.uploadMulticanale.be.service;

import java.util.Date;

import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.arch.uploadMulticanale.be.dao.*;
import it.bmed.asia.exception.*;
import it.bmed.asia.log.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("uploadMulticanaleService")
public class uploadMulticanaleServiceImpl implements uploadMulticanaleService, InitializingBean {
	Logger log = LoggerFactory.getLogger(uploadMulticanaleServiceImpl.class);

	@Autowired
	uploadMulticanaleDaoJdbcTemplate uploadMulticanaleDaoJdbcTemplate;

	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (uploadMulticanaleDaoJdbcTemplate == null)
			throw new Exception("ERROR: uploadMulticanaleDaoJdbcTemplate not injected");
	}
	
	@Override
	public MediaResponse InsertMedia(MediaRequest request) throws  TechnicalException, Exception
	{
		try
		{	
			MediaDTO  dto = request.getMediaDTO();
			
			//campi non obbligatori lasciati null
		
			// controllo obbligatorieta dei campi
			if (dto == null || dto.getCanale().isEmpty() || dto.getDataInserimento()== null  || dto.getDominio().isEmpty() ||
					dto.getIdUtente().isEmpty() || dto.getNomeApp().isEmpty() || dto.getNomeFile().isEmpty() ||
					dto.getSorgente_Path().isEmpty() || dto.getTipo().isEmpty() || dto.getTipoUtente().isEmpty() ) 
			{
				log.debug("Errore Servizio: parametri non corretti ");	
				//TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")); 
				
				//throw e;
				throw new RuntimeException(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+ UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription()) ;	
			}	
			
			// controllo lunghezza del campo di input stato
			if ( dto.getCanale().length() > 15 || dto.getContainerType().length() > 20 
					|| dto.getDestinazione_Path().length() > 500 || dto.getDominio().length() > 50  
					|| dto.getECMType().length() > 3 ||  dto.getIdFileECM().length() > 200 || dto.getIdUtente().length() > 11 
					|| dto.getNomeApp().length() > 100 ||  dto.getNomeFile().length() >  50
					|| dto.getSorgente_Path().length() > 500 || dto.getStato().length() > 3  || dto.getTipo().length() > 25  
					|| dto.getTipoUtente().length() > 15  ) 
			{
				
				
				log.debug("Errore Servizio: parametri non corretti qualche campo troppo lungo");	
				//TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")); 
				
				//throw e;
				throw new RuntimeException(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+ UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription()) ;	
			}				
			
			log.debug(" Servizio: parametri  corretti ");	
			MediaResponse response = new MediaResponse();
			
			response = uploadMulticanaleDaoJdbcTemplate.InsertMedia(request);	
			
			return response;			
		}
		catch (TechnicalException e)
		{			
			log.debug("Errore Servizio InsertMedia TechnicalException ", e.getMessage());			
			log.error("Errore Servizio InsertMedia getErrorCode {}_getErrorDescription {}  " + e.getErrorCode()+ "_" + e.getErrorDescription());				
			throw e;			
			
			
		}  catch (RuntimeException e) 
		{				
			log.error("Errore Servizio InsertMedia ");
			//TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			//throw tec;
			log.error("Errore Servizio InsertMedia: RuntimeException");
			throw e;			
		
		} 		
		catch (Exception e) 
		{				
			log.error("Errore  Servizio InsertMedia:  Exception ");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;
		} 	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public MediaResponse uploadListFile(MediaRequest request) throws AsiaException, Exception
	{
		try
		{
			
			MediaResponse response = new MediaResponse();
			response = uploadMulticanaleDaoJdbcTemplate.uploadListFile(request);

			return response;
			
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}
	
	
	
	
	
	
	
				//listMedia
	
	@Override
   public MediaResponse listMedia( MediaRequest request) throws TechnicalException, Exception {
		try
		{
			
			MediaDTO  dto = request.getMediaDTO();
			
			if (dto == null || dto.getCanale().isEmpty() || dto.getIdUtente().isEmpty() || dto.getTipoUtente().isEmpty() ) 
			{
				log.debug("Errore InsertMedia: parametri non corretti ");	
				//TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")); 
				
				//throw e;
				throw new RuntimeException(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+ UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription()) ;	
			}	
			
			// controllo lunghezza del campo di input stato
			if ( dto.getCanale().length() > 15 || dto.getIdUtente().length() > 11 || dto.getTipoUtente().length() > 15  ) 
			{
				
				
				log.debug("Errore InsertMedia: parametri non corretti qualche campo troppo lungo");	
				//TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR")); 
				
				//throw e;
				throw new RuntimeException(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+"_"+ UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription()) ;	
			}		
			
			
			
			
			
			MediaResponse response = new MediaResponse();
			response = uploadMulticanaleDaoJdbcTemplate.listMedia(request);

			return response;
			
		}
		catch (TechnicalException e)
		{			
			log.debug("Errore InsertMedia  getMessage {}", e.getMessage());			
			log.error("Errore  InsertMedia getErrorCode {}_getErrorDescription {}  " + e.getErrorCode()+ "_" + e.getErrorDescription());				
			throw e;			
			
			
		}  catch (RuntimeException e) 
		{				
			log.error("Errore InsertMedia in Servizio");
			//TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			//throw tec;
			log.error("Errore getJdbcTemplate() RuntimeException");
			throw e;			
		
		} 		
		catch (Exception e) 
		{				
			log.error("Errore InsertMedia:    Exception ");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;
		} 	
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public uploadMulticanaleResponse moveFile(uploadMulticanaleRequest request) throws  TechnicalException, Exception
	{
		try
		{
			
			uploadMulticanaleResponse response = new uploadMulticanaleResponse();
			response = uploadMulticanaleDaoJdbcTemplate.moveFile(request);

			return response;
			
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}	
	
	
	@Override
	public uploadMulticanaleResponse getFilenetToken(uploadMulticanaleRequest request) throws AsiaException, Exception
	{
		try
		{
			
			uploadMulticanaleResponse response = new uploadMulticanaleResponse();
			response = uploadMulticanaleDaoJdbcTemplate.moveFile(request);

			return response;
			
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}	
	
	
	
	@Override
	public uploadMulticanaleResponse getAzureToken(uploadMulticanaleRequest request) throws AsiaException, Exception
	{
		try
		{
			
			uploadMulticanaleResponse response = new uploadMulticanaleResponse();
			response = uploadMulticanaleDaoJdbcTemplate.moveFile(request);

			return response;
			
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}		
	
	 
	@Override
	public uploadMulticanaleResponse deleteFileECM(uploadMulticanaleRequest request) throws AsiaException, Exception
	{
		try
		{
			
			uploadMulticanaleResponse response = new uploadMulticanaleResponse();
			response = uploadMulticanaleDaoJdbcTemplate.deleteFileECM(request);

			return response;
			
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}		
	
	
	@Override
	public boolean updateMedia(String idFile, String ecmType, String Stato) throws AsiaException, Exception
	{
		try
		{
			
			boolean response = false;
			response = uploadMulticanaleDaoJdbcTemplate.updateMedia( idFile,  ecmType,  Stato);

			return response;
			
		}
		catch (Exception e)
		{
			log.error("Errore di accesso ai dati {}", e.getMessage());
			throw new AsiaException("999", "Errore di accesso ai dati");
		}
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
