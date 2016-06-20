package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

public class Document implements Serializable{

	private static final long serialVersionUID = 1L;
	private String signerId;
 	private String id;
 	private String type;
 	private DocumentPolicy policy;
 	private CompositionPolicy compositionPolicy;
 	private SignaturePolicy signaturePolicy;
 	private ArchivingPolicy archivingPolicy;
	/**
	 * @return the signerId
	 */
	public String getSignerId() {
		return signerId;
	}
	/**
	 * @param signerId the signerId to set
	 */
	public void setSignerId(String signerId) {
		this.signerId = signerId;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the policy
	 */
	public DocumentPolicy getPolicy() {
		return policy;
	}
	/**
	 * @param policy the policy to set
	 */
	public void setPolicy(DocumentPolicy policy) {
		this.policy = policy;
	}
	/**
	 * @return the compositionPolicy
	 */
	public CompositionPolicy getCompositionPolicy() {
		return compositionPolicy;
	}
	/**
	 * @param compositionPolicy the compositionPolicy to set
	 */
	public void setCompositionPolicy(CompositionPolicy compositionPolicy) {
		this.compositionPolicy = compositionPolicy;
	}
	/**
	 * @return the signaturePolicy
	 */
	public SignaturePolicy getSignaturePolicy() {
		return signaturePolicy;
	}
	/**
	 * @param signaturePolicy the signaturePolicy to set
	 */
	public void setSignaturePolicy(SignaturePolicy signaturePolicy) {
		this.signaturePolicy = signaturePolicy;
	}
	/**
	 * @return the archivingPolicy
	 */
	public ArchivingPolicy getArchivingPolicy() {
		return archivingPolicy;
	}
	/**
	 * @param archivingPolicy the archivingPolicy to set
	 */
	public void setArchivingPolicy(ArchivingPolicy archivingPolicy) {
		this.archivingPolicy = archivingPolicy;
	}

}
