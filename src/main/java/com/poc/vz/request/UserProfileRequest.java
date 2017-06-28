/**
 * 
 */
package com.poc.vz.request;

import java.io.Serializable;

import com.poc.vz.model.UserProfile;

/**
 * @author ranjit.soni
 *
 */
public class UserProfileRequest implements Serializable{

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
