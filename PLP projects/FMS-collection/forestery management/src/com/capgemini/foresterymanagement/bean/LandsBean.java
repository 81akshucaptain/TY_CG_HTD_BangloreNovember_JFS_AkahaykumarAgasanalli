package com.capgemini.foresterymanagement.bean;

public class LandsBean {
	private String landLocation;
	private int landId;
	private String landSize;
	private String landResources;
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
	public String getlandLocation() {
		return landLocation;
	}
	public void setlandLocation(String landLocation) {
		this.landLocation = landLocation;
	}

	@Override
	public String toString() {
		return "       ::::LAND DETAILS:::  \nLAND ID=" + landId + 
				"\nLAND LOCATION="+landLocation+
				"\nLAND SIZE=" + landSize + "\nLAND RESOURCES=" + landResources;

	}


}
