package com.fms.dao.facility;

import java.util.ArrayList;

import com.fms.model.maintenance.FacilityMaintenanceDetails;

public interface InterfaceFacilityMaintenanceDAO {

	
	public ArrayList<FacilityMaintenanceDetails> listFacilityMaintenanceRequest();
	public void scheduleFacilityMaintenance(FacilityMaintenanceDetails fmd);
}
