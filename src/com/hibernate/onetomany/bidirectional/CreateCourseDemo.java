package com.hibernate.onetomany.bidirectional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.entityclass.bidirectional.Courses;
import com.hibernate.onetomany.entityclass.bidirectional.Instructor;
import com.hibernate.onetomany.entityclass.bidirectional.InstructorDetailClass;

public class CreateCourseDemo {

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
			
			Courses courses = new Courses("oop");
			Courses courses2 = new Courses("java");

			

			session.save(courses);
			session.save(courses2);

			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			session.close();
			sessionFactory.close();
		}

	}

}
