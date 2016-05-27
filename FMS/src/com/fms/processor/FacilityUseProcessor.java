package com.fms.processor;

import java.util.Date;

import com.fms.dao.facility.FacilityDAO;
import com.fms.dao.facility.FacilityUseDAO;
import com.fms.dao.facility.InterfaceFacilityDAO;
import com.fms.dao.facility.InterfaceFacilityUseDAO;
import com.fms.model.facility.FacilityDetails;
import com.fms.model.use.FacilityUseDetails;
import com.fms.model.user.UserDetails;
import com.fms.util.FMSConstants;

public class FacilityUseProcessor {
	
	public void assignFacilityToUse(int facilityID){
		InterfaceFacilityUseDAO iFacilityDAO = new FacilityUseDAO();
		iFacilityDAO.assignFacilityToUse(facilityID);
	}

	public int bookFacility(FacilityUseDetails facilityUse){
		
		int bookingID = 0;
		int facilityAvailability = isFacilityAvailableForDate(facilityUse.getFacilityID() , facilityUse.getBookingDate());
		int totalCapacity = getTotalCapacity(facilityUse.getFacilityID());
		if(FMSConstants.AVAILABLE_COMPLETELY == facilityAvailability){
			if(facilityUse.getNumbOfSeats() <= totalCapacity){
				InterfaceFacilityUseDAO iFacilityDAO = new FacilityUseDAO();
				bookingID = iFacilityDAO.bookFacility(facilityUse);
			}
		}else if(FMSConstants.AVAILABLE_PARTIALLY == facilityAvailability){
			int availableCapacity = totalCapacity - getNumbOfBookedSeats(facilityUse.getFacilityID(), facilityUse.getBookingDate());
			if(facilityUse.getNumbOfSeats() <= availableCapacity){
				InterfaceFacilityUseDAO iFacilityDAO = new FacilityUseDAO();
				bookingID = iFacilityDAO.bookFacility(facilityUse);
			}else{
				System.out.println("Facility not available");
			}
		}else if(FMSConstants.NOT_AVAILABLE == facilityAvailability){
			System.out.println("Facility not available");
		}
		return bookingID;
	}
	
	
	public int isFacilityAvailable(FacilityDetails facility){
		
		Date todayDate = new Date();
		return isFacilityAvailableForDate(facility.getFacilityID() , todayDate);
	}
	
	
	public int isFacilityAvailableForDate(int facilityID,Date forDate){
		
		InterfaceFacilityUseDAO iFacilityDAO = new FacilityUseDAO();
		return iFacilityDAO.checkFacilityAvailabilityForDate(facilityID, forDate);
	}
	
	
	public int getNumbOfBookedSeats(int facilityID,Date forDate){
		
		int numbOfBookedSeats = 0;
		InterfaceFacilityUseDAO iFacilityDAO = new FacilityUseDAO();
		numbOfBookedSeats = iFacilityDAO.getNumbOfBookedSeats(facilityID, forDate);
		System.out.println("numbOfBookedSeats = " + numbOfBookedSeats);
		return numbOfBookedSeats;
	}
	
	
	public int getTotalCapacity(int facilityID){
		
		InterfaceFacilityDAO iFacilityDAO = new FacilityDAO();
		FacilityDetails facilityDetails = iFacilityDAO.getFacilityInformationByID(facilityID);
		return facilityDetails.getCapacity();
	}
	
	
	public int getAvailableCapacity(int facilityID,Date forDate){
		int numbOfBookedSeats = getNumbOfBookedSeats(facilityID,forDate);
		int totalCapacity = getTotalCapacity(facilityID);
		return (totalCapacity - numbOfBookedSeats);
	}
	
	
	public void vacateFacility(int facilityID){
		InterfaceFacilityUseDAO iFacilityDAO = new FacilityUseDAO();
		iFacilityDAO.vacateFacility(facilityID);
	}
}
