package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnums;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public abstract class AbstractECMConnector implements ECMConnector {
	private static final Logger logger = LoggerFactory.getLogger(AbstractECMConnector.class);
	// Applicative user credentials
	protected String user = null;
	protected String password = null;
	protected String alfrescoUrl = null;

	// WebService connection settings	
	private String repositoryServiceUrl = null;
	private String navigationServiceWsdlUrl = null;
	private String objectServiceWsdlUrl = null;
	private String versioningServiceWsdlUrl = null;
	private String discoveryServiceWsdlUrl = null;
	private String relationshipServiceWsdlUrl = null;
	private String multiFilingServiceWsdlUrl = null;
	private String policyServiceWsdlUrl = null;
	private String aclServiceWsdlUrl = null;
	
	
	/**
	 * @return the alfrescoUrl
	 */
	public String getAlfrescoUrl() {
		return alfrescoUrl;
	}
	/**
	 * @param alfrescoUrl the alfrescoUrl to set
	 */
	public void setAlfrescoUrl(String alfrescoUrl) {
		this.alfrescoUrl = alfrescoUrl;
	}

	
	// Bindings Settings
	public String bindingSPIType = null;
	
	// ECM connector session
	protected Session session = null;

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}	
	/**
	 * @param bindingSPIType the bindingSPIType to set
	 */
	public void setBindingSPIType(String bindingSPIType) {
		this.bindingSPIType = bindingSPIType;
	}
	/**
	 * @param repositoryServiceUrl the repositoryServiceUrl to set
	 */
	public void setRepositoryServiceUrl(String repositoryServiceUrl) {
		this.repositoryServiceUrl = repositoryServiceUrl + "/" + CmisWSBindingWsdlUrl.REPOSITORY_SERVICE_URL;
	}
	/**
	 * @param navigationServiceWsdlUrl the navigationServiceWsdlUrl to set
	 */
	public void setNavigationServiceWsdlUrl(String navigationServiceWsdlUrl) {
		this.navigationServiceWsdlUrl = navigationServiceWsdlUrl + "/" + CmisWSBindingWsdlUrl.NAVIGATION_SERVICE_URL;
	}
	/**
	 * @param objectServiceWsdlUrl the objectServiceWsdlUrl to set
	 */
	public void setObjectServiceWsdlUrl(String objectServiceWsdlUrl) {
		this.objectServiceWsdlUrl = objectServiceWsdlUrl + "/" + CmisWSBindingWsdlUrl.OBJECT_SERVICE_URL;
	}
	/**
	 * @param versioningServiceWsdlUrl the versioningServiceWsdlUrl to set
	 */
	public void setVersioningServiceWsdlUrl(String versioningServiceWsdlUrl) {
		this.versioningServiceWsdlUrl = versioningServiceWsdlUrl + "/" + CmisWSBindingWsdlUrl.VERSIONING_SERVICE_URL;
	}
	/**
	 * @param discoveryServiceWsdlUrl the discoveryServiceWsdlUrl to set
	 */
	public void setDiscoveryServiceWsdlUrl(String discoveryServiceWsdlUrl) {
		this.discoveryServiceWsdlUrl = discoveryServiceWsdlUrl + "/" + CmisWSBindingWsdlUrl.DISCOVERY_SERVICE_URL;
	}
	/**
	 * @param relationshipServiceWsdlUrl the relationshipServiceWsdlUrl to set
	 */
	public void setRelationshipServiceWsdlUrl(String relationshipServiceWsdlUrl) {
		this.relationshipServiceWsdlUrl = relationshipServiceWsdlUrl + "/" + CmisWSBindingWsdlUrl.RELATIONSHIP_SERVICE_URL;
	}
	/**
	 * @param multiFilingServiceWsdlUrl the multiFilingServiceWsdlUrl to set
	 */
	public void setMultiFilingServiceWsdlUrl(String multiFilingServiceWsdlUrl) {
		this.multiFilingServiceWsdlUrl = multiFilingServiceWsdlUrl + "/" + CmisWSBindingWsdlUrl.MULTIFILING_SERVICE_URL;
	}
	/**
	 * @param policyServiceWsdlUrl the policyServiceWsdlUrl to set
	 */
	public void setPolicyServiceWsdlUrl(String policyServiceWsdlUrl) {
		this.policyServiceWsdlUrl = policyServiceWsdlUrl + "/" + CmisWSBindingWsdlUrl.POLICY_SERVICE_URL;
	}
	/**
	 * @param aclServiceWsdlUrl the aclServiceWsdlUrl to set
	 */
	public void setAclServiceWsdlUrl(String aclServiceWsdlUrl) {
		this.aclServiceWsdlUrl = aclServiceWsdlUrl + "/" + CmisWSBindingWsdlUrl.ACL_SERVICE_URL;
	}
	
	@Override
	public boolean createConnection() throws AsiaException {
		logger.debug("createConnection - setting connection parameters");
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(SessionParameter.USER, user);
		parameters.put(SessionParameter.PASSWORD, password);		
		parameters.put(SessionParameter.WEBSERVICES_REPOSITORY_SERVICE, repositoryServiceUrl);
		parameters.put(SessionParameter.WEBSERVICES_NAVIGATION_SERVICE, navigationServiceWsdlUrl);
		parameters.put(SessionParameter.WEBSERVICES_OBJECT_SERVICE, objectServiceWsdlUrl);
		parameters.put(SessionParameter.WEBSERVICES_VERSIONING_SERVICE, versioningServiceWsdlUrl);
		parameters.put(SessionParameter.WEBSERVICES_DISCOVERY_SERVICE, discoveryServiceWsdlUrl);
		parameters.put(SessionParameter.WEBSERVICES_RELATIONSHIP_SERVICE, relationshipServiceWsdlUrl);
		parameters.put(SessionParameter.WEBSERVICES_MULTIFILING_SERVICE, multiFilingServiceWsdlUrl);
		parameters.put(SessionParameter.WEBSERVICES_POLICY_SERVICE, policyServiceWsdlUrl);
		parameters.put(SessionParameter.WEBSERVICES_ACL_SERVICE, aclServiceWsdlUrl);
		//parameters.put(SessionParameter.BINDING_SPI_CLASS, bindingSPIType);
		parameters.put(SessionParameter.BINDING_TYPE, BindingType.WEBSERVICES.value());
		//parameters.put(SessionParameter.AUTHENTICATION_PROVIDER_CLASS, "");
		// TODO: Authentication provider must extend org.apache.chemistry.opencmis.client.provider.spi.AbstractAuthenticationProvider and override getHTTPHeaders and getSOAPHeaders 
		//parameters.put(SessionParameter.REPOSITORY_ID, "");
		
		SessionFactory factory = null;
		List<Repository> repositories = null;
		try {
			factory = SessionFactoryImpl.newInstance();
			try {
				repositories = factory.getRepositories(parameters);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw e;
			}
			logger.debug("createConnection - Retrieved "+ repositories.size() + " repository: got the first one '" + repositories.get(0).getName() + "'");
			if( repositories != null && repositories.size() > 0 ) {
				parameters.put(SessionParameter.REPOSITORY_ID, repositories.get(0).getId());
			}
			session = factory.createSession(parameters);
			session.getDefaultContext().setCacheEnabled(true);		
		} catch (Exception e) {
			logger.error("createConnection - Bad connector settings. ");
			throw new AsiaException(UploadMulticanaleErrorCodeEnums.TCH_ECM_ERROR.getErrorCode(), "ECM error: " + e.getMessage());
		}		
		logger.debug("createConnection - session established");
		
		return true;
	}
	
	/**
	 * Convert an InputStream returning an empty string if InputStream is empty
	 * @param is InputStream
	 * @return The converted string
	 */
	protected static String convertStreamToString(InputStream is) {
		Scanner s = new Scanner(is, "UTF-8").useDelimiter("\\A");
		return (s.hasNext() ? s.next() : "");
	}
}
