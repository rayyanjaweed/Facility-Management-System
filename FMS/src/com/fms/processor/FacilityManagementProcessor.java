package com.fms.processor;

import java.util.ArrayList;

import com.fms.dao.facility.FacilityDAO;
import com.fms.dao.facility.InterfaceFacilityDAO;
import com.fms.model.facility.FacilityDetails;

public class FacilityManagementProcessor {

	public int addFacility(FacilityDetails facility){
		if(facility.isBuilding()){
			InterfaceFacilityDAO iFacilityDAO = new FacilityDAO();
			return iFacilityDAO.addFacility(facility);
		}else {
			InterfaceFacilityDAO iFacilityDAO = new FacilityDAO();
			return iFacilityDAO.addFacility(facility);
		}
	}
	
	public void addFacilityDetail(int facilityID ,String detail){
		InterfaceFacilityDAO iFacilityDAO = new FacilityDAO();
		iFacilityDAO.addFacilityDetail(facilityID , detail);
	}
	public void removeFacility(int ID){
		InterfaceFacilityDAO iFacilityDAO = new FacilityDAO();
		iFacilityDAO.deleteFacility(ID);
	}
	
	public FacilityDetails getFacilityInformationByID(int ID){
		InterfaceFacilityDAO iFacilityDAO = new FacilityDAO();
		return iFacilityDAO.getFacilityInformationByID(ID);
	}
	public void modifyFacility(FacilityDetails facility){
		
	}
	public ArrayList<FacilityDetails> listFacilities(){
		ArrayList<FacilityDetails> facilitiesList = new ArrayList<FacilityDetails>();
		InterfaceFacilityDAO iFacilityDAO = new FacilityDAO();
		facilitiesList = iFacilityDAO.listFacilities();
		return facilitiesList;
	}
	
}
