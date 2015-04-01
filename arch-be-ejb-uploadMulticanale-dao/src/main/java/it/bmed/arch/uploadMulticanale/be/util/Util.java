/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author andrea.perrotta
 *
 */
public class Util {
	public static final String DATE_LOCAL_FORMAT = "dd/MM/yyyy";
	
	public static Date convertLongToDate(long dateInMills){
		Date d = new Date(dateInMills);
		return d;	
	}
	
	public static String formattedDate(Date d){
		SimpleDateFormat sf = new SimpleDateFormat(DATE_LOCAL_FORMAT);
		
		String ritorno = sf.format(d);
		
		return ritorno;
		
	}
}
