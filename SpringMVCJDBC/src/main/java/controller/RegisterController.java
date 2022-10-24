package controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentServiceImpl;

@Controller	
public class RegisterController  {
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public ModelAndView showUser(@RequestParam("sno") String sno, 
			@RequestParam("spwd") String spwd,@RequestParam("smail") String smail,
			@RequestParam("sname") String sname,@RequestParam("ssex") int ssex,
			@RequestParam("sbday") String sbday) {
		StudentServiceImpl ssi = new StudentServiceImpl();
		String message="";
		Student student = ssi.selectBySnoforlogin(sno);
		if (student!=null) { //不存在就創建
			ssi.insertforRegister(sno, sname, sbday,ssex, smail, spwd);
			message ="創建成功";
			
		}else {
			message="創建失敗";
		}		
		ModelAndView mv = new ModelAndView("resultregister");
		mv.addObject("message", message);
		return mv;

	}

	 

	
}

