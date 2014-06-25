package it.bmed.arch.uploadMulticanale.be.api;

public enum ECMSource {

	NTERNET_BANKING(1),PORTALE_DI_SEDE(2),RETE_DI_VENDITA(3);
	
	private Integer value;
	
	private ECMSource(Integer value) {
        this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}

}

