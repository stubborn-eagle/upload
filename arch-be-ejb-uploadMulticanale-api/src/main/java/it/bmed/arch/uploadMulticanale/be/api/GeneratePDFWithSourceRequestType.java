package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.api.BaseBeRequest;

import javax.xml.bind.annotation.XmlType;
@XmlType(name="GeneratePDFWithSourceRequestType")
public class GeneratePDFWithSourceRequestType extends BaseBeRequest {

	private static final long serialVersionUID = 1L;
	private String xml;
	private ECMOrigin origin;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MoveRequest [origin=" + origin + ", xml=" + xml + "]";
	}

	/**
	 * @return the xml
	 */
	public String getXml() {
		return xml;
	}

	/**
	 * @param xml the xml to set
	 */
	public void setXml(String xml) {
		this.xml = xml;
	}

	/**
	 * @return the origin
	 */
	public ECMOrigin getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(ECMOrigin origin) {
		this.origin = origin;
	}
	
}
