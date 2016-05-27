package com.fms.processor;

import java.util.ArrayList;

import com.fms.dao.facility.FacilityMaintenanceDAO;
import com.fms.dao.facility.InterfaceFacilityMaintenanceDAO;
import com.fms.model.maintenance.FacilityMaintenanceDetails;
import com.fms.model.use.FacilityUseDetails;

public class FacilityMaintenanceProcessor {

	
	public double calcDownTimeForFacility(int facilityID){
		FacilityUseProcessor fup = new FacilityUseProcessor();
		int totalSeats = fup.getTotalCapacity(facilityID);
		double downTimeDays = (totalSeats)%100;
		return downTimeDays;
	}
	public double calcMaintenanceCostForFacility(int facilityID){
		
		FacilityUseProcessor fup = new FacilityUseProcessor();
		int totalSeats = fup.getTotalCapacity(facilityID);
		double downTimeDays = calcDownTimeForFacility(facilityID);
		double costInDollars = (1*totalSeats)+(50*downTimeDays);
		return costInDollars;
	}
	
	public void listFacilityMaintenanceRequest(){
		
		ArrayList<FacilityMaintenanceDetails> facilityMaintenanceRequestList = new ArrayList<FacilityMaintenanceDetails>();
		InterfaceFacilityMaintenanceDAO iFacilityMaintenanceDAO = new FacilityMaintenanceDAO();
		facilityMaintenanceRequestList = iFacilityMaintenanceDAO.listFacilityMaintenanceRequest();
		for(int i = 0; i < facilityMaintenanceRequestList.size() ; i++){
			facilityMaintenanceRequestList.get(i).displayFacilityMaintenanceDetails();
		}
	}
	
	public void requestFacilityMaintenance(FacilityUseDetails facilityUse){
		
		int bookingID = 0;
		double cost = 0;
		double downTimeDays = 0;
		FacilityUseProcessor fup = new FacilityUseProcessor();
		int totalSeats = fup.getTotalCapacity(facilityUse.getFacilityID());
		facilityUse.setNumbOfSeats(totalSeats);
		bookingID = fup.bookFacility(facilityUse);
		if(0 == bookingID){
			System.out.println("Facility not available for this date");
		}else{
			cost = calcMaintenanceCostForFacility(facilityUse.getFacilityID());
			downTimeDays = calcDownTimeForFacility(facilityUse.getFacilityID());
			FacilityMaintenanceDetails fmd = new FacilityMaintenanceDetails(cost, downTimeDays, bookingID, facilityUse.getFacilityID());
			scheduleFacilityMaintenance(fmd);
		}
		
	}
	
	public void scheduleFacilityMaintenance(FacilityMaintenanceDetails fmd){
		
		InterfaceFacilityMaintenanceDAO iFacilityMaintenanceDAO = new FacilityMaintenanceDAO();
		iFacilityMaintenanceDAO.scheduleFacilityMaintenance(fmd);
	}
	
	
}
