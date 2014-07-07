/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.exception.AsiaException;
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

	/* (non-Javadoc)
	 * @see it.bmed.arch.uploadMulticanale.be.service.nas.NASService#deleteFile(java.lang.String)
	 */
	@Override
	public boolean deleteFile(String path, String filename) throws TechnicalException, Exception {
		boolean result = false;
		String destinationPathname; // used by copyFile as recovery path
		
		// Init destinationPathname from file properties
		try {
			destinationPathname = NASServiceProperties.getString("NasSettings.multicannelUploadDeleted");
		} catch (Exception e) {
			logger.error("deleteFile: " + e.getMessage());
			throw e;
		}
		
		// check uninitialized variables
		if(path == null || path.isEmpty() || filename == null || filename.isEmpty() || destinationPathname == null || destinationPathname.isEmpty()) {
			logger.error("deleteFile: IllegalArgument.");
			IErrorCode iErrorCode = UploadMulticanaleErrorCodeEnums.valueOf("TCH_GENERIC_ERROR");
			TechnicalException  technicalException = new TechnicalException( iErrorCode );	
			throw technicalException;
		}
		
		String sourcePathname = path + filename;
		File file = new File(sourcePathname);
		
		try {
			copyFile(sourcePathname, destinationPathname, filename);
			result = file.delete();
		} catch (Exception e) {
			logger.error("deleteFile: " + e.getMessage());
		} finally {
			file = null;
		}
		return result;
	}
	
	@Override
		public byte[] loadFile(String path, String filename) {		
			InputStream inputStream = null;
			File file = null;
			int fileLength = 0;
			
			file = new File(path + filename);
			fileLength = (int) file.length();

			// FIXME: check which is the real limit in bytes to load a file
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
				throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), "loadFile error: file not found.", e);
			} catch (IOException e) {
				throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), "loadFile error: can't read from file.", e);
			} finally {
				if(inputStream != null) {
					try {
						inputStream.close();
					} catch (Exception e) {
						logger.error("loadFile " + UploadMulticanaleErrorCodeEnums.TCH_GENERIC_ERROR.getErrorCode() + " - " + e.getMessage());
					}
				}
			}
			return buffer;
		}

	private void copyFile(String sourcePathname, String destinationPathname, String filename) throws IOException {
		File srcfile = new File(sourcePathname);
		File destFile = new File(destinationPathname + filename);
		
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
				logger.error("copyFile: " + e.getMessage());
				throw e;
			} finally {
				if(inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						logger.error("copyFile: " + e.getMessage());
						throw e;
					}
				}
				if(outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						logger.error("copyFile: " + e.getMessage());
						throw e;
					}
				}
				srcfile = null;
				destFile = null;
			}
		} catch (FileNotFoundException e) {
			logger.error("copyFile: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public void saveFile(InputStream fileStream, String nameFile)
			throws TechnicalException, Exception {
		String destinationPath = NASServiceProperties.getString("NasSettings.multicannelUploadSaved");
		FileOutputStream fileToBeSaved = null;
		// pay attention destinationPath must be slash ended
		try {
			fileToBeSaved = new FileOutputStream(destinationPath + nameFile);
		} catch (Exception e) {
			logger.error("saveFile: Cannot save %s. " + e.getMessage(), fileStream );
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_NAS_ERROR.getErrorCode(), "Cannot save " + fileStream);			
		}
		
		// copy inputstream to outputstream
		int read = 0;
		byte[] buffer = new  byte[1024];
		while ( (read = fileStream.read(buffer) ) != -1) {
			fileToBeSaved.write(buffer, 0, read);
		}
		
	}

}
