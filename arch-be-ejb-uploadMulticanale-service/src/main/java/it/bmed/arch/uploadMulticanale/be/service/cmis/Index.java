package it.bmed.arch.uploadMulticanale.be.service.cmis;


public class Index {
	//ATTRIBUTI DI INDEX
	private String name;
	private String search;
	
	//FIGLIO DI INDEX (NODO)
	private Value value;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}
	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}
	/**
	 * @return the value
	 */
	public Value getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Value value) {
		this.value = value;
	}


	
	
}