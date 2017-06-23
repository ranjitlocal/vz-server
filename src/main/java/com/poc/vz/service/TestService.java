/**
 * 
 */
package com.poc.vz.service;

import javax.enterprise.context.RequestScoped;

import com.poc.vz.response.TestResponseBean;

/**
 * @author ranjit.soni
 *
 */

@RequestScoped
public class TestService {

	public TestResponseBean getResponse(String string)
	{
		TestResponseBean bean = new TestResponseBean();
		bean.setMessage("Hello "+string);
		bean.setSuccess(true);
		return bean;
	}
}
