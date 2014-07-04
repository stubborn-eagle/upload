package it.bmed.arch.uploadMulticanale.be.ejbimpl;

import it.bmed.arch.uploadMulticanale.be.api.AzureDTO;
import it.bmed.arch.uploadMulticanale.be.api.AzureRequest;
import it.bmed.arch.uploadMulticanale.be.api.AzureResponse;
import it.bmed.arch.uploadMulticanale.be.api.ECMConvertRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.ECMState;
import it.bmed.arch.uploadMulticanale.be.api.ECMType;
import it.bmed.arch.uploadMulticanale.be.api.MoveDTO;
import it.bmed.arch.uploadMulticanale.be.api.MoveRequest;
import it.bmed.arch.uploadMulticanale.be.api.MoveResponse;
import it.bmed.arch.uploadMulticanale.be.api.RemoveFromNAS;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleRemote;
import it.bmed.arch.uploadMulticanale.be.service.UploadMulticanaleService;
import it.bmed.arch.uploadMulticanale.be.service.azure.AzureService;
import it.bmed.arch.uploadMulticanale.be.service.cmis.ECMService;
import it.bmed.arch.uploadMulticanale.be.service.cmis.Util;
import it.bmed.arch.uploadMulticanale.be.service.nas.NASService;
import it.bmed.asia.exception.ApplicationException;
import it.bmed.asia.exception.AsiaApplicationException;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.exception.ExceptionToFaultConversionUtil;
import it.bmed.asia.exception.IErrorCode;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.File;
import java.rmi.RemoteException;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(name = "uploadMulticanaleDaoWS", mappedName = "ejb/", description = "")
@WebService(serviceName = "uploadMulticanaleBS", name = "uploadMulticanaleBS", portName = "uploadMulticanaleBS", endpointInterface = "it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleRemote")
@Remote(UploadMulticanaleRemote.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UploadMulticanaleRemoteImpl implements UploadMulticanaleRemote {

	private static final Logger log = LoggerFactory.getLogger(UploadMulticanaleRemoteImpl.class);

	@Autowired
	UploadMulticanaleService uploadMulticanaleService;

	@Autowired
	private ECMService ecmService;

	@Autowired
	private AzureService azureService;

	@Autowired
	private NASService nasService;
	
	public UploadMulticanaleRemoteImpl() {
		super();
	}

	@Override
	public ECMResponse insertMedia(ECMRequest r) throws SystemFault,
			RemoteException, Exception {
		ECMResponse resp = null;

		try {
			resp = uploadMulticanaleService.insertMedia(r);

		} catch (ApplicationException e) {

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(e);
			fault.getFaultInfo().setMessaggio(
					fault.getFaultInfo().getCodice() + "_"
							+ fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setTechnical(true);

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
			fault.getFaultInfo().setLayer(
					UploadMulticanaleErrorCodeEnums
							.valueOf("TCH_GENERIC_ERROR").getErrorCode()
							+ "_"
							+ UploadMulticanaleErrorCodeEnums.valueOf(
									"TCH_GENERIC_ERROR").getDescription());
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
	public ECMResponse listMedia(ECMRequest request) throws SystemFault,
			RemoteException, Exception {
		ECMResponse resp = null;

		try {
			resp = uploadMulticanaleService.listMedia(request);

		} catch (ApplicationException e) {

			SystemFault fault = ExceptionToFaultConversionUtil.toFault(e);
			fault.getFaultInfo().setMessaggio(
					fault.getFaultInfo().getCodice() + "_"
							+ fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setLayer(fault.getFaultInfo().getMessaggio());
			fault.getFaultInfo().setTechnical(true);

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

		}
		return resp;
	}

	@Override
	public boolean updateMedia(UpdateECMRequest request) throws SystemFault,
			RemoteException, Exception {
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

			throw fault;
		}
		return resp;

	}

	/**
		 * @author donatello.boccaforno
		 */
		@Override
		public boolean deleteFileNAS(ECMRequest request) throws RemoteException, Exception {
			boolean response = false;
			ECMResponse ecmResponse = null;
			if (request == null) {
				log.error("deleteFileNAS: request cannot be null.");
				throw new AsiaException("deleteFileNAS: request cannot be null.");
			}
	
			try {
				ecmResponse = listMedia(request);
				response = nasService.deleteFile(ecmResponse.getResult()
						.getSourcePath(), ecmResponse.getResult()
						.getNameFile());
				log.info("deleteFileNAS: operation succesfully returned.");
			} catch (Exception e) {
				log.error("deleteFileNAS: " + e.getMessage());
//				throw new AsiaException("TCH_ECM_ERROR", "deleteFileNAS: "
//						+ e.getMessage());
				throw e;
			}
			return response;
		}

	/**
	 * @author donatello.boccaforno
	 */
	@Override
	public boolean deleteFileECM(ECMRequest request) throws RemoteException,
			Exception {
		boolean result = false;
		ECMResponse response = null;
		try {
			log.info("deleteFileECM params: " + response);
		} catch (NullPointerException e) {
			log.error("deleteFileECM: request argument cannot be null.");
			throw new AsiaApplicationException("TCH_ECM_ERROR",
					"deleteFileECM: request argument cannot be null.");
		}

		try {
			response = listMedia(request);
			if (response == null) {
				log.error("deleteFileECM: ListMedia cannot be null. ");
				throw new AsiaApplicationException("TCH_ECM_ERROR",
						"deleteFileECM: ListMedia cannot be null. ");
			}
		} catch (Exception e) {
			log.error("deleteFileECM: SQLException. " + e.getMessage());
			throw new AsiaApplicationException("TCH_ECM_ERROR",
					"deleteFileECM: SQLException. " + e.getMessage());
		}

		try {
			result = ecmService.removeFile(response.getResult().getEcmType(),
					response.getResult().getIdFileECM());
		} catch (Exception e) {
			log.error("deleteFileECM " + e.getMessage());
			throw new AsiaApplicationException("TCH_ECM_ERROR",
					"deleteFileECM: " + e.getMessage());
		}
		log.info("deleteFileECM returns: " + result);
		return result;
	}

	/**
	 * @author donatello.boccaforno
	 */
	@Override
	public AzureResponse getAzureToken(AzureRequest request)
			throws RemoteException, Exception {
		AzureResponse azureResponse = new AzureResponse();
		AzureDTO azureDTO = null;
		azureDTO = azureService.generateToken(request);
		azureResponse.setResult(azureDTO);
		return azureResponse;
	}

	/**
	 * @author donatello.boccaforno
	 */
	@Override
	public MoveResponse moveFile(MoveRequest request) throws RemoteException, Exception {
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
			ecmResponse = listMedia(ecmRequest);
			
			// Load file from NAS
			buffer = nasService.loadFile(ecmResponse.getResult().getSourcePath(), ecmResponse.getResult().getNameFile() + ecmResponse.getResult().getType());
			ecmFile = ecmResponse.getResult();
			
			// Create file on ECM
//			idFileECM = ecmService.createFile(ecmFile.getEcmType(), buffer, ecmFile.getContainerType(), ecmFile.getNameFile(), ecmFile.getType(), ecmFile.getNameApp(), ecmFile.getDestinationPath(), ecmFile);
			idFileECM = ecmService.createFile(buffer, ecmFile, request.getEcmParam());
			updateECMRequest.setContainerType(ecmFile.getContainerType());
			updateECMRequest.setDestinationPath(ecmFile.getDestinationPath());
			updateECMRequest.setEcmType(ecmFile.getEcmType());
			updateECMRequest.setIdFile(ecmFile.getIdFile());
			updateECMRequest.setIdFileECM(idFileECM);
			updateECMRequest.setNameApp(ecmFile.getNameApp());
			updateECMRequest.setState(ECMState.MOVED);
			// FIXME: dao doesn't handle operation timestamp field 
//			updateMediaRequest.setOperationTimestamp(new Timestamp(new Date().getTime())); //TODO: instance variable to be implemented
			updateMedia(updateECMRequest);
			
			// Remove file from NAS
			if(request.getEcmParam().getRemoveFromNAS() == RemoveFromNAS.REMOVE) {
				nasService.deleteFile(ecmFile.getSourcePath(), ecmFile.getNameFile());
			}
			moveDTO.setEcmFileId(idFileECM);
			moveDTO.setFileId(ecmFile.getIdFile());
		} catch (ApplicationException e) {
			//TODO :hnadle exception
			log.error("moveFile: " + e.getMessage());
			throw e;
		}
		response.setResult(moveDTO);
		return response;
	}

	/**
	 * Lookup a file from NAS or ECM, and convert it into a pdf
	 * @author donatello.boccaforno
	 */
	@Override
	public ECMResponse convertToPDF(ECMConvertRequest request) throws RemoteException, Exception {
		ECMRequest ecmRequest = new ECMRequest();
		ECMResponse ecmResponse = new ECMResponse();
		final String OPEN_IMGTAG = "<img src=\"data:image/png;base64,";
		final String CLOSE_IMGTAG = "\">"; 
		
		// Retrieve the file's data from technical db
		ECMFile ecmFile = new ECMFile();
		ecmFile.setIdFile(request.getEcmParam().getIdFile());
		ecmRequest.setEcmFile(ecmFile);
		
		try {
			ecmResponse = listMedia(ecmRequest);
		} catch (Exception e) {
			log.error("convertToPDF: file not found.");
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST.getErrorCode(), "convertToPDF error: file not found.");
		}
		
		// File to looking for
		String encodedFile = null;
		// load the file from repository
		try {
			encodedFile = lookupFileToConvert(ecmResponse);
		} catch (Exception e) {
			log.error("convertToPDF " + e.getMessage());
			throw e;
		}
		// TODO: caricare il template
		File templateFile = new File("TemplatePDF.html");
//		File targetFile = new File("HtmlToPDF.html");
		StringBuilder imgTag = new StringBuilder();
		imgTag.append(OPEN_IMGTAG).append(encodedFile).append(CLOSE_IMGTAG);

		// TODO: reading the file coping the words into a buffer still doesn't mach the div tag with id image
		
		// TODO: append the imgTag String into the target file
		
		// TODO: Continue reading&coping
		
		if (templateFile.exists()) {
			// TODO: append imgTag in templateFile after matching pattern 
		} else {
			log.error("convertToPDF: template file " + templateFile.getName() + " not found.");
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST.getErrorCode(), "convertToPDF error: template file " + templateFile.getName() + " not found.");			
		}
		// TODO: sostituire l'immagine con il file content encodato
		
		// TODO: chiamare htmpToPDF2 di GenerateServiceClient passando il file html, aspettandosi un InputStream
		
		// TODO: salvare il pdf
		
		// TODO: salvare info nel db tecnico attraverso insertMedia
		return ecmResponse;
	}
	/**
	 * Retrieve the file from the repository using the response from the technical database 
	 * @param ecmResponse
	 * @return The file encoded in base64 as <b>String</b>
	 */
	private String lookupFileToConvert(ECMResponse ecmResponse) {
		// File to looking for
		String encodedFile = null;
		
		if (ecmResponse != null && ecmResponse.getResult() != null) {
			// File found
			if (ecmResponse.getResult().getDestinationPath() != null && ecmResponse.getResult().getDestinationPath().length() > 0) {
				// the file it's on the ECM
				try {
					ECMType ecmType = ecmResponse.getResult().getEcmType();
					String ecmFileId = ecmResponse.getResult().getIdFileECM();
					encodedFile = ecmService.downloadFile(ecmType, ecmFileId);
				} catch (Exception e) {
					log.error("convertToPDF " + e.getMessage());
					throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), e.getMessage());
				}
			} else {
				// the file it's on the NAS
				try {
					String path = ecmResponse.getResult().getSourcePath();
					String filename = ecmResponse.getResult().getNameFile() + "." + ecmResponse.getResult().getType();
					encodedFile = Util.encodeFileToBase64Binary(nasService.loadFile(path, filename));
				} catch (Exception e) {
					log.error("convertToPDF " + e.getMessage());
					throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), e.getMessage());
				}
			}		 	
		} else {
			// File not found
			log.error("convertToPDF: file not found.");
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST.getErrorCode(), "convertToPDF error: file not found.");
		}
		return encodedFile;
	}
}
