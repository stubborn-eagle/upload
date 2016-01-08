package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientFactory;
import it.bmed.asia.utility.CommandServiceLocator;
import it.bmed.ib.uploadmulticanale.file.be.wsclient.sign.infocert.FirmaWS;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class SignInfocertConnector implements InitializingBean, SignConnectorInterface {
	private static final Logger logger = LoggerFactory.getLogger(SignInfocertConnector.class);
	
	@Autowired
	private CommandServiceLocator ejbServiceLocator;
	private String signInfocertUrl = null;
	private String signFirmatariDominio = null;
	private String signFirmatariAlias = null;
	private String signFirmatariPin = null;
	private String signFirmatariOtp = null;


	@HandlerChain(file = "handler-chain-be.xml")
	public static class SignInfocertFactory implements AsiaWsClientFactory<FirmaWS> {
		public SignInfocertFactory() {
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
		logger.info("firmaCades call.");
		String result = null;
		try {
			FirmaWS serviceSign = (FirmaWS) getWsClient(SignInfocertFactory.class);
			result = serviceSign.firmaCADES(documentoDaFirmare, dominio, alias, pin, otp);
		} catch (Exception e) {
			logger.error("firmaCades " + e.getMessage());
			e.printStackTrace();
			for(int i=0; i < e.getStackTrace().length; i++){
				logger.error("STACK"+e.getStackTrace()[i]);
			}
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "firmaCades error", e);
		}
		return result;
	}
	
	@Override
	public String firmaPades(String documentoDaFirmare, String firmatari) throws AsiaException {
		logger.info("firmaPades call.");
		String result = null;
		try {
			FirmaWS serviceSign = (FirmaWS) getWsClient(SignInfocertFactory.class);
			result = serviceSign.firmaPADES(documentoDaFirmare, firmatari);
		} catch (Exception e) {
			logger.error("firmaPades " + e.getMessage());
			e.printStackTrace();
			for(int i=0; i < e.getStackTrace().length; i++){
				logger.error("STACK"+e.getStackTrace()[i]);
			}
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "firmaPades error", e);
		}
		return result;
	}
	
	
	public <SERVICE,FACT extends AsiaWsClientFactory<SERVICE>> SERVICE getWsClient(Class<FACT> factoryClass)  throws Exception {
		
		FACT realService = factoryClass.newInstance();
		SERVICE port = (SERVICE) realService.getPort();
		BindingProvider bp = (BindingProvider) port;
		String url = getSignInfocertUrl(); 
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		bp.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 15000); // inserire altre due variabili nel web.xml
		bp.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 5000);  //


		return port;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("ejbServiceLocator injected with " + ejbServiceLocator.getClass().getName());
	}
	public String getSignInfocertUrl() {
		return signInfocertUrl;
	}
	public void setSignInfocertUrl(String signInfocertUrl) {
		this.signInfocertUrl = signInfocertUrl;
	}
	public String getSignFirmatariDominio() {
		return signFirmatariDominio;
	}
	public void setSignFirmatariDominio(String signFirmatariDominio) {
		this.signFirmatariDominio = signFirmatariDominio;
	}
	public String getSignFirmatariAlias() {
		return signFirmatariAlias;
	}
	public void setSignFirmatariAlias(String signFirmatariAlias) {
		this.signFirmatariAlias = signFirmatariAlias;
	}
	public String getSignFirmatariPin() {
		return signFirmatariPin;
	}
	public void setSignFirmatariPin(String signFirmatariPin) {
		this.signFirmatariPin = signFirmatariPin;
	}
	public String getSignFirmatariOtp() {
		return signFirmatariOtp;
	}
	public void setSignFirmatariOtp(String signFirmatariOtp) {
		this.signFirmatariOtp = signFirmatariOtp;
	}
}
