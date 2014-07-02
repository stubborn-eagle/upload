package it.bmed.arch.uploadMulticanale.be.service;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.ECMState;
import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.arch.uploadMulticanale.be.api.MediaDTO;
import it.bmed.arch.uploadMulticanale.be.api.MediaResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.dao.UploadMulticanaleDaoJdbcTemplate;
import it.bmed.asia.exception.ApplicationException;
import it.bmed.asia.exception.IErrorCode;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UploadMulticanaleService")
public class UploadMulticanaleServiceImpl implements UploadMulticanaleService,
		InitializingBean {
	Logger log = LoggerFactory.getLogger(UploadMulticanaleServiceImpl.class);

	@Autowired
	UploadMulticanaleDaoJdbcTemplate uploadMulticanaleDaoJdbcTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("uploadMulticanaleDaoJdbcTemplate: " + uploadMulticanaleDaoJdbcTemplate.getClass().getName());
		if (uploadMulticanaleDaoJdbcTemplate == null)
			throw new Exception(
					"ERROR: uploadMulticanaleDaoJdbcTemplate not injected");
	}

	@Override
	public ECMResponse insertMedia(ECMRequest request)
			throws TechnicalException, Exception {
		try {
//			MediaDTO dto = request.getMediaDTO();
			ECMFile ecmFile = request.getEcmFile(); 
			// stato e dominio per il db devono essere not null
			// default
			if(ecmFile.getState() == null /*|| ecmFile.getState() == 0*/) {

				ecmFile.setState(ECMState.INSERTED);
			}

			// default perche obbligatorio sul db ma non obbligatorio in input
			if (ecmFile.getEcmType() == null /*|| ecmFile.getECMType() == 0*/) {
				ecmFile.setEcmType(ECMType.IBM_FILENET);
			}

			// campi non obbligatori lasciati null
			// controllo obbligatorieta dei campiù

			if (ecmFile == null || ecmFile.getChannel().isEmpty()
					|| ecmFile.getUserId().isEmpty()
					|| ecmFile.getNameApp().isEmpty()
					|| ecmFile.getNameFile().isEmpty()
					|| ecmFile.getSourcePath().isEmpty()
					|| ecmFile.getUserType().isEmpty()
					|| ecmFile.getSource() == null
					|| ecmFile.getType().isEmpty()) {
				log.debug("Errore Servizio: parametri non corretti ");

				IErrorCode er = UploadMulticanaleErrorCodeEnums
						.valueOf("TCH_GENERIC_ERROR");
				TechnicalException tec = new TechnicalException(er);

				throw tec;
			}

			// controllo lunghezza del campo di input stato
			if (ecmFile.getChannel().length() > 15
					|| ecmFile.getContainerType().length() > 20
					|| ecmFile.getDestinationPath().length() > 200
					|| ecmFile.getIdFileECM().length() > 500
					|| ecmFile.getUserId().length() > 16
					|| ecmFile.getNameApp().length() > 100
					|| ecmFile.getNameFile().length() > 50
					|| ecmFile.getSourcePath().length() > 500
					|| ecmFile.getType().length() > 5
					|| ecmFile.getUserType().length() > 50) {
				log.debug("Errore Servizio: parametri non corretti qualche campo troppo lungo");
				IErrorCode er = UploadMulticanaleErrorCodeEnums
						.valueOf("TCH_GENERIC_ERROR");
				TechnicalException tec = new TechnicalException(er);

				throw tec;

			}

			/*
			 * 
			 * COD_UPLD_FILE_INTERN INTEGER NOT NULL , ID_FILE VARCHAR2(50) NOT
			 * NULL ENABLE, COD_TIPO_ECM INTEGER NULL , ECM_TYPE VARCHAR2(3) NOT
			 * NULL ENABLE, COD_TIPO_PROVNZ_FILE INTEGER NOT NULL , DOMINIO
			 * VARCHAR2(50), COD_STATO_ECM INTEGER NOT NULL , STATO VARCHAR2(3),
			 * 
			 * DES_APPLICNE VARCHAR2(100) NULL , NOME_APP VARCHAR2(100),
			 * DES_DEST_PATH VARCHAR2(200) NULL , DESTINAZIONE_PATH
			 * VARCHAR2(500), DEN_CNTR VARCHAR2(50) NULL , CONTAINER_TYPE
			 * VARCHAR2(50), COD_TIPO_CANA VARCHAR2(15) NULL , CANALE
			 * VARCHAR2(15), COD_TIPO_UTE VARCHAR2(50) NULL , TIPO_UTENTE
			 * VARCHAR2(15), DEN_FILE VARCHAR2(50) NULL , NOME_FILE
			 * VARCHAR2(50), DES_SORG_PATH VARCHAR2(200) NULL , SORGENTE_PATH
			 * VARCHAR2(500), COD_UPLD_FILE_ECM VARCHAR2(500) NULL , ID_FILE_ECM
			 * VARCHAR2(200), DEN_ESTNS_FILE VARCHAR2(5) NULL , TIPO_FILE
			 * VARCHAR2(25), GSTD_M_NOM_ULT_MODF CHAR(16) NULL, GSTD_X_USER
			 * CHAR(16) NULL, GSTD_D_ULT_MODF_RECORD DATE , DATA_AGGIORNAMENTO
			 * DATE DEFAULT sysdate, GSTD_D_INS_RECORD DATE DEFAULT sysdate
			 * NULL, DATA_INSERIMENTO LONG, GSTD_X_TIP_MODF CHAR(1) NULL,
			 * GSTD_F_ESIST CHAR(1) DEFAULT 'S' NOT NULL CHECK (GSTD_F_ESIST IN
			 * ('S','N')) ) ;
			 */

			log.debug(" Servizio: parametri  corretti ");
			ECMResponse response = new ECMResponse();
			response = uploadMulticanaleDaoJdbcTemplate.insertMedia(request);
			return response;
		} catch (ApplicationException e) {
			log.error("Errore Servizio InsertMedia getErrorCode {}_getErrorDescription {}  "
					+ e.getErrorCode() + "_" + e.getErrorDescription());
			throw e;

		} catch (RuntimeException e) {
			log.error("Errore Servizio InsertMedia ");
			throw e;
		}

	}

	@Override
	public ECMResponse listMedia(ECMRequest request)
			throws TechnicalException, Exception {
		try {
			ECMFile ecmFile = request.getEcmFile();

			/*
			 * tolgo obbligatorieta per tutti
			 * 
			 * if (dto == null || dto.getCanale().isEmpty() ||
			 * dto.getIdUtente().isEmpty() || dto.getTipoUtente().isEmpty() ) {
			 * log.debug("Errore InsertMedia: parametri non corretti ");
			 * 
			 * IErrorCode er =
			 * UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			 * TechnicalException tec = new TechnicalException( er ); throw tec;
			 * }
			 */

			// controllo lunghezza del campo di input stato

			if (ecmFile.getChannel().length() > 15
					|| ecmFile.getUserId().length() > 11
					|| ecmFile.getUserType().length() > 15
					|| ecmFile.getIdFileECM().length() > 15
					|| ecmFile.getIdFileECM().length() > 15) {
				log.debug("Errore InsertMedia: parametri non corretti qualche campo troppo lungo");
				IErrorCode er = UploadMulticanaleErrorCodeEnums
						.valueOf("TCH_GENERIC_ERROR");
				TechnicalException tec = new TechnicalException(er);

				throw tec;
			}

			ECMResponse response = new ECMResponse();
			response = uploadMulticanaleDaoJdbcTemplate.listMedia(request);

			return response;

		} catch (ApplicationException e) {
			log.error("Errore  InsertMedia getErrorCode {}_getErrorDescription {}  "
					+ e.getErrorCode() + "_" + e.getErrorDescription());
			throw e;

		} catch (RuntimeException e) {
			log.error("Errore InsertMedia in Servizio");
			throw e;
		}

	}

	@Override
	public boolean updateMedia(UpdateECMRequest request) throws SystemFault,
			Exception {
		try {
			boolean res;

			String Destinazione_path = request.getDestinationPath();
			String idFileECM = request.getIdFileECM();
			String Container_type = request.getContainerType();
			String nomApp = request.getNameApp();

			// controllo campi obbligatori
			if ((request.getIdFile() == null || request.getIdFile() == 0)
					&& (request.getState() == null)
					&& request.getNameApp().isEmpty()) {
				log.debug("Errore updateMedia: IdFile obbligatorio ");

				IErrorCode er = UploadMulticanaleErrorCodeEnums
						.valueOf("TCH_GENERIC_ERROR");
				TechnicalException tec = new TechnicalException(er);

				throw tec;
			}

			// controllo lunghezza del campo di input stato
			if (Container_type.length() > 20
					|| Destinazione_path.length() > 200
					|| idFileECM.length() > 500 || nomApp.length() > 100) {

				log.debug("Errore updateMedia: campi non corretti per dimensione ");
				// Il valore della correttezza del valore va fatta a livello
				// superiore
				IErrorCode er = UploadMulticanaleErrorCodeEnums
						.valueOf("TCH_GENERIC_ERROR");
				TechnicalException tec = new TechnicalException(er);
				throw tec;
			}

			res = uploadMulticanaleDaoJdbcTemplate.updateMedia(request);
			return res;

		} catch (ApplicationException e) {

			log.error("Errore updateMedia:    ApplicationException ");
			throw e;

		} catch (RuntimeException e) {
			log.error("Errore updateMedia in Servizio");
			log.error("Errore getJdbcTemplate() RuntimeException");
			throw e;
		}

	}

}
