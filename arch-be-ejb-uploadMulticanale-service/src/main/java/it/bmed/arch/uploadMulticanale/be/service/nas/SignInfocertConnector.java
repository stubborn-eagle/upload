package it.bmed.arch.uploadMulticanale.be.service.nas;

import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.service.nas.util.CredentialMappingHandler;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientFactory;
import it.bmed.asia.utility.CommandServiceLocator;
import it.bmed.ib.uploadmulticanale.file.be.wsclient.sign.infocert.FirmaWS;
import it.bmed.ib.uploadmulticanale.file.be.wsclient.sign.infocert.FirmaWSService;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class SignInfocertConnector implements InitializingBean, SignInfocertConnectorInterface {
	private static final Logger logger = LoggerFactory.getLogger(SignInfocertConnector.class);
	
	@Autowired
	private CommandServiceLocator ejbServiceLocator;
	private String signInfocertUrl = null;
	private String signFirmatariDominio = null;
	private String signFirmatariAlias = null;
	private String signFirmatariPin = null;
	private String signFirmatariOtp = null;

	private String signInfocertUser = null;
	private String signInfocertPassword = null;

	@HandlerChain(file = "handler-chain-be.xml")
	public static class SignInfocertFactory extends FirmaWSService implements AsiaWsClientFactory<FirmaWS> {
		public SignInfocertFactory() {
			super();
		}

		public FirmaWS getPort() {
			return this.getFirmaWSPort();
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
			logger.error("firmaCades " + e.getMessage(), e);
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
			logger.error("firmaPades " + e.getMessage(), e);
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
		
//		oracle.security.jps.service.credstore.PasswordCredential credentials = CredentialMappingHandler.getCredentialsFromCSF("bmed.auth.users", "med-lookup.users");
//        	bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, credentials.getName());   
//			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, credentials.getPassword());
//        	throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "credentials error");
        	bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "JVJRAO2");   
	        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "anno2012");
		
		return port;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("ejbServiceLocator injected with " + ejbServiceLocator.getClass().getName());
	}
	@Override
	public String getSignInfocertUrl() {
		return signInfocertUrl;
	}
	@Override
	public void setSignInfocertUrl(String signInfocertUrl) {
		this.signInfocertUrl = signInfocertUrl;
	}
	@Override
	public String getSignFirmatariDominio() {
		return signFirmatariDominio;
	}
	@Override
	public void setSignFirmatariDominio(String signFirmatariDominio) {
		this.signFirmatariDominio = signFirmatariDominio;
	}
	@Override
	public String getSignFirmatariAlias() {
		return signFirmatariAlias;
	}
	@Override
	public void setSignFirmatariAlias(String signFirmatariAlias) {
		this.signFirmatariAlias = signFirmatariAlias;
	}
	@Override
	public String getSignFirmatariPin() {
		return signFirmatariPin;
	}
	@Override
	public void setSignFirmatariPin(String signFirmatariPin) {
		this.signFirmatariPin = signFirmatariPin;
	}
	@Override
	public String getSignFirmatariOtp() {
		return signFirmatariOtp;
	}
	@Override
	public void setSignFirmatariOtp(String signFirmatariOtp) {
		this.signFirmatariOtp = signFirmatariOtp;
	}
	public String getSignInfocertUser() {
		return signInfocertUser;
	}
	public void setSignInfocertUser(String signInfocertUser) {
		this.signInfocertUser = signInfocertUser;
	}
	public String getSignInfocertPassword() {
		return signInfocertPassword;
	}
	public void setSignInfocertPassword(String signInfocertPassword) {
		this.signInfocertPassword = signInfocertPassword;
	}
}
