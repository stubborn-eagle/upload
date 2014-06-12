package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.*;

import it.bmed.asia.dao.util.AsiaSqlBuilder;
import it.bmed.asia.api.*;
import it.bmed.asia.exception.*;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.asia.dao.*;
import it.bmed.asia.log.*;
import it.bmed.asia.utility.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository("uploadMulticanaleDaoJdbcTemplate")
public class uploadMulticanaleDaoImplJdbcTemplate implements uploadMulticanaleDaoJdbcTemplate ,InitializingBean{

	Logger log = LoggerFactory.getLogger(uploadMulticanaleDaoImplJdbcTemplate.class);
	@Autowired
	DataSource dataSource;
	
	protected JdbcTemplate jdbcTemplate;
	
	protected JdbcTemplate getJdbcTemplate() {
		//log.debug("getJdbcTemplate!!!!!");
		if (jdbcTemplate == null) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
	}	
	
	
	@Override
	public MediaResponse uploadListFile(MediaRequest parameters) throws AsiaException, Exception {
		
		MediaResponse response = new MediaResponse();
		
		/*   commentata perche usa  MediaDTO
		 *   
		 * 
		
		List<MediaDTO> ret = new ArrayList<MediaDTO>();
		List<MediaParam> params = parameters.getParams();
		RequestMetaData metaData = parameters.getMetadata();
		for (MediaParam mediaParam : params) {
			// *********************************************************************************
			// Preparo la insert
			// *********************************************************************************
			String id = mediaParam.getIdFile();
			java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
			MediaDTO tmp = new MediaDTO();
			
			
			int result = getJdbcTemplate()
					.update(" INSERT INTO qpush_be.ECM_FILE (ID_FILE, ECM_TYPE, ID_FILE_ECM, SORGENTE_PATH, DESTINAZIONE_PATH, NOME_APP, CONTAINER_TYPE, CANALE, ID_UTENTE, TIPO_UTENTE, DATA_INSERIMENTO, STATO, TIPO_FILE, NOME_FILE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ",
							new Object[] {id, mediaParam.getEcmType(), id, mediaParam.getSorgente_path(), mediaParam.getDestinazione_path(), mediaParam.getNomeApp(), mediaParam.getContainerType(), mediaParam.getCanale(), metaData.getUserId(), mediaParam.getTipoUtente(), date, "INSERT", mediaParam.getTipo(), mediaParam.getNomeFile() });

			tmp.setIdFile(id);
			tmp.setDataInserimento(date.getTime());
			tmp.setCanale(mediaParam.getCanale());
			tmp.setContainerType(mediaParam.getContainerType());
			tmp.setDataInserimento(mediaParam.getDataInserimento());
			tmp.setDestinazione_path(mediaParam.getDestinazione_path());
			tmp.setIdECMFile(mediaParam.getIdECMFile());
			tmp.setIdUtente(mediaParam.getIdUtente());
			tmp.setNomeApp(mediaParam.getNomeApp());
			tmp.setNomeFile(mediaParam.getNomeFile());
			tmp.setSorgente_path(mediaParam.getSorgente_path());
			tmp.setStato(mediaParam.getStato());
			tmp.setTipo(mediaParam.getTipo());
			tmp.setTipoUtente(mediaParam.getTipoUtente());			
			ret.add(tmp);
		}
		log.debug("OUTPUT DAO {}", CommonUtils.bean2string(response));
		response.setListResults(ret);
		return response;
		
		*/
		return response;
	}	
	
	
	@Override
	public MediaResponse InsertMedia(MediaRequest parameters) throws TechnicalException, Exception {
			
		MediaDTO dto = parameters.getMediaDTO();
		
		//java.sql.Date dat  =  new java.sql.Date(dto.getDataInserimento().getTime())  ;
		//java.sql.Timestamp ts    =  new Timestamp(dto.getDataInserimento().getTime()); 
		//long dataInserimento = dto.getDataInserimento().getTime();
				
		int result = 0;
	
		try {
			/*
			result = getJdbcTemplate()
					.update("insert into qpush_be.PROVA (prova) " +
							" values ("+ dto.getDataInserimento().getTime() +") "  
				);
			 */
			
			result = getJdbcTemplate()
					.update("insert into qpush_be.ECM_FILE (ID_FILE, ECM_TYPE, ID_FILE_ECM, SORGENTE_PATH, DESTINAZIONE_PATH, " +
							"NOME_APP, CONTAINER_TYPE, CANALE, ID_UTENTE, TIPO_UTENTE, DATA_INSERIMENTO, DATA_AGGIORNAMENTO, " +
							"STATO, TIPO_FILE, NOME_FILE, DOMINIO) " +
							" values (qpush_be.ECM_FILE_SEQ.nextval, '" +   
							dto.getECMType()+ "',  '" +   dto.getIdFileECM()+ "',  '" +    dto.getSorgente_Path()+ "',  '" +    
							dto.getDestinazione_Path()+ "',  '" +  dto.getNomeApp()+ "',  '" +   
							dto.getContainerType()+ "',  '" +   dto.getCanale()+ "', '" +    dto.getIdUtente()+ "',  '" +    
							dto.getTipoUtente()+ "', "+ dto.getDataInserimento().getTime() +", sysdate, '" + 
							dto.getStato()+ "',  '" +    dto.getTipo()+ "',  '" +    dto.getNomeFile() +"', '" + dto.getDominio() +"' )"   
							);

			if (result == 0) {				
				log.debug("Errore DAO InsertMedia: parametri non corretti ");
				TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));				
				throw e;							
			}	

		}catch (ApplicationException ex) 
		{
			log.error("Errore DAO  ApplicationException");
			TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));	
			throw e;			
		
		}  catch (RuntimeException e) 
		{				
			log.error("Errore DAO  RuntimeException");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;	
			
			//log.error("Errore DAO getJdbcTemplate() Exception");
			//throw e;			
		
		}  catch (Exception e) 
		{				
			log.error("Errore DAO  Exception ");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;							
			
		} 		
		
		log.debug("risultato DAO query result {} "+ result)	;		
		
		MediaResponse response = new MediaResponse();
		response.setResult(dto);
		
		log.debug("OUTPUT DAO {}", CommonUtils.bean2string(response.getResult()));
		return response;
	
	}		
	
	
	
	
	
	
	
	
	
	private String[] getRequestId(List<MediaParam> parameters) {
		String[] id = new String[parameters.size()];
		int i = 0;
		for (MediaParam documentParam : parameters) {
			id[i] = documentParam.getIdFile();
			i++;
		}
		return id;
	}	
	
	
	
	
	
	
	
	


	@Override
   public MediaResponse listMedia( MediaRequest request) throws TechnicalException, Exception {	
		
		MediaDTO dto = request.getMediaDTO();		
		MediaResponse response = new MediaResponse() ;
		

		// *********************************************************************************
		// Preparo la query
		// *********************************************************************************
	/*	StringBuilder whereClause = new StringBuilder(" ");
		AsiaSqlBuilder sqlparam = AsiaSqlBuilder.getInstance();
		
		String[] param = {dto.getIdUtente(),dto.getCanale(),dto.getTipoUtente()};
		
		//String[] id = getRequestId(request.getParams());		
		
		sqlparam.getQueryStringArrayOR(whereClause, param, "ID_FILE");
	*/
		
		
		String whereClause = "and ID_UTENTE = '"+dto.getIdUtente()+
				"' and  CANALE = '"+dto.getCanale()+
				"' and  TIPO_UTENTE = '"+dto.getTipoUtente()+
				"' ";
		
		StringBuilder queryStrBuilder = new StringBuilder().append("SELECT * FROM qpush_be.ECM_FILE WHERE 1= 1 " + whereClause);
		log.debug("QUERY CommandDataMove : {}", queryStrBuilder);
		
		/*		 
		manca DATA_AGGIORNAMENTO			
	
		*/
		
		try {
		
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<MediaDTO> ret = getJdbcTemplate().query( queryStrBuilder.toString(), new RowMapper() {
				@Override
				public Object mapRow(java.sql.ResultSet rs, int row) throws SQLException {
					// MAP YOUR FIELDS HERE
					MediaDTO te = new MediaDTO();
					Date date = null;
					
					te.setCanale(rs.getString("CANALE"));
					te.setContainerType(rs.getString("CONTAINER_TYPE"));
					
					Date dataInserimento = new Date(rs.getLong("DATA_INSERIMENTO"));
					/*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 	           
		            String strDate = formatter.format(dataInserimento);
		            */
					
					te.setDataInserimento(dataInserimento);
					te.setDestinazione_Path(rs.getString("DESTINAZIONE_PATH"));
					te.setDominio(rs.getString("DOMINIO"));	
					te.setECMType(rs.getString("ECM_TYPE"));
					te.setIdFileECM(rs.getString("ID_FILE_ECM"));				
					te.setIdUtente(rs.getString("ID_UTENTE"));
					te.setNomeApp(rs.getString("NOME_APP"));
					te.setNomeFile(rs.getString("NOME_FILE"));
					te.setSorgente_Path(rs.getString("SORGENTE_PATH"));
					te.setStato(rs.getString("STATO"));
					te.setTipo(rs.getString("TIPO_FILE"));
					te.setTipoUtente(rs.getString("TIPO_UTENTE"));
					te.setDominio(rs.getString("DOMINIO"));
					
					return te;
				}
			});
			

			response.setListResults(ret);
			return response;
		
			
		
		}catch (RuntimeException e) 
		{				
			log.error("Errore DAO : RuntimeException ");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;	
			
			//log.error("Errore DAO getJdbcTemplate() Exception");
			//throw e;			
		
		}  catch (Exception e) 
		{				
			log.error("Errore DAO : Exception ");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;	
		} 
		
	}	
	


	
	
	
	
	
	
	
	//			updateMedia
	
	/*
	@Override
	public MediaResponse updateMedia(MediaRequest request)throws TechnicalException, Exception {			
		
		MediaDTO dto = request.getMediaDTO();			
		int result = 0;
	
		try {
			
			
			
			 getJdbcTemplate().jdbcTemplate.update(
		                " UPDATE ECM_FILE SET STATO = <stato>, ECM_TYPE = ?, DATA_AGGIORNAMENTO = SYSDATE, destinazione_path = ?, id_file_ecm = ?, container_type = ?, WHERE ID_FILE = ? ", 
		                dto.getStato(), dto.getECMType(),dto.getDestinazione_Path() ,dto.getIdFileECM() ,dto.getContainerType(),dto.getidFile );
		  
			
			 UPDATE ECM_FILE
			 SET STATO = <stato>,
			 ECM_TYPE = <ecm_type>,
			 DATA_AGGIORNAMENTO = SYSDATE,
			 destinazione_path = <Destinazione_path>,
			 id_file_ecm = <id_file_Ecm>,
			 container_type = <containerType>
			 WHERE ID_FILE = <idFile>;

			 
			 
			result = getJdbcTemplate()
					.update("insert into qpush_be.ECM_FILE (ID_FILE, ECM_TYPE, ID_FILE_ECM, SORGENTE_PATH, DESTINAZIONE_PATH, " +
							"NOME_APP, CONTAINER_TYPE, CANALE, ID_UTENTE, TIPO_UTENTE, DATA_INSERIMENTO, DATA_AGGIORNAMENTO, " +
							"STATO, TIPO_FILE, NOME_FILE, DOMINIO) " +
							" values (qpush_be.ECM_FILE_SEQ.nextval, '" +   
							dto.getECMType()+ "',  '" +   dto.getIdFileECM()+ "',  '" +    dto.getSorgente_Path()+ "',  '" +    
							dto.getDestinazione_Path()+ "',  '" +  dto.getNomeApp()+ "',  '" +   
							dto.getContainerType()+ "',  '" +   dto.getCanale()+ "', '" +    dto.getIdUtente()+ "',  '" +    
							dto.getTipoUtente()+ "', "+ dto.getDataInserimento().getTime() +", sysdate, '" + 
							dto.getStato()+ "',  '" +    dto.getTipo()+ "',  '" +    dto.getNomeFile() +"', '" + dto.getDominio() +"' )"   
							);

			if (result == 0) {				
				log.debug("Errore DAO InsertMedia: parametri non corretti ");
				TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));				
				throw e;							
			}	

		}catch (ApplicationException ex) 
		{
			log.error("Errore DAO  ApplicationException");
			TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));	
			throw e;			
		
		}  catch (RuntimeException e) 
		{				
			log.error("Errore DAO  RuntimeException");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;	
			
			//log.error("Errore DAO getJdbcTemplate() Exception");
			//throw e;			
		
		}  catch (Exception e) 
		{				
			log.error("Errore DAO  Exception ");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;							
			
		} 		
		
		log.debug("risultato DAO query result {} "+ result)	;		
		
		MediaResponse response = new MediaResponse();
		response.setResult(dto);
		
		log.debug("OUTPUT DAO {}", CommonUtils.bean2string(response.getResult()));
		return response;
	
	}		
	
	
	
	*/
	
	
	
	
	

	@Override
	public uploadMulticanaleResponse moveFile(uploadMulticanaleRequest request) throws AsiaException, Exception
	{
		uploadMulticanaleResponse response = new uploadMulticanaleResponse() ;
		
  
		
		
		
		
		return response;
	}	

	
	
	@Override
	public uploadMulticanaleResponse getFilenetToken(uploadMulticanaleRequest request) throws AsiaException, Exception
	{
		uploadMulticanaleResponse response = new uploadMulticanaleResponse() ;
		
  
		return response;
	}	
	
	
	@Override
	public uploadMulticanaleResponse getAzureToken(uploadMulticanaleRequest request) throws AsiaException, Exception
	{
		uploadMulticanaleResponse response = new uploadMulticanaleResponse() ;
		
  
		return response;
	}	
		
	
	@Override
	public uploadMulticanaleResponse deleteFileECM(uploadMulticanaleRequest request) throws AsiaException, Exception
	{
		uploadMulticanaleResponse response = new uploadMulticanaleResponse() ;
		
  
		return response;
	}	
	

	@Override
	public boolean updateMedia(String idFile, String ecmType, String Stato) throws AsiaException, Exception
	{
		try {
			int result = getJdbcTemplate()
					.update(" update qpush_be.ECM_FILE set STATO = ? where ECM_TYPE = ? and ID_FILE = ? ",
							new Object[] {Stato, idFile, idFile });
			if (result > 0) {
				return true;
			} else {
				return false;
			}		
			
		} catch (Exception e) {
			return false;
		}		
	}

	
	
}
