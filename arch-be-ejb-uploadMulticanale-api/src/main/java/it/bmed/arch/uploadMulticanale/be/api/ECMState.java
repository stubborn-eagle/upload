package it.bmed.arch.uploadMulticanale.be.api;

public enum ECMState {

	INSERTED(1), PENDING(2), MOVED(3), DELETED(4), ERROR(5);

	private Integer value;

	private ECMState(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
