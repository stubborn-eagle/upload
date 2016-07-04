package it.bmed.arch.uploadMulticanale.be.service.livecycle;

import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.InputStream;
import java.util.Scanner;

public class GeneratePDFServiceClientImpl implements GeneratePDFServiceClient {
	private static final Logger logger = LoggerFactory.getLogger(GeneratePDFServiceClientImpl.class);
	private static final String HTML_TEMPLATE = "/TemplatePDF.html";
	private static final String PDF_DOCUMENT = "/it/bmed/arch/uploadMulticanale/be/service/livecycle/Documento.pdf";
	private static final String PATTERN = "<div id=\"image\">";
	private static final String IMG_TAG_START = "<img src=\"data:image/png;base64,";
	private static final String IMG_TAG_END = "\">";
	private LiveCycleConnector liveCycleConnector;

	public LiveCycleConnector getLiveCycleConnector() {
		return liveCycleConnector;
	}

	public void setLiveCycleConnector(LiveCycleConnector liveCycleConnector) {
		this.liveCycleConnector = liveCycleConnector;
	}

	@Override
	public InputStream htmlToPDF2(String inputUrl) {
		logger.debug("htmltoPDF2 params: " + inputUrl);
		InputStream stream = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			stream = loader.getResourceAsStream(PDF_DOCUMENT);
		} catch (Exception e) {
			logger.error("htmlToPDF2: Documento.pdf not found. " + e.getMessage());
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST.getErrorCode(), "htmlToPDF2: ", e);
		}
		logger.debug("htmltoPDF2 returns: " + stream);
		return stream;
	}
	
	@Override
	public String createHTMLDocument(String encodedFile) throws AsiaException {
		StringBuilder outputSB = new StringBuilder();
		InputStream source = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		source = loader.getResourceAsStream(HTML_TEMPLATE);
		int patternIndex = 0;
		Scanner scanner = null;
		try {
			scanner = new Scanner(source);
			StringBuilder builder = new StringBuilder();
			scanner.useDelimiter("");
			String next = null;
			while (scanner.hasNext()) {
				next = scanner.next();
				if (patternIndex <= PATTERN.length() - 1
						&& next.equals(PATTERN.substring(patternIndex,
								patternIndex + 1))) {
					++patternIndex;
					builder.append(next);
				} else {
					outputSB.append(builder.toString()).append(next);
					if (patternIndex == PATTERN.length()) {
						outputSB.append(IMG_TAG_START).append(encodedFile)
								.append(IMG_TAG_END);
					}
					builder.delete(0, builder.length());
					patternIndex = 0;
				}
			}
			outputSB.append(builder.toString());
		} catch (Exception e) {
			logger.error("createHTMLDocument: cannot create HTML document. TemplatePDF not found." + e.getMessage(), e);
			throw new AsiaException(
					UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST
							.getErrorCode(),
					"createHTMLDocument error: TemplatePDF.html not found.", e);
		}
		return outputSB.toString();
	}

	@Override
	public byte[] generatePDF(String xml) throws AsiaException {
		return liveCycleConnector.generatePDF(xml);
	}

	@Override
	public byte[] generatePDFDynamic(String xml) throws AsiaException {
		return liveCycleConnector.generatePDFDynamic(xml);
	}
}
