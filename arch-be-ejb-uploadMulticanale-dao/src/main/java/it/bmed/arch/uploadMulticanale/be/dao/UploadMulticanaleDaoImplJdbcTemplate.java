package it.bmed.arch.uploadMulticanale.be.dao;

import it.bmed.arch.uploadMulticanale.be.api.MediaDTO;
import it.bmed.arch.uploadMulticanale.be.api.MediaRequest;
import it.bmed.arch.uploadMulticanale.be.api.MediaResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateMediaRequest;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.api.CommonUtils;
import it.bmed.asia.exception.ApplicationException;
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
public class UploadMulticanaleDaoImplJdbcTemplate implements
		UploadMulticanaleDaoJdbcTemplate, InitializingBean {

	Logger log = LoggerFactory
			.getLogger(UploadMulticanaleDaoImplJdbcTemplate.class);
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
	}

	@Override
	public MediaResponse insertMedia(MediaRequest parameters)
			throws ApplicationException, Exception {

		MediaDTO dto = parameters.getMediaDTO();
		int result = 0;

		try {

			result = getJdbcTemplate().update(
					"insert into qpush_be.ECM_FILE ("
							+ "COD_UPLD_FILE_INTERN, " + "COD_TIPO_ECM,  "
							+ "COD_TIPO_PROVNZ_FILE, " + "COD_STATO_ECM, "
							+ "DES_APPLICNE, " + "DES_DEST_PATH, "
							+ "DEN_CNTR, " + "COD_TIPO_CANA, "
							+ "COD_TIPO_UTE, " + "DEN_FILE, "
							+ "DES_SORG_PATH, " + "COD_UPLD_FILE_ECM, "
							+ "DEN_ESTNS_FILE, " + "GSTD_M_NOM_ULT_MODF, "
							+ "GSTD_X_USER, " + "GSTD_D_ULT_MODF_RECORD, "
							+ "GSTD_D_INS_RECORD, " + "GSTD_X_TIP_MODF, "
							+ "GSTD_F_ESIST) " + "values  "
							+ "( qpush_be.ECM_FILE_SEQ.nextval, "
							+ dto.getECMType()
							+ ",  "
							+ dto.getDominio()
							+ ",  "
							+ dto.getStato()
							+ ",  '"
							+ dto.getNomeApp()
							+ "',  '"
							+ // controllare
							dto.getDestinazione_Path()
							+ "',  '"
							+ dto.getContainerType()
							+ "',  '"
							+ dto.getCanale()
							+ "', '"
							+ dto.getTipoUtente()
							+ "', '"
							+ dto.getNomeFile()
							+ "', '"
							+ dto.getSorgente_Path()
							+ "',  '"
							+ dto.getIdFileECM()
							+ "',  '"
							+ dto.getTipo()
							+ "',  '"
							+ dto.getNomeApp()
							+ "',  '"
							+ dto.getIdUtente()
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

		MediaResponse response = new MediaResponse();
		response.setResult(dto);

		log.debug("OUTPUT DAO {}",
				CommonUtils.bean2string(response.getResult()));
		return response;

	}

	@Override
	public MediaResponse listMedia(MediaRequest request)
			throws ApplicationException, Exception {

		MediaDTO dto = request.getMediaDTO();
		MediaResponse response = new MediaResponse();

		// unici valori richiesti per la ricerca nonj obbligatori
		String and1 = dto.getIdUtente().equals("") ? "" : "and GSTD_X_USER = '"
				+ dto.getIdUtente() + "' ";
		String and2 = dto.getCanale().equals("") ? "" : "and COD_TIPO_CANA = '"
				+ dto.getCanale() + "' ";
		String and3 = dto.getTipoUtente().equals("") ? ""
				: "and  COD_TIPO_UTE = '" + dto.getTipoUtente() + "' ";
		String and4 = dto.getIdFileECM().equals("") ? ""
				: "and COD_UPLD_FILE_ECM = '" + dto.getIdFileECM() + "' ";
		String and5 = dto.getECMType() == null || dto.getECMType() == 0 ? ""
				: "and  COD_TIPO_ECM = " + dto.getECMType() + " ";
		String and6 = dto.getIdFile() == null || dto.getIdFile() == 0 ? ""
				: "and  COD_UPLD_FILE_INTERN = " + dto.getIdFile() + " ";

		String whereClause = and1 + and2 + and3 + and4 + and5 + and6;

		StringBuilder queryStrBuilder = new StringBuilder()
				.append("SELECT * FROM qpush_be.ECM_FILE WHERE 1= 1 "
						+ whereClause);
		log.debug("QUERY CommandDataMove : {}", queryStrBuilder);

		try {

			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<MediaDTO> ret = getJdbcTemplate().query(
					queryStrBuilder.toString(), new RowMapper() {
						@Override
						public Object mapRow(java.sql.ResultSet rs, int row)
								throws SQLException {
							// MAP YOUR FIELDS HERE
							MediaDTO te = new MediaDTO();

							te.setIdFile(rs.getInt("COD_UPLD_FILE_INTERN"));
							te.setCanale(rs.getString("COD_TIPO_CANA"));
							te.setContainerType(rs.getString("DEN_CNTR"));
							te.setDestinazione_Path(rs
									.getString("DES_DEST_PATH"));
							te.setDominio(rs.getInt("COD_TIPO_PROVNZ_FILE"));
							te.setECMType(rs.getInt("COD_TIPO_ECM"));
							te.setIdFileECM(rs.getString("COD_UPLD_FILE_ECM"));
							te.setIdUtente(rs.getString("GSTD_X_USER"));
							te.setNomeApp(rs.getString("DES_APPLICNE"));
							te.setNomeFile(rs.getString("DEN_FILE"));
							te.setSorgente_Path(rs.getString("DES_SORG_PATH"));
							te.setStato(rs.getInt("COD_STATO_ECM"));
							te.setTipo(rs.getString("DEN_ESTNS_FILE"));
							te.setTipoUtente(rs.getString("COD_TIPO_UTE"));

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

			response.setListResults(ret);
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
	public boolean updateMedia(UpdateMediaRequest request)
			throws ApplicationException, Exception {

		String Destinazione_path = "" + request.getDestinazione_path();
		String idFileECM = "" + request.getIdFileECM();
		String Container_type = "" + request.getContainer_type();
		String NomeApp = "" + request.getNameApp();

		String campo1 = " COD_UPLD_FILE_INTERN = " + request.getIdFile() + "";
		String campo2 = request.getECMType() == null
				|| request.getECMType() == 0 ? "" : ", COD_TIPO_ECM = "
				+ request.getECMType() + "";
		String campo3 = request.getStato() == null || request.getStato() == 0 ? ""
				: ", COD_STATO_ECM = " + request.getStato() + "";

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
