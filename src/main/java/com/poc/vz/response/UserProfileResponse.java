/**
 * 
 */
package com.poc.vz.response;

import com.poc.vz.model.UserProfile;


/**
 * @author ranjit.soni
 *
 */
public class UserProfileResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserProfile userProfile;

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
}
