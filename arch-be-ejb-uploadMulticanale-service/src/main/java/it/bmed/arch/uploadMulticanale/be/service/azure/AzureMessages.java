package it.bmed.arch.uploadMulticanale.be.service.azure;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class AzureMessages {
	private static final String BUNDLE_NAME = "it.bmed.arch.uploadMulticanale.be.service.azure.azuremessages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private AzureMessages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
