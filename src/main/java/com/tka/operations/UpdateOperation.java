package com.tka.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UpdateOperation {

	public static void main(String[] args) {
		
		StandardServiceRegistry registry = null;
		Metadata metadata = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			
		registry = new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
		
		metadata =  new MetadataSources(registry).addAnnotatedClass(Employee.class).buildMetadata();
		
		factory = metadata.buildSessionFactory();
		
		session = factory.openSession();
		
		tx = session.beginTransaction();
		
		// UPDATE operation using update()
		Employee emp = new Employee(2,"reshma","dev","reshma@gmail.com",60000,21,2,"mumbai");
		session.update(emp);
		System.out.println("update operation done sucessfully");
		

	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(tx != null && session !=null && registry != null ) {
			   tx.commit();
			   session.close();
			   registry.close();
	}

}
}
}



