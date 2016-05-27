package com.fms.model.facility;

public class AddressDetails {

	private int facilityID;
	private int serialNumb;
	private int zipCode;
	private String streetName;
	private String cityName;
	private String stateName;
	
	
	public int getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}
	public int getSerialNumb() {
		return serialNumb;
	}
	public void setSerialNumb(int serialNumb) {
		this.serialNumb = serialNumb;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	

}
