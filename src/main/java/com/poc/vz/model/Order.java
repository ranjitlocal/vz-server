/**
 * 
 */
package com.poc.vz.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ranjit.soni
 *
 */

@Entity
@Table(name="joborder")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderId;
	private String userProfileId;
	private String productId;
	private String estimatedTime_Days;
	private String paymentMode;
	private String unitCost_in_$;
	private String totalCost_in_$;
	private String grantCost_in_$;
	private String orderStatus;
	private int quantity;
	private String productShortDescription;
	private String productType;
	private String productCategory;
	
	public Order()
	{}
	
	@Id
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getUserProfileId() {
		return userProfileId;
	}
	
	public void setUserProfileId(String userProfileId) {
		this.userProfileId = userProfileId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getEstimatedTime_Days() {
		return estimatedTime_Days;
	}
	
	public void setEstimatedTime_Days(String estimatedTime_Days) {
		this.estimatedTime_Days = estimatedTime_Days;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public String getUnitCost_in_$() {
		return unitCost_in_$;
	}
	
	public void setUnitCost_in_$(String unitCost_in_$) {
		this.unitCost_in_$ = unitCost_in_$;
	}
	
	public String getTotalCost_in_$() {
		return totalCost_in_$;
	}
	
	public void setTotalCost_in_$(String totalCost_in_$) {
		this.totalCost_in_$ = totalCost_in_$;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getGrantCost_in_$() {
		return grantCost_in_$;
	}

	public void setGrantCost_in_$(String grantCost_in_$) {
		this.grantCost_in_$ = grantCost_in_$;
	}

	public String getProductShortDescription() {
		return productShortDescription;
	}

	public void setProductShortDescription(String productShortDescription) {
		this.productShortDescription = productShortDescription;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
}
