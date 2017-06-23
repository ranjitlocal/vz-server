/**
 * 
 */
package com.poc.vz.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.poc.vz.model.User;
import com.poc.vz.request.TestRequestBean;
import com.poc.vz.request.UserProfileRequest;
import com.poc.vz.response.TestResponseBean;
import com.poc.vz.response.UserProfile;
import com.poc.vz.response.UserProfileResponse;
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
    public Response persistUserProfile(UserProfileRequest profile)
    {
    	User user = userProfileService.save(profile);
    	UserProfileResponse profileResponse = null;
    	
    	if(user != null)
    	{
    		UserProfile userProfile = new UserProfile();
    		userProfile.setId(user.getId());
    		userProfile.setName(user.getName());
    		userProfile.setMobileNumber(user.getMobileNumber());
    		userProfile.setEmailId(user.getEmailId());
    		
    		profileResponse = new UserProfileResponse();
    		profileResponse.setSuccess(true);
    		profileResponse.setUserProfile(userProfile);
    		
    		return Response.ok().entity(profileResponse).build();
    	}
    	
    	return null;
    }
    
}
