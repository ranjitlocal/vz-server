/**
 * 
 */
package com.poc.vz.request;

import java.io.Serializable;

/**
 * @author ranjit.soni
 *
 */
public class CheckProfileRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mobileNumber;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
