package com.fms.dao.facility;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fms.model.facility.FacilityDetails;
import com.fms.util.HibernateHelper;

public class FacilityDAO implements InterfaceFacilityDAO {

	
	public final int addFacility(FacilityDetails facility){
		int rowsUpdated = 0;
		
		System.out.println("*************** Adding the following facility details ******************** " );
		facility.displayFacilityDetails();
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(facility);
		session.getTransaction().commit();
		return rowsUpdated;
	}
	
	
	public void addFacilityDetail(int facilityID ,String detail){
		
		try{
			System.out.println("*************** Adding facility detail ***************** " );
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query getCustQuery = session.createQuery("UPDATE FacilityDetails set facilityDetail= :facilityDetail WHERE facilityID= :facilityID");		
			getCustQuery.setString("facilityDetail", detail);
			getCustQuery.setInteger("facilityID", facilityID);
			getCustQuery.executeUpdate();
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println("HQL Exception" + e.getMessage());
		}
		
		
	}
	
	
	public void deleteFacility(int ID){
		try{
			System.out.println("*************** Deleting facility ***************** " );
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query deleteFacilityQuery = session.createQuery("DELETE from FacilityDetails where facilityID= :facilityID");
			deleteFacilityQuery.setInteger("facilityID", ID);
			deleteFacilityQuery.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Facility is deleted");
			
		}catch(Exception e){
			System.out.println("HQL Exception" + e.getMessage());
		}
		
	}
	
	public ArrayList<FacilityDetails> listFacilities(){
		ArrayList<FacilityDetails> facilitiesList = new ArrayList<FacilityDetails>();
		System.out.println("*************** Listing facilities ***************** " );
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query listAllFacilities = session.createQuery("FROM FacilityDetails");
		facilitiesList = (ArrayList<FacilityDetails>) listAllFacilities.list();
		return facilitiesList;
	}
	
	public FacilityDetails getFacilityInformationByID(int ID){
		
		System.out.println("*************** Get Facility Information with ID ...  " + ID);
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query getFacilityQuery = session.createQuery("From FacilityDetails where facilityID= :facilityID");		
		getFacilityQuery.setInteger("facilityID", ID);
		List<FacilityDetails> facility = getFacilityQuery.list();
		session.getTransaction().commit();
		return (FacilityDetails)facility.get(0);
	}

}
