package it.bmed.arch.uploadMulticanale.be.service.cmis;

import it.bmed.asia.log.Logger;
import it.bmed.asia.log.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.springframework.beans.factory.InitializingBean;

public class BeInjectHandler implements SOAPHandler<SOAPMessageContext>, InitializingBean {

	protected static Logger log = LoggerFactory.getLogger(BeInjectHandler.class);

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		SOAPMessage soap = ((SOAPMessageContext) context).getMessage();
		try {
			soap.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "ISO-8859");
//			try {
//				log.debug("@@@@@@@ {} ", soap.getSOAPBody().getValue());
//			} catch (Exception e) {
//			}
			String output = logToSystemOut(context);
			log.debug("OUTPUT OSB {} ", output);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
//		String output = logToSystemOut(context);
		return true;
	}

	@Override
	public void close(MessageContext context) {
		log.debug("Client : close()......");
	}

	@Override
	public Set<QName> getHeaders() {
		log.debug("Client : getHeaders()......");
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ inizializzazione QarcInjectHandler");
	}

	/*
	 * Check the MESSAGE_OUTBOUND_PROPERTY in the context to see if this is an outgoing or incoming message. Write a brief message to the print stream and
	 * output the message. The writeTo() method can throw SOAPException or IOException
	 */
	private String logToSystemOut(SOAPMessageContext smc) {
		// Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// if (outboundProperty.booleanValue()) {
		// out.println("\n \n Outbound message:");
		// } else {
		// out.println("\n \n Inbound message:");
		// }

		SOAPMessage message = smc.getMessage();
		OutputStream output = new OutputStream() {
			private StringBuilder string = new StringBuilder();

			@Override
			public void write(int b) throws IOException {
				this.string.append((char) b);
			}

			public String toString() {
				return this.string.toString();
			}
		};

		try {

			message.writeTo(output);
			// log.debug("LOGGING SOAP MESSAGE {} ", output.toString());
			// out.println("\n \n "); // just to add a newline
		} catch (Exception e) {
			// out.println("Exception in handler: " + e);
			log.info("skipped");
		}
		return output.toString();
	}

}
