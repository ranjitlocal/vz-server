/**
 * 
 */
package com.poc.vz.request;

import java.io.Serializable;

/**
 * @author ranjit.soni
 *
 */
public class TestRequestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8131022287485224036L;
	
	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

}
