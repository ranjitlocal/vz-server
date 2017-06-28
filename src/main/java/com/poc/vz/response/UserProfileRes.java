/**
 * 
 */
package com.poc.vz.response;

/**
 * @author ranjit.soni
 *
 */
public class UserProfileRes extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserProfileTest profile;

	public UserProfileTest getProfile() {
		return profile;
	}

	public void setProfile(UserProfileTest profile) {
		this.profile = profile;
	}
	
	
}
