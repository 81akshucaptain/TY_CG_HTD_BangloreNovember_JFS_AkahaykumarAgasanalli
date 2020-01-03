package com.capgemini.forestmanagementjpa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jpaLands")
public class LandsBean {
	@Id
	@Column
	private int landId;
	@Column
	private String landSize;
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
	public String getLandSize() {
		return landSize;
	}
	public void setLandSize(String landSize) {
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
