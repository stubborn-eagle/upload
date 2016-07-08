/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.arch.uploadMulticanale.be.api.ECMFile;
import it.bmed.arch.uploadMulticanale.be.api.ECMSource;
import it.bmed.arch.uploadMulticanale.be.api.ECMState;
import it.bmed.arch.uploadMulticanale.be.api.SignatureData;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.exception.DevelopmentException;
import it.bmed.asia.exception.IErrorCode;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * @author donatello.boccaforno
 *
 */
public class NASServiceImpl implements NASService {
	private static final Logger logger = LoggerFactory.getLogger(NASServiceImpl.class); 
	private NASServiceSettingsBean settingsBean = null;
	
	private SignConnector signConnector;
	private SignInfocertConnector signInfocertConnector;

	/**
	 * @param settingsBean the settingsBean to set
	 */
	public void setSettingsBean(NASServiceSettingsBean settingsBean) {
		this.settingsBean = settingsBean;
	}
	
	public void setSignConnector(SignConnector signConnector) {
		this.signConnector = signConnector;
	}

	public void setSignInfocertConnector(SignInfocertConnector signInfocertConnector) {
		this.signInfocertConnector = signInfocertConnector;
	}

	/* (non-Javadoc)
	 * @see it.bmed.arch.uploadMulticanale.be.service.nas.NASService#deleteFile(java.lang.String)
	 */
	@Override
	public boolean deleteFile(String sourcePath, String filename, ECMSource source) throws TechnicalException, Exception {
		boolean result = false;
		String destinationPathname = null; // used by copyFile as recovery path
		String destinationDeletedPathname = null; // 
		
		// Init destinationPathname from settings
		destinationPathname = getDestinationPathFromSource(source);		
		destinationDeletedPathname = getDestinationDeletedPathFromSource(source);	
				
		// check uninitialized variables
		logger.debug("###### destinationPathname: " +destinationPathname +"  ###########");
		logger.debug("###### destinationDeletedPathname: " +destinationDeletedPathname +"  ###########");
		logger.debug("###### filename: " +filename +"  ###########");
		
		if(filename == null || filename.isEmpty() || destinationDeletedPathname == null || destinationDeletedPathname.isEmpty()) {
			logger.error("deleteFile: IllegalArgument.");
			IErrorCode iErrorCode = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			TechnicalException  technicalException = new TechnicalException( iErrorCode );	
			throw technicalException;
		}
		
		String sourcePathname;
		
	 			
		if ( destinationPathname != null && destinationPathname.length() == 0) {
                   throw new DevelopmentException("Path di upload non configurato");
             }else{
                   if(sourcePath != null && !sourcePath.contains("../") && !sourcePath.isEmpty()){
                    	  destinationPathname += "/"+sourcePath;
              }
        }
		
				
		sourcePathname = destinationPathname + "/"+ filename;
			
		File file = new File(sourcePathname);
		
		try {
			copyFile(sourcePathname, destinationDeletedPathname, filename);
			result = file.delete();
		} catch (Exception e) {
			logger.error("deleteFile: " + e.getMessage(), e);
		} finally {
			file = null;
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see it.bmed.arch.uploadMulticanale.be.service.nas.NASService#deleteFilePhisical(String, String, ECMSource)
	 */
	@Override
	public boolean deleteFilePhisical(String sourcePath, String filename, ECMSource source) throws TechnicalException, Exception {
		boolean result = false;
		String destinationPathname = null; // used by copyFile as recovery path
		
		// Init destinationPathname from settings
		destinationPathname = getDestinationPathFromSource(source);		
				
		// check uninitialized variables
		if(filename == null || filename.isEmpty()) {
			logger.error("deleteFile: IllegalArgument.");
			IErrorCode iErrorCode = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			TechnicalException  technicalException = new TechnicalException( iErrorCode );	
			throw technicalException;
		}
		
		String sourcePathname;
		
	 			
		if ( destinationPathname != null && destinationPathname.length() == 0) {
                   throw new DevelopmentException("Path di upload non configurato");
             }else{
                   if(sourcePath != null && !sourcePath.contains("../") && !sourcePath.isEmpty()){
                    	  destinationPathname += "/"+sourcePath;
              }
        }
		
				
		sourcePathname = destinationPathname + "/"+ filename;
			
		File file = new File(sourcePathname);
		
		try {
			result = file.delete();
		} catch (Exception e) {
			logger.error("deleteFile: " + e.getMessage(), e);
		} finally {
			file = null;
		}
		return result;
	}
	
	@Override
	public byte[] loadFile(String sourcePath, String filename, ECMSource source) throws TechnicalException {	
	
		
		String sourcePathname="";
		String destinationPathname="";
		
		destinationPathname = getDestinationPathFromSource(source);
		logger.debug("Destination PATH From Source "+destinationPathname);
		if ( destinationPathname != null && destinationPathname.length() == 0) {
			throw new DevelopmentException("Path di upload non configurato");
		}else{
			if(sourcePath != null && !sourcePath.contains("../") && !sourcePath.isEmpty()){
					destinationPathname += "/"+sourcePath;
			}
		}	
					
		InputStream inputStream = null;
		File file = null;
		int fileLength = 0;
		
		sourcePathname = destinationPathname + "/"+ filename;
		logger.debug("loadFile sourcePathname:"+sourcePathname);
		
		file = new File(sourcePathname);
		fileLength = (int) file.length();

		// The higher bound is checked in the caller's side
		if (fileLength >= Integer.MAX_VALUE) { 
			throw new AsiaException("Illegal file size.");
		}
		
		byte[] buffer = new byte[fileLength];
		try {
			inputStream = new FileInputStream(file);
			if (inputStream.read(buffer) == -1) {
				throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), "loadFile error: BOF equals to EOF.");
			}
		} catch (FileNotFoundException e) {
			logger.error("loadFile", e);
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), "loadFile error: file not found.", e);
		} catch (IOException e) {
			logger.error("loadFile", e);
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), "loadFile error: can't read from file.", e);
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					logger.error("loadFile " + UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR.getErrorCode() + " - " + e.getMessage(), e);
				}
			}
		}
		return buffer;
	}
	
	@Override
	public void saveFile(InputStream fileStream, String nameFile, ECMSource source, String sourcePath) throws TechnicalException, Exception {
		logger.debug("saveFile called. ");
		String destinationPath = null;
		if (settingsBean == null) {
			logger.error("saveFile: settingsBean is null.");
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), "settingsBean is null");
		} 		
		destinationPath = getDestinationPathFromSource(source);
		logger.debug("saveFile-destinationPath:"+destinationPath);
		logger.debug("saveFile-sourcePath:"+sourcePath);
		if ( destinationPath != null && destinationPath.length() == 0) {
            throw new DevelopmentException("Path di upload non configurato");
	      }else{
	            if(sourcePath != null && !sourcePath.contains("../") && !sourcePath.isEmpty()){
	            	   destinationPath += "/"+sourcePath;
	       }
	 }
	
			
	String sourcePathname = destinationPath + "/"+ nameFile + ".pdf";
		
		FileOutputStream fileToBeSaved = null;
		// pay attention destinationPath must be slash ended
		try {
			fileToBeSaved = new FileOutputStream(sourcePathname);
			int read = 0;
			byte[] buffer = new  byte[1024];
			// copy inputstream to outputstream
			while ( (read = fileStream.read(buffer) ) != -1) {
				fileToBeSaved.write(buffer, 0, read);
			}
		} catch (Exception e) {
			logger.error("saveFile: Cannot save. " + e.getMessage(), fileStream, e);
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), "Cannot save " + fileStream);			
		} finally {
			if (fileToBeSaved != null) {
				try {
					fileToBeSaved.close();
				} catch (Exception e) {logger.info("skipped");}	
			}
		}
	}

	private void copyFile(String sourcePathname, String destinationPathname, String filename) throws IOException {
		File srcfile = new File(sourcePathname);
		File destFile = new File(destinationPathname + filename);
//		if(destFile.exists()){
//			destFile.renameTo(NEWNAME);
//		}
//		System.currentTimeMillis();
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = new FileInputStream(srcfile);
			outputStream = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];
			int bytes = 0;
			try {
				while ( (bytes = inputStream.read(buffer)) > 0 ) {
					outputStream.write(buffer, 0, bytes);
				}
			} catch (IOException e) {
				logger.error("copyFile: " + e.getMessage(), e);
				throw e;
			} finally {
				if(inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						logger.error("copyFile: " + e.getMessage(), e);
						throw e;
					}
				}
				if(outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						logger.error("copyFile: " + e.getMessage(), e);
						throw e;
					}
				}
				srcfile = null;
				destFile = null;
			}
		} catch (FileNotFoundException e) {
			logger.error("copyFile: " + e.getMessage(), e);
			throw e;
		}
	}

	private String getDestinationDeletedPathFromSource(ECMSource source) throws TechnicalException {
		logger.debug("getDestinationDeletedPathFromSource: Entering");
		String destinationDeletedPathname = null;
		logger.debug("SOURCE: "+source);
		try {
			switch (source) {
			case INTERNET_BANKING:
				destinationDeletedPathname = settingsBean.getNasInternetBankingDeletedPath();
				break;
			case PORTALE_DI_SEDE:
				destinationDeletedPathname = settingsBean.getNasPortaleDiSedeDeletedPath();
				break;
			case RETE_DI_VENDITA:
				destinationDeletedPathname = settingsBean.getNasReteDiVenditaDeletedPath();
				break;
			case LIVE_CYCLE:
				destinationDeletedPathname = settingsBean.getNasInternetBankingDeletedPath();
				break;
			case LIVE_CYCLE_DYNAMIC:
				destinationDeletedPathname = settingsBean.getNasInternetBankingDeletedPath();
				break;
			}

		} catch (Exception e) {
			logger.error("deleteFile: " + e.getMessage(), e);
			throw new TechnicalException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, e);
		}
		logger.debug("getDestinationDeletedPathFromSource: Exting");
		return destinationDeletedPathname;
	}

	
	private String getDestinationPathFromSource(ECMSource source) throws TechnicalException {
		String destinationPathname = null;
		logger.debug("Settings Bean TO STRING: " + settingsBean.toString());
		logger.debug("getDestinationPathFromSource source:"+ source);
		try {
			switch (source) {
			case INTERNET_BANKING:
				destinationPathname = settingsBean.getNasInternetBankingPath();
				break;
			case PORTALE_DI_SEDE:
				destinationPathname = settingsBean.getNasPortaleDiSedePath();
				break;
			case RETE_DI_VENDITA:
				destinationPathname = settingsBean.getNasReteDiVenditaPath();
				break;
			case LIVE_CYCLE:
				destinationPathname = settingsBean.getGeneratedPdfFilePath();
				break;
			case LIVE_CYCLE_DYNAMIC:
				destinationPathname = settingsBean.getGeneratedDynamicPdfFilePath();
				break;
			}

		} catch (Exception e) {
			logger.error("deleteFile: " + e.getMessage(), e);
			throw new TechnicalException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, e);
		}
		return destinationPathname;
	}

	@Override
	public ECMFile getEcmFileLiveCyclePdf(String fileName, boolean isDynamic) throws TechnicalException {
		
		String destinationPath = "";
		
		if (isDynamic)
			destinationPath = getDestinationPathFromSource(ECMSource.LIVE_CYCLE_DYNAMIC);
		else
			destinationPath = getDestinationPathFromSource(ECMSource.LIVE_CYCLE);
		
//		String sourcePath = destinationPath + "/"+ fileName;
		
		ECMFile ecmFile = new ECMFile();
		
		ecmFile.setIdFile(0);
		ecmFile.setChannel(settingsBean.getPdfLiveCycleChannel());
		ecmFile.setContainerType(settingsBean.getPdfLiveCycleContainerType());
		ecmFile.setDestinationPath(destinationPath);
		ecmFile.setNameApp(settingsBean.getPdfLiveCycleNameApp());
		ecmFile.setNameFile(fileName);
		ecmFile.setSource(ECMSource.LIVE_CYCLE);
//		ecmFile.setSourcePath(sourcePath);
		ecmFile.setState(ECMState.INSERTED);
		ecmFile.setType("pdf");
		ecmFile.setUserId(settingsBean.getPdfLiveCycleUserId());
		
		return ecmFile;
	}
	
	@Override
	public String firmaCades(String documentoDaFirmare, String dominio, String alias, String pin, String otp) throws TechnicalException {
		logger.info("firmaCades call.");
		String result = null;
		try {
			result = signConnector.firmaCades(documentoDaFirmare, dominio, alias, pin, otp);
		} catch (Exception e) {
			logger.error("firmaCades", e);
			throw new TechnicalException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, e);
		}
		return result;
	}
	
	@Override
	public String firmaPades(String documentoDaFirmare, String firmatari) throws TechnicalException {
		logger.info("firmaPades call.");
		String result = null;
		try {
			result = signConnector.firmaPades(documentoDaFirmare, firmatari);
		} catch (Exception e) {
			logger.error("firmaPades", e);
			throw new TechnicalException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, e);
		}
		return result;
	}
	
	@Override
	public String firmaCadesInfocert(String documentoDaFirmare, String dominio, String alias, String pin, String otp) throws TechnicalException {
		logger.info("firmaCadesInfocert call.");
		String result = null;
		try {
			result = signInfocertConnector.firmaCades(documentoDaFirmare, dominio, alias, pin, otp);
		} catch (Exception e) {
			logger.error("firmaCadesInfocert", e);
			throw new TechnicalException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, e);
		}
		return result;
	}
	
	@Override
	public String firmaPadesInfocert(String documentoDaFirmare, String firmatari, String idDocumento) throws TechnicalException {
		logger.info("firmaPadesInfocert call.");
		String result = null;
		try {
			result = signInfocertConnector.firmaPades(documentoDaFirmare, firmatari, idDocumento);
		} catch (Exception e) {
			logger.error("firmaPadesInfocert", e);
			throw new TechnicalException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, e);
		}
		return result;
	}
	
	@Override
	public SignatureData getSignatureData() throws TechnicalException {
		SignatureData result = null;
		try {
			result = new SignatureData(signInfocertConnector.getSignFirmatariDominio(), signInfocertConnector.getSignFirmatariAlias(), signInfocertConnector.getSignFirmatariPin(), signInfocertConnector.getSignFirmatariOtp());
		} catch (Exception e) {
			logger.error("getSignatureData", e);
			throw new TechnicalException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR, e);
		}
		return result;
	}
}
