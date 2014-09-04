package it.bmed.arch.uploadMulticanale.be.ejbimpl;

import it.bmed.arch.uploadMulticanale.be.api.APIParams;
import it.bmed.arch.uploadMulticanale.be.api.AzureDTO;
import it.bmed.arch.uploadMulticanale.be.api.AzureRequest;
import it.bmed.arch.uploadMulticanale.be.api.AzureResponse;
import it.bmed.arch.uploadMulticanale.be.api.ECMConvertRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.ECMSource;
import it.bmed.arch.uploadMulticanale.be.api.ECMState;
import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.arch.uploadMulticanale.be.api.MoveDTO;
import it.bmed.arch.uploadMulticanale.be.api.MoveRequest;
import it.bmed.arch.uploadMulticanale.be.api.MoveResponse;
import it.bmed.arch.uploadMulticanale.be.api.RemoveFromNAS;
import it.bmed.arch.uploadMulticanale.be.api.TokenRequest;
import it.bmed.arch.uploadMulticanale.be.api.TokenResponse;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleRemote;
import it.bmed.arch.uploadMulticanale.be.service.UploadMulticanaleService;
import it.bmed.arch.uploadMulticanale.be.service.azure.AzureService;
import it.bmed.arch.uploadMulticanale.be.service.cmis.ECMService;
import it.bmed.arch.uploadMulticanale.be.service.cmis.Util;
import it.bmed.arch.uploadMulticanale.be.service.livecycle.GeneratePDFServiceClient;
import it.bmed.arch.uploadMulticanale.be.service.nas.NASService;
import it.bmed.asia.exception.ApplicationException;
import it.bmed.asia.exception.AsiaApplicationException;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.exception.ExceptionToFaultConversionUtil;
import it.bmed.asia.exception.IErrorCode;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.exception.jaxws.HeaderInputType;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebService;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(name = "UploadMulticanaleServiceWS", mappedName = "ejb/", description = "")
@WebService(serviceName = APIParams.SERVICE_NAME,  portName = APIParams.PORT_NAME, targetNamespace=APIParams.DEFINITION_NAMESPACE, endpointInterface = "it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleRemote")
@Remote(UploadMulticanaleRemote.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UploadMulticanaleRemoteImpl implements UploadMulticanaleRemote, InitializingBean {

	private static final Logger log = LoggerFactory.getLogger(UploadMulticanaleRemoteImpl.class);

	@Autowired
	UploadMulticanaleService uploadMulticanaleService;

	@Autowired
	private ECMService ecmService = null;

	@Autowired
	private AzureService azureService = null;

	@Autowired
	private NASService nasService = null;
	
	@Autowired
	private GeneratePDFServiceClient generatePDFServiceClient = null;
	
	// FIXME: To be replaced injecting the livecycle WSClient; pay attention this is just a stub. 
//	private GeneratePDFServiceClient generatePDFServiceClient = new GeneratePDFServiceClientImpl();
	
	public UploadMulticanaleRemoteImpl() {
		super();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (uploadMulticanaleService == null) {
			System.err.println("Failed injecting uploadMulticanaleService. ");
			throw new AsiaApplicationException(UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR.getErrorCode(), "Failed injecting uploadMulticanaleService.");
		} else {
			System.out.println("uploadMulticanaleService injected: " + uploadMulticanaleService.getClass().getName());
		}
		
		if (ecmService == null) {
			System.err.println("Failed injecting ecmService. ");
			throw new AsiaApplicationException(UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR.getErrorCode(), "Failed injecting ecmService.");
		} else {
			System.out.println("ecmService injected: " + ecmService.getClass().getName());
		}
		
		if (azureService == null) {
			System.err.println("Failed injecting azureService. ");
			throw new AsiaApplicationException(UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR.getErrorCode(), "Failed injecting azureService.");
		} else {
			System.out.println("azureService injected: " + azureService.getClass().getName());
		}
		
		if (generatePDFServiceClient == null) {
			System.err.println("Failed injecting generatePDFServiceClient. ");
			throw new AsiaApplicationException(UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR.getErrorCode(), "Failed injecting generatePDFServiceClient.");
		} else {
			System.out.println("generatePDFServiceClient injected: " + generatePDFServiceClient.getClass().getName());
		}
		
		if (nasService == null) {
			System.err.println("Failed injecting nasService. ");
			throw new AsiaApplicationException(UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR.getErrorCode(), "Failed injecting nasService.");
		} else {
			System.out.println("nasService injected: " + nasService.getClass().getName());
		}
	}
	
	@Override
	public ECMResponse insertMedia(ECMRequest r, HeaderInputType string) throws SystemFault,
			RemoteException, Exception {
		ECMResponse resp = null;

		try {
			resp = uploadMulticanaleService.insertMedia(r);

		} catch (ApplicationException e) {

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(e);
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice() + "_" + fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setTechnical(true);

			throw fault;

		} catch (RuntimeException runtimeException) {

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(runtimeException);
			fault.getFaultInfo().setCodice(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+ "_" + UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setLayer(UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getErrorCode()+ "_"+ UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false);
			/*
			 * log.error("Errore e.getMessage() "+
			 * runtimeException.getMessage());
			 * log.error("Errore e.getFaultInfo().getCodice() "+
			 * fault.getFaultInfo().getCodice());
			 * log.error("Errore e.getFaultInfo().getMessaggio() "+
			 * fault.getFaultInfo().getMessaggio());
			 * log.error("Errore e.getFaultInfo().getMessaggio() "+
			 * fault.getFaultInfo().isTechnical());
			 */
			throw fault;

		} catch (Exception app) {
			
	

			IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			TechnicalException applicationException = new TechnicalException(er);
			SystemFault fault = ExceptionToFaultConversionUtil.toFault(applicationException);
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice() + "_"+ fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setTechnical(false);
		
			
			throw fault; 
			
			
			
			/*
			 * log.error("Errore e.getMessage() "+ fault.getMessage());
			 * log.error("Errore e.getFaultInfo().getCodice() "+
			 * fault.getFaultInfo().getCodice());
			 * log.error("Errore e.getFaultInfo().getMessaggio() "+
			 * fault.getFaultInfo().getMessaggio());
			 * log.error("Errore e.getFaultInfo().getMessaggio() "+
			 * fault.getFaultInfo().isTechnical());
			 */
		}

		return resp;
	}

	@Override
	public ECMResponse listMedia(ECMRequest request, HeaderInputType string ) throws SystemFault,
			RemoteException, Exception {
		ECMResponse resp = null;

		try {
			resp = uploadMulticanaleService.listMedia(request);

		} catch (ApplicationException e) {

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(e);
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice() + "_"+ fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setTechnical(true);

			throw fault;

		} catch (RuntimeException runtimeException) {

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(runtimeException);
			fault.getFaultInfo().setCodice(
					UploadMulticanaleErrorCodeEnums
							.valueOf("TCH_GENERIC_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(
					UploadMulticanaleErrorCodeEnums
							.valueOf("TCH_GENERIC_ERROR").getErrorCode()
							+ "_"
							+ UploadMulticanaleErrorCodeEnums.valueOf(
									"TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setLayer(
					UploadMulticanaleErrorCodeEnums
							.valueOf("TCH_GENERIC_ERROR").getErrorCode()
							+ "_"
							+ UploadMulticanaleErrorCodeEnums.valueOf(
									"TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false);

			throw fault;

		} catch (Exception app) {

			IErrorCode er = UploadMulticanaleErrorCodeEnums
					.valueOf("TCH_GENERIC_ERROR");
			TechnicalException applicationException = new TechnicalException(er);
			SystemFault fault = ExceptionToFaultConversionUtil
					.toFault(applicationException);
			fault.getFaultInfo().setMessaggio(
					fault.getFaultInfo().getCodice() + "_"
							+ fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setTechnical(false);
			
			throw fault;

		}
		return resp;
	}

	@Override
	public boolean updateMedia(UpdateECMRequest request, HeaderInputType string) throws SystemFault,
			RemoteException, Exception {
		log.debug("updateMedia: Entering");
		boolean resp = false;

		try {
			resp = uploadMulticanaleService.updateMedia(request);

		} catch (ApplicationException e) {

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(e);
			fault.getFaultInfo().setMessaggio(
					fault.getFaultInfo().getCodice() + "_"
							+ fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio());

			throw fault;

		} catch (RuntimeException runtimeException) {

			SystemFault fault = ExceptionToFaultConversionUtil
					.toFault(runtimeException);
			fault.getFaultInfo().setCodice(
					UploadMulticanaleErrorCodeEnums
							.valueOf("TCH_GENERIC_ERROR").getErrorCode());
			fault.getFaultInfo().setMessaggio(
					UploadMulticanaleErrorCodeEnums
							.valueOf("TCH_GENERIC_ERROR").getErrorCode()
							+ "_"
							+ UploadMulticanaleErrorCodeEnums.valueOf(
									"TCH_GENERIC_ERROR").getDescription());
			fault.getFaultInfo().setTechnical(false);

			throw fault;

		} catch (Exception e) {

			IErrorCode er = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			TechnicalException applicationException = new TechnicalException(er);
			SystemFault fault = ExceptionToFaultConversionUtil.toFault(applicationException);
			fault.getFaultInfo().setMessaggio(fault.getFaultInfo().getCodice() + "_" + fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setTechnical(false);
			log.error("ERRORE IN UPDATEMEDIA: "+e.getMessage());
			throw fault;
		}
		log.debug("updateMedia: Exiting");
		return resp;

	}

	/**
		 * @author donatello.boccaforno
		 */
		@Override
		public boolean deleteFileNAS(ECMRequest request, HeaderInputType string) throws SystemFault, RemoteException, Exception {
			boolean response = false;
			boolean isDeletedOnDB = false;
			ECMResponse ecmResponse = null;
			if (request == null) {
				technicalError(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, "deleteFileNAS: request cannot be null.");
			}
	
			try {
				ecmResponse = listMedia(request, new HeaderInputType());
				String nameFile =  ecmResponse.getResult().getNameFile() + "." + ecmResponse.getResult().getType().toLowerCase(); 
				log.debug("NOME FILE SUL NAS", nameFile);
				response = nasService.deleteFile(ecmResponse.getResult().getSourcePath(), nameFile, ecmResponse.getResult().getSource());
				log.info("deleteFileNAS: operation succesfully returned.");
			} catch (TechnicalException e) {
				technicalError(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, "deleteFileNAS: " + e.getMessage());
			}
			
			if (response){
				UpdateECMRequest upRequest = new UpdateECMRequest();
				upRequest.setIdFile(request.getEcmFile().getIdFile());
				upRequest.setState(ECMState.DELETED);
				upRequest.setNameApp(ecmResponse.getResult().getNameApp());
				isDeletedOnDB = updateMedia(upRequest, new HeaderInputType());
			}
			
			if(response && isDeletedOnDB){
				return true;
			}else{
				return false;
			}
		}

	/**
	 * @author donatello.boccaforno
	 */
	@Override
	public boolean deleteFileECM(ECMRequest request, HeaderInputType string) throws SystemFault, RemoteException, Exception {
		log.debug("deleteFileECM: Entering");
		boolean result = false;
		ECMResponse response = null;
		
		try {
			response = listMedia(request, new HeaderInputType());
			if (response == null) {
				technicalError(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR, "deleteFileECM: ListMedia cannot be null. ");
			}
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR, "deleteFileECM: SQLException. " + e.getMessage());
		}

		try {
			log.debug("ECM TYPE RECUPERATO DA LISTMEDIA: "+response.getResult().getEcmType());
			result = ecmService.removeFile(response.getResult().getEcmType(), response.getResult().getIdFileECM(), response.getResult().getContainerType());
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR, "deleteFileECM " + e.getMessage());
		}
		log.info("deleteFileECM returns: " + result);
		log.debug("deleteFileECM: Exiting");
		return result;
	}

	/**
	 * @author donatello.boccaforno
	 */
	@Override
	public AzureResponse getAzureToken(AzureRequest request, HeaderInputType string)
			throws SystemFault, RemoteException, Exception {
		AzureResponse azureResponse = new AzureResponse();
		AzureDTO azureDTO = new AzureDTO();
		try {
			azureDTO = azureService.generateToken(request);
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_AZURE_ERROR, "getAzureToken: " + e.getMessage());
		}
		azureResponse.setResult(azureDTO);
		return azureResponse;
	}

	/**
	 * @author donatello.boccaforno
	 */
	@Override
	public MoveResponse moveFile(MoveRequest request, HeaderInputType string) throws SystemFault, RemoteException, Exception {
		log.debug("moveFile: Entering");
		MoveResponse response = new MoveResponse();
		ECMResponse ecmResponse = null;
		UpdateECMRequest updateECMRequest = new UpdateECMRequest();
		byte[] buffer = null;
		ECMFile ecmFile = null;
		String idFileECM = null;
		MoveDTO moveDTO = new MoveDTO();
		
		ECMRequest ecmRequest = new ECMRequest();
		ecmFile = new ECMFile();
		ecmFile.setIdFile(request.getEcmParam().getIdFile());
		ecmRequest.setEcmFile(ecmFile);
		
		try {
			
			ecmResponse = listMedia(ecmRequest, new HeaderInputType());
			String nameFile = ecmResponse.getResult().getNameFile() + "." + ecmResponse.getResult().getType().toLowerCase();
			
			// Load file from NAS
			buffer = nasService.loadFile(ecmResponse.getResult().getSourcePath(), nameFile, ecmResponse.getResult().getSource());
			ecmFile = ecmResponse.getResult();
			
			// Create file on ECM
//			idFileECM = ecmService.createFile(ecmFile.getEcmType(), buffer, ecmFile.getContainerType(), ecmFile.getNameFile(), ecmFile.getType(), ecmFile.getNameApp(), ecmFile.getDestinationPath(), ecmFile);
			log.debug("CHIAMATA A CREATEFILE - INIZIO");
			idFileECM = ecmService.createFile(buffer, ecmFile, request.getEcmParam());
			log.debug("CHIAMATA A CREATEFILE - FINE");
			updateECMRequest.setContainerType(request.getEcmParam().getContainerType());
			updateECMRequest.setDestinationPath(request.getEcmParam().getDestinationPath());
			updateECMRequest.setEcmType(request.getEcmParam().getEcmType());
			updateECMRequest.setIdFile(ecmFile.getIdFile());
			updateECMRequest.setIdFileECM(idFileECM);
			updateECMRequest.setNameApp(request.getEcmParam().getNameApp());
			updateECMRequest.setState(ECMState.MOVED);
			log.debug("CHIAMATA A UPDATEMEDIA - INIZIO");
			updateMedia(updateECMRequest, new HeaderInputType());
			log.debug("CHIAMATA A UPDATEMEDIA - FINE");
			
			// Remove file from NAS
			if(request.getEcmParam().getRemoveFromNAS() == RemoveFromNAS.REMOVE) {
				nasService.deleteFile(ecmFile.getSourcePath(), ecmFile.getNameFile(), ecmFile.getSource());
			}
			moveDTO.setEcmFileId(idFileECM);
			moveDTO.setFileId(ecmFile.getIdFile());
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR, "moveFile: " + e.getMessage());
		}
		response.setResult(moveDTO);
		return response;
	}

	/**
	 * Lookup a file from NAS or ECM, and convert it into a pdf
	 * @author donatello.boccaforno
	 */
	@Override
	public ECMResponse convertToPDF(ECMConvertRequest request, HeaderInputType string) throws SystemFault, RemoteException, Exception {
		log.debug("convertToPDF: Entering");
		ECMRequest ecmRequest = new ECMRequest();
		ECMResponse ecmResponse = new ECMResponse();
		final String OPEN_IMGTAG = "<img src=\"data:image/png;base64,";
		final String CLOSE_IMGTAG = "\">"; 
		log.debug("ECMConvertRequest: "+ request);
		log.debug("ECMConvertRequest idFile: "+ request.getIdFile());
		log.debug("ECMConvertRequest ECMFile idFile: "+ request.getEcmFile().getIdFile());
		log.debug("ECMConvertRequest ECMParam: "+ request.getEcmParam().getIdFile());
		// Retrieve the file's data from technical db
		ECMFile ecmFile = new ECMFile();
		ecmFile.setIdFile(request.getIdFile());
		ecmRequest.setEcmFile(ecmFile);

		// retrive file's data from technical db
		try {
			ecmResponse = listMedia(ecmRequest, new HeaderInputType());
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_SQL_ERROR,"convertToPDF: file not found in technical db.");
		}
		
		// File to looking for
		String encodedFile = null;
		// load the file from repository
		try {
			encodedFile = lookupFileToConvert(ecmResponse);
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, "convertToPDF " + e.getMessage());		
		}
		
		String htmlDocument = null;
		// generate the html doc from template, using encoded file as IMG data attribute value
		try {
			htmlDocument = createHTMLDocument(encodedFile);
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR, "convertToPDF " + e.getMessage());
		}
		
		String inputUrl = null;
		// Call to livecycle stub
		InputStream resultStream = null;
		try {
			resultStream = generatePDFServiceClient.htmlToPDF2(inputUrl);
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, "convertToPDF " + e.getMessage());
		}

				
		// Save the pdf to the NAS filesystem
		try {
			 nasService.saveFile(resultStream, ecmResponse.getResult().getNameFile(), request.getEcmFile().getSource(), request.getEcmFile().getSourcePath());
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, "convertToPDF " + e.getMessage());
		}
		
		ECMRequest ecmRequestReg = new ECMRequest();
		
		ecmFile.setIdFile(0);
		ecmFile.setChannel(request.getEcmFile().getChannel());
		ecmFile.setContainerType(request.getEcmFile().getContainerType());
		ecmFile.setDestinationPath(request.getEcmFile().getDestinationPath());
		ecmFile.setEcmType(request.getEcmFile().getEcmType());
		//ecmFile.setIdFile(ecmResponse.getResult().getIdFile());
		ecmFile.setIdFileECM(request.getEcmFile().getIdFileECM());
		ecmFile.setNameApp(request.getEcmFile().getNameApp());
		ecmFile.setNameFile(ecmResponse.getResult().getNameFile());
		ecmFile.setSource(request.getEcmFile().getSource());
		ecmFile.setSourcePath(request.getEcmFile().getSourcePath());
		ecmFile.setState(request.getEcmFile().getState());
		ecmFile.setType("PDF");
		ecmFile.setUserId(request.getEcmFile().getUserId());
		ecmFile.setUserType(request.getEcmFile().getUserType());
		
		ecmRequestReg.setEcmFile(ecmFile);
		
		/*
		 * ecmFile.getChannel().isEmpty()
					|| ecmFile.getUserId().isEmpty()
					|| ecmFile.getNameApp().isEmpty()
					|| ecmFile.getNameFile().isEmpty()
					|| ecmFile.getSourcePath().isEmpty()
					|| ecmFile.getUserType().isEmpty()
					|| ecmFile.getSource() == null
					|| ecmFile.getType().isEmpty()) {
		 */
		
		// Save the file's metadata to the technical db
		try {
			ecmResponse = insertMedia(ecmRequestReg, new HeaderInputType());
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_SQL_ERROR, "convertToPDF " + e.getMessage());
		}
		log.debug("convertToPDF: Exiting");
		return ecmResponse;
	}

	/**
	 * Inject encoded file into the HTML img tag's data attribute and create an HTML document generated from a template file
	 * @author donatello.boccaforno
	 * @param encodedFile
	 * @return The encoded html document as <b>String</b>
	 */
	private String createHTMLDocument(String encodedFile) throws AsiaException {
		log.debug("createHTMLDocument params: " + encodedFile);
		String result = null;
		try {
			result = generatePDFServiceClient.createHTMLDocument(encodedFile);
			log.debug("createHTMLDocument returns: " + result);
		} catch (AsiaException e) {
			log.error("createHTMLDocument " + e.getMessage());
			throw e;
		}		
		return result;
	}
	
	/**
	 * Retrieve the file from the repository using the response from the technical database
	 * @author donatello.boccaforno 
	 * @param ecmResponse
	 * @return The file encoded in base64 as <b>String</b>
	 */
	private String lookupFileToConvert(ECMResponse ecmResponse) {
		log.debug("lookupFileToConvert params: " + ecmResponse);
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
					log.error("lookupFileToConvert: " + e.getMessage());
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
					log.error("lookupFileToConvert: " + e.getMessage());
					throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), e.getMessage());
				}
			}		 	
		} else {
			// File not found
			log.error("lookupFileToConvert: file not found.");
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST.getErrorCode(), "convertToPDF error: file not found.");
		}
		log.debug("lookupFileToConvert returns: " + encodedFile);
		return encodedFile;
	}

	private void technicalError(UploadMulticanaleErrorCodeEnums errorCode, String error) throws SystemFault {
		log.error(error);
		TechnicalException technicalException = new TechnicalException(errorCode, new NullPointerException(error));			
		SystemFault systemFault = ExceptionToFaultConversionUtil.toFault(technicalException);
		systemFault.getFaultInfo().setLayer("BKE");
		throw systemFault;
	}
	
	/**
	 * @author 	andrea.perrotta
	 * @param 	TokenRequest --> ECMParam --> ecmParam.getEcmType() = ECMType.IBM_FILENET 	--> Filenet 	Token (not implemented yet) 		
	 * @param 	TokenRequest --> ECMParam --> ecmParam.getEcmType() = ECMType.ALFRESCO 		--> Alfresco 	Token
	 * @return  Alfresco Or Filenet according ecmParam EcmType value
	 */
	@Override
	public TokenResponse getToken(TokenRequest request, HeaderInputType string) throws SystemFault, RemoteException, Exception {
		log.debug("getECMToken: Entering");
		TokenResponse response = new TokenResponse();
		
		try {			
			response.setToken(ecmService.getECMToken(request.getEcmParam()));
		} catch (Exception e) {
			technicalError(UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR, "getECMToken: " + e.getMessage());
		}
		log.debug("getECMToken: Exiting");
		return response;
	}
	
	@Override
    public String getVersione () throws SystemFault, RemoteException, Exception {
        return APIParams.VERSION;
    }

}
