package com.fms.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.fms.model.facility.FacilityDetails;
import com.fms.processor.FacilityManagementProcessor;

public class FacilityView {
	
	public static void main(String args[]){
		FacilityManagementProcessor fmp = new FacilityManagementProcessor();
		
		/*



		//Add a new Facility
		FacilityDetails test = new FacilityDetails(true, false, 150, 444, 3, 302, "Messi", "Some Address to fill up the DB. Placein Chicago. Testing the length of the address", "Nice Place. Good Facility");
		fmp.addFacility(test);
		
		
		
		
		//List All Facilities
		ArrayList<FacilityDetails> facilitiesList = new ArrayList<FacilityDetails>();
		facilitiesList = fmp.listFacilities();
		for(int i = 0; i < facilitiesList.size(); i++){
			facilitiesList.get(i).displayFacilityDetails();
		}
		
		
		
		//Get Facility Information by FacilityID
		FacilityDetails test21 = fmp.getFacilityInformationByID(5);
		test21.displayFacilityDetails();
		
		
		
		//Removing a Facility
		fmp.removeFacility(5);
		
		*/
	}

}
