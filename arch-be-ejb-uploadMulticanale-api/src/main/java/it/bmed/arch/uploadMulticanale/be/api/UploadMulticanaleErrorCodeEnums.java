package it.bmed.arch.uploadMulticanale.be.api;

import it.bmed.asia.exception.IErrorCode;


public enum UploadMulticanaleErrorCodeEnums implements IErrorCode {
	TCH_AZURE_ERROR(UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_AZURE_ERROR_CODE"), UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_AZURE_ERROR_DESC") ),
	TCH_GENERIC_ERROR(UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_GENERIC_ERROR_CODE"), UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_GENERIC_ERROR_DESC") ),   //$NON-NLS-1$ //$NON-NLS-2$
	BSN_FILE_NOT_EXIST(UploadMulticanaleErrorCodeEnumsMessages.getString("BSN_FILE_NOT_EXIST_CODE"), UploadMulticanaleErrorCodeEnumsMessages.getString("BSN_FILE_NOT_EXIST_DESC") ), //$NON-NLS-1$ //$NON-NLS-2$
	TCH_NAS_ERROR(UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_NAS_ERROR_CODE"), UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_NAS_ERROR_DESC") ), //$NON-NLS-1$ //$NON-NLS-2$
	TCH_ECM_ERROR(UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_ECM_ERROR_CODE"), UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_ECM_ERROR_DESC")), //$NON-NLS-1$ //$NON-NLS-2$       
	TCH_SQL_ERROR(UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_SQL_ERROR_CODE"), UploadMulticanaleErrorCodeEnumsMessages.getString("TCH_SQL_ERROR_DESC") ); //$NON-NLS-1$ //$NON-NLS-2$


	/* TCH_SQL_ERROR_CODE=TCH_UM_002
   	TCH_SQL_ERROR_DESC=SQLException
    TCH_ECM_ERROR_CODE=TCH_UM_003
    TCH_ECM_ERROR_DESC=Errore su ECM
    TCH_NAS_ERROR_CODE=TCH_UM_004
    TCH_NAS_ERROR_DESC=Errore su NAS
    BSN_FILE_NOT_EXIST_CODE=BSN_UM_001
    BSN_FILE_NOT_EXIST_DESC=File non esistente
    TCH_GENERIC_ERROR_CODE=TCH_UM_005
    TCH_GENERIC_ERROR_DESC=Errore Generico  
    TCH_AZURE_ERROR_CODE=TCH_UM_006
    TCH_AZURE_ERROR_DESC=Errore su Azure
	 */





	private final String errorCode;
	private final String description;

	UploadMulticanaleErrorCodeEnums(String errorCode, String description) {
		this.errorCode = errorCode;
		this.description = description;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public LayerErrorCode getLayerErrorCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAppErrorCode() {
		// TODO Auto-generated method stub
		return null;
	}
}


