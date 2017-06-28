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
	
	public static final String GET_REPAIR_JOB_LIST_SUCCESS_CODE="700";
	public static final String GET_REPAIR_JOB_LIST_ERROR_CODE="701";
	public static final String GET_REPAIR_JOB_LIST_ERROR_DESCRIPTION="Error while getting repair product list";
	
	public static final String GET_REPAIR_JOB_STATUS_SUCCESS_CODE="800";
	public static final String GET_REPAIR_JOB_STATUS_ERROR_CODE="801";
	public static final String GET_REPAIR_JOB_STATUS_REPAIR_DETAIL_NOT_FOUND="Repair detail not found";
	public static final String GET_REPAIR_JOB_STATUS_ERROR_DESCRIPTION="Error while getting repair product";
	
//	For Mobile API
	public static final String GET_ORDER_LIST_MOBILE_SUCCESS_CODE="900";
	public static final String GET_ORDER_LIST_MOBILE_ERROR_CODE="901";
	public static final String GET_ORDER_LIST_MOBILE_ERROR_DESCRIPTION="Error while getting order list";
	
	public static final String GET_ORDER_DETAILS_MOBILE_SUCCESS_CODE="1000";
	public static final String GET_ORDER_DETAILS_MOBILE_ERROR_CODE="1001";
	public static final String GET_ORDER_DETAILS_MOBILE_ERROR_DESCRIPTION="Error while getting order detail";
	
	public static final String GET_REPAIR_JOB_LIST_MOBILE_SUCCESS_CODE="1100";
	public static final String GET_REPAIR_JOB_LIST_MOBILE_ERROR_CODE="1101";
	public static final String GET_REPAIR_JOB_LIST_MOBILE_ERROR_DESCRIPTION="Error while getting repair list";
	
	public static final String GET_REPAIR_JOB_DETAILS_MOBILE_SUCCESS_CODE="1200";
	public static final String GET_REPAIR_JOB_DETAILS_MOBILE_ERROR_CODE="1201";
	public static final String GET_REPAIR_JOB_DETAILS_MOBILE_ERROR_DESCRIPTION="Error while getting repair job detail";
	
	public static final String GET_RECOMMENDATION_MOBILE_SUCCESS_CODE="1300";
	public static final String GET_RECOMMENDATION_MOBILE_ERROR_CODE="1301";
	public static final String GET_RECOMMENDATION_MOBILE_ERROR_DESCRIPTION="Error while getting recommendation";
	
	public static final String NULL_REQUEST_ERROR_CODE = "000";
	public static final String NULL_REQUEST_ERROR_DESCRIPTION = "Request data not found";
}
