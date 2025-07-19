package com.tka.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SaveOperation {

	public static void main(String[] args) {
		
		StandardServiceRegistry registry = null;
		Metadata metadata = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			
			registry =  new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
			
			metadata = new MetadataSources(registry).addAnnotatedClass(Employee.class) .buildMetadata(); 
			
		    factory = metadata.buildSessionFactory();
		    
		    session = factory.openSession();
		    
		    tx = session.beginTransaction();
		    
//		    Employee emp = new Employee();
//		    emp.setId(1);
//		    emp.setName("vib");
//		    emp.setProfile("dev");
//		    emp.setEmail("vib@gmail.com");
//		    emp.setSalary(90000);
//		    emp.setAge(20);
//		    emp.setExperiance(5);
//		    emp.setLoc("pune");
//
//		    session.save(emp);
//		    
//		    Employee emp2 = new Employee();
//		    emp2.setId(2);
//		    emp2.setName("sid");
//		    emp2.setProfile("test");
//		    emp2.setEmail("sid@gmail.com");
//		    emp2.setSalary(60000);
//		    emp2.setAge(21);
//		    emp2.setExperiance(2);
//		    emp2.setLoc("mumabai");
//		    session.save(emp2);
		    
		    // INSERT operation using save()
		    Employee emp3 = new Employee();
		    emp3.setId(3);
		    emp3.setName("jay");
		    emp3.setProfile("dev");
		    emp3.setEmail("jay@gmail.com");
		    emp3.setSalary(80000);
		    emp3.setAge(26);
		    emp3.setExperiance(3);
		    emp3.setLoc("nashik");
		    session.save(emp3);

		    
		System.out.println("Save operation sucessfull");
		    
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


