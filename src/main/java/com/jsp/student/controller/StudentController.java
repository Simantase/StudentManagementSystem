package com.jsp.student.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.student.service.StudentService;
@Controller
public class StudentController {
	@Autowired
	private StudentService ss;
	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest req,HttpServletResponse resp)
	{
		int sId=Integer.parseInt(req.getParameter("sId"));
		String sName=req.getParameter("sName");
		int sMarks=Integer.parseInt(req.getParameter("sMarks"));

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","Data Is Added Successfully");
		ss.saveStudent(sId, sName, sMarks);
		return mav;
	}
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest req,HttpServletResponse resp)
	{
		int sId=Integer.parseInt(req.getParameter("sId"));
		int sMarks=Integer.parseInt(req.getParameter("sMarks"));
		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","Data Is Updated Successfully");
		ss.updateById(sId, sMarks);
		return mav;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse resp)
	{
		int sId=Integer.parseInt(req.getParameter("sId"));
		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","Data Is Deleted Successfully");
		ss.deleteById(sId);
		return mav;
	}
	@RequestMapping("/fetch")
	public ModelAndView fetch(HttpServletRequest req,HttpServletResponse resp)
	{
		int sId=Integer.parseInt(req.getParameter("sId"));
		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","Data Is Fetched Successfully");
		ss.fetchById(sId);
		return mav;
	}
	@RequestMapping("/fetchAll")
	public ModelAndView fetchAll(HttpServletRequest req,HttpServletResponse resp)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("output1.jsp");
		mav.addObject("output1","All The Data Are Fetched Successfully");
		ss.fetchAll();
		return mav;
	}
}
