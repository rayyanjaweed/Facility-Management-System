package com.fms.view;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fms.model.facility.AddressDetails;
import com.fms.model.facility.BuildingDetails;
import com.fms.model.facility.FacilityDetails;
import com.fms.model.use.FacilityUseDetails;
import com.fms.processor.FacilityMaintenanceProcessor;
import com.fms.processor.FacilityManagementProcessor;
import com.fms.processor.FacilityUseProcessor;

public class ClientView {

	public static void main(String[] args) {

		
//		· Facility:
//		1. List All Facilities
//		2. Get Facility Information by FacilityID
//		3. Get Available Capacity
//		4. Add Facility
//		5. Add Facility Detail
//		6. Removing a Facility
		
//		· Facility Use:
//		7. Assign facility to use
//		8. Book a facility
//		9. Vacate the facility
		
//		· Facility Maintenance:
//		10. Make Facility maintenance request
//		11. Calculate Maintenance Cost
//		12. Calculate down time for maintenance
//		13. List maintenance requests
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");
		
		int k = 1;
		
		FacilityMaintenanceProcessor fmaintp = (FacilityMaintenanceProcessor) context.getBean("facilityMaintenanceProcessorID");
		FacilityManagementProcessor fmp = (FacilityManagementProcessor) context.getBean("facilityManagementProcessorID");
		FacilityUseProcessor fup = (FacilityUseProcessor) context.getBean("facilityUseProcessorID");
		
		switch(k){
		
		case 1: 
						//List All Facilities
						ArrayList<FacilityDetails> facilitiesList = new ArrayList<FacilityDetails>();
						facilitiesList = fmp.listFacilities();
						for(int i = 0; i < facilitiesList.size(); i++){
							facilitiesList.get(i).displayFacilityDetails();
						}
						break;
						
		case 2: 
						//Get Facility Information by FacilityID
						FacilityDetails test21 = fmp.getFacilityInformationByID(4);
						test21.displayFacilityDetails();
						break;
						
		case 3: 
						//Get Available Capacity
						Date date = new Date(2015, 02, 20);
						System.out.println("Available Capacity =" + fup.getAvailableCapacity(2, date ));
						break;
						
		case 4: 
						//Add a new Facility

						AddressDetails facilityAddress = (AddressDetails) context.getBean("facilityAddress");
						facilityAddress.setCityName("Chicago");
						facilityAddress.setSerialNumb(2833);
						facilityAddress.setStateName("Illinois");
						facilityAddress.setStreetName("W Pearson Ave");
						facilityAddress.setZipCode(60228);
						
						
						BuildingDetails buildingDetails = (BuildingDetails) context.getBean("buildingDetails");
						buildingDetails.setArea(444.21);
						buildingDetails.setFloors(27);
						buildingDetails.setNumbOfElevators(9);
						buildingDetails.setNumbOfEscalators(6);
						buildingDetails.setNumbOfRooms(90);
						buildingDetails.setNumbOfStaircases(4);
						
						
						FacilityDetails test = (FacilityDetails) context.getBean("facilityDetailsID");
						test.setAvailable(true);
						test.setBuilding(true);
						test.setCapacity(260);
						test.setBuildingDetails(buildingDetails);
						test.setFloorNumb(6);
						test.setRoomNumb(644);
						test.setFacilityAddress(facilityAddress);
						test.setFacilityName("Test Facility");
						
						
						fmp.addFacility(test);
						
						break;
						
		case 5: 
						//Add Facility Detail
						fmp.addFacilityDetail(6, "Detail: Area of the room is 8888 sqft");
						break;
						
		case 6: 
						//Removing a Facility
						fmp.removeFacility(7);
						break;
						
		case 7: 
						//Assign facility to use
						fup.assignFacilityToUse(6);
						break;
						
		case 8: 
						//Book a facility
						Date date2 = new Date(2033 -1900, 02, 25);
						System.out.println("Date :" + date2);
						FacilityUseDetails facilityUse = (FacilityUseDetails) context.getBean("facilityUseDetailsID");
						facilityUse.setBookingDate(date2);
						facilityUse.setBookedBy(1);
						facilityUse.setFacilityID(6);
						facilityUse.setNumbOfSeats(100);
						fup.bookFacility(facilityUse);
						break;
						
		case 9: 
						//Vacate the facility
						fup.vacateFacility(6);
						break;
						
		case 10: 
						//Make Facility maintenance request
						Date date3 = new Date(2015 -1900, 06, 22);
						FacilityUseDetails facilityUse13 = (FacilityUseDetails) context.getBean("facilityUseDetailsID");
						facilityUse13.setBookingDate(date3);
						facilityUse13.setBookedBy(3);
						facilityUse13.setFacilityID(6);
						fmaintp.requestFacilityMaintenance(facilityUse13);
						break;
						
		case 11: 
						//Calculate Maintenance Cost
						double costInDollars = fmaintp.calcMaintenanceCostForFacility(2);
						System.out.println("Maintenance Cost for Facility = " + costInDollars);
						break;
						
		case 12: 
						//Calculate down time for maintenance
						double downTimeDays = fmaintp.calcDownTimeForFacility(2);
						System.out.println("Down time for maintenance in days = " + downTimeDays);
						break;
						
		case 13:
						//List maintenance requests
						fmaintp.listFacilityMaintenanceRequest();	
						break;
		}
		
		
	}

}
