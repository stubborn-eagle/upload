package it.bmed.arch.uploadMulticanale.be.service.onboarding;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMParam;
import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.ECMSource;
import it.bmed.arch.uploadMulticanale.be.api.ECMState;
import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.arch.uploadMulticanale.be.api.FileProperty;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentsRequest;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentsResponse;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.FilenetDossierMoveResult;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetRequest;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetResponse;
import it.bmed.arch.uploadMulticanale.be.dao.UploadMulticanaleDaoJdbcTemplate;
import it.bmed.arch.uploadMulticanale.be.service.UploadMulticanaleService;
import it.bmed.arch.uploadMulticanale.be.service.cmis.ECMService;
import it.bmed.arch.uploadMulticanale.be.service.cmis.Util;
import it.bmed.arch.uploadMulticanale.be.service.nas.NASService;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocuments;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.EnrollmentService;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.OnboardingService;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientFactory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.jws.HandlerChain;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnBoardingServiceImpl implements InitializingBean, OnBoardingServiceInterface {
	
	private static final Logger logger = LoggerFactory.getLogger(OnBoardingServiceImpl.class);
	
	@Autowired
	private UploadMulticanaleService uploadMulticanaleService;
	
	@Autowired
	private UploadMulticanaleDaoJdbcTemplate uploadMulticanaleDaoJdbcTemplate;
	
	@Autowired
	private NASService nasService;
	
	@Autowired
	private ECMService ecmService;
	
	@Autowired
	private OnBoardingMapper mapper;
	
	/* PARAMETRI IN CONFIGURAZIONE - WEB.XML */
	private String onBoardingServiceIstituto;
	private String onBoardingServiceMatricola; 
	private String onBoardingServiceRuolo;
	private String onBoardingServiceFiliale; 
	private String onBoardingServiceUserId;
	private String onBoardingServiceChannel; 
	private String onBoardingServiceContainer;
	private String onBoardingServiceCompanyId;
	private String onBoardingServiceURL = null;
	private Integer requestTimeout = null;
	private Integer connectTimeout = null;

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("OnBoardingServiceImpl initialized.", "");
	}

	@HandlerChain(file = "handler-chain-be.xml")
	public static class OnboardingServiceFactory extends EnrollmentService implements AsiaWsClientFactory<OnboardingService> {
		public OnboardingServiceFactory() {
			super();
		}
		@Override
		public QName getServiceName() {
			return this.getServiceName();
		}
		@Override
		public OnboardingService getPort() {
			try{
				return this.getOnboardingServicePort();
			} catch (Exception e){
				throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "On Boarding Services error", e);
			}
			
		}
	}

	
	public <SERVICE,FACT extends AsiaWsClientFactory<SERVICE>> SERVICE getWsClient(Class<FACT> factoryClass)  throws Exception {
		
		FACT realService = factoryClass.newInstance();
		SERVICE port = (SERVICE) realService.getPort();
		BindingProvider bp = (BindingProvider) port;
		
		/* BASIC AUTHENTICATION - START */
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "mediolanum01");
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "m3d10lanum01");
		/* BASIC AUTHENTICATION - END */
		
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, onBoardingServiceURL);
		bp.getRequestContext().put(WS_REQUEST_TIMEOUT, requestTimeout);  //default: 15000
		bp.getRequestContext().put(WS_CONNECT_TIMEOUT, connectTimeout);  //default: 5000
		return port;
	}
	
	/** IMPLEMENTAZIONE METODI SERVIZIO ESTERNO */
	@Override
	public MoveDossierIntoFilenetResponse moveDossierIntoFilenet(MoveDossierIntoFilenetRequest request){
		try {
			List<FilenetDossierMoveResult> filenetResults = new ArrayList<FilenetDossierMoveResult>();
			OnboardingService service = (OnboardingService) getWsClient(OnboardingServiceFactory.class);
			/* BASIC AUTHENTICATION - START */
			BindingProvider prov = (BindingProvider) service;
			prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "mediolanum01");
			prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "m3d10lanum01");
			/* BASIC AUTHENTICATION - END */
			it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.GetDossier wsRequest = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.GetDossier();
			wsRequest.setCompanyId(onBoardingServiceCompanyId);
			wsRequest.setDossierId(request.getDossierId());
			it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.GetDossierResponse wsResponse = service.getDossier(wsRequest);
			List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.DocumentInfo> listaDocumenti = wsResponse.getDossierInfo().getDocuments().getDocuments();
			/* per ogni documento ottenuto nel dossier */
			for (it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.DocumentInfo documentInfo : listaDocumenti){
				ECMParam ecmParam = createEcmParam(onBoardingServiceIstituto, onBoardingServiceMatricola, onBoardingServiceRuolo, onBoardingServiceFiliale);
				ECMFile ecmFile = createEcmFile(documentInfo.getContent().getMimeType(), documentInfo.getId(), onBoardingServiceUserId, onBoardingServiceChannel, onBoardingServiceContainer);
				// ESECUZIONE SALVATAGGIO SUL DB
				ECMResponse dbResponse = uploadMulticanaleService.insertMedia(createEcmRequest(ecmFile));
				Integer idFile = dbResponse.getResult().getIdFile();
				// IL CONTENUTO DELL'ATTACHMENT DA CODIFICARE IN BASE 64
				ByteArrayOutputStream buffOS= new ByteArrayOutputStream();
				documentInfo.getContent().getData().writeTo(buffOS);
				byte[] byteStream = buffOS.toByteArray();
				ecmFile.setIdFile(idFile);
				// INSERIMENTO SU FILENET
				String filenetId = ecmService.createFileWithMetadata(byteStream, ecmFile, ecmParam);
				FilenetDossierMoveResult resRecord = new FilenetDossierMoveResult();
				resRecord.setDossierFileId(documentInfo.getId());
				resRecord.setDossierId(request.getDossierId());
				resRecord.setFilenetId(filenetId);
				filenetResults.add(resRecord);
			}
			MoveDossierIntoFilenetResponse response = new MoveDossierIntoFilenetResponse();
			response.setFilenetResults(filenetResults);
			return response;
		} catch (Exception e) {
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "On Boarding Services error", e);
		}
	}
	
	@Override
	public AddDocumentsResponse addDocuments(AddDocumentsRequest request){
		try {
			ECMRequest ecmRequest = new ECMRequest();
			ECMFile ecmFile = new ECMFile();
			ecmFile.setIdFile(request.getEcmFileId());
			ecmRequest.setEcmFile(ecmFile);
			ECMResponse ecmResponse = uploadMulticanaleService.listMedia(ecmRequest);
			String nameFile = ecmResponse.getResult().getNameFile() + "." + ecmResponse.getResult().getType().toLowerCase();
			byte[] buffer = nasService.loadFile(ecmResponse.getResult().getSourcePath(), nameFile, ecmResponse.getResult().getSource());
			//String fileContent = Util.encodeFileToBase64Binary(buffer);
			DataSource fileContent = new ByteArrayDataSource(buffer, "application/octet-stream");
			OnboardingService service = (OnboardingService) getWsClient(OnboardingServiceFactory.class);
			
			AddDocuments parameters = new AddDocuments();
			parameters.setCompanyId(request.getCompanyId());
			parameters.setDossierId(request.getDossierId());
			parameters.setDocuments(mapper.mapECMDocumentForWSRequest(request.getDocument(), fileContent));
			/* it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocumentsResponse wsResponse = */
			service.addDocuments(parameters);
		} catch (Exception e) {
			logger.error("OnBoardingServiceImpl addDocuments ", e);
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "On Boarding Services error", e);
		}
		return new AddDocumentsResponse();
	}
	
	
	
	/* nuovo metodo per l'estrazione di un file a partire dal id del sistema multicanale */
	@Override
	public String extractFileContent(Integer multicanaleReferenceId){
		try {
			ECMResponse r1 = uploadMulticanaleDaoJdbcTemplate.selectMedia(multicanaleReferenceId);
			String content = lookupFileToConvert(r1);
			return content;
		} catch (TechnicalException e) {
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "On Boarding Services error", e);
		} catch (Exception e) {
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "On Boarding Services error", e);
		}
	}
	
	private String lookupFileToConvert(ECMResponse ecmResponse) {
		//log.debug("lookupFileToConvert params: " + ecmResponse);
		// File to looking for
		String encodedFile = null;
		
		if (ecmResponse != null && ecmResponse.getResult() != null) {
			// File found
			if (ecmResponse.getResult().getDestinationPath() != null && ecmResponse.getResult().getDestinationPath().length() > 0) {
				// the file is on the ECM
				try {
					ECMType ecmType = ecmResponse.getResult().getEcmType();
					String ecmFileId = ecmResponse.getResult().getIdFileECM();
					encodedFile = ecmService.downloadFile(ecmType, ecmFileId);
				} catch (Exception e) {
					//log.error("lookupFileToConvert: " + e.getMessage());
					throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), e.getMessage());
				}
			} else {
				// the file is on the NAS
				try {
					String path = ecmResponse.getResult().getSourcePath();
					String filename = ecmResponse.getResult().getNameFile() + "." + ecmResponse.getResult().getType();
					ECMSource source = ecmResponse.getResult().getSource();
					encodedFile = Util.encodeFileToBase64Binary(nasService.loadFile(path, filename, source));
				} catch (Exception e) {
					//log.error("lookupFileToConvert: " + e.getMessage());
					throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), e.getMessage());
				}
			}		 	
		} else {
			// File not found
			//log.error("lookupFileToConvert: file not found.");
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST.getErrorCode(), "convertToPDF error: file not found.");
		}
		//log.debug("lookupFileToConvert returns: " + encodedFile);
		return encodedFile;
	}
	
	
	/**
	 * @return the onBoardingServiceURL
	 */
	public String getOnBoardingServiceURL() {
		return onBoardingServiceURL;
	}

	/**
	 * @param onBoardingServiceURL the onBoardingServiceURL to set
	 */
	public void setOnBoardingServiceURL(String onBoardingServiceURL) {
		this.onBoardingServiceURL = onBoardingServiceURL;
	}

	/**
	 * @return the requestTimeout
	 */
	public Integer getRequestTimeout() {
		return requestTimeout;
	}

	/**
	 * @param requestTimeout the requestTimeout to set
	 */
	public void setRequestTimeout(Integer requestTimeout) {
		this.requestTimeout = requestTimeout;
	}

	/**
	 * @return the connectTimeout
	 */
	public Integer getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * @param connectTimeout the connectTimeout to set
	 */
	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	
	
	private ECMRequest createEcmRequest(ECMFile ecmFile){
		ECMRequest request = new ECMRequest();
		request.setEcmFile(ecmFile);
		return request;
	}
	
	private ECMFile createEcmFile(String mimeType, String documentId, String userId, String channel, String container){
		ECMFile ecmFile = new ECMFile();
		ecmFile.setNameApp(userId);
		ecmFile.setUserId(userId);
		ecmFile.setChannel(channel);
		ecmFile.setContainerType(container);
		ecmFile.setSource(ECMSource.INFOCERT_DOSSIER);
		ecmFile.setNameFile(documentId);
		ecmFile.setType(mimeType);
		ecmFile.setState(ECMState.INSERTED);
		return ecmFile;
	}
	
	private ECMParam createEcmParam(String istituto, String matricola, String ruolo, String filiale){
		ECMParam ecmParam = new ECMParam();
		ecmParam.setEcmType(ECMType.IBM_FILENET);
		ecmParam.setDestinationPath("-");
		
		ArrayList<FileProperty> properties  = new ArrayList<FileProperty>();
		
		if (istituto != null){
			FileProperty fp1 = new FileProperty();
			fp1.setName("Istituto");
			fp1.setValue(istituto);
			properties.add(fp1);
		}
		if (matricola != null){
			FileProperty fp2 = new FileProperty();
			fp2.setName("Matricola");
			fp2.setValue(matricola);
			properties.add(fp2);
		}
		if (ruolo != null){
			FileProperty fp3 = new FileProperty();
			fp3.setName("Ruolo");
			fp3.setValue(ruolo);
			properties.add(fp3);
		}
		if (filiale != null){
			FileProperty fp4 = new FileProperty();
			fp4.setName("Filiale");
			fp4.setValue(filiale);
			properties.add(fp4);
		}

		ecmParam.setProperty(properties);

		return ecmParam;
	}

	/**
	 * @param uploadMulticanaleService the uploadMulticanaleService to set
	 */
	public void setUploadMulticanaleService(UploadMulticanaleService uploadMulticanaleService) {
		this.uploadMulticanaleService = uploadMulticanaleService;
	}

	/**
	 * @param onBoardingServiceIstituto the onBoardingServiceIstituto to set
	 */
	public void setOnBoardingServiceIstituto(String onBoardingServiceIstituto) {
		this.onBoardingServiceIstituto = onBoardingServiceIstituto;
	}

	/**
	 * @param onBoardingServiceMatricola the onBoardingServiceMatricola to set
	 */
	public void setOnBoardingServiceMatricola(String onBoardingServiceMatricola) {
		this.onBoardingServiceMatricola = onBoardingServiceMatricola;
	}

	/**
	 * @param onBoardingServiceRuolo the onBoardingServiceRuolo to set
	 */
	public void setOnBoardingServiceRuolo(String onBoardingServiceRuolo) {
		this.onBoardingServiceRuolo = onBoardingServiceRuolo;
	}

	/**
	 * @param onBoardingServiceFiliale the onBoardingServiceFiliale to set
	 */
	public void setOnBoardingServiceFiliale(String onBoardingServiceFiliale) {
		this.onBoardingServiceFiliale = onBoardingServiceFiliale;
	}

	/**
	 * @param onBoardingServiceUserId the onBoardingServiceUserId to set
	 */
	public void setOnBoardingServiceUserId(String onBoardingServiceUserId) {
		this.onBoardingServiceUserId = onBoardingServiceUserId;
	}

	/**
	 * @param onBoardingServiceChannel the onBoardingServiceChannel to set
	 */
	public void setOnBoardingServiceChannel(String onBoardingServiceChannel) {
		this.onBoardingServiceChannel = onBoardingServiceChannel;
	}

	/**
	 * @param onBoardingServiceContainer the onBoardingServiceContainer to set
	 */
	public void setOnBoardingServiceContainer(String onBoardingServiceContainer) {
		this.onBoardingServiceContainer = onBoardingServiceContainer;
	}

	/**
	 * @param onBoardingServiceCompanyId the onBoardingServiceCompanyId to set
	 */
	public void setOnBoardingServiceCompanyId(String onBoardingServiceCompanyId) {
		this.onBoardingServiceCompanyId = onBoardingServiceCompanyId;
	}
}
