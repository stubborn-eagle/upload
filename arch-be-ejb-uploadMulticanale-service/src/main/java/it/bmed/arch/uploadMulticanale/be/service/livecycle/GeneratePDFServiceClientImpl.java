package it.bmed.arch.uploadMulticanale.be.service.livecycle;

import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class GeneratePDFServiceClientImpl implements GeneratePDFServiceClient {
	private static final Logger logger = LoggerFactory.getLogger(GeneratePDFServiceClientImpl.class);
	@Override
	public InputStream htmlToPDF2(String inputUrl) {
		FileInputStream stream;
		File file = null;
		try {
			file = new File("src//main//resources//it//bmed//arch//uploadMulticanale//be//livecycle//Documento.pdf");
			logger.info("File " + file.getAbsolutePath());
			stream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.error("htmlToPDF2 " + e.getMessage() + " " + file.getAbsolutePath());
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST.getErrorCode(), "htmlToPDF2 error ", e);
		}
		return stream;
	}

}
