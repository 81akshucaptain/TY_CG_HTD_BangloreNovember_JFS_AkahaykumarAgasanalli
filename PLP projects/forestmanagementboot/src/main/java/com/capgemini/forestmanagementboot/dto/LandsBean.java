package com.capgemini.forestmanagementboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jpaLands")
public class LandsBean {
	@Id
	@Column
	@GeneratedValue
	private int landId;
	@Column
	private int landSize;
	@Column
	private String landResources;
	@Column
	private String landLocation;
	
	public String getLandLocation() {
		return landLocation;
	}
	public void setLandLocation(String landLocation) {
		this.landLocation = landLocation;
	}
	public int getLandId() {
		return landId;
	}
	public void setLandId(int landId) {
		this.landId = landId;
	}
	public int getLandSize() {
		return landSize;
	}
	public void setLandSize(int landSize) {
		this.landSize = landSize;
	}
	public String getLandResources() {
		return landResources;
	}
	public void setLandResources(String landResources) {
		this.landResources = landResources;
	}
	@Override
	public String toString() {
		return "\n                   ::::LAND DETAILS::::\n"+
				"LAND-ID         = " + landId +
				"\nLAND-LOCATION = "+landLocation+ 
				"\nLAND-SIZE     = " + landSize +
				"\nLAND-RESOURCES= " + landResources
				+"\n===============================================================";
	}
}
