package com.poc.vz.request;

import java.io.Serializable;

import com.poc.vz.model.Order;
import com.poc.vz.model.Product;

/**
 * @author ranjit.soni
 *
 */
public class OrderCreationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Order order;
	private Product product;
	
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
	
}
