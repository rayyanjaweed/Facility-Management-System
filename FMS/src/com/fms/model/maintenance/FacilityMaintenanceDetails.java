package com.fms.model.maintenance;

public class FacilityMaintenanceDetails {

	private double cost;
	private double downTimeDays;
	
	private int bookingID;
	private int facilityID;
	private int maintenanceID;
	
	
	public FacilityMaintenanceDetails() {
		super();
	}
	

	public FacilityMaintenanceDetails(double cost, double downTimeDays,
			int bookingID, int facilityID, int maintenanceID) {
		super();
		this.cost = cost;
		this.downTimeDays = downTimeDays;
		this.bookingID = bookingID;
		this.facilityID = facilityID;
		this.maintenanceID = maintenanceID;
	}




	public FacilityMaintenanceDetails(double cost, double downTimeDays,
			int bookingID, int facilityID) {
		super();
		this.cost = cost;
		this.downTimeDays = downTimeDays;
		this.bookingID = bookingID;
		this.facilityID = facilityID;
	}
	
	
	public void displayFacilityMaintenanceDetails(){
		System.out.println("MAINTENANCE ID : \"" + getMaintenanceID() 
						+ "\", FACILITY ID : \"" + getFacilityID() 
						+ "\", BOOKING ID : \"" + getBookingID() 
						+ "\", COST : \"" + getCost()
						+ "\", DOWN TIME DAYS : \"" + getDownTimeDays() );
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public double getDownTimeDays() {
		return downTimeDays;
	}


	public void setDownTimeDays(double downTimeDays) {
		this.downTimeDays = downTimeDays;
	}


	public int getBookingID() {
		return bookingID;
	}


	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}


	public int getFacilityID() {
		return facilityID;
	}


	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}


	public void setMaintenanceID(int maintenanceID) {
		this.maintenanceID = maintenanceID;
	}


	public int getMaintenanceID() {
		return maintenanceID;
	}
	
	
	
	
}
