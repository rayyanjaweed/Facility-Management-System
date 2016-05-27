package com.fms.dao.facility;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fms.model.maintenance.FacilityMaintenanceDetails;
import com.fms.util.HibernateHelper;

public class FacilityMaintenanceDAO implements InterfaceFacilityMaintenanceDAO{

	
	public ArrayList<FacilityMaintenanceDetails> listFacilityMaintenanceRequest(){
		
		ArrayList<FacilityMaintenanceDetails> facilityMaintenanceRequestList = new ArrayList<FacilityMaintenanceDetails>();
		System.out.println("*************** Listing Facility Maintenance Requests***************** " );
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query listAllFacilityMaintenanceRequest = session.createQuery("FROM FacilityMaintenanceDetails");
		facilityMaintenanceRequestList = (ArrayList<FacilityMaintenanceDetails>) listAllFacilityMaintenanceRequest.list();
		return facilityMaintenanceRequestList;
	}
	
	public void scheduleFacilityMaintenance(FacilityMaintenanceDetails fmd){
		
		System.out.println("getFacilityID  " + fmd.getFacilityID());
		System.out.println("getMaintenanceID  " + fmd.getMaintenanceID());
		System.out.println("getBookingID  " + fmd.getBookingID());
		System.out.println("getCost  " + fmd.getCost());
		System.out.println("getDownTimeDays  " + fmd.getDownTimeDays());
		
		System.out.println("*************** Scheduling Facility Maintenance ******************** " );
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(fmd);
		session.getTransaction().commit();
	}
}
