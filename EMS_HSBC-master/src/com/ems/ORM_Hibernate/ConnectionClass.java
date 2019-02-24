package com.ems.ORM_Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionClass {

	private static Session session;
	private static SessionFactory sessionFactory;
	
	public static Session getsession()
	{
		session=new Configuration().configure().buildSessionFactory().openSession();
		return session;
	}
}
