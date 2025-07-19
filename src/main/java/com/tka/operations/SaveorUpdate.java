package com.tka.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class SaveorUpdate {

	public static void main(String[] args) {
		
		StandardServiceRegistry registry = null;
		Metadata metadata = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			
		registry =  new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
		
		metadata = new MetadataSources(registry).addAnnotatedClass(Employee.class).buildMetadata();
		
		factory = metadata.buildSessionFactory();
		
		session = factory.openSession();
		
		tx = session.beginTransaction();
		
		// SAVE or UPDATE operation using saveorupdate()
		Employee emp = new Employee(101,"neha","test","neha@gmail.com",60000,21,2,"mumbai");
		session.saveOrUpdate(emp);
		System.out.println("save or update operation sucessfull");
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(tx != null && session != null && registry != null) {
				tx.commit();
				session.close();
				registry.close();
			
		}
		
	}

}
}




