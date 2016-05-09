package it.bmed.arch.uploadMulticanale.be.service.onboarding;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.springframework.stereotype.Service;

import it.bmed.arch.uploadMulticanale.be.api.onboarding.ArchivingPolicy;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.Attribute;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.CompositionPolicy;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.Document;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.DocumentPolicy;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.KeywordSignatureField;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.PositionSignatureField;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.SignatureField;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.SignaturePolicy;

@Service
public class OnBoardingMapperImpl implements OnBoardingMapper {

	@Override
	public it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents mapECMDocumentForWSRequest (Document documentoECM, DataSource fileContent) {
		List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document> wsList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document>();
		wsList.add(mapDocumentToWS(documentoECM, fileContent));
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents wsClientListObj = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents();
		wsClientListObj.getDocument().addAll(wsList);
		return wsClientListObj;
	}
	
	
	public it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document mapDocumentToWS (Document document, DataSource fileContent) {
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document();
		
		wsObject.setId(document.getId());
		wsObject.setSignerId(document.getSignerId());
		wsObject.setType(document.getType());
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Content content = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Content();
		content.setData(new DataHandler(fileContent));
		content.setMimeType("application/octet-stream");
		wsObject.setContent(content);
		wsObject.setArchivingPolicy(mapArchivingPolicyToWS(document.getArchivingPolicy()));
		wsObject.setCompositionPolicy(mapCompositionPolicyToWS(document.getCompositionPolicy()));
		wsObject.setPolicy(mapDocumentPolicyToWS(document.getPolicy()));
		wsObject.setSignaturePolicy(mapSignaturePolicyToWS(document.getSignaturePolicy()));

		return wsObject;
	}
	
	private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy mapArchivingPolicyToWS (ArchivingPolicy incomingObject) {
		if (incomingObject == null){
			return null;
		}
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy();
		wsObject.setDocumentClass(incomingObject.getDocumentClass());
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy.Attributes wsAttributes = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy.Attributes();
		List<Attribute> incomingAttributes = incomingObject.getAttributes();
		List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute> wsAttributeList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute>();
		for (Attribute incomingAttribute : incomingAttributes){
			wsAttributeList.add(mapAttributeToWs(incomingAttribute));
		}
		wsAttributes.getAttribute().addAll(wsAttributeList);
		wsObject.setAttributes(wsAttributes);
		return wsObject;
	}
	
	private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute mapAttributeToWs (Attribute incomingObject){
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute();
		wsObject.setName(incomingObject.getName());
		wsObject.setValue(incomingObject.getValue()); 
		return wsObject;
	}
	
	private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.CompositionPolicy mapCompositionPolicyToWS (CompositionPolicy incomingObject) {
		if (incomingObject == null){
			return null;
		}
		
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.CompositionPolicy wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.CompositionPolicy();
		wsObject.setParameters(incomingObject.getParameters());
		wsObject.setTemplateName(incomingObject.getTemplateName());
		return wsObject;
	}
	
	private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.DocumentPolicy mapDocumentPolicyToWS (DocumentPolicy incomingObject) {
		if (incomingObject == null){
			return null;
		}
		
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.DocumentPolicy wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.DocumentPolicy();
		wsObject.setArchive(incomingObject.isArchive());
		wsObject.setCompose(incomingObject.isCompose());
		wsObject.setSign(incomingObject.isSign());
		return wsObject;
	}
	
	private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy mapSignaturePolicyToWS (SignaturePolicy incomingObject) {
		if (incomingObject == null){
			return null;
		}
		
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy();

		List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.KeywordSignatureField> wsKeywordSignatureList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.KeywordSignatureField>();
		List<KeywordSignatureField> aList = incomingObject.getKeywordSignatureFieldList();
		for (KeywordSignatureField keywordSignatureField : aList){
			wsKeywordSignatureList.add(mapKeywordSignatureFieldToWs(keywordSignatureField));
		}
		
		List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.PositionSignatureField> wsPositionSignatureFieldList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.PositionSignatureField>();
		List<PositionSignatureField> bList = incomingObject.getPositionSignatureFieldList();
		for (PositionSignatureField positionSignatureField : bList){
			wsPositionSignatureFieldList.add(mapPositionSignatureFieldToWs(positionSignatureField));
		}
		
		List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField> wsSignatureFieldList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField>();
		List<SignatureField> cList = incomingObject.getSignatureFieldList();
		for (SignatureField signatureField : cList){
			wsSignatureFieldList.add(mapSignatureFieldToWs(signatureField));
		}
		
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.SignatureFields aWs = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.SignatureFields();
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.KeywordSignatureFields bWs = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.KeywordSignatureFields();
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.PositionSignatureFields cWs = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.PositionSignatureFields();
		
		aWs.getSignatureField().addAll(wsSignatureFieldList);
		bWs.getKeywordSignatureField().addAll(wsKeywordSignatureList);
		cWs.getPositionSignatureField().addAll(wsPositionSignatureFieldList);
		wsObject.setKeywordSignatureFields(bWs);
		wsObject.setPositionSignatureFields(cWs);
		wsObject.setSignatureFields(aWs);
		return wsObject;
	}
	
	private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.KeywordSignatureField mapKeywordSignatureFieldToWs (KeywordSignatureField incomingObject){
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.KeywordSignatureField wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.KeywordSignatureField();
		wsObject.setHeight(incomingObject.getHeight());  
		wsObject.setKeyword(incomingObject.getKeyword());  
		wsObject.setLocation(incomingObject.getLocation());  
		wsObject.setOffsetX(incomingObject.getOffsetX());  
		wsObject.setOffsetY(incomingObject.getOffsetY()); 
		wsObject.setReason(incomingObject.getReason()); 
		wsObject.setSignerId(incomingObject.getSignerId());  
		wsObject.setWidth(incomingObject.getWidth());  
		return wsObject;
	}
	
	private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.PositionSignatureField mapPositionSignatureFieldToWs (PositionSignatureField incomingObject){
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.PositionSignatureField wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.PositionSignatureField();
		wsObject.setHeight(incomingObject.getHeight());
		wsObject.setLocation(incomingObject.getLocation());
		wsObject.setName(incomingObject.getName());
		wsObject.setPage(incomingObject.getPage());
		wsObject.setReason(incomingObject.getReason());
		wsObject.setSignerId(incomingObject.getSignerId());
		wsObject.setWidth(incomingObject.getWidth());
		wsObject.setX(incomingObject.getX());
		wsObject.setY(incomingObject.getY());
		return wsObject;
	}
	
	private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField mapSignatureFieldToWs (SignatureField incomingObject){
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField();
		wsObject.setLocation(incomingObject.getLocation());
		wsObject.setName(incomingObject.getName());
		wsObject.setReason(incomingObject.getReason());
		wsObject.setSignerId(incomingObject.getSignerId());
		return wsObject;
	}
}
