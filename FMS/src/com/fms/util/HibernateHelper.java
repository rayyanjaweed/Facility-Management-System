package com.fms.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class HibernateHelper {
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("*************** Session Factory instantiated ..................");
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Rayyan's message Initial SessionFactory creation failed." + ex.getMessage() );
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
