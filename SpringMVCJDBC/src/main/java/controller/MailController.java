package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentServiceImpl;


@Controller

public class MailController {

//	@RequestMapping(value ="Mail.do", method = RequestMethod.POST)
//	public ModelAndView showUser(			
//			@RequestParam("smail") String smail){
//		StudentServiceImpl ssi =new StudentServiceImpl();
//		List<Student> list =ssi.selectStudent();
//		Student student =ssi.sendEmail();
		
//		ModelAndView mv = new ModelAndView("loginview");
//		List list =new ArrayList();
//		list.add(student.getSno());
//		list.add(student.getSname());
//		list.add(student.getSbday());
//		list.add(student.getSsex());		
//		list.add(student.getSmail());
//		list.add(student.getSpwd());
//		mv.addObject("stu", list);
//
//		return mv;		
				
//	}
	

}

