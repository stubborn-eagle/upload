package it.bmed.arch.uploadMulticanale.be.service.onboarding;

import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentToDossierInfocertRequestType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.ArchivingPolicyType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.AttributeType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.CompositionPolicyType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.DocumentPolicy;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.DocumentType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.KeywordSignatureFieldType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.PositionSignatureFieldType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.SignatureFieldType;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.SignaturePolicyType;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocuments;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;

public class OnBoardingMapper {

	static public AddDocuments mapUMCRequestToWSRequest (AddDocumentToDossierInfocertRequestType request, DataSource fileContent, String companyId) {
        AddDocuments parameters = new AddDocuments();
		parameters.setCompanyId(companyId);
		parameters.setDossierId(request.getDossierId());
        DocumentType documentoECM = request.getDocument();
		List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document> wsList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document>();
		wsList.add(mapDocumentToWS(documentoECM, fileContent));
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents wsClientListObj = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents();
		wsClientListObj.getDocument().addAll(wsList);
        parameters.setDocuments(wsClientListObj);
		return parameters;
	}
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document mapDocumentToWS (DocumentType document, DataSource fileContent) {
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Document();
		wsObject.setId(document.getId());
		wsObject.setSignerId(document.getSignerId());
		wsObject.setType(document.getType());
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Content content = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Content();
		content.setData(new DataHandler(fileContent));
		content.setMimeType("application/octet-stream");
		wsObject.setContent(content);
		if (document.getArchivingPolicy()!= null)
			wsObject.setArchivingPolicy(mapArchivingPolicyToWS(document.getArchivingPolicy()));
		if (document.getCompositionPolicy()!=null)
			wsObject.setCompositionPolicy(mapCompositionPolicyToWS(document.getCompositionPolicy()));
		if (document.getPolicy() != null)
			wsObject.setPolicy(mapDocumentPolicyToWS(document.getPolicy()));
		if (document.getSignaturePolicy() != null)
			wsObject.setSignaturePolicy(mapSignaturePolicyToWS(document.getSignaturePolicy()));
		return wsObject;
	}
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy mapArchivingPolicyToWS (ArchivingPolicyType incomingObject) {
		if (incomingObject == null){
			return null;
		}
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy();
		wsObject.setDocumentClass(incomingObject.getDocumentClass());
		if (incomingObject.getAttributes() != null && incomingObject.getAttributes().size() > 0){
			it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy.Attributes wsAttributes = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.ArchivingPolicy.Attributes();
			List<AttributeType> incomingAttributes = incomingObject.getAttributes();
			List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute> wsAttributeList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute>();
			for (AttributeType incomingAttribute : incomingAttributes){
				if (incomingAttribute != null)
					wsAttributeList.add(mapAttributeToWs(incomingAttribute));
			}
			wsAttributes.getAttribute().addAll(wsAttributeList);
			wsObject.setAttributes(wsAttributes);
		}
		return wsObject;
	}
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute mapAttributeToWs (AttributeType incomingObject){
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Attribute();
		wsObject.setName(incomingObject.getName());
		wsObject.setValue(incomingObject.getValue()); 
		return wsObject;
	}
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.CompositionPolicy mapCompositionPolicyToWS (CompositionPolicyType incomingObject) {
		if (incomingObject == null){
			return null;
		}
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.CompositionPolicy wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.CompositionPolicy();
		wsObject.setParameters(incomingObject.getParameters());
		wsObject.setTemplateName(incomingObject.getTemplateName());
		return wsObject;
	}
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.DocumentPolicy mapDocumentPolicyToWS (DocumentPolicy incomingObject) {
		if (incomingObject == null){
			return null;
		}
		
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.DocumentPolicy wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.DocumentPolicy();
		wsObject.setArchive(incomingObject.isArchive());
		wsObject.setCompose(incomingObject.isCompose());
		wsObject.setSign(incomingObject.isSign());
		return wsObject;
	}
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy mapSignaturePolicyToWS (SignaturePolicyType incomingObject) {
		if (incomingObject == null){
			return null;
		}

		
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy();
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.SignatureFields aWs = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.SignatureFields();
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.KeywordSignatureFields bWs = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.KeywordSignatureFields();
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.PositionSignatureFields cWs = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignaturePolicy.PositionSignatureFields();

		if (incomingObject.getKeywordSignatureFieldList() != null){
			List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.KeywordSignatureField> wsKeywordSignatureList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.KeywordSignatureField>();
			List<KeywordSignatureFieldType> aList = incomingObject.getKeywordSignatureFieldList();
			for (KeywordSignatureFieldType keywordSignatureField : aList){
				wsKeywordSignatureList.add(mapKeywordSignatureFieldToWs(keywordSignatureField));
			}
			bWs.getKeywordSignatureField().addAll(wsKeywordSignatureList);
		}
		if (incomingObject.getPositionSignatureFieldList() != null){
			List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.PositionSignatureField> wsPositionSignatureFieldList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.PositionSignatureField>();
			List<PositionSignatureFieldType> bList = incomingObject.getPositionSignatureFieldList();
			for (PositionSignatureFieldType positionSignatureField : bList){
				wsPositionSignatureFieldList.add(mapPositionSignatureFieldToWs(positionSignatureField));
			}
			cWs.getPositionSignatureField().addAll(wsPositionSignatureFieldList);
		}
		if (incomingObject.getSignatureFieldList() != null){
			List<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField> wsSignatureFieldList = new ArrayList<it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField>();
			List<SignatureFieldType> cList = incomingObject.getSignatureFieldList();
			for (SignatureFieldType signatureField : cList){
				wsSignatureFieldList.add(mapSignatureFieldToWs(signatureField));
			}
			aWs.getSignatureField().addAll(wsSignatureFieldList);
		}
		wsObject.setKeywordSignatureFields(bWs);
		wsObject.setPositionSignatureFields(cWs);
		wsObject.setSignatureFields(aWs);
		return wsObject;
	}
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.KeywordSignatureField mapKeywordSignatureFieldToWs (KeywordSignatureFieldType incomingObject){
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
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.PositionSignatureField mapPositionSignatureFieldToWs (PositionSignatureFieldType incomingObject){
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
	
	static private it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField mapSignatureFieldToWs (SignatureFieldType incomingObject){
		it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField wsObject = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.SignatureField();
		wsObject.setLocation(incomingObject.getLocation());
		wsObject.setName(incomingObject.getName());
		wsObject.setReason(incomingObject.getReason());
		wsObject.setSignerId(incomingObject.getSignerId());
		return wsObject;
	}
}
