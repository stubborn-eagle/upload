package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.ECMSource;
import it.bmed.arch.uploadMulticanale.be.api.ECMState;
import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.api.CommonUtils;
import it.bmed.asia.exception.ApplicationException;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("UploadMulticanaleDaoJdbcTemplate")
public class UploadMulticanaleDaoImplJdbcTemplate implements UploadMulticanaleDaoJdbcTemplate, InitializingBean {

	Logger log = LoggerFactory.getLogger(UploadMulticanaleDaoImplJdbcTemplate.class);
	
	@Autowired
	DataSource dataSource;

	protected JdbcTemplate jdbcTemplate;

	protected JdbcTemplate getJdbcTemplate() {
		// log.debug("getJdbcTemplate!!!!!");
		if (jdbcTemplate == null) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("dataSource bean = " + dataSource.getClass().getName());
	}

	@Override
	public ECMResponse insertMedia(ECMRequest parameters) throws ApplicationException, Exception {
		ECMFile ecmFile = parameters.getEcmFile();
		int result = 0;

		try {

			result = getJdbcTemplate().update(
					"insert into qpush_be.ECM_FILE ("
							+ "COD_UPLD_FILE_INTERN, " 	// PK
							+ (ecmFile.getEcmType() == null ? "" : "COD_TIPO_ECM,  ")
							+ "COD_TIPO_PROVNZ_FILE, "	// Required 
							+ "COD_STATO_ECM, "			// Required
							+ "DES_APPLICNE, " 			// Required
							+ (ecmFile.getDestinationPath() == null ? "" : "DES_DEST_PATH, ")
							+ (ecmFile.getContainerType() == null ? "" : "DEN_CNTR, ") 
							+ "COD_TIPO_CANA, "			// Required
							+ (ecmFile.getUserType() == null ? "" : "COD_TIPO_UTE, ") 
							+ "DEN_FILE, "				// Required
							+ (ecmFile.getSourcePath() == null ? "" : "DES_SORG_PATH, ")
							+ (ecmFile.getIdFileECM() == null ? "" : "COD_UPLD_FILE_ECM, ")
							+ (ecmFile.getType() == null ? "" : "DEN_ESTNS_FILE, ") 
							+ (ecmFile.getNameApp() == null ? "" : "GSTD_M_NOM_ULT_MODF, ")
							+ "GSTD_X_USER, " 			// Required
							+ "GSTD_D_ULT_MODF_RECORD, "
							+ "GSTD_D_INS_RECORD, " 
							+ "GSTD_X_TIP_MODF, "
							+ "GSTD_F_ESIST) " 			// Required
							+ "values  "
							+ "( qpush_be.ECM_FILE_SEQ.nextval, "
							+ (ecmFile.getEcmType() == null ? "" : ecmFile.getEcmType().getValue())
							+ ",  "
							+ ecmFile.getSource().getValue()
							+ ",  "
							+ ecmFile.getState().getValue()
							+ ",  '"
							+ ecmFile.getNameApp()
							+ "',  '"
							+ (ecmFile.getDestinationPath() == null ? "" : ecmFile.getDestinationPath())
							+ "',  '"
							+ (ecmFile.getContainerType() == null ? "" :  ecmFile.getContainerType())
							+ "',  '"
							+ ecmFile.getChannel()
							+ "', '"
							+ (ecmFile.getUserType() == null ? "" : ecmFile.getUserType())
							+ "', '"
							+ ecmFile.getNameFile()
							+ "', '"
							+ (ecmFile.getSourcePath() == null ? "" : ecmFile.getSourcePath())
							+ "',  '"
							+ (ecmFile.getIdFileECM() == null ? "" : ecmFile.getIdFileECM())
							+ "',  '"
							+ (ecmFile.getType() == null ? "" : ecmFile.getType())
							+ "',  '"
							+ (ecmFile.getNameApp() == null ? "" : ecmFile.getNameApp())
							+ "',  '"
							+ ecmFile.getUserId()
							+ "', "
							+ " sysdate, "
							+ " sysdate, " + "'I', " + "'S' )");

			if (result == 0) {
				log.debug("Errore DAO updateMedia: query fallita ");
				TechnicalException e = new TechnicalException(
						UploadMulticanaleErrorCodeEnums
								.valueOf("TCH_SQL_ERROR"));
				throw e;
			}

		} catch (ApplicationException ex) {
			log.error("Errore DAO  ApplicationException");
			TechnicalException e = new TechnicalException(
					UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw e;

		} catch (RuntimeException e) {
			log.error("Errore DAO  RuntimeException");
			TechnicalException tec = new TechnicalException(
					UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;

		} catch (Exception e) {
			log.error("Errore DAO  Exception ");
			TechnicalException tec = new TechnicalException(
					UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;

		}

		log.debug("risultato DAO query result {} " + result);

		ECMResponse response = new ECMResponse();
		response.setResult(ecmFile);

		log.debug("OUTPUT DAO {}",
				CommonUtils.bean2string(response.getResult()));
		return response;

	}

	@Override
	public ECMResponse listMedia(ECMRequest request) throws ApplicationException, Exception {

		ECMFile ecmFile = request.getEcmFile();
		ECMResponse response = new ECMResponse();
		log.debug("listMedia params: " + request);
		// unici valori richiesti per la ricerca nonj obbligatori
		String and1 = ecmFile.getUserId().equals("") ? "" : "and GSTD_X_USER = '"
				+ ecmFile.getUserId() + "' ";
		String and2 = ecmFile.getChannel().equals("") ? "" : "and COD_TIPO_CANA = '"
				+ ecmFile.getChannel() + "' ";
		String and3 = ecmFile.getUserType().equals("") ? ""
				: "and  COD_TIPO_UTE = '" + ecmFile.getUserType() + "' ";
		String and4 = ecmFile.getIdFileECM().equals("") ? ""
				: "and COD_UPLD_FILE_ECM = '" + ecmFile.getIdFileECM() + "' ";
		String and5 = ecmFile.getEcmType() == null ? ""
				: "and  COD_TIPO_ECM = " + ecmFile.getEcmType().getValue() + " ";
		String and6 = ecmFile.getIdFile() == null || ecmFile.getIdFile() == 0 ? ""
				: "and  COD_UPLD_FILE_INTERN = " + ecmFile.getIdFile() + " ";

//		ecmFile.getNameApp()
		
		String whereClause = and1 + and2 + and3 + and4 + and5 + and6;

		StringBuilder queryStrBuilder = new StringBuilder()
				.append("SELECT * FROM qpush_be.ECM_FILE WHERE 1= 1 "
						+ whereClause);
		log.debug("QUERY CommandDataMove : {}", queryStrBuilder);

		try {

			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<ECMFile> ret = getJdbcTemplate().query(queryStrBuilder.toString(), new RowMapper() {
						@Override
						public Object mapRow(java.sql.ResultSet rs, int row) throws SQLException {
							// MAP YOUR FIELDS HERE							
							ECMFile te = new ECMFile();
							
							ECMSource ecmSource = null;
							switch (rs.getInt("COD_TIPO_PROVNZ_FILE")) {
							case 1:
								ecmSource = ECMSource.INTERNET_BANKING;
								break;
							case 2:
								ecmSource = ECMSource.PORTALE_DI_SEDE;
								break;
							case 3:
								ecmSource = ECMSource.RETE_DI_VENDITA;
								break;
							default:
								log.error("mapRow: illegal mapping for COD_TIPO_PROVNZ_FILE.");
								throw new AsiaException("illegal mapping");
							}
							
							ECMType ecmType = null;
							switch (rs.getInt("COD_TIPO_ECM")) {
							case 1:
								ecmType = ECMType.IBM_FILENET;
								break;
							case 2:
								ecmType = ECMType.ALFRESCO;
								break;
							case 3:
								ecmType = ECMType.AZURE;
								break;
							default:
								log.error("mapRow: illegal mapping for COD_TIPO_ECM.");
								throw new AsiaException("illegal mapping");
							}
							
							ECMState ecmState = null;
							switch (rs.getInt("COD_STATO_ECM")) {
							case 1:		
								ecmState = ECMState.INSERTED;
								break;
							case 2:
								ecmState = ECMState.PENDING;
								break;
							case 3:
								ecmState = ECMState.MOVED;
								break;
							case 4:
								ecmState = ECMState.DELETED;
								break;								
							default:
								log.error("mapRow: illegal mapping for COD_STATO_ECM.");
								throw new AsiaException("illegal mapping");
							}

							te.setIdFile(rs.getInt("COD_UPLD_FILE_INTERN"));
							te.setChannel(rs.getString("COD_TIPO_CANA"));
							te.setContainerType(rs.getString("DEN_CNTR"));
							te.setDestinationPath(rs.getString("DES_DEST_PATH"));
							te.setSource(ecmSource);
							te.setEcmType(ecmType);
							te.setIdFileECM(rs.getString("COD_UPLD_FILE_ECM"));
							te.setUserId(rs.getString("GSTD_X_USER"));
							te.setNameApp(rs.getString("DES_APPLICNE"));
							te.setNameFile(rs.getString("DEN_FILE"));
							te.setSourcePath(rs.getString("DES_SORG_PATH"));
							te.setState(ecmState);
							te.setType(rs.getString("DEN_ESTNS_FILE"));
							te.setUserType(rs.getString("COD_TIPO_UTE"));
							
							/*
							 * COD_UPLD_FILE_INTERN INTEGER NOT NULL , ID_FILE
							 * VARCHAR2(50) NOT NULL ENABLE, COD_TIPO_ECM
							 * INTEGER NULL , ECM_TYPE VARCHAR2(3) NOT NULL
							 * ENABLE, COD_TIPO_PROVNZ_FILE INTEGER NOT NULL ,
							 * DOMINIO VARCHAR2(50), COD_STATO_ECM INTEGER NOT
							 * NULL , STATO VARCHAR2(3), DES_APPLICNE
							 * VARCHAR2(100) NULL , NOME_APP VARCHAR2(100),
							 * DES_DEST_PATH VARCHAR2(200) NULL ,
							 * DESTINAZIONE_PATH VARCHAR2(500), DEN_CNTR
							 * VARCHAR2(50) NULL , CONTAINER_TYPE VARCHAR2(50),
							 * COD_TIPO_CANA VARCHAR2(15) NULL , CANALE
							 * VARCHAR2(15), COD_TIPO_UTE VARCHAR2(50) NULL ,
							 * TIPO_UTENTE VARCHAR2(15), DEN_FILE VARCHAR2(50)
							 * NULL , NOME_FILE VARCHAR2(50), DES_SORG_PATH
							 * VARCHAR2(200) NULL , SORGENTE_PATH VARCHAR2(500),
							 * COD_UPLD_FILE_ECM VARCHAR2(500) NULL ,
							 * ID_FILE_ECM VARCHAR2(200), DEN_ESTNS_FILE
							 * VARCHAR2(5) NULL , TIPO_FILE VARCHAR2(25),
							 * GSTD_M_NOM_ULT_MODF CHAR(16) NULL, GSTD_X_USER
							 * CHAR(16) NULL, GSTD_D_ULT_MODF_RECORD DATE ,
							 * DATA_AGGIORNAMENTO DATE DEFAULT sysdate,
							 * GSTD_D_INS_RECORD DATE DEFAULT sysdate NULL,
							 * DATA_INSERIMENTO LONG, GSTD_X_TIP_MODF CHAR(1)
							 * NULL, GSTD_F_ESIST CHAR(1) DEFAULT 'S' NOT NULL
							 * CHECK (GSTD_F_ESIST IN ('S','N')) ) ;
							 */

							return te;
						}
					});
			if (ret != null && !ret.isEmpty() && ret.size() == 1) {
				response.setResult(ret.get(0));
			} else {
				if(ret != null && !ret.isEmpty() && ret.size() > 1) {
					response.setListResults(ret);
				}
			}			
			return response;

		} catch (RuntimeException e) {
			log.error("Errore DAO  RuntimeException");
			TechnicalException tec = new TechnicalException(
					UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;

		} catch (Exception e) {
			log.error("Errore DAO  Exception ");
			TechnicalException tec = new TechnicalException(
					UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;

		}
	}

	@Override
	public boolean updateMedia(UpdateECMRequest request)
			throws ApplicationException, Exception {
		
		// Check object fields
		if (request.getEcmType() == null) {
			
		} 		
		String Destinazione_path = "" + request.getDestinationPath();
		String idFileECM = "" + request.getIdFileECM();
		String Container_type = "" + request.getContainerType();
		String NomeApp = "" + request.getNameApp();

		String campo1 = " COD_UPLD_FILE_INTERN = " + request.getIdFile() + "";
		String campo2 = request.getEcmType() == null
				|| request.getEcmType() == null ? "" : ", COD_TIPO_ECM = "
				+ request.getEcmType() + "";
		String campo3 = request.getState() == null || request.getState().getValue() == 0 ? ""
				: ", COD_STATO_ECM = " + request.getState() + "";

		String campo4 = Destinazione_path.isEmpty() ? ""
				: ", DES_DEST_PATH = '" + Destinazione_path + "'";
		String campo5 = idFileECM.isEmpty() ? "" : ", COD_UPLD_FILE_ECM =  '"
				+ idFileECM + "'";
		String campo6 = Container_type.isEmpty() ? "" : ", DEN_CNTR = '"
				+ Container_type + "'";
		String campo7 = NomeApp.isEmpty() ? "" : ", GSTD_M_NOM_ULT_MODF = '"
				+ NomeApp + "'";

		int response = 0;

		String query = " UPDATE qpush_be.ECM_FILE SET GSTD_D_ULT_MODF_RECORD = SYSDATE, GSTD_D_INS_RECORD  = SYSDATE "
				+ campo2
				+ campo3
				+ campo4
				+ campo5
				+ campo6
				+ campo7
				+ " WHERE " + campo1 + " ";
		log.debug(" DAO query {} " + query);

		try {

			response = getJdbcTemplate().update(query);

		} catch (RuntimeException e) {
			log.error("Errore DAO updateMedia:");
			TechnicalException tec = new TechnicalException(
					UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;

		} catch (Exception e) {
			log.error("Errore DAO updateMedia:");
			TechnicalException tec = new TechnicalException(
					UploadMulticanaleErrorCodeEnums.valueOf("TCH_SQL_ERROR"));
			throw tec;
		}

		log.debug("OUTPUT result {} " + response);
		return response == 0 ? false : true;
	}

}
