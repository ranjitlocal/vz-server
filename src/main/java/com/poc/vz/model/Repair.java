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
@Table(name="repair")
public class Repair implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String repairId;
	private String orderId;
	private String model;
	private String color;
	private String configuration;
	private String repairShortDescription;
	private String repairStatus;
	
	@Id
	public String getRepairId() {
		return repairId;
	}
	
	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
	public String getRepairShortDescription() {
		return repairShortDescription;
	}
	
	public void setRepairShortDescription(String repairShortDescription) {
		this.repairShortDescription = repairShortDescription;
	}
	
	public String getRepairStatus() {
		return repairStatus;
	}
	
	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
