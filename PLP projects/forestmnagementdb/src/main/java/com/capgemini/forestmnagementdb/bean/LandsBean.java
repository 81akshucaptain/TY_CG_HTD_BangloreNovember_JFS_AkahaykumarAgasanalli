package com.capgemini.forestmnagementdb.bean;

public class LandsBean {

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
	@Override
	public String toString() {
		return "           ::::LAND DETAILS::::\n LANDID=" + landId + 
				"\n LANDSIZE=" + landSize + "\n LANDRESOURCES=" + landResources
				+"\n--------------------------------------------------";
	}
}
