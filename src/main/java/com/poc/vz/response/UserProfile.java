/**
 * 
 */
package com.poc.vz.response;

import java.io.Serializable;

/**
 * @author ranjit.soni
 *
 */

public class UserProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6281444609131956610L;
	
	private int id;
	private String name;
	private String mobileNumber;
	private String emailId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
