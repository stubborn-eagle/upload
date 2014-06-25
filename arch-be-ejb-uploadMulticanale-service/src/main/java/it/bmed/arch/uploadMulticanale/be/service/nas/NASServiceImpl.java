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

import javax.activation.FileTypeMap;


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
		public byte[] loadFile(String path, String filename)
				throws TechnicalException, Exception {		
			InputStream inputStream = null;
			File file = null;
			int fileLength = 0;
			
			file = new File(path + filename);
			fileLength = (int) file.length();
	
	//		TODO: check this if required		
	//		if(fileLength > MAX_FILE_SIZE) {
	//			throw new AsiaException("Illegal file size.");
	//		}
			
			byte[] buffer = new byte[fileLength];
			try {
				inputStream = new FileInputStream(file);
				if (inputStream.read(buffer) == -1) {
					throw new AsiaException(new IOException("Error while loding file."));
				}
			} catch (FileNotFoundException e) {
				throw new AsiaException(e);
			} finally {
				if(inputStream != null) {
					try {
						inputStream.close();
					} catch (Exception e) {
						logger.error("loadFile " + e.getMessage());
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

}
