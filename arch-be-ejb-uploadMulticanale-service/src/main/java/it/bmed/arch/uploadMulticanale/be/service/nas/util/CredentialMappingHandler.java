package it.bmed.arch.uploadMulticanale.be.service.nas.util;

public class CredentialMappingHandler {
    private CredentialMappingHandler() {
        super();
    }
    
    public static oracle.security.jps.service.credstore.PasswordCredential getCredentialsFromCSF(final String mapName,
                                                                                                      final String csfKey) {
            oracle.security.jps.service.credstore.PasswordCredential passwordCredential = null;
            try {
                if (csfKey != null) {
                    final oracle.security.jps.service.credstore.CredentialStore credStore = getCredStore();
                    if (credStore != null) {
                        System.out.println(credStore.getName());
                        passwordCredential =
                                (oracle.security.jps.service.credstore.PasswordCredential)java.security.AccessController.doPrivileged(new java.security.PrivilegedExceptionAction<oracle.security.jps.service.credstore.Credential>() {
                                    public oracle.security.jps.service.credstore.Credential run() throws Exception {
                                        return credStore.getCredential(mapName, csfKey);
                                    }
                                });
                    } else {
                        System.out.println("failure obtaining csf credentials");
                    }
                }
            } catch (final java.security.PrivilegedActionException ex) {
                System.out.println(ex.getMessage());
            } catch (final oracle.security.jps.JpsException jpse) {
                System.out.println(jpse.getMessage());
            }
            return passwordCredential;
        }
    private static oracle.security.jps.service.credstore.CredentialStore getCredStore() throws oracle.security.jps.JpsException {
           oracle.security.jps.service.credstore.CredentialStore csfStore;
           oracle.security.jps.service.credstore.CredentialStore appCsfStore =
               null;
           oracle.security.jps.service.credstore.CredentialStore systemCsfStore =
               null;

           final oracle.security.jps.internal.api.runtime.ServerContextFactory factory =
               (oracle.security.jps.internal.api.runtime.ServerContextFactory)oracle.security.jps.JpsContextFactory.getContextFactory();

           final oracle.security.jps.JpsContext jpsCtxSystemDefault =
               factory.getContext(oracle.security.jps.internal.api.runtime.ServerContextFactory.Scope.SYSTEM);

           final oracle.security.jps.JpsContext jpsCtxAppDefault =
               factory.getContext(oracle.security.jps.internal.api.runtime.ServerContextFactory.Scope.APPLICATION);

           appCsfStore =
                   (jpsCtxAppDefault != null) ? jpsCtxAppDefault.getServiceInstance(oracle.security.jps.service.credstore.CredentialStore.class) : null;

           if (appCsfStore == null) {
               systemCsfStore =
                       jpsCtxSystemDefault.getServiceInstance(oracle.security.jps.service.credstore.CredentialStore.class);
               csfStore = systemCsfStore;
           } else {
               //use Credential Store defined in app-level jps-config.xml
               csfStore = appCsfStore;
           }
           return csfStore;
       }
}

