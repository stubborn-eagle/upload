package it.bmed.arch.uploadMulticanale.be.ejbimpl;

public enum GeneratePdfAsynchStatusEnum {

	PENDING("0"), COMPLETED("1"), NOT_FOUND("-1"), ERROR("-2");

	private String value;

	private GeneratePdfAsynchStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
