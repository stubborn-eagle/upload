package it.bmed.arch.uploadMulticanale.be.api;

public enum ECMOrigin {

	INTERNET_BANKING(1), PORTALE_DI_SEDE(2), RETE_DI_VENDITA(3), OTHER_ORIGIN(4);

	private Integer value;

	private ECMOrigin(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
