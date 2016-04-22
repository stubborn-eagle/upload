package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

public class DocumentPolicy implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean compose;
    private boolean sign;
    private boolean archive;
    
	/**
	 * @return the compose
	 */
	public boolean isCompose() {
		return compose;
	}
	/**
	 * @param compose the compose to set
	 */
	public void setCompose(boolean compose) {
		this.compose = compose;
	}
	/**
	 * @return the sign
	 */
	public boolean isSign() {
		return sign;
	}
	/**
	 * @param sign the sign to set
	 */
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	/**
	 * @return the archive
	 */
	public boolean isArchive() {
		return archive;
	}
	/**
	 * @param archive the archive to set
	 */
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
}
