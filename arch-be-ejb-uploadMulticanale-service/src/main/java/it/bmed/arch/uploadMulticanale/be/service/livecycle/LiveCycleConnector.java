package it.bmed.arch.uploadMulticanale.be.service.livecycle;

import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.arch.uploadMulticanale.be.livecycle.ws.client.Dispatcher;
import it.bmed.arch.uploadMulticanale.be.livecycle.ws.client.Dispatcher30919F;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;
import it.bmed.asia.utility.AsiaWsClientFactory;
import it.bmed.asia.utility.CommandServiceLocator;

import javax.jws.HandlerChain;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
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
	public static class LiveCycleFactory extends Dispatcher30919F implements AsiaWsClientFactory<Dispatcher> {
		public LiveCycleFactory() {
			super();
		}

		public Dispatcher getPort() {
			return this.getDispatcherImplPort();
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
			logger.debug("invoking getWsClient");
			Dispatcher serviceLiveCycle = (Dispatcher) getWsClient(LiveCycleFactory.class);
//			SshHelper.makeWebServiceClientTrustEveryone(serviceLiveCycle);
			logger.debug("getWsClient invoked");
			result = serviceLiveCycle.generatePDF(refId);
			logger.debug("generatePDF invoked");
		} catch (Throwable e) {
			logger.error("generatePDF " + e.getMessage(), e);
			e.printStackTrace();
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
		} catch (Throwable e) {
			logger.error("generatePDFDynamic " + e.getMessage(), e);
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "generatePDFDynamic error", e);
		}
		return result;
	}
	
	
	public <SERVICE,FACT extends AsiaWsClientFactory<SERVICE>> SERVICE getWsClient(Class<FACT> factoryClass)  throws Exception {
//		// Now you are telling the JRE to ignore the hostname
//        HostnameVerifier hv = new HostnameVerifier() {
//            public boolean verify(String urlHostName, SSLSession session) {
//                // System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
//                return true;
//            }
//        };
//               
//        // Now you are telling the JRE to trust any https server. 
//      // If you know the URL that you are connecting to then this should not be a problem
//      trustAllHttpsCertificates();
//      HttpsURLConnection.setDefaultHostnameVerifier(hv);
      
		String url = getLiveCycleUrl();
		logger.debug("endpoint:"+url);
		FACT realService = factoryClass.newInstance();
		SERVICE port = (SERVICE) realService.getPort();
		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		bp.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 15000); // inserire altre due variabili nel web.xml
		bp.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 5000);  //

		return port;
	}
	
//	private static void trustAllHttpsCertificates() throws Exception {
//
//        //  Create a trust manager that does not validate certificate chains:
//
//        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
//
//        javax.net.ssl.TrustManager tm = new miTM();
//
//        trustAllCerts[0] = tm;
//
//        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
//
//        sc.init(null, trustAllCerts, null);
//
//        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//    }
//	
//	public static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager
//    {
//        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//            return null;
//        }
//
//        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
//            return true;
//        }
//         
//        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
//            return true;
//        }
//         
//        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException {
//            return;
//        }
//
//        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException {
//            return;
//        }
//    }

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
