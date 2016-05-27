package com.fms.dao.facility;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.fms.model.use.FacilityUseDetails;
import com.fms.util.FMSConstants;
import com.fms.util.HibernateHelper;

public class FacilityUseDAO implements InterfaceFacilityUseDAO{
	
	public void assignFacilityToUse(int facilityID){
		
		
		try{
			System.out.println("*************** Assigning Facility To Use ***************** " );
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query assignFacilityQuery = session.createQuery("UPDATE FacilityDetails set isInUseNow= :isInUseNow WHERE facilityID= :facilityID");		
			assignFacilityQuery.setBoolean("isInUseNow", true);
			assignFacilityQuery.setInteger("facilityID", facilityID);
			assignFacilityQuery.executeUpdate();
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println("HQL Exception" + e.getMessage());
		}
		
	}

	public int bookFacility(FacilityUseDetails facilityUse){
		
		
		int bookingID;
		System.out.println("*************** Booking the Facility ******************** " );
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(facilityUse);
		
		Criteria criteria = session.createCriteria(FacilityUseDetails.class).setProjection(Projections.max("bookingID"));
		bookingID = (Integer)criteria.uniqueResult();
		System.out.println("The booking id is : "+bookingID);
		
		session.getTransaction().commit();
		return bookingID;
		
	}
	
	
	public int checkFacilityAvailabilityForDate(int facilityID, Date forDate){
		
		int totalBookedSeats = 0;
		int totalCapacity = 0;
		System.out.println("*************** Check Facility Availability For Date : " + forDate);
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		
		
		
		Query checkNumbSeatsQuery = session.createQuery("SELECT SUM(numbOfSeats) FROM FacilityUseDetails WHERE facilityID= :facilityID AND bookingDate= :bookingDate");
		checkNumbSeatsQuery.setInteger("facilityID", facilityID);
		checkNumbSeatsQuery.setDate("bookingDate", forDate);
		System.out.println("checkNumbSeatsQuery.uniqueResult()  = " + checkNumbSeatsQuery.uniqueResult());
		if(null == checkNumbSeatsQuery.uniqueResult()){
			totalBookedSeats = 0;
		}else{
			totalBookedSeats = Integer.parseInt(checkNumbSeatsQuery.uniqueResult().toString());
		}
		System.out.println("totalBookedSeats = " +totalBookedSeats);
		
		
		Query getCapacityQuery = session.createQuery("SELECT capacity FROM FacilityDetails WHERE facilityID= :facilityID");
		getCapacityQuery.setInteger("facilityID", facilityID);
		totalCapacity = Integer.parseInt(getCapacityQuery.uniqueResult().toString());
		System.out.println("totalCapacity = " +totalCapacity);
		session.getTransaction().commit();
		
		if(totalBookedSeats == 0){
			return FMSConstants.AVAILABLE_COMPLETELY;
		}else if(totalBookedSeats < totalCapacity){
			return FMSConstants.AVAILABLE_PARTIALLY;
		}else{
			return FMSConstants.NOT_AVAILABLE;
		}
	}
	
	
	public int getNumbOfBookedSeats(int facilityID,Date forDate){
		
		int totalBookedSeats = 0;
		System.out.println("*************** Get Numb Of Booked Seats for Date : " + forDate);
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query getNumbBookedSeatsQuery = session.createQuery("SELECT SUM(numbOfSeats) FROM FacilityUseDetails WHERE facilityID= :facilityID AND bookingDate= :bookingDate");
		getNumbBookedSeatsQuery.setInteger("facilityID", facilityID);
		getNumbBookedSeatsQuery.setDate("bookingDate", forDate);
		if(null == getNumbBookedSeatsQuery.uniqueResult()){
			totalBookedSeats = 0;
		}else{
			totalBookedSeats = Integer.parseInt(getNumbBookedSeatsQuery.uniqueResult().toString());
		}
		session.getTransaction().commit();
		
		return totalBookedSeats;
	}
	
	
	public void vacateFacility(int facilityID){
		
		
		try{
			System.out.println("*************** Assigning Facility To Use ***************** " );
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query assignFacilityQuery = session.createQuery("UPDATE FacilityDetails set isInUseNow= :isInUseNow WHERE facilityID= :facilityID");		
			assignFacilityQuery.setBoolean("isInUseNow", false);
			assignFacilityQuery.setInteger("facilityID", facilityID);
			assignFacilityQuery.executeUpdate();
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println("HQL Exception" + e.getMessage());
		}
		
	}
}
