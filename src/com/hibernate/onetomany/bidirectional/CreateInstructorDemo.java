package com.hibernate.onetomany.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.entityclass.bidirectional.Courses;
import com.hibernate.onetomany.entityclass.bidirectional.Instructor;
import com.hibernate.onetomany.entityclass.bidirectional.InstructorDetailClass;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Courses.class).addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetailClass.class).buildSessionFactory();
	
	Session session = sessionFactory.getCurrentSession();
	
	try {
		Instructor instructor = new Instructor("tonmoy", "saha", "tonmoy@gmail.com");
		
		InstructorDetailClass instructorDetailClass = new InstructorDetailClass("https://www.youtube.com/watch?v=z65MTQQjgjg&list=RDz65MTQQjgjg&start_radio=1", "sameasconfused");
		
		instructor.setInstructorDetailClass(instructorDetailClass);
		
		session.beginTransaction();
		
		session.save(instructor);
		
		session.getTransaction().commit();
	} finally {
		// TODO: handle finally clause
		session.close();
		sessionFactory.close();
	}
	
	
	

	}

}
