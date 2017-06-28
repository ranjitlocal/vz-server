/**
 * 
 */
package com.poc.vz.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
import com.poc.vz.model.Repair;
import com.poc.vz.model.User;
import com.poc.vz.model.UserProfile;
import com.poc.vz.request.CheckProfileRequest;
import com.poc.vz.request.OrderCreationRequest;
import com.poc.vz.request.RepairRequest;
import com.poc.vz.request.TestRequestBean;
import com.poc.vz.request.UserProfileRequest;
import com.poc.vz.request.UserRequest;
import com.poc.vz.response.OrderResponse;
import com.poc.vz.response.ProductRepsonse;
import com.poc.vz.response.RepairResponse;
import com.poc.vz.response.TestResponseBean;
import com.poc.vz.response.UserProfileRes;
import com.poc.vz.response.UserProfileResponse;
import com.poc.vz.response.UserProfileTest;
import com.poc.vz.service.TestService;
import com.poc.vz.service.UserProfileService;

/**
 * @author ranjit.soni
 *
 */


@Path("api")
public class WebApi
{
	@Inject
	private TestService testService;
	
	@Inject
	private UserProfileService userProfileService;
	
	@GET
    @Path("helloworld")
    public String helloworld() {
        return "Hello World!";
    }
    
    @GET
    @Path("helloname/{name}")
    public String hello(@PathParam("name") final String name) {
      return "Hello " +name;
    }
    
    @POST
    @Path("getBeanResponse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TestResponseBean beanData(TestRequestBean bean)
    {
    	TestResponseBean responseBean = new TestResponseBean();
    	responseBean.setMessage("Hello "+bean.getProperty());
    	responseBean.setSuccess(true);
    	return responseBean;
    }
    
    @POST
    @Path("checkDI")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TestResponseBean checkDI(TestRequestBean bean)
    {
    	TestResponseBean responseBean = testService.getResponse(bean.getProperty());
    	return responseBean;
    }
    
    @POST
    @Path("checkFormParam")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response checkDI(@FormParam("parameter1") String parameter1, @FormParam("parameter2") String parameter2)
    {
    	return Response.ok().entity("parameter1 =>"+parameter1+", parameter2"+parameter2).build();
    }
    
    @POST
    @Path("saveprofile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response persistUserProfile(UserRequest profile)
    {
    	User user = userProfileService.save(profile);
    	UserProfileRes profileResponse = null;
    	
    	if(user != null)
    	{
    		UserProfileTest userProfile = new UserProfileTest();
    		userProfile.setId(user.getId());
    		userProfile.setName(user.getName());
    		userProfile.setMobileNumber(user.getMobileNumber());
    		userProfile.setEmailId(user.getEmailId());
    		
    		profileResponse = new UserProfileRes();
    		profileResponse.setSuccess(true);
    		profileResponse.setProfile(userProfile);
    		
    		return Response.ok().entity(profileResponse).build();
    	}
    	
    	return null;
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
}
