package com.fms.dao.facility;

import java.util.ArrayList;

import com.fms.model.facility.FacilityDetails;

public interface InterfaceFacilityDAO {

	public int addFacility(FacilityDetails facility);
	public void addFacilityDetail(int facilityID ,String detail);
	public void deleteFacility(int ID);
	public FacilityDetails getFacilityInformationByID(int ID);
	public ArrayList<FacilityDetails> listFacilities();
}
