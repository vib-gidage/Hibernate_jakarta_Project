package com.tka.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class getOpertaion {

	public static void main(String[] args){
		
		StandardServiceRegistry registry = null;
		Metadata metadata = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		
		
		try {
		
        // Step 1: Build the Service Registry (reads hibernate.cfg.xml)
        registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();   // Looks for config in classpath
		
        // Step 2: Build Metadata from the Registry
        metadata = new MetadataSources(registry).addAnnotatedClass(Employee.class) .buildMetadata();
		
		factory = metadata.buildSessionFactory();
		
		session = factory.openSession();
		
		tx = session.beginTransaction();
		
		// SELECT operation using get()
		Employee emp = session.get(Employee.class,101);
		
		if(emp != null) {
			System.out.println(emp);
		}else {
			System.out.println("emp id is not prsent");
		}
		
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









