package it.bmed.arch.uploadMulticanale.be.service.cmis;

/**
 * Contains all the URLs to the WSDL for the web service binding used by opencmis to connect with Alfresco CMS  
 * @author donatello.boccaforno
 *
 */
public class CmisWSBindingWsdlUrl {
	public static final String REPOSITORY_SERVICE_URL = "alfresco/cmisws/cmis/services/RepositoryService?wsdl";
	public static final String NAVIGATION_SERVICE_URL = "alfresco/cmisws/cmis/services/NavigationService?wsdl";
	public static final String OBJECT_SERVICE_URL = "alfresco/cmisws/cmis/services/ObjectService?wsdl";
	public static final String VERSIONING_SERVICE_URL = "alfresco/cmisws/cmis/services/VersioningService?wsdl";
	public static final String DISCOVERY_SERVICE_URL = "alfresco/cmisws/cmis/services/DiscoveryService?wsdl";
	public static final String RELATIONSHIP_SERVICE_URL = "alfresco/cmisws/cmis/services/RelationshipService?wsdl";
	public static final String MULTIFILING_SERVICE_URL = "alfresco/cmisws/cmis/services/MultiFilingService?wsdl";
	public static final String POLICY_SERVICE_URL = "alfresco/cmisws/cmis/services/PolicyService?wsdl";
	public static final String ACL_SERVICE_URL = "alfresco/cmisws/cmis/services/ACLService?wsdl";
}
