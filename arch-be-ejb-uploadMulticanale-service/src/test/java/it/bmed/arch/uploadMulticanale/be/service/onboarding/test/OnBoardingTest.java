/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bmed.arch.uploadMulticanale.be.service.onboarding.test;

import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.*;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.OnBoardingMapper;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocuments;
import it.bmed.arch.uploadMulticanale.be.service.test.AbstractUnitTest;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pierluigi
 */
public class OnBoardingTest extends AbstractUnitTest {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractUnitTest.class);
    
    AddDocumentToDossierInfocertRequestType addDocumentsRequest;
    DataSource fileContent;
    
    MoveDossierIntoFilenetRequestType moveDossietIntoFilenetRequest;
    
    ECMResponse ecmResponse;
    
    it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocumentsResponse responseWS;
    
    @Override
    public void before() throws Exception {
        
        addDocumentsRequest = new AddDocumentToDossierInfocertRequestType();
//        addDocumentsRequest.setCompanyId("companyId");
        addDocumentsRequest.setDossierId("dossierId");
        addDocumentsRequest.setEcmFileId(1);
        byte[] buffer = "File di test".getBytes();
        fileContent = new ByteArrayDataSource(buffer, "application/octet-stream");
        responseWS = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocumentsResponse();
        ecmResponse = new ECMResponse();
        moveDossietIntoFilenetRequest = new MoveDossierIntoFilenetRequestType();
        
    }

    @Test
    public void fullRequestTest(){
        LOG.debug("START - fullRequestTest() ...");
        
        DocumentType document = new DocumentType();
        document.setId("documentId");
        document.setSignerId("SignerId");
        document.setType("type");
                
        DocumentPolicy documentPolicy = new DocumentPolicy();
        documentPolicy.setArchive(true);
        documentPolicy.setCompose(true);
        documentPolicy.setSign(true);
        
        // SET DOCUMENT POLICY
        document.setPolicy(documentPolicy);
        
        ArchivingPolicyType archivingPolicy = new ArchivingPolicyType();
        archivingPolicy.setDocumentClass("documentClass");
        
        List <AttributeType> attributes = new ArrayList <AttributeType>();
        AttributeType attribute = new AttributeType();
        attribute.setName("nomeAttributo");
        attribute.setValue("valoreAttributo");
        attributes.add(attribute);
        
        archivingPolicy.setAttributes(attributes);
        
        // SET ARCHIVING POLICY
        document.setArchivingPolicy(archivingPolicy);
        
        SignaturePolicyType signaturePolicy = new SignaturePolicyType();
        
        List <KeywordSignatureFieldType> keywordSignatureFields = new ArrayList <KeywordSignatureFieldType>();
        KeywordSignatureFieldType keywordSignatureField = new KeywordSignatureFieldType();
        keywordSignatureField.setHeight(10);
        keywordSignatureField.setKeyword("keyword");
        keywordSignatureField.setLocation("location");
        keywordSignatureField.setOffsetX(10);
        keywordSignatureField.setOffsetY(10);
        keywordSignatureField.setReason("reason");
        keywordSignatureField.setSignerId("signerId");
        keywordSignatureField.setWidth(10);
        
        keywordSignatureFields.add(keywordSignatureField);
        signaturePolicy.setKeywordSignatureFieldList(keywordSignatureFields);
        
        List <SignatureFieldType> signatureFields = new ArrayList <SignatureFieldType>();
        SignatureFieldType signatureField = new SignatureFieldType();
        signatureField.setLocation("location");
        signatureField.setName("name");
        signatureField.setReason("reason");
        signatureField.setSignerId("signatureId");
        
        signatureFields.add(signatureField);
        signaturePolicy.setSignatureFieldList(signatureFields);
        
        List <PositionSignatureFieldType> positionSignatureFields = new ArrayList <PositionSignatureFieldType>();
        PositionSignatureFieldType positionSignatureField = new PositionSignatureFieldType();
        positionSignatureField.setHeight(10);
        positionSignatureField.setLocation("location");
        positionSignatureField.setName("name");
        positionSignatureField.setPage(10);
        positionSignatureField.setReason("reason");
        positionSignatureField.setSignerId("signerId");
        positionSignatureField.setWidth(10);
        positionSignatureField.setX(10);
        positionSignatureField.setY(10);
        
        positionSignatureFields.add(positionSignatureField);
        signaturePolicy.setPositionSignatureFieldList(positionSignatureFields);
        
        // SET SIGNATURE POLICY
        document.setSignaturePolicy(signaturePolicy);
        
        CompositionPolicyType compositionPolicy = new CompositionPolicyType();
        compositionPolicy.setParameters("parameter");
        compositionPolicy.setTemplateName("templateName");
        
        // SET COMPOSITION POLICY
        document.setCompositionPolicy(compositionPolicy);
        
        addDocumentsRequest.setDocument(document);
        
        AddDocuments wsClientRequest = OnBoardingMapper.mapUMCRequestToWSRequest(addDocumentsRequest, fileContent, "companyId");
        
        
       Assert.assertEquals("companyId", wsClientRequest.getCompanyId());
        
        LOG.debug("FINISH - fullRequestTest() ...");
    }
    
    @Override
    public void after() throws Exception {
    }
    
}
