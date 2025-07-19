package com.tka.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SelectOperation {

	public static void main(String[] args) {
		

        StandardServiceRegistry registry = null;
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;

        try {
            
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(registry).addAnnotatedClass(Employee.class).buildMetadata();

            // Build SessionFactory
            factory = metadata.buildSessionFactory();

            // Open Session and begin transaction
            session = factory.openSession();
            
            tx = session.beginTransaction();

            // SELECT operation using load()
            Employee emp = session.load(Employee.class, 3);  
            System.out.println(emp);
            System.out.println("Select operation done successfully.");
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if(tx != null && session != null && registry != null) {
				tx.commit();
				session.close();
				registry.close();
        }
    }
}
}











