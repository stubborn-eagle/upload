package it.bmed.arch.uploadMulticanale.be.ejbimpl;

import it.bmed.arch.uploadMulticanale.be.api.ECMSource;
import it.bmed.arch.uploadMulticanale.be.api.ECMState;
import it.bmed.arch.uploadMulticanale.be.api.UpdateECMRequest;
import it.bmed.arch.uploadMulticanale.be.service.UploadMulticanaleService;
import it.bmed.arch.uploadMulticanale.be.service.livecycle.GeneratePDFServiceClient;
import it.bmed.arch.uploadMulticanale.be.service.nas.NASService;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.ByteArrayInputStream;

public class GeneratePdfThread implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(GeneratePdfThread.class);
	
	private boolean isDynamic;
	private GeneratePDFServiceClient generatePDFServiceClient;
	private String xml;
	private NASService nasService;
	private String fileName;
	private UploadMulticanaleService uploadMulticanaleService;
	private String nameApp;
	private Integer idFile;
	
	public GeneratePdfThread(boolean isDynamic, GeneratePDFServiceClient generatePDFServiceClient, String xml, NASService nasService, String fileName, UploadMulticanaleService uploadMulticanaleService, String nameApp, Integer idFile){
		this.isDynamic = isDynamic;
		this.generatePDFServiceClient = generatePDFServiceClient;
		this.xml = xml;
		this.nasService = nasService;
		this.fileName = fileName;
		this.uploadMulticanaleService = uploadMulticanaleService;
		this.nameApp = nameApp;
		this.idFile = idFile;
	}

	@Override
	public void run() {
		byte[] fileContent = null;
		if(!isDynamic){
			fileContent = generatePDFServiceClient.generatePDF(xml);
		}else{
			fileContent = generatePDFServiceClient.generatePDFDynamic(xml);
		}
		
		ECMSource ecmSource =  ECMSource.LIVE_CYCLE;
		if(isDynamic){
			ecmSource =  ECMSource.LIVE_CYCLE_DYNAMIC;
		}
		ByteArrayInputStream resultStream = new ByteArrayInputStream(fileContent);
		try{
			nasService.saveFile(resultStream, fileName, ecmSource, null);
			UpdateECMRequest updateECMRequest = new UpdateECMRequest();
			updateECMRequest.setIdFile(idFile);
			updateECMRequest.setState(ECMState.INSERTED);
			updateECMRequest.setNameApp(nameApp);
			uploadMulticanaleService.updateMedia(updateECMRequest);
		} catch (Exception e) {
			try {
				UpdateECMRequest updateECMRequest = new UpdateECMRequest();
				updateECMRequest.setIdFile(idFile);
				updateECMRequest.setState(ECMState.ERROR);
				updateECMRequest.setNameApp(nameApp);
				uploadMulticanaleService.updateMedia(updateECMRequest);
			}catch (Throwable t) {
				log.error("generatePDF"+(isDynamic?"Dynamic":" ")+"AsynchronousThread Error management", t);
			}
			log.error("generatePDF"+(isDynamic?"Dynamic":" ")+"AsynchronousThread" + e.getMessage());
		}
	}
}
