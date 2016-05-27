package com.fms.dao.facility;

import java.util.Date;

import com.fms.model.facility.FacilityDetails;
import com.fms.model.use.FacilityUseDetails;

public interface InterfaceFacilityUseDAO {

	public void assignFacilityToUse(int facilityID);
	public int bookFacility(FacilityUseDetails facilityUse);
	public int checkFacilityAvailabilityForDate(int facilityID, Date forDate);
	public int getNumbOfBookedSeats(int facilityID,Date forDate);
	public void vacateFacility(int facilityID);
}
