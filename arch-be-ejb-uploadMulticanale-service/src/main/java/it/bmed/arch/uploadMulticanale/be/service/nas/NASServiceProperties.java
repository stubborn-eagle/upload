package it.bmed.arch.uploadMulticanale.be.service.nas;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Deprecated
public class NASServiceProperties {
	private static final String BUNDLE_NAME = "it.bmed.arch.uploadMulticanale.be.service.nas.nasservicesettings"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
