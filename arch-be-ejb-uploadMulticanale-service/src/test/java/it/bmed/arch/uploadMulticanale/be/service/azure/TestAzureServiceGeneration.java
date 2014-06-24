package it.bmed.arch.uploadMulticanale.be.service.azure;

import static org.junit.Assert.fail;
import it.bmed.arch.uploadMulticanale.be.api.AzureDTO;
import it.bmed.arch.uploadMulticanale.be.api.AzureRequest;
import it.bmed.arch.uploadMulticanale.be.service.azure.exception.InvalidAzureExpirationTimeException;
import it.bmed.asia.exception.AsiaException;
import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

public class TestAzureServiceGeneration {

	private static final String IMAGE = "Penguins.jpg";
	private static final String IB_SFONDI_CONTAINER = "ib-sfondi";
	private static final int EXPIRATIONTIME = 45;
	
	Logger log = LoggerFactory.getLogger(AzureServiceImpl.class);

	private AzureService azureService = null;
	
	@Before
	public void setUp() throws Exception {
		azureService =  new AzureServiceImpl();
	}
	
	@Test
	public void testReadOnlyTokenOneHour() {
		AzureRequest parameters = new AzureRequest();

		GregorianCalendar calendar = new GregorianCalendar(
				TimeZone.getTimeZone("UTC")); //$NON-NLS-1$
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, EXPIRATIONTIME); // Applicable time span is 45 MINUTES
		parameters.setExpirationTime(calendar.getTime());
		parameters.setTargetContainer(IB_SFONDI_CONTAINER);
		parameters.setReadOnly(true);

		try {
			AzureDTO azureDTO = azureService.generateToken(parameters);
			log.info("Generated token with SAS:" + azureDTO.getSAS()
					+ " and Expired Time is: " + azureDTO.getExpiredTime()
					+ " for readonly access to container: '"
					+ azureDTO.getContainer() + "'");
		} catch (AsiaException e) {
			log.error("Error on token generation", e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error on token generation", e);
			e.printStackTrace();
		}
	}

	@Test
	public void testUploadTokenOneHour() {
		AzureRequest parameters = new AzureRequest();

		GregorianCalendar calendar = new GregorianCalendar(
				TimeZone.getTimeZone("UTC")); //$NON-NLS-1$
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, EXPIRATIONTIME); // Applicable time span is 45 MINUTES
		parameters.setExpirationTime(calendar.getTime());
		parameters.setTargetContainer(IB_SFONDI_CONTAINER);
		parameters.setReadOnly(false);

		try {
			AzureDTO azureDTO = azureService.generateToken(parameters);
			log.info("Generated token with SAS:" + azureDTO.getSAS()
					+ " and Expired Time is: " + azureDTO.getExpiredTime()
					+ " for upload access to container: '"
					+ azureDTO.getContainer() + "'");
		} catch (AsiaException e) {
			log.error("Error on token generation", e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error on token generation", e);
			e.printStackTrace();
		}
	}

	@Test
	public void testMultipleUploadTokenOneHour() throws InterruptedException {
		AzureRequest parameters = new AzureRequest();

		for (int i = 0; i < 10; i++) {
			Thread.sleep(500);
			GregorianCalendar calendar = new GregorianCalendar(
					TimeZone.getTimeZone("UTC")); //$NON-NLS-1$
			calendar.setTime(new Date());
			calendar.add(Calendar.MINUTE, EXPIRATIONTIME); // Applicable time span is 45
												// MINUTES
			parameters.setExpirationTime(calendar.getTime());
			parameters.setTargetContainer(IB_SFONDI_CONTAINER);
			parameters.setReadOnly(false);

			try {
				AzureDTO azureDTO = azureService.generateToken(parameters);
				log.info("Generated token with SAS:" + azureDTO.getSAS()
						+ " and Expired Time is: " + azureDTO.getExpiredTime()
						+ " for upload access to container: '"
						+ azureDTO.getContainer() + "'");
			} catch (AsiaException e) {
				log.error("Error on token generation", e);
				e.printStackTrace();
			} catch (Exception e) {
				log.error("Error on token generation", e);
				e.printStackTrace();
			}

		}

	}

	@Test
	public void testMaximumTimeFail() throws InterruptedException {
		AzureRequest parameters = new AzureRequest();

		GregorianCalendar calendar = new GregorianCalendar(
				TimeZone.getTimeZone("UTC")); //$NON-NLS-1$
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, 50); // Applicable time span is 45 MINUTES
		parameters.setExpirationTime(calendar.getTime());
		parameters.setTargetContainer(IB_SFONDI_CONTAINER);
		parameters.setReadOnly(false);

		try {
			azureService.generateToken(parameters);
			fail();
		} 
		 catch (InvalidAzureExpirationTimeException e) {
				log.debug("Received Correct error on token generation", e);
				
				return;
		} 
		catch (AsiaException e) {
			log.error("Received Correct error on token generation", e);
			e.printStackTrace();
			
		} catch (Exception e) {
			log.error("Error on token generation", e.getMessage());
		
		}


	}
	
	@Test
	public void testReadOnlyTokenOneHourSingleBlob() {
		AzureRequest parameters = new AzureRequest();

		GregorianCalendar calendar = new GregorianCalendar(
				TimeZone.getTimeZone("UTC")); //$NON-NLS-1$
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, EXPIRATIONTIME); // Applicable time span is 45 MINUTES
		parameters.setExpirationTime(calendar.getTime());
		parameters.setTargetContainer(IB_SFONDI_CONTAINER);
		parameters.setReadOnly(true);
		parameters.setResourceBlobFile(IMAGE);
		try {
			AzureDTO azureDTO = azureService.generateToken(parameters);
			log.info("Generated token with SAS:" + azureDTO.getSAS()
					+ " and Expired Time is: " + azureDTO.getExpiredTime()
					+ " for readonly access to container: '"
					+ azureDTO.getContainer() + "'");
		} catch (AsiaException e) {
			log.error("Error on token generation", e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error on token generation", e);
			e.printStackTrace();
		}
	}

}
