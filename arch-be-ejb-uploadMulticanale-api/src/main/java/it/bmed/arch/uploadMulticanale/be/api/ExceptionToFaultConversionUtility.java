package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.exception.*;
import it.bmed.asia.exception.jaxws.SystemFault;
import it.bmed.schema.common.fault.v1.*;

public class ExceptionToFaultConversionUtility {
	
	public static SystemFault toSystemFault(ApplicationException technicalException) {
		
		SystemFault systemFault;
		
		SystemFaultType systemFaultType = new SystemFaultType();
		systemFaultType.setCodice(technicalException.getErrorCode());
		systemFaultType.setMessaggio(technicalException.getErrorDescription());
		systemFault = new SystemFault(technicalException.getErrorDescription(), systemFaultType, technicalException);

		return systemFault;
	}
}