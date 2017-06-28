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
		private String successCode;
		private String errorCode;
		private String errorDescription;
		
		public boolean isSuccess() {
			return success;
		}
		
		public void setSuccess(boolean success) {
			this.success = success;
		}
		
		public String getSuccessCode() {
			return successCode;
		}
		
		public void setSuccessCode(String successCode) {
			this.successCode = successCode;
		}
		
		public String getErrorCode() {
			return errorCode;
		}
		
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		
		public String getErrorDescription() {
			return errorDescription;
		}
		
		public void setErrorDescription(String errorDescription) {
			this.errorDescription = errorDescription;
		}
}
