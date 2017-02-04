package com.mongo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.ogm.book.model.Book;
import org.hibernate.stat.Statistics;


public class DAO {

	private static DAO instance;
	private SessionFactory factory;
	private static volatile Session session;
	private static volatile Transaction trans;
	
	private static volatile EntityManagerFactory emf;
	private static volatile EntityManager entityManager;


	/**
	 * Intantiate DAO class that loads configured SessionFactory object. 
	 * 
	 * You can also configure further settings for the session. 
	 * 
	 */
	private DAO() {

		factory = HibernateUtil.getSessionFactory();
		System.out.println("Creating factory");

		Statistics stats = factory.getStatistics(); 
		stats.setStatisticsEnabled(true);
		
		session = factory.openSession();
		session.setFlushMode(FlushMode.ALWAYS);
		
		emf = Persistence.createEntityManagerFactory( "hike-PU-JTA" );
		entityManager = emf.createEntityManager();

		
	}

	/**
	 * DAO instance is always synchronized, for sake of memory consistency, 
	 * and we use a shared static session object.
	 * 
	 * @return DAO instance
	 */
	public static synchronized DAO instance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}
	
	public Book getBooks(String author){
		
		session = factory.getCurrentSession();
		
	    trans = session.getTransaction();
		
		if (!trans.isActive()) {
			
			trans.begin();
		}
		
		String hql = "from Book";
		
		org.hibernate.Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		
		return list.get(0);
	}
	

}
