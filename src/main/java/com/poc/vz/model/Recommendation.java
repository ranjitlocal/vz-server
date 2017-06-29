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
@Table(name="recommendation")
public class Recommendation implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private String recId;
	private String productSetId; 
	private String productType;
	private String productCategory;
	private String packageId;
	private String packageShortDescription;
	private String applicableProducts;
	private String productId;
	private String productShortDescription;
	private String jobType;
	private String serviceId;
	private String serviceType;
	private String groupId;
	private String productGroupId;
	private String productGroupDescription;
	private String orderId;
	private String userProfileId;
	
	public Recommendation()
	{}
	
	@Id
	public String getRecId() {
		return recId;
	}
	
	public void setRecId(String recId) {
		this.recId = recId;
	}
	
	public String getProductSetId() {
		return productSetId;
	}
	
	public void setProductSetId(String productSetId) {
		this.productSetId = productSetId;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public String getPackageId() {
		return packageId;
	}
	
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
	public String getPackageShortDescription() {
		return packageShortDescription;
	}
	
	public void setPackageShortDescription(String packageShortDescription) {
		this.packageShortDescription = packageShortDescription;
	}
	
	public String getApplicableProducts() {
		return applicableProducts;
	}
	
	public void setApplicableProducts(String applicableProducts) {
		this.applicableProducts = applicableProducts;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductShortDescription() {
		return productShortDescription;
	}
	
	public void setProductShortDescription(String productShortDescription) {
		this.productShortDescription = productShortDescription;
	}
	
	public String getJobType() {
		return jobType;
	}
	
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	public String getServiceId() {
		return serviceId;
	}
	
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public String getGroupId() {
		return groupId;
	}
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getProductGroupId() {
		return productGroupId;
	}
	
	public void setProductGroupId(String productGroupId) {
		this.productGroupId = productGroupId;
	}
	
	public String getProductGroupDescription() {
		return productGroupDescription;
	}
	
	public void setProductGroupDescription(String productGroupDescription) {
		this.productGroupDescription = productGroupDescription;
	}

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
	
}
