package it.bmed.arch.uploadMulticanale.be.api;

public enum ECMSource {

	INTERNET_BANKING(1), PORTALE_DI_SEDE(2), RETE_DI_VENDITA(3), LIVE_CYCLE(4), LIVE_CYCLE_DYNAMIC(5), INFOCERT_DOSSIER(6);

	private Integer value;

	private ECMSource(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
