/**
 * 
 */
package com.poc.vz.response;

import java.io.Serializable;

/**
 * @author ranjit.soni
 *
 */
public class TestResponseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4720455623779185415L;

	private String message;
	private boolean success;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
