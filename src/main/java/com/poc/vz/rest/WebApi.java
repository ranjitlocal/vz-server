/**
 * 
 */
package com.poc.vz.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.poc.vz.constant.ResponseCode;
import com.poc.vz.model.Order;
import com.poc.vz.model.Product;
import com.poc.vz.model.Recommendation;
import com.poc.vz.model.Repair;
import com.poc.vz.model.UserProfile;
import com.poc.vz.request.CheckProfileRequest;
import com.poc.vz.request.OrderCreationRequest;
import com.poc.vz.request.RepairRequest;
import com.poc.vz.request.UserProfileRequest;
import com.poc.vz.response.OrderResponse;
import com.poc.vz.response.ProductRepsonse;
import com.poc.vz.response.RecommendationResponse;
import com.poc.vz.response.RepairResponse;
import com.poc.vz.response.UserProfileResponse;
import com.poc.vz.service.UserProfileService;

/**
 * @author ranjit.soni
 *
 */


@Path("api")
public class WebApi
{
	
	@Inject
	private UserProfileService userProfileService;
	
	@GET
    @Path("helloworld")
    public String helloworld() {
        return "TEsting webservice";
    }
    
    @POST
    @Path("checkProfile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkProfile(CheckProfileRequest checkProfileRequest)
    {
    	UserProfileResponse userProfileResponse = new UserProfileResponse();
    	
    	if(checkProfileRequest != null && checkProfileRequest.getMobileNumber() != null)
    	{
    		UserProfile userProfileExist = userProfileService.checkUserProfile(checkProfileRequest.getMobileNumber());

    		if(userProfileExist != null)
        	{
        		userProfileResponse.setSuccess(true);
        		userProfileResponse.setSuccessCode(ResponseCode.CHECK_PROFILE_SUCCESS_CODE);
        	}
        	else
        	{
        		userProfileResponse.setSuccess(false);
        		userProfileResponse.setErrorCode(ResponseCode.CHECK_PROFILE_ERROR_CODE);
        		userProfileResponse.setErrorDescription(ResponseCode.CHECK_PROFILE_ERROR_DESCRIPTION);
        	}	
    	}
    	else
    	{
    		userProfileResponse.setSuccess(false);
    		userProfileResponse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		userProfileResponse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(userProfileResponse).build();
    }
    
    @POST
    @Path("createProfile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProfile(UserProfileRequest userProfileRequest)
    {
    	UserProfileResponse userProfileResponse = new UserProfileResponse();
    	
    	if(userProfileRequest != null && userProfileRequest.getUserProfile() != null)
    	{
    		UserProfile userProfile = userProfileService.createUserprofile(userProfileRequest.getUserProfile());
    		userProfileResponse.setUserProfile(userProfile);
    		userProfileResponse.setSuccess(true);
    		userProfileResponse.setSuccessCode(ResponseCode.CREATE_PROFILE_SUCCESS_CODE);
    	}
    	else
    	{
    		userProfileResponse.setSuccess(false);
    		userProfileResponse.setErrorCode(ResponseCode.CREATE_PROFILE_ERROR_CODE);
    		userProfileResponse.setErrorDescription(ResponseCode.CREATE_PROFILE_ERROR_DESCRIPTION);
    	}
    		
    	return Response.ok(userProfileResponse).build();
    }
    
    
    @Path("createOrderJob")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrderJob(OrderCreationRequest orderCreationRequest)
    {
    	OrderResponse orderCreationResponse = new OrderResponse();
    	
    	if(orderCreationRequest != null && 
    			orderCreationRequest.getOrder() != null && 
    			orderCreationRequest.getProduct() != null)
    	{
    		
    		Product product = userProfileService.saveProduct(orderCreationRequest.getProduct());
    		if(product != null)
    		{
    			Order order = orderCreationRequest.getOrder();
    			order.setProductId(product.getProductId());
    			order = userProfileService.createOrderJob(orderCreationRequest.getOrder());
        		
    			if(order != null)
        		{
        			UserProfile userProfile = userProfileService.getUserProfile(orderCreationRequest.getOrder().getUserProfileId());
        			if(userProfile != null)
        			{
        				orderCreationResponse.setSuccess(true);
        				orderCreationResponse.setSuccessCode(ResponseCode.CREATE_ORDER_JOB_SUCCESS_CODE);
        				orderCreationResponse.setOrder(order);
        				orderCreationResponse.setUserProfile(userProfile);
        			}
        			else
        			{
        				orderCreationResponse.setSuccess(false);
                		orderCreationResponse.setErrorCode(ResponseCode.CREATE_ORDER_JOB_ERROR_CODE);
                		orderCreationResponse.setErrorDescription(ResponseCode.CREATE_ORDER_JOB_USER_PROFILE_ERROR_DESCRIPTION);
        			}
        		}
        		else
        		{
        			orderCreationResponse.setSuccess(false);
            		orderCreationResponse.setErrorCode(ResponseCode.CREATE_ORDER_JOB_ERROR_CODE);
            		orderCreationResponse.setErrorDescription(ResponseCode.CREATE_ORDER_JOB_ERROR_DESCRIPTION);
        		}	
    		}
    		else
    		{
    			orderCreationResponse.setSuccess(false);
        		orderCreationResponse.setErrorCode(ResponseCode.CREATE_ORDER_JOB_ERROR_CODE);
        		orderCreationResponse.setErrorDescription(ResponseCode.CREATE_ORDER_JOB_PRODUCT_ERROR_DESCRIPTION);
    		}
    	}
    	else
    	{
    		orderCreationResponse.setSuccess(false);
    		orderCreationResponse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		orderCreationResponse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(orderCreationResponse).build();
    }
    
    @GET
    @Path("getPurchasedOrderList/{userProfileId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPurchasedOrderList(@PathParam("userProfileId") String userProfileId)
    {
    	OrderResponse orderResponse = new OrderResponse();
    	
    	if(userProfileId != null)
    	{
    		List<Order> orders = userProfileService.getPurchasedOrder(userProfileId);
    		if(orders != null)
    		{
    			orderResponse.setOrders(orders);
    			orderResponse.setSuccess(true);
    			orderResponse.setSuccessCode(ResponseCode.GET_PURCHASED_ORDER_LIST_SUCCESS_CODE);
    		}
    		else
    		{
    			orderResponse.setSuccess(false);
    			orderResponse.setErrorCode(ResponseCode.GET_PURCHASED_ORDER_LIST_ERROR_CODE);
    			orderResponse.setErrorDescription(ResponseCode.GET_PURCHASED_ORDER_LIST_ERROR_DESCRIPTION);
    		}
    	}
    	else
    	{
    		orderResponse.setSuccess(false);
    		orderResponse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		orderResponse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(orderResponse).build();
    }
    
    @GET
    @Path("getOrderJob/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderJob(@PathParam("orderId") String orderId)
    {
    	ProductRepsonse productRepsonse = new ProductRepsonse();
    	
    	if(orderId != null)
    	{
    		Product product = userProfileService.getOrderJob(orderId);
    		if(product != null)
    		{
    			productRepsonse.setProduct(product);
    			productRepsonse.setOrderId(orderId);
    			productRepsonse.setSuccess(true);
    			productRepsonse.setSuccessCode(ResponseCode.GET_ORDER_JOB_SUCCESS_CODE);
    		}
    		else
    		{
    			productRepsonse.setSuccess(false);
    			productRepsonse.setErrorCode(ResponseCode.GET_ORDER_JOB_ERROR_CODE);
    			productRepsonse.setErrorDescription(ResponseCode.GET_ORDER_JOB_ERROR_DESCRIPTION);
    		}
    	}
    	else
    	{
    		productRepsonse.setSuccess(false);
    		productRepsonse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		productRepsonse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(productRepsonse).build();
    }
    
    
    @POST
    @Path("createRepairJob")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRepairJob(RepairRequest repairRequest)
    {
    	RepairResponse repairResponse = new RepairResponse();
    	
    	if(repairRequest != null && 
    			repairRequest.getProduct() != null &&
    			repairRequest.getRepair() != null)
    	{
    		Repair repair = userProfileService.createRepairJob(repairRequest.getRepair());
    		Order order = userProfileService.getOrder(repair.getOrderId());
    		UserProfile userProfile = userProfileService.getUserProfile(order.getUserProfileId());
    		
    		repairResponse.setSuccess(true);
    		repairResponse.setUserProfile(userProfile);
    		repairResponse.setRepair(repair);
    		repairResponse.setSuccessCode(ResponseCode.CREATE_REPAIR_JOB_SUCCESS_CODE);
    	}
    	else
    	{
    		repairResponse.setSuccess(false);
    		repairResponse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		repairResponse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(repairResponse).build();
    }
    
    @GET
    @Path("getRepairJobList/{userProfileId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRepairJobList(@PathParam("userProfileId") String userProfileId)
    {
    	RepairResponse repairResponse = new RepairResponse();
    	
    	if(userProfileId != null)
    	{
    		List<Repair> repairs = userProfileService.getRepairJobs(userProfileId);
    		repairResponse.setRepairs(repairs);
    		repairResponse.setSuccess(true);
    		repairResponse.setSuccessCode(ResponseCode.GET_REPAIR_JOB_LIST_SUCCESS_CODE);
    	}
    	else
    	{
    		repairResponse.setSuccess(false);
    		repairResponse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		repairResponse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(repairResponse).build();
    }
    
    @GET
    @Path("getRepairJobStaus/{repairId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRepairJobStatus(@PathParam("repairId") String repairId)
    {
    	RepairResponse repairResponse = new RepairResponse();
    	
    	if(repairId != null)
    	{
    		Repair repair = userProfileService.getRepairDetails(repairId);
    		if(repair != null)
    		{
    			Product product = userProfileService.getProduct(repairId);
    			if(product != null)
    			{
    				repairResponse.setSuccess(true);
    				repairResponse.setSuccessCode(ResponseCode.GET_REPAIR_JOB_STATUS_SUCCESS_CODE);
    				repairResponse.setRepair(repair);
    				repairResponse.setProduct(product);
    			}
    			else
    			{
    				repairResponse.setSuccess(false);
    				repairResponse.setErrorCode(ResponseCode.GET_REPAIR_JOB_STATUS_ERROR_CODE);
    				repairResponse.setErrorDescription(ResponseCode.GET_REPAIR_JOB_STATUS_ERROR_DESCRIPTION);
    			}
    		}
    		else
    		{
    			repairResponse.setSuccess(false);
				repairResponse.setErrorCode(ResponseCode.GET_REPAIR_JOB_STATUS_ERROR_CODE);
				repairResponse.setErrorDescription(ResponseCode.GET_REPAIR_JOB_STATUS_REPAIR_DETAIL_NOT_FOUND);
    		}
    	}
    	else
    	{
    		repairResponse.setSuccess(false);
    		repairResponse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		repairResponse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(repairResponse).build();
    }
    
    @GET
    @Path("getOrderList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderList()
    {
    	OrderResponse orderResponse = new OrderResponse();

    	List<Order> orders = userProfileService.getOrderList();
    	if(orders != null)
    	{
    		List<Order> list = new ArrayList<Order>();
    		Product product = null;
    		for(Order order : orders)
    		{
    			product = userProfileService.getProductDetails(order.getProductId());
    			order.setProductType(product.getProductType());
    			order.setProductShortDescription(product.getShortDescription());
    			list.add(order);
    		}
    		
    		orderResponse.setOrders(orders);
    		orderResponse.setSuccess(true);
    		orderResponse.setSuccessCode(ResponseCode.GET_ORDER_LIST_MOBILE_SUCCESS_CODE);
    	}
    	else
    	{
    		orderResponse.setSuccess(false);
    		orderResponse.setErrorCode(ResponseCode.GET_ORDER_LIST_MOBILE_ERROR_CODE);
    		orderResponse.setErrorDescription(ResponseCode.GET_ORDER_LIST_MOBILE_ERROR_DESCRIPTION);
    	}

    	return Response.ok(orderResponse).build();
    }
    
    @GET
    @Path("getOrderDetails/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderDetails(@PathParam("orderId") String orderId)
    {
    	ProductRepsonse productRepsonse = new ProductRepsonse();
    	
    	if(orderId != null)
    	{
    		Product product = userProfileService.getOrderJob(orderId);
    		if(product != null)
    		{
    			productRepsonse.setProduct(product);
    			productRepsonse.setOrderId(orderId);
    			productRepsonse.setSuccess(true);
    			productRepsonse.setSuccessCode(ResponseCode.GET_ORDER_DETAILS_MOBILE_SUCCESS_CODE);
    		}
    		else
    		{
    			productRepsonse.setSuccess(false);
    			productRepsonse.setErrorCode(ResponseCode.GET_ORDER_DETAILS_MOBILE_ERROR_CODE);
    			productRepsonse.setErrorDescription(ResponseCode.GET_ORDER_DETAILS_MOBILE_ERROR_DESCRIPTION);
    		}
    	}
    	else
    	{
    		productRepsonse.setSuccess(false);
    		productRepsonse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		productRepsonse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(productRepsonse).build();
    }
    
    @GET
    @Path("getRepairJobList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRepairJobList()
    {
    	RepairResponse repairResponse = new RepairResponse();

    	List<Repair> repairs = userProfileService.getRepairJobs();
    	repairResponse.setRepairs(repairs);
    	repairResponse.setSuccess(true);
    	repairResponse.setSuccessCode(ResponseCode.GET_REPAIR_JOB_LIST_SUCCESS_CODE);

    	return Response.ok(repairResponse).build();
    }
    
    @GET
    @Path("/getRecommendation/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecommendation(@PathParam("orderId") String orderId)
    {
    	RecommendationResponse recommendationResponse = new RecommendationResponse();
    	
    	if(orderId != null)
    	{
    		Recommendation recommendation = userProfileService.getRecommendation(orderId);
    		if(recommendation != null)
    		{
    			recommendationResponse.setRecommendation(recommendation);
    			recommendationResponse.setSuccess(true);
    			recommendationResponse.setSuccessCode(ResponseCode.GET_RECOMMENDATION_MOBILE_SUCCESS_CODE);
    		}
    		else
    		{
    			recommendationResponse.setSuccess(false);
    			recommendationResponse.setSuccessCode(ResponseCode.GET_RECOMMENDATION_MOBILE_ERROR_CODE);
    			recommendationResponse.setErrorDescription(ResponseCode.GET_RECOMMENDATION_MOBILE_ERROR_DESCRIPTION);
    		}
    	}
    	else
    	{
    		recommendationResponse.setSuccess(false);
    		recommendationResponse.setErrorCode(ResponseCode.NULL_REQUEST_ERROR_CODE);
    		recommendationResponse.setErrorDescription(ResponseCode.NULL_REQUEST_ERROR_DESCRIPTION);
    	}
    	
    	return Response.ok(recommendationResponse).build();
    }
    
    
}
