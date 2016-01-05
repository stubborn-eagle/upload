package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientFactory;
import it.bmed.asia.utility.CommandServiceLocator;
import it.bmed.ib.uploadmulticanale.file.be.wsclient.sign.FirmaWS;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class SignConnector implements InitializingBean, SignConnectorInterface {
	private static final Logger logger = LoggerFactory.getLogger(SignConnector.class);
	
	@Autowired
	private CommandServiceLocator ejbServiceLocator;
	private String signUrl = null;

	@HandlerChain(file = "handler-chain-be.xml")
	public static class SignFactory implements AsiaWsClientFactory<FirmaWS> {
		public SignFactory() {
			super();
		}

		public FirmaWS getPort() {
			return this.getPort();
		}

		@Override
		public QName getServiceName() {
			return this.getServiceName();
		}
	}
	
	@Override
	public String firmaCades(String documentoDaFirmare, String dominio, String alias, String pin, String otp) throws AsiaException {
		logger.info("generatePDF call.");
		String result = null;
		try {
			FirmaWS serviceSign = (FirmaWS) getWsClient(SignFactory.class);
			result = serviceSign.firmaCADES(documentoDaFirmare, dominio, alias, pin, otp);
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
	public String firmaPades(String documentoDaFirmare, String firmatari) throws AsiaException {
		logger.info("generatePDFDynamic call.");
		String result = null;
		try {
			FirmaWS serviceSign = (FirmaWS) getWsClient(SignFactory.class);
			result = serviceSign.firmaPADES(documentoDaFirmare, firmatari);
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
		String url = getSignUrl(); 
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		bp.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 15000); // inserire altre due variabili nel web.xml
		bp.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 5000);  //


		return port;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("ejbServiceLocator injected with " + ejbServiceLocator.getClass().getName());
	}
	public String getSignUrl() {
		return signUrl;
	}
	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}
}
