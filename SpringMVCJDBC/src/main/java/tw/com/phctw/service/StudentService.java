package tw.com.phctw.service;



import java.util.List;

import org.springframework.stereotype.Service;

import tw.com.phctw.bean.Student;

@Service (value ="service")
public interface  StudentService {
	
	public List<Student> selectStudent(); //查詢學生資料

	public Boolean insertStudent(Student student); //新增學生資料

	public Integer updateStudent(Student student); //修改學生資料

	public Boolean deleteStudent(String sno); //刪除學生資料
    
	public Student selectBySno(String sno); //查詢學生by sno
	
	public Student selectBySnoSpwd(String sno,String spwd); //查詢學生by sno spwd
  
}