package it.bmed.arch.uploadMulticanale.be.api.onboarding;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MoveDocumentParamListType")
public class MoveDocumentParamListType implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<MoveDocumentParamType> moveDocumentParamType;

	/**
	 * @return the moveDocumentParamType
	 */
	public List<MoveDocumentParamType> getMoveDocumentParamType() {
		return moveDocumentParamType;
	}

	/**
	 * @param moveDocumentParamType the moveDocumentParamType to set
	 */
	public void setMoveDocumentParamType(
			List<MoveDocumentParamType> moveDocumentParamType) {
		this.moveDocumentParamType = moveDocumentParamType;
	}


	
	
}
