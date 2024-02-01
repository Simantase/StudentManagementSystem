package com.jsp.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository sr;
	public void saveStudent(int sId,String sName,int sMarks)
	{
		sr.saveStudent(sId, sName, sMarks);
	}
	public void updateById(int sId,int sMarks)
	{
		sr.updateById(sId, sMarks);
	}
	public void deleteById(int sId)
	{
		sr.deleteById(sId);
	}
	public void fetchById(int sId)
	{
		sr.fetchById(sId);
	}
	public void fetchAll()
	{
		sr.fetchAll();
	}
}
