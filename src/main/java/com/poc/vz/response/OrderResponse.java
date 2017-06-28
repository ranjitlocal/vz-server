/**
 * 
 */
package com.poc.vz.response;

import java.util.List;

import com.poc.vz.model.Order;
import com.poc.vz.model.UserProfile;

/**
 * @author ranjit.soni
 *
 */
public class OrderResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserProfile userProfile;
	private Order order;
	private List<Order> orders;
	
	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
