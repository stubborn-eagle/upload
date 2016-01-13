package it.bmed.arch.uploadMulticanale.be.ejbimpl;

import org.apache.commons.codec.binary.Base64;

import it.bmed.arch.uploadMulticanale.be.api.SignDocumentAndMoveToFilenetRequest;
import it.bmed.arch.uploadMulticanale.be.api.SignDocumentAndMoveToFilenetSignatureDataSigner;
import it.bmed.arch.uploadMulticanale.be.api.SignDocumentAndMoveToFilenetSignatureDataSignerField;
import it.bmed.arch.uploadMulticanale.be.api.SignatureData;

public class SignHelper {

	public static String getXmlFirmatariOsbCades(SignDocumentAndMoveToFilenetRequest request, String hash) {
		StringBuffer result = new StringBuffer();
result.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
result.append("<!DOCTYPE datifirma>");
result.append("<datifirma>");
result.append("	<hash_doc>"+hash+"</hash_doc>");
result.append("	<NDG1>"+convertNullValue(request.getSignatureData().getNdg1())+"</NDG1>");
result.append("	<NDG2>"+convertNullValue(request.getSignatureData().getNdg2())+"</NDG2>");
result.append("	<NDG3>"+convertNullValue(request.getSignatureData().getNdg3())+"</NDG3>");
result.append("	<CODICECLI>"+convertNullValue(request.getSignatureData().getCodClient())+"</CODICECLI>");
result.append("	<CODICEDOC>"+convertNullValue(request.getSignatureData().getCodDocument())+"</CODICEDOC>");
result.append("	<DATARIF>"+convertNullValue(request.getSignatureData().getReferenceDate())+"</DATARIF>");
result.append("	<lista_firmatari>");
if(request.getSignatureData().getSigners()!=null && request.getSignatureData().getSigners().getSigner()!=null){
	for(SignDocumentAndMoveToFilenetSignatureDataSigner signer : request.getSignatureData().getSigners().getSigner()){
result.append("		<firmatario>");
result.append("			<alias>"+convertNullValue(signer.getAlias())+"</alias>");
result.append("			<dominio>"+convertNullValue(signer.getDomain())+"</dominio>");
result.append("			<pin>"+convertNullValue(signer.getPin())+"</pin>");
result.append("			<lista_campi>");
		if(signer.getFields()!=null && signer.getFields().getField()!=null){
			for(SignDocumentAndMoveToFilenetSignatureDataSignerField field : signer.getFields().getField()){
result.append("				<campo>");
result.append("					<nome>"+convertNullValue(field.getName())+"</nome>");
result.append("					<reason>"+convertNullValue(field.getReason())+"</reason>");
result.append("					<location>"+convertNullValue(field.getLocation())+"</location>");
result.append("				</campo>");
			}
		}
result.append("			</lista_campi>");
result.append("		</firmatario>");
	}
}
result.append("	</lista_firmatari>");
result.append("</datifirma>");
		
		return result.toString();
	}

	public static String getXmlFirmatariOsbCadesCustom(String xmlFirmatariOsbCades, SignatureData signatureData) {
		StringBuffer result = new StringBuffer();
result.append("<soapenv:Body xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">");
result.append("	<fir:firmaCADES xmlns:fir=\"http://firma.webservice.ncfr.infocert.it/\">");
result.append("		<documentoDaFirmare>"+Base64.encodeBase64String(xmlFirmatariOsbCades.getBytes())+"</documentoDaFirmare>");
result.append("		<dominio>"+convertNullValue(signatureData.getSignFirmatariDominio())+"</dominio>");
result.append("		<alias>"+convertNullValue(signatureData.getSignFirmatariAlias())+"</alias>");
result.append("		<pin>"+convertNullValue(signatureData.getSignFirmatariPin())+"</pin>");
result.append("		<otp>"+convertNullValue(signatureData.getSignFirmatariOtp())+"</otp>");
result.append("	</fir:firmaCADES>");
result.append("</soapenv:Body>");
		
		return result.toString();
	}
	
	private static String convertNullValue(String rawValue){
		return rawValue!=null?rawValue:"";
	}

}
