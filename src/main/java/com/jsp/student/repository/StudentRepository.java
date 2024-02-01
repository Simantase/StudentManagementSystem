package com.jsp.student.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jsp.student.model.Student;

@Repository
public class StudentRepository {
	public static Session getSession()
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		return session;
	}
	public void saveStudent(int sId,String sName,int sMarks)
	{
		Session session=StudentRepository.getSession();
		Transaction trans=session.beginTransaction();
		Student s1=new Student();
		s1.setsId(sId);
		s1.setsName(sName);
		s1.setsMarks(sMarks);
		session.save(s1);
		System.out.println("Data Is Saved Successfully");
		trans.commit();
		session.close();
	}
	public void updateById(int sId,int sMarks)
	{
		Session session=StudentRepository.getSession();
		Transaction trans=session.beginTransaction();
		Student s=session.get(Student.class,sId);
		s.getsId();
		s.setsMarks(sMarks);
		session.update(s);
		System.out.println("Data Is Updated Successfully");
		trans.commit();
		session.close();
	}
	public void deleteById(int sId)
	{
		Session session=StudentRepository.getSession();
		Transaction trans=session.beginTransaction();
		Student s=session.get(Student.class,sId);
		session.delete(s);
		System.out.println("Data Is Deleted Successfully");
		trans.commit();
		session.close();
	}
	public void fetchById(int sId)
	{
		Session session=StudentRepository.getSession();
		Transaction trans=session.beginTransaction();
		Student s=session.get(Student.class,sId);
		System.out.println(s);
		System.out.println("Data Is Fetched Successfully");
		trans.commit();
		session.close();
	}
	public void fetchAll()
	{
		Session session=StudentRepository.getSession();
		Transaction trans=session.beginTransaction();
		Query<Student> query=session.createQuery("from Student");
		List<Student> l1=query.list();
		for(Student s:l1)
		{
			System.out.println(s);
		}
		System.out.println("All The Data Are Fetched Successfully");
		trans.commit();
		session.close();
	}
}

