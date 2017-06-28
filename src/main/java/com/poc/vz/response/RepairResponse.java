package com.poc.vz.response;

import java.util.List;

import com.poc.vz.model.Order;
import com.poc.vz.model.Product;
import com.poc.vz.model.Repair;
import com.poc.vz.model.UserProfile;


/**
 * @author ranjit.soni
 *
 */
public class RepairResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserProfile userProfile;
	private Order order;
	private Repair repair;
	private Product product;
	private List<Repair> repairs;
	
	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	public Repair getRepair() {
		return repair;
	}
	
	public void setRepair(Repair repair) {
		this.repair = repair;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Repair> getRepairs() {
		return repairs;
	}

	public void setRepairs(List<Repair> repairs) {
		this.repairs = repairs;
	}
	
}
