/**
 * 
 */
package it.bmed.arch.uploadMulticanale.be.util;

import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author andrea.perrotta
 *
 */
public class Util {
	public static final String 	SINO_S = "S";
	public static final String	SINO_N = "N";
	public static final long 	DEFAULT_DATE_01_01_1753 = -6847808400000L;
	public static final String 	DATE_DDMMYYY_WITH_SLASH_REGEX = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
	public static final String 	IMPORTI_SENZA_PUNTO_CON_SENZA_DECIMALI_REGEX = "(^\\d+)(\\,\\d{1,2})?$";
	public static final double 	IMPORTO_DOUBLE_ZERO = 0.00D;
	public static final String 	DEFAULT_DATE_01_01_1753_S = "01/01/1973";
	public static final String 	DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	public static final String 	DEFAULT_TIME_ZONE_ID = "Europe/Rome";
	
	static Logger log = LoggerFactory.getLogger(Util.class);
	
	public static Date convertLongToDate(long dateInMills){
		Date d = new Date(dateInMills);
		return d;	
	}
	
	public static String formattedDate(Date d){
		SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.ITALY);
		
		String ritorno = sf.format(d);
		
		return ritorno;
		
	}
	
	public static long date2Long(String dd, String mm, String aaaa){

		Date d = null;
		long ritorno = DEFAULT_DATE_01_01_1753;
		try {
			DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.ITALY);			
			df.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIME_ZONE_ID));
			d = df.parse(dd+"/"+mm+"/"+aaaa);
			ritorno = d.getTime();
		} catch (Exception e) {
			log.debug("Errore durante la conversione della data ->" + DEFAULT_DATE_FORMAT + ":" + dd+"/"+mm+"/"+aaaa);
		} 
		
		return ritorno;
		
	}
	
	public static long date2Long(String data){

		Date d = null;
		long ritorno = DEFAULT_DATE_01_01_1753;
		try {
			DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.ITALY);
			df.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIME_ZONE_ID));
			long offSet = df.getTimeZone().getDSTSavings();
			d = df.parse(data);
			ritorno = d.getTime()+offSet;
		} catch (Exception e) {
			log.debug("Errore durante la conversione della data ->" + DEFAULT_DATE_FORMAT + ":" + data);
		} 
		
		return ritorno;
		
	}

	
	public static String date2String(long data){

		Date d = new Date(data);
		String ritorno = "";
		try {
			DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.ITALY);
			df.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIME_ZONE_ID));
			ritorno = df.format(d);
		} catch (Exception e) {
			log.debug("Errore durante la conversione della data -> dd/mm/yyyy :" + ritorno);
		} 
		
		return ritorno;
		
	}
	
}
