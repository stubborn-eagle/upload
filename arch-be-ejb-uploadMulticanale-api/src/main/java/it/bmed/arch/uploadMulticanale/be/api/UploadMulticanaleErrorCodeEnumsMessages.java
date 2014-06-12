package it.bmed.arch.uploadMulticanale.be.api;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class UploadMulticanaleErrorCodeEnumsMessages {
	
    private static final String BUNDLE_NAME = "it.bmed.arch.uploadMulticanale.be.api.UploadMulticanaleErrorCodeEnumsMessages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);    
    
    
    public UploadMulticanaleErrorCodeEnumsMessages() {		
	}
    
    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
    
   
    
    
    
    
    
    
}
