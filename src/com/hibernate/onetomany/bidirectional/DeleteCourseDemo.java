package com.hibernate.onetomany.bidirectional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.onetomany.entityclass.bidirectional.Courses;
import com.hibernate.onetomany.entityclass.bidirectional.Instructor;
import com.hibernate.onetomany.entityclass.bidirectional.InstructorDetailClass;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Courses.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetailClass.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			

			session.beginTransaction();
		
			int courseId = 10;
			
			Courses courses = session.get(Courses.class, courseId);
			
			session.delete(courses);

			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			session.close();
			sessionFactory.close();
		}

	}

}
