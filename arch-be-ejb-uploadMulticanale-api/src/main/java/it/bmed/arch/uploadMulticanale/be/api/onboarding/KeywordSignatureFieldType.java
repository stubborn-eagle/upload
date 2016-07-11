package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "KeywordSignatureFieldType")
public class KeywordSignatureFieldType implements Serializable {

	private static final long serialVersionUID = 1L;
	private String reason;
	private String location;
	private String signerId;
	private String keyword;
	private int offsetX;
	private int offsetY;
	private int width;
	private int height;
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
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
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * @return the offsetX
	 */
	public int getOffsetX() {
		return offsetX;
	}
	/**
	 * @param offsetX the offsetX to set
	 */
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	/**
	 * @return the offsetY
	 */
	public int getOffsetY() {
		return offsetY;
	}
	/**
	 * @param offsetY the offsetY to set
	 */
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
