package it.bmed.arch.uploadMulticanale.be.api;

import javax.xml.bind.annotation.XmlElement;

public class SignDocumentAndMoveToFilenetRequest {
	
	private SignDocumentAndMoveToFilenetSignatureDataRequest signatureData;
	private SignDocumentAndMoveToFilenetFilenetRequest filenet;
	private SignDocumentAndMoveToFilenetECMParamRequest ecmParams;
	
	@XmlElement(nillable=true, required=true)
	public SignDocumentAndMoveToFilenetSignatureDataRequest getSignatureData() {
		return signatureData;
	}
	public void setSignatureData(
			SignDocumentAndMoveToFilenetSignatureDataRequest signatureData) {
		this.signatureData = signatureData;
	}
	public SignDocumentAndMoveToFilenetFilenetRequest getFilenet() {
		return filenet;
	}
	public void setFilenet(SignDocumentAndMoveToFilenetFilenetRequest filenet) {
		this.filenet = filenet;
	}
	public SignDocumentAndMoveToFilenetECMParamRequest getEcmParams() {
		return ecmParams;
	}
	public void setEcmParams(SignDocumentAndMoveToFilenetECMParamRequest ecmParams) {
		this.ecmParams = ecmParams;
	}
	
	/*
	 <signDocumentAndMoveToFilenet>
                               <signatureData>                                            
                                              <!--Optional:-->
                                             <domain>?</domain>
                                             <!--Optional:-->
                                             <alias>?</alias>
                                             <!--Optional:-->
                                             <pin>?</pin>
                                             <!--Optional:-->
                                             <otp>?</otp>
                                             <!--Optional:-->
                                             <signers>?</signers>
                               </signatureData>
                               <filenet>
                                             <objectClass></objectClass>
                                             <indices>
                                                             <documentCode>?</documentCode>
                                                             <!--0 or more repetitions:-->
                                                             <index>                                                                            
                                                                             <name>?<name>
                                                                             <values>
                                                                                            <!--1 or more repetitions:-->
                                                                                            <value>?</value>
                                                                             </values>
                                                                             <!-- Optional (default: false) -->
                                                                             <search>?</search>
                                                             </index>
                                             </indices>
                                             <!--Optional:-->
                                             <identificationNumber></identificationNumber>
                                             <!--Optional:-->
                                             <role></role>
                                             <!--Optional:-->
                                             <agency></agency>                                      
                               </filenet>                       
                               <ecmParams>           
             <idFile>?</idFile>
             <!-- Optional: (default: false) -->
                                             <removeFromNAS>?</removeFromNAS>
</ecmParams>                 
                </signDocumentAndMoveToFilenet>
	 * */
}
