package it.bmed.arch.uploadMulticanale.be.service.livecycle;

import filenet.ws.client.WSGDIImplService;
import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.livecycle.ws.client.Dispatcher;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientFactory;
import it.bmed.asia.utility.CommandServiceLocator;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class LiveCycleConnector implements InitializingBean, LiveCycleConnectorInterface {
	private static final Logger logger = LoggerFactory.getLogger(LiveCycleConnector.class);
	
	@Autowired
	private CommandServiceLocator ejbServiceLocator;
	private String liveCycleUrl = null;

	@HandlerChain(file = "handler-chain-be.xml")
	public static class LiveCycleFactory implements AsiaWsClientFactory<Dispatcher> {
		public LiveCycleFactory() {
			super();
		}

		public Dispatcher getPort() {
			return this.getPort();
		}

		@Override
		public QName getServiceName() {
			return this.getServiceName();
		}
	}
	
	@Override
	public byte[] generatePDF(String refId) throws AsiaException {
		logger.info("generatePDF call.");
		byte[] result = null;
		try {
			Dispatcher serviceLiveCycle = (Dispatcher) getWsClient(LiveCycleFactory.class);
			result = serviceLiveCycle.generatePDF(refId);
		} catch (Exception e) {
			logger.error("generatePDF " + e.getMessage());
			e.printStackTrace();
			for(int i=0; i < e.getStackTrace().length; i++){
				logger.error("STACK"+e.getStackTrace()[i]);
			}
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "generatePDF error", e);
		}
		return result;
	}
	
	@Override
	public byte[] generatePDFDynamic(String refId) throws AsiaException {
		logger.info("generatePDFDynamic call.");
		byte[] result = null;
		try {
			Dispatcher serviceLiveCycle = (Dispatcher) getWsClient(LiveCycleFactory.class);
			result = serviceLiveCycle.generatePDFDynamic(refId);
		} catch (Exception e) {
			logger.error("generatePDFDynamic " + e.getMessage());
			e.printStackTrace();
			for(int i=0; i < e.getStackTrace().length; i++){
				logger.error("STACK"+e.getStackTrace()[i]);
			}
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "generatePDFDynamic error", e);
		}
		return result;
	}
	
	
	public <SERVICE,FACT extends AsiaWsClientFactory<SERVICE>> SERVICE getWsClient(Class<FACT> factoryClass)  throws Exception {
		
		FACT realService = factoryClass.newInstance();
		SERVICE port = (SERVICE) realService.getPort();
		BindingProvider bp = (BindingProvider) port;
		String url = getLiveCycleUrl(); 
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		bp.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 15000); // inserire altre due variabili nel web.xml
		bp.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 5000);  //


		return port;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("ejbServiceLocator injected with " + ejbServiceLocator.getClass().getName());
	}
	public String getLiveCycleUrl() {
		return liveCycleUrl;
	}
	public void setLiveCycleUrl(String liveCycleUrl) {
		this.liveCycleUrl = liveCycleUrl;
	}
}
