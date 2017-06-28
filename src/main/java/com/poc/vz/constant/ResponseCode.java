package com.poc.vz.constant;

public interface ResponseCode {

	public static final String CHECK_PROFILE_SUCCESS_CODE="100";
	public static final String CHECK_PROFILE_ERROR_CODE="101";
	public static final String CHECK_PROFILE_ERROR_DESCRIPTION="Profile doesn't exist";
	
	public static final String CREATE_PROFILE_SUCCESS_CODE="200";
	public static final String CREATE_PROFILE_ERROR_CODE="201";
	public static final String CREATE_PROFILE_ERROR_DESCRIPTION="Error in profile creation";
	
	public static final String CREATE_ORDER_JOB_SUCCESS_CODE="300";
	public static final String CREATE_ORDER_JOB_ERROR_CODE="301";
	public static final String CREATE_ORDER_JOB_ERROR_DESCRIPTION="Error in job creation";
	public static final String CREATE_ORDER_JOB_PRODUCT_ERROR_DESCRIPTION="Error in job creation due to product";
	public static final String CREATE_ORDER_JOB_USER_PROFILE_ERROR_DESCRIPTION="Error in job creation due to user profile";
	
	public static final String GET_PURCHASED_ORDER_LIST_SUCCESS_CODE="400";
	public static final String GET_PURCHASED_ORDER_LIST_ERROR_CODE="401";
	public static final String GET_PURCHASED_ORDER_LIST_ERROR_DESCRIPTION="";
	
	public static final String GET_ORDER_JOB_SUCCESS_CODE="500";
	public static final String GET_ORDER_JOB_ERROR_CODE="501";
	public static final String GET_ORDER_JOB_ERROR_DESCRIPTION="";
	
	public static final String CREATE_REPAIR_JOB_SUCCESS_CODE="600";
	public static final String CREATE_REPAIR_JOB_ERROR_CODE="601";
	public static final String CREATE_REPAIR_JOB_ERROR_DESCRIPTION="";
	
	public static final String GET_REPAIR_JOB_LIST_SUCCESS_CODE="";
	public static final String GET_REPAIR_JOB_LIST_ERROR_CODE="";
	public static final String GET_REPAIR_JOB_LIST_ERROR_DESCRIPTION="";
	
	public static final String GET_REPAIR_JOB_STATUS_SUCCESS_CODE="";
	public static final String GET_REPAIR_JOB_STATUS_ERROR_CODE="";
	public static final String GET_REPAIR_JOB_STATUS_ERROR_DESCRIPTION="";
	
//	For Mobile API
	public static final String GET_ORDER_LIST_MOBILE_SUCCESS_CODE="";
	public static final String GET_ORDER_LIST_MOBILE_ERROR_CODE="";
	public static final String GET_ORDER_LIST_MOBILE_ERROR_DESCRIPTION="";
	
	public static final String GET_ORDER_DETAILS_MOBILE_SUCCESS_CODE="";
	public static final String GET_ORDER_DETAILS_MOBILE_ERROR_CODE="";
	public static final String GET_ORDER_DETAILS_MOBILE_ERROR_DESCRIPTION="";
	
	public static final String GET_REPAIR_JOB_LIST_MOBILE_SUCCESS_CODE="";
	public static final String GET_REPAIR_JOB_LIST_MOBILE_ERROR_CODE="";
	public static final String GET_REPAIR_JOB_LIST_MOBILE_ERROR_DESCRIPTION="";
	
	public static final String GET_REPAIR_JOB_DETAILS_MOBILE_SUCCESS_CODE="";
	public static final String GET_REPAIR_JOB_DETAILS_MOBILE_ERROR_CODE="";
	public static final String GET_REPAIR_JOB_DETAILS_MOBILE_ERROR_DESCRIPTION="";
	
	public static final String NULL_REQUEST_ERROR_CODE = "000";
	public static final String NULL_REQUEST_ERROR_DESCRIPTION = "Request data not found";
}
