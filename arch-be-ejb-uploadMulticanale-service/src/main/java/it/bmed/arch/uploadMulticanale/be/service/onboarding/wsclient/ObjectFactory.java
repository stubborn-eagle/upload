
package it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetNewTokenResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getNewTokenResponse");
    private final static QName _AssertAuthorization_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "assertAuthorization");
    private final static QName _CreateDossierResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "createDossierResponse");
    private final static QName _GetDossierStatusResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getDossierStatusResponse");
    private final static QName _AddDocumentsExResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "addDocumentsExResponse");
    private final static QName _GetDossierStatus_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getDossierStatus");
    private final static QName _IdentityAssertion_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion", "identity-assertion");
    private final static QName _GetNewToken_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getNewToken");
    private final static QName _GetDossiersByBusinessIdResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getDossiersByBusinessIdResponse");
    private final static QName _AssertIdentityResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "assertIdentityResponse");
    private final static QName _GetDossier_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getDossier");
    private final static QName _CreateDossier_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "createDossier");
    private final static QName _AssertAuthorizationResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "assertAuthorizationResponse");
    private final static QName _AddDocumentsEx_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "addDocumentsEx");
    private final static QName _GetWebidServiceInfoResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getWebidServiceInfoResponse");
    private final static QName _OnboardingException_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding/model", "onboarding-exception");
    private final static QName _CadesSignResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "cadesSignResponse");
    private final static QName _CadesSign_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "cadesSign");
    private final static QName _AddDocumentsResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "addDocumentsResponse");
    private final static QName _Person_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding/model", "person");
    private final static QName _GetWebidServiceInfo_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getWebidServiceInfo");
    private final static QName _AssertIdentity_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "assertIdentity");
    private final static QName _AddDocuments_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "addDocuments");
    private final static QName _GetDossierResponse_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getDossierResponse");
    private final static QName _GetDossiersByBusinessId_QNAME = new QName("http://www.infocert.it/legalbus/cop/onboarding", "getDossiersByBusinessId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DocumentInfo }
     * 
     */
    public DocumentInfo createDocumentInfo() {
        return new DocumentInfo();
    }

    /**
     * Create an instance of {@link ArchivingPolicy }
     * 
     */
    public ArchivingPolicy createArchivingPolicy() {
        return new ArchivingPolicy();
    }

    /**
     * Create an instance of {@link SignerInfo }
     * 
     */
    public SignerInfo createSignerInfo() {
        return new SignerInfo();
    }

    /**
     * Create an instance of {@link DossierInfo }
     * 
     */
    public DossierInfo createDossierInfo() {
        return new DossierInfo();
    }

    /**
     * Create an instance of {@link SignaturePolicy }
     * 
     */
    public SignaturePolicy createSignaturePolicy() {
        return new SignaturePolicy();
    }

    /**
     * Create an instance of {@link DossierResultSet }
     * 
     */
    public DossierResultSet createDossierResultSet() {
        return new DossierResultSet();
    }

    /**
     * Create an instance of {@link Dossier }
     * 
     */
    public Dossier createDossier() {
        return new Dossier();
    }

    /**
     * Create an instance of {@link DossierCreationInfo }
     * 
     */
    public DossierCreationInfo createDossierCreationInfo() {
        return new DossierCreationInfo();
    }

    /**
     * Create an instance of {@link IdentityAssertion }
     * 
     */
    public IdentityAssertion createIdentityAssertion() {
        return new IdentityAssertion();
    }

    /**
     * Create an instance of {@link Statement }
     * 
     */
    public Statement createStatement() {
        return new Statement();
    }

    /**
     * Create an instance of {@link Claimer }
     * 
     */
    public Claimer createClaimer() {
        return new Claimer();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link DossierRecord }
     * 
     */
    public DossierRecord createDossierRecord() {
        return new DossierRecord();
    }

    /**
     * Create an instance of {@link WebidServiceInfo }
     * 
     */
    public WebidServiceInfo createWebidServiceInfo() {
        return new WebidServiceInfo();
    }

    /**
     * Create an instance of {@link Rao }
     * 
     */
    public Rao createRao() {
        return new Rao();
    }

    /**
     * Create an instance of {@link IdentityDocumentData }
     * 
     */
    public IdentityDocumentData createIdentityDocumentData() {
        return new IdentityDocumentData();
    }

    /**
     * Create an instance of {@link Attribute }
     * 
     */
    public Attribute createAttribute() {
        return new Attribute();
    }

    /**
     * Create an instance of {@link PersonalData }
     * 
     */
    public PersonalData createPersonalData() {
        return new PersonalData();
    }

    /**
     * Create an instance of {@link DossierActionResult }
     * 
     */
    public DossierActionResult createDossierActionResult() {
        return new DossierActionResult();
    }

    /**
     * Create an instance of {@link SignatureFieldInfo }
     * 
     */
    public SignatureFieldInfo createSignatureFieldInfo() {
        return new SignatureFieldInfo();
    }

    /**
     * Create an instance of {@link Certificate }
     * 
     */
    public Certificate createCertificate() {
        return new Certificate();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link DossierStatus }
     * 
     */
    public DossierStatus createDossierStatus() {
        return new DossierStatus();
    }

    /**
     * Create an instance of {@link Signer }
     * 
     */
    public Signer createSigner() {
        return new Signer();
    }

    /**
     * Create an instance of {@link Token }
     * 
     */
    public Token createToken() {
        return new Token();
    }

    /**
     * Create an instance of {@link PositionSignatureField }
     * 
     */
    public PositionSignatureField createPositionSignatureField() {
        return new PositionSignatureField();
    }

    /**
     * Create an instance of {@link LegalId }
     * 
     */
    public LegalId createLegalId() {
        return new LegalId();
    }

    /**
     * Create an instance of {@link it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents }
     * 
     */
    public it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents createDocuments() {
        return new it.bmed.arch.uploadMulticanale.be.service.onboarding.wsclient.Documents();
    }

    /**
     * Create an instance of {@link DocumentsInfo }
     * 
     */
    public DocumentsInfo createDocumentsInfo() {
        return new DocumentsInfo();
    }

    /**
     * Create an instance of {@link KeywordSignatureField }
     * 
     */
    public KeywordSignatureField createKeywordSignatureField() {
        return new KeywordSignatureField();
    }

    /**
     * Create an instance of {@link Content }
     * 
     */
    public Content createContent() {
        return new Content();
    }

    /**
     * Create an instance of {@link ContactDetails }
     * 
     */
    public ContactDetails createContactDetails() {
        return new ContactDetails();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link SignatureField }
     * 
     */
    public SignatureField createSignatureField() {
        return new SignatureField();
    }

    /**
     * Create an instance of {@link DocumentPolicy }
     * 
     */
    public DocumentPolicy createDocumentPolicy() {
        return new DocumentPolicy();
    }

    /**
     * Create an instance of {@link CompositionPolicy }
     * 
     */
    public CompositionPolicy createCompositionPolicy() {
        return new CompositionPolicy();
    }

    /**
     * Create an instance of {@link ClauseResult }
     * 
     */
    public ClauseResult createClauseResult() {
        return new ClauseResult();
    }

    /**
     * Create an instance of {@link CreateDossier }
     * 
     */
    public CreateDossier createCreateDossier() {
        return new CreateDossier();
    }

    /**
     * Create an instance of {@link GetDossier }
     * 
     */
    public GetDossier createGetDossier() {
        return new GetDossier();
    }

    /**
     * Create an instance of {@link GetDossiersByBusinessId }
     * 
     */
    public GetDossiersByBusinessId createGetDossiersByBusinessId() {
        return new GetDossiersByBusinessId();
    }

    /**
     * Create an instance of {@link AssertAuthorizationResponse }
     * 
     */
    public AssertAuthorizationResponse createAssertAuthorizationResponse() {
        return new AssertAuthorizationResponse();
    }

    /**
     * Create an instance of {@link AddDocumentsEx }
     * 
     */
    public AddDocumentsEx createAddDocumentsEx() {
        return new AddDocumentsEx();
    }

    /**
     * Create an instance of {@link GetWebidServiceInfoResponse }
     * 
     */
    public GetWebidServiceInfoResponse createGetWebidServiceInfoResponse() {
        return new GetWebidServiceInfoResponse();
    }

    /**
     * Create an instance of {@link CadesSignResponse }
     * 
     */
    public CadesSignResponse createCadesSignResponse() {
        return new CadesSignResponse();
    }

    /**
     * Create an instance of {@link GetNewTokenResponse }
     * 
     */
    public GetNewTokenResponse createGetNewTokenResponse() {
        return new GetNewTokenResponse();
    }

    /**
     * Create an instance of {@link CreateDossierResponse }
     * 
     */
    public CreateDossierResponse createCreateDossierResponse() {
        return new CreateDossierResponse();
    }

    /**
     * Create an instance of {@link AssertAuthorization }
     * 
     */
    public AssertAuthorization createAssertAuthorization() {
        return new AssertAuthorization();
    }

    /**
     * Create an instance of {@link CadesSign }
     * 
     */
    public CadesSign createCadesSign() {
        return new CadesSign();
    }

    /**
     * Create an instance of {@link GetDossierStatusResponse }
     * 
     */
    public GetDossierStatusResponse createGetDossierStatusResponse() {
        return new GetDossierStatusResponse();
    }

    /**
     * Create an instance of {@link AddDocumentsExResponse }
     * 
     */
    public AddDocumentsExResponse createAddDocumentsExResponse() {
        return new AddDocumentsExResponse();
    }

    /**
     * Create an instance of {@link AddDocumentsResponse }
     * 
     */
    public AddDocumentsResponse createAddDocumentsResponse() {
        return new AddDocumentsResponse();
    }

    /**
     * Create an instance of {@link GetWebidServiceInfo }
     * 
     */
    public GetWebidServiceInfo createGetWebidServiceInfo() {
        return new GetWebidServiceInfo();
    }

    /**
     * Create an instance of {@link AssertIdentity }
     * 
     */
    public AssertIdentity createAssertIdentity() {
        return new AssertIdentity();
    }

    /**
     * Create an instance of {@link AddDocuments }
     * 
     */
    public AddDocuments createAddDocuments() {
        return new AddDocuments();
    }

    /**
     * Create an instance of {@link GetDossierResponse }
     * 
     */
    public GetDossierResponse createGetDossierResponse() {
        return new GetDossierResponse();
    }

    /**
     * Create an instance of {@link GetNewToken }
     * 
     */
    public GetNewToken createGetNewToken() {
        return new GetNewToken();
    }

    /**
     * Create an instance of {@link GetDossiersByBusinessIdResponse }
     * 
     */
    public GetDossiersByBusinessIdResponse createGetDossiersByBusinessIdResponse() {
        return new GetDossiersByBusinessIdResponse();
    }

    /**
     * Create an instance of {@link AssertIdentityResponse }
     * 
     */
    public AssertIdentityResponse createAssertIdentityResponse() {
        return new AssertIdentityResponse();
    }

    /**
     * Create an instance of {@link GetDossierStatus }
     * 
     */
    public GetDossierStatus createGetDossierStatus() {
        return new GetDossierStatus();
    }

    /**
     * Create an instance of {@link DocumentInfo.KeywordSignatureFields }
     * 
     */
    public DocumentInfo.KeywordSignatureFields createDocumentInfoKeywordSignatureFields() {
        return new DocumentInfo.KeywordSignatureFields();
    }

    /**
     * Create an instance of {@link ArchivingPolicy.Attributes }
     * 
     */
    public ArchivingPolicy.Attributes createArchivingPolicyAttributes() {
        return new ArchivingPolicy.Attributes();
    }

    /**
     * Create an instance of {@link SignerInfo.Clauses }
     * 
     */
    public SignerInfo.Clauses createSignerInfoClauses() {
        return new SignerInfo.Clauses();
    }

    /**
     * Create an instance of {@link DossierInfo.Signers }
     * 
     */
    public DossierInfo.Signers createDossierInfoSigners() {
        return new DossierInfo.Signers();
    }

    /**
     * Create an instance of {@link DossierInfo.Documents }
     * 
     */
    public DossierInfo.Documents createDossierInfoDocuments() {
        return new DossierInfo.Documents();
    }

    /**
     * Create an instance of {@link SignaturePolicy.SignatureFields }
     * 
     */
    public SignaturePolicy.SignatureFields createSignaturePolicySignatureFields() {
        return new SignaturePolicy.SignatureFields();
    }

    /**
     * Create an instance of {@link SignaturePolicy.KeywordSignatureFields }
     * 
     */
    public SignaturePolicy.KeywordSignatureFields createSignaturePolicyKeywordSignatureFields() {
        return new SignaturePolicy.KeywordSignatureFields();
    }

    /**
     * Create an instance of {@link SignaturePolicy.PositionSignatureFields }
     * 
     */
    public SignaturePolicy.PositionSignatureFields createSignaturePolicyPositionSignatureFields() {
        return new SignaturePolicy.PositionSignatureFields();
    }

    /**
     * Create an instance of {@link DossierResultSet.Dossiers }
     * 
     */
    public DossierResultSet.Dossiers createDossierResultSetDossiers() {
        return new DossierResultSet.Dossiers();
    }

    /**
     * Create an instance of {@link Dossier.Signers }
     * 
     */
    public Dossier.Signers createDossierSigners() {
        return new Dossier.Signers();
    }

    /**
     * Create an instance of {@link Dossier.Documents }
     * 
     */
    public Dossier.Documents createDossierDocuments() {
        return new Dossier.Documents();
    }

    /**
     * Create an instance of {@link DossierCreationInfo.Tokens }
     * 
     */
    public DossierCreationInfo.Tokens createDossierCreationInfoTokens() {
        return new DossierCreationInfo.Tokens();
    }

    /**
     * Create an instance of {@link IdentityAssertion.Statements }
     * 
     */
    public IdentityAssertion.Statements createIdentityAssertionStatements() {
        return new IdentityAssertion.Statements();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getNewTokenResponse")
    public JAXBElement<GetNewTokenResponse> createGetNewTokenResponse(GetNewTokenResponse value) {
        return new JAXBElement<GetNewTokenResponse>(_GetNewTokenResponse_QNAME, GetNewTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssertAuthorization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "assertAuthorization")
    public JAXBElement<AssertAuthorization> createAssertAuthorization(AssertAuthorization value) {
        return new JAXBElement<AssertAuthorization>(_AssertAuthorization_QNAME, AssertAuthorization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDossierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "createDossierResponse")
    public JAXBElement<CreateDossierResponse> createCreateDossierResponse(CreateDossierResponse value) {
        return new JAXBElement<CreateDossierResponse>(_CreateDossierResponse_QNAME, CreateDossierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDossierStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getDossierStatusResponse")
    public JAXBElement<GetDossierStatusResponse> createGetDossierStatusResponse(GetDossierStatusResponse value) {
        return new JAXBElement<GetDossierStatusResponse>(_GetDossierStatusResponse_QNAME, GetDossierStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDocumentsExResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "addDocumentsExResponse")
    public JAXBElement<AddDocumentsExResponse> createAddDocumentsExResponse(AddDocumentsExResponse value) {
        return new JAXBElement<AddDocumentsExResponse>(_AddDocumentsExResponse_QNAME, AddDocumentsExResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDossierStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getDossierStatus")
    public JAXBElement<GetDossierStatus> createGetDossierStatus(GetDossierStatus value) {
        return new JAXBElement<GetDossierStatus>(_GetDossierStatus_QNAME, GetDossierStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentityAssertion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding/model/identityassertion", name = "identity-assertion")
    public JAXBElement<IdentityAssertion> createIdentityAssertion(IdentityAssertion value) {
        return new JAXBElement<IdentityAssertion>(_IdentityAssertion_QNAME, IdentityAssertion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getNewToken")
    public JAXBElement<GetNewToken> createGetNewToken(GetNewToken value) {
        return new JAXBElement<GetNewToken>(_GetNewToken_QNAME, GetNewToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDossiersByBusinessIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getDossiersByBusinessIdResponse")
    public JAXBElement<GetDossiersByBusinessIdResponse> createGetDossiersByBusinessIdResponse(GetDossiersByBusinessIdResponse value) {
        return new JAXBElement<GetDossiersByBusinessIdResponse>(_GetDossiersByBusinessIdResponse_QNAME, GetDossiersByBusinessIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssertIdentityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "assertIdentityResponse")
    public JAXBElement<AssertIdentityResponse> createAssertIdentityResponse(AssertIdentityResponse value) {
        return new JAXBElement<AssertIdentityResponse>(_AssertIdentityResponse_QNAME, AssertIdentityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDossier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getDossier")
    public JAXBElement<GetDossier> createGetDossier(GetDossier value) {
        return new JAXBElement<GetDossier>(_GetDossier_QNAME, GetDossier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDossier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "createDossier")
    public JAXBElement<CreateDossier> createCreateDossier(CreateDossier value) {
        return new JAXBElement<CreateDossier>(_CreateDossier_QNAME, CreateDossier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssertAuthorizationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "assertAuthorizationResponse")
    public JAXBElement<AssertAuthorizationResponse> createAssertAuthorizationResponse(AssertAuthorizationResponse value) {
        return new JAXBElement<AssertAuthorizationResponse>(_AssertAuthorizationResponse_QNAME, AssertAuthorizationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDocumentsEx }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "addDocumentsEx")
    public JAXBElement<AddDocumentsEx> createAddDocumentsEx(AddDocumentsEx value) {
        return new JAXBElement<AddDocumentsEx>(_AddDocumentsEx_QNAME, AddDocumentsEx.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebidServiceInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getWebidServiceInfoResponse")
    public JAXBElement<GetWebidServiceInfoResponse> createGetWebidServiceInfoResponse(GetWebidServiceInfoResponse value) {
        return new JAXBElement<GetWebidServiceInfoResponse>(_GetWebidServiceInfoResponse_QNAME, GetWebidServiceInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Error }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding/model", name = "onboarding-exception")
    public JAXBElement<Error> createOnboardingException(Error value) {
        return new JAXBElement<Error>(_OnboardingException_QNAME, Error.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadesSignResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "cadesSignResponse")
    public JAXBElement<CadesSignResponse> createCadesSignResponse(CadesSignResponse value) {
        return new JAXBElement<CadesSignResponse>(_CadesSignResponse_QNAME, CadesSignResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadesSign }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "cadesSign")
    public JAXBElement<CadesSign> createCadesSign(CadesSign value) {
        return new JAXBElement<CadesSign>(_CadesSign_QNAME, CadesSign.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDocumentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "addDocumentsResponse")
    public JAXBElement<AddDocumentsResponse> createAddDocumentsResponse(AddDocumentsResponse value) {
        return new JAXBElement<AddDocumentsResponse>(_AddDocumentsResponse_QNAME, AddDocumentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding/model", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebidServiceInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getWebidServiceInfo")
    public JAXBElement<GetWebidServiceInfo> createGetWebidServiceInfo(GetWebidServiceInfo value) {
        return new JAXBElement<GetWebidServiceInfo>(_GetWebidServiceInfo_QNAME, GetWebidServiceInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssertIdentity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "assertIdentity")
    public JAXBElement<AssertIdentity> createAssertIdentity(AssertIdentity value) {
        return new JAXBElement<AssertIdentity>(_AssertIdentity_QNAME, AssertIdentity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDocuments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "addDocuments")
    public JAXBElement<AddDocuments> createAddDocuments(AddDocuments value) {
        return new JAXBElement<AddDocuments>(_AddDocuments_QNAME, AddDocuments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDossierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getDossierResponse")
    public JAXBElement<GetDossierResponse> createGetDossierResponse(GetDossierResponse value) {
        return new JAXBElement<GetDossierResponse>(_GetDossierResponse_QNAME, GetDossierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDossiersByBusinessId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.infocert.it/legalbus/cop/onboarding", name = "getDossiersByBusinessId")
    public JAXBElement<GetDossiersByBusinessId> createGetDossiersByBusinessId(GetDossiersByBusinessId value) {
        return new JAXBElement<GetDossiersByBusinessId>(_GetDossiersByBusinessId_QNAME, GetDossiersByBusinessId.class, null, value);
    }

}
