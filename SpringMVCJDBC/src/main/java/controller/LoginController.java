package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentServiceImpl;

@Controller

public class LoginController {
	
	

	@RequestMapping(value = "Login.do", method = RequestMethod.POST)
	public ModelAndView showUser(@RequestParam("sno") String sno, @RequestParam("spwd") String spwd) {
		StudentServiceImpl ssi = new StudentServiceImpl();

		Student student = ssi.selectBySnoSpwd(sno,spwd);

		if (student.getSno()!=null) {
		ModelAndView mv = new ModelAndView("loginview");

		mv.addObject("stu", student);

		return mv;
		}
		else {
			ModelAndView mv = new ModelAndView("loginerror");

			mv.addObject("stu", student);

			return mv;

		}
	}

}
