/**
 * 
 */
package com.poc.vz.request;

import java.io.Serializable;

import com.poc.vz.model.Product;
import com.poc.vz.model.Repair;

/**
 * @author ranjit.soni
 *
 */
public class RepairRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Repair repair;
	private Product product;
	
	public Repair getRepair() {
		return repair;
	}
	
	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
