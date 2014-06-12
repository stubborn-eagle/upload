 package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.exception.ApplicationException;
import it.bmed.asia.exception.ExceptionToFaultConversionUtil;
import it.bmed.asia.exception.TechnicalException;
import it.bmed.asia.exception.jaxws.BaseFaultType;
import it.bmed.asia.exception.jaxws.SystemFault;

public class test {

	
	public static void main(String[] args) throws SystemFault {
		
	/*	 System.out.println("UploadMulticanaleErrorCodeEnums.TCH_SQL_ERROR");
	System.out.println(UploadMulticanaleErrorCodeEnums.TCH_SQL_ERROR.getErrorCode());
	  System.out.println(UploadMulticanaleErrorCodeEnums.TCH_SQL_ERROR.getDescription());
		*/
	  
	  try {
		
		  if (true) {
			  System.out.println("--------------fine ");			  
			  throw new Exception("errore");
			
		 }

		 
		  
		
	  } catch (Exception app) {
		  
		  System.out.println("--------------eccc ");
		  
		  
		  TechnicalException	tec =	new TechnicalException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST);
		
		  System.out.println(tec.getErrorCode());
		  System.out.println(tec.getErrorDescription());
		  
		  SystemFault fault = ExceptionToFaultConversionUtil.toFault(tec);		  
		  fault.getFaultInfo().setTechnical(true);
		  System.out.println(fault.getFaultInfo().getCodice());
		  System.out.println(fault.getFaultInfo().getMessaggio());
		  
		  
		  System.out.println("------------ "+fault.getMessage());
		  
		  
		  throw fault;
		  //throw new ApplicationException(UploadMulticanaleErrorCodeEnums.BSN_FILE_NOT_EXIST);
		 
		}
	 
	  
		

	}

}
