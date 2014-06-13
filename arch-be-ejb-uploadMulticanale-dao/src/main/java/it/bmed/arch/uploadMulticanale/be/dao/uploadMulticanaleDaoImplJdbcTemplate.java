package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.*;
import it.bmed.asia.api.*;
import it.bmed.asia.exception.*;
import it.bmed.asia.log.*;
import java.sql.SQLException;
import java.util.Date;
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
	public MediaResponse InsertMedia(MediaRequest parameters) throws ApplicationException, Exception {
			
		MediaDTO dto = parameters.getMediaDTO();		
		int result = 0;
	
		try {			
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
				log.debug("Errore DAO updateMedia: query fallita ");
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
	

   @Override
   public MediaResponse listMedia( MediaRequest request) throws ApplicationException, Exception {	
		
		MediaDTO dto = request.getMediaDTO();		
		MediaResponse response = new MediaResponse() ;
				
		String whereClause = "and ID_UTENTE = '"+dto.getIdUtente()+
				"' and  CANALE = '"+dto.getCanale()+
				"' and  TIPO_UTENTE = '"+dto.getTipoUtente()+
				"' ";
		
		StringBuilder queryStrBuilder = new StringBuilder().append("SELECT * FROM qpush_be.ECM_FILE WHERE 1= 1 " + whereClause);
		log.debug("QUERY CommandDataMove : {}", queryStrBuilder);
				
		try {
		
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<MediaDTO> ret = getJdbcTemplate().query( queryStrBuilder.toString(), new RowMapper() {
				@Override
				public Object mapRow(java.sql.ResultSet rs, int row) throws SQLException {
					// MAP YOUR FIELDS HERE
					MediaDTO te = new MediaDTO();					
					
					te.setCanale(rs.getString("CANALE"));
					te.setContainerType(rs.getString("CONTAINER_TYPE"));					
					Date dataInserimento = new Date(rs.getLong("DATA_INSERIMENTO"));					
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
			log.error("Errore DAO  RuntimeException");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;						
		
		}  catch (Exception e) 
		{				
			log.error("Errore DAO  Exception ");
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;						
			
		} 
	}	
	
	
	@Override
	public boolean updateMedia( UpdateMediaRequest request )throws ApplicationException, Exception {
		
		String IdFile = ""+request.getIdFile();
		String ECMType = ""+request.getECMType();
		String Stato = ""+request.getStato();
		String Destinazione_path = ""+request.getDestinazione_path();
		String idFileECM = ""+request.getIdFileECM();
		String Container_type = ""+request.getContainer_type();
		
		
		String campo1 = IdFile.isEmpty()? "" : " ID_FILE = '"+IdFile+"'";	
		
		String campo2 = ECMType.isEmpty()? "" : ", ECM_TYPE = '"+ECMType+"'";		
		String campo3 = Stato.isEmpty()? "" : ", STATO = '" + Stato+"'";
		String campo4 = Destinazione_path.isEmpty()? "" : ", DESTINAZIONE_PATH = '"+Destinazione_path+"'";
		String campo5 = idFileECM.isEmpty()? "" : ", ID_FILE_ECM =  '"+idFileECM+"'";
		String campo6 = Container_type.isEmpty()? "" : ", CONTAINER_TYPE = '"+Container_type+"'";
		
		
		int response = 0;
		
		if ( Stato.isEmpty() && ECMType.isEmpty() &&  Destinazione_path.isEmpty() &&  idFileECM.isEmpty() &&  Container_type.isEmpty() ) {
			return false;
		}
		
		String query = " UPDATE qpush_be.ECM_FILE SET DATA_AGGIORNAMENTO = SYSDATE "+campo2+campo3+campo4+campo5+campo6+" WHERE " +campo1+ " " ;  
		log.debug("Errore DAO query {} " + query );
		
	
		try {
			
			response = getJdbcTemplate().update(query);
			
			/*response = getJdbcTemplate().update(
		                " UPDATE qpush_be.ECM_FILE SET STATO = ?, ECM_TYPE = ?, DATA_AGGIORNAMENTO = SYSDATE, destinazione_path = ?, id_file_ecm = ?, container_type = ? WHERE ID_FILE = ? ", 
		                Stato, ECMType, Destinazione_path , idFileECM ,Container_type ,IdFile );
		   
			if (response == 0) {				
				log.debug("Errore DAO updateMedia:" );
				TechnicalException  e = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));				
				throw e;							
			}
			
		}catch (ApplicationException e) 
		{				
			log.error("Errore DAO  ApplicationException " );
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;	  */
		
		}  
		catch (RuntimeException e) 
		{				
			log.error("Errore DAO updateMedia:" );
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;							
		
		}  catch (Exception e) 
		{				
			log.error("Errore DAO updateMedia:" );
			TechnicalException  tec = new TechnicalException( UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;	
		} 		
				
		log.debug("OUTPUT result {} "+ response);		
		return response == 0 ? false : true;	
	}
	
	
}
