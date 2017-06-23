/**
 * 
 */
package com.poc.vz.response;

import java.io.Serializable;

/**
 * @author ranjit.soni
 *
 */
public class BaseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7169701523899100054L;
	
		private boolean success;
		private String errorMessage;
		
		public boolean isSuccess() {
			return success;
		}
		
		public void setSuccess(boolean success) {
			this.success = success;
		}
		
		public String getErrorMessage() {
			return errorMessage;
		}
		
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
}
