package com.hibernate.onetomany.bidirectional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.entityclass.bidirectional.Courses;
import com.hibernate.onetomany.entityclass.bidirectional.Instructor;
import com.hibernate.onetomany.entityclass.bidirectional.InstructorDetailClass;

public class GetInstructorCoursesDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Courses.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetailClass.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			

			session.beginTransaction();
		
			int instructorId = 3;

			Instructor instructor = session.get(Instructor.class, instructorId);
			
			System.out.println("the instructor" +instructor);
			
			System.out.println("instructor courses with id: "+ instructorId +": "+instructor.getCourses());

			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			session.close();
			sessionFactory.close();
		}

	}

}
