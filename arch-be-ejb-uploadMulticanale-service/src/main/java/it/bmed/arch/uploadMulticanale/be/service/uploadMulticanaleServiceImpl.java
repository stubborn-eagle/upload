package it.bmed.arch.uploadMulticanale.be.service;

import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.arch.uploadMulticanale.be.dao.*;
import it.bmed.asia.exception.*;
import it.bmed.asia.exception.jaxws.SystemFault;
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
				
				IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
				TechnicalException  tec = new TechnicalException( er );	
			
				throw tec;			
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
				IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
				TechnicalException  tec = new TechnicalException( er );	
								
				throw tec;
			
			}				
			
			log.debug(" Servizio: parametri  corretti ");	
			MediaResponse response = new MediaResponse();			
			response = uploadMulticanaleDaoJdbcTemplate.InsertMedia(request);				
			return response;			
		}
		catch (ApplicationException e)
		{						
			log.error("Errore Servizio InsertMedia getErrorCode {}_getErrorDescription {}  " + e.getErrorCode()+ "_" + e.getErrorDescription());				
			throw e;			
			
			
		}  catch (RuntimeException e) 
		{				
			log.error("Errore Servizio InsertMedia ");
			throw e;
		} 	
		
	}
	

	@Override
   public MediaResponse listMedia( MediaRequest request) throws TechnicalException, Exception {
		try
		{			
			MediaDTO  dto = request.getMediaDTO();
			
			if (dto == null || dto.getCanale().isEmpty() || dto.getIdUtente().isEmpty() || dto.getTipoUtente().isEmpty() ) 
			{				
				log.debug("Errore InsertMedia: parametri non corretti ");	
				
				IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
				TechnicalException  tec = new TechnicalException( er );					
				throw tec;
			}	
						
			// controllo lunghezza del campo di input stato
			if ( dto.getCanale().length() > 15 || dto.getIdUtente().length() > 11 || dto.getTipoUtente().length() > 15  ) 
			{
				log.debug("Errore InsertMedia: parametri non corretti qualche campo troppo lungo");	
				IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
				TechnicalException  tec = new TechnicalException( er );	
				
				throw tec;
			}		
			
			MediaResponse response = new MediaResponse();
			response = uploadMulticanaleDaoJdbcTemplate.listMedia(request);

			return response;
			
		}
		catch (ApplicationException e)
		{		
			log.error("Errore  InsertMedia getErrorCode {}_getErrorDescription {}  " + e.getErrorCode()+ "_" + e.getErrorDescription());				
			throw e;
			
		}  catch (RuntimeException e) 
		{				
			log.error("Errore InsertMedia in Servizio");
			throw e;	
		} 	
		
	}	
	
	
	
	@Override
	public boolean updateMedia(UpdateMediaRequest request) throws SystemFault, Exception 
	{		
		try
		{	

			String IdFile = request.getIdFile();
			String ECMType = request.getECMType();
			String Stato = request.getStato();
			String Destinazione_path = request.getDestinazione_path();
			String idFileECM = request.getIdFileECM();
			String Container_type = request.getContainer_type();
			boolean res ;

			if (IdFile.isEmpty()) 
			{
				log.debug("Errore updateMedia: IdFile obbligatorio ");	
				
				IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
				TechnicalException  tec = new TechnicalException( er );	
								
				throw tec;
				}	

			// controllo lunghezza del campo di input stato
			if ( Container_type.length() > 20 
					|| Destinazione_path.length() > 500  
					|| ECMType.length() > 3
					|| idFileECM.length() > 200            
					|| IdFile.length() > 50 
					|| Stato.length() > 3 
				) 
			{

				//	Il valore della correttezza del valore va fatta  a livello superiore	
				IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
				TechnicalException  tec = new TechnicalException( er );	
				throw tec;
			}
			
			res = uploadMulticanaleDaoJdbcTemplate.updateMedia( request);
			return res;
					
		}
		catch (ApplicationException e) 
		{	
			
			log.error("Errore updateMedia:    ApplicationException ");
			throw e;
			
			
		}catch (RuntimeException e) 
		{				
			log.error("Errore updateMedia in Servizio");
			log.error("Errore getJdbcTemplate() RuntimeException");
			throw e;
		} 
		
	}		
	
		
	
}
