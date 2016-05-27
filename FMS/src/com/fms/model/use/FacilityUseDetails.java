package com.fms.model.use;

import java.util.Date;

public class FacilityUseDetails {
	
	private Date bookingDate;
	
	private int bookingID;
	private int bookedBy;
	private int facilityID;
	private int numbOfSeats;
	
	
	public FacilityUseDetails() {
		super();
	}


	public FacilityUseDetails(Date bookingDate, int bookedBy, int facilityID,
			int numbOfSeats) {
		super();
		this.bookingDate = bookingDate;
		this.bookedBy = bookedBy;
		this.facilityID = facilityID;
		this.numbOfSeats = numbOfSeats;
	}
	
	
	public FacilityUseDetails(Date bookingDate, int bookedBy, int facilityID) {
		super();
		this.bookingDate = bookingDate;
		this.bookedBy = bookedBy;
		this.facilityID = facilityID;
	}


	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public int getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(int bookedBy) {
		this.bookedBy = bookedBy;
	}
	public int getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}
	public int getNumbOfSeats() {
		return numbOfSeats;
	}
	public void setNumbOfSeats(int numbOfSeats) {
		this.numbOfSeats = numbOfSeats;
	}
	
	
}
