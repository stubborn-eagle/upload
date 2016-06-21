/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bmed.arch.uploadMulticanale.be.service.onboarding.test;

import it.bmed.arch.uploadMulticanale.be.api.ECMRequest;
import it.bmed.arch.uploadMulticanale.be.api.ECMResponse;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.AddDocumentsRequest;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.MoveDossierIntoFilenetRequest;
import it.bmed.arch.uploadMulticanale.be.api.onboarding.*;
import it.bmed.arch.uploadMulticanale.be.service.UploadMulticanaleService;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocuments;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.OnboardingService;
import it.bmed.arch.uploadMulticanale.be.service.test.AbstractUnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author pierluigi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-context.xml"})
public class OnBoardingTest extends AbstractUnitTest {

    AddDocumentsRequest addDocumentsRequest;
    MoveDossierIntoFilenetRequest moveDossietIntoFilenetRequest;
    
    ECMResponse ecmResponse;
    
    it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocumentsResponse responseWS;
    
    @Override
    public void before() throws Exception {
        
        addDocumentsRequest = new AddDocumentsRequest();
        addDocumentsRequest.setCompanyId("companyId");
        addDocumentsRequest.setDossierId("dossierId");
        addDocumentsRequest.setEcmFileId(1);
        
        responseWS = new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.AddDocumentsResponse();
        ecmResponse = new ECMResponse();
        
        moveDossietIntoFilenetRequest = new MoveDossierIntoFilenetRequest();
        
    }

    @Test
    public void fullRequestTest(){
        
        Document document = new Document();
        document.setId("documentId");
        document.setSignerId("SignerId");
        document.setType("type");
                
        DocumentPolicy documentPolicy = new DocumentPolicy();
        documentPolicy.setArchive(true);
        documentPolicy.setCompose(true);
        documentPolicy.setSign(true);
        
        // SET DOCUMENT POLICY
        document.setPolicy(documentPolicy);
        
        ArchivingPolicy archivingPolicy = new ArchivingPolicy();
        archivingPolicy.setDocumentClass("documentClass");
        
        List <Attribute> attributes = new ArrayList <Attribute>();
        Attribute attribute = new Attribute();
        attribute.setName("nomeAttributo");
        attribute.setValue("valoreAttributo");
        attributes.add(attribute);
        
        archivingPolicy.setAttributes(attributes);
        
        // SET ARCHIVING POLICY
        document.setArchivingPolicy(archivingPolicy);
        
        SignaturePolicy signaturePolicy = new SignaturePolicy();
        
        List <KeywordSignatureField> keywordSignatureFields = new ArrayList <KeywordSignatureField>();
        KeywordSignatureField keywordSignatureField = new KeywordSignatureField();
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
        
        List <SignatureField> signatureFields = new ArrayList <SignatureField>();
        SignatureField signatureField = new SignatureField();
        signatureField.setLocation("location");
        signatureField.setName("name");
        signatureField.setReason("reason");
        signatureField.setSignerId("signatureId");
        
        signatureFields.add(signatureField);
        signaturePolicy.setKeywordSignatureFieldList(keywordSignatureFields);
        
        List <PositionSignatureField> positionSignatureFields = new ArrayList <PositionSignatureField>();
        PositionSignatureField positionSignatureField = new PositionSignatureField();
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
        
        CompositionPolicy compositionPolicy = new CompositionPolicy();
        compositionPolicy.setParameters("parameter");
        compositionPolicy.setTemplateName("templateName");
        
        // SET COMPOSITION POLICY
        document.setCompositionPolicy(compositionPolicy);
        
        addDocumentsRequest.setDocument(document);
        
        //AddDocuments parameters = OnBoardingMapper.mapUMCRequestToWSRequest(addDocumentsRequest, );
        
        
    }
    
    @Override
    public void after() throws Exception {
    }
    
}
