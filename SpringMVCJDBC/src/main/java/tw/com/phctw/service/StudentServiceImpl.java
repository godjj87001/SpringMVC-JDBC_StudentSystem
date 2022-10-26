package tw.com.phctw.service;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.math.BigInteger;
import java.security.MessageDigest;

import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.StudentDao;

public class StudentServiceImpl implements StudentService {

	public static StudentDao dao = new StudentDao();

	@Override
	public List<Student> selectStudent() {
		// TODO Auto-generated method stub

		return dao.selectStudent();
	}

	@Override
	public Boolean insertStudent(Student student) {
		
	return dao.insertStudent(student);
	}

	@Override
	public Integer updateStudent(Student student) {
		
		return dao.updateStudent(student);
	}

	@Override
	public Boolean deleteStudent(String sno) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(sno);
	}

	@Override
	public Student selectBySno(String sno) {
		// TODO Auto-generated method stub
		return dao.selectStudentbySno(sno);
	}

	public static Boolean flag = null ;
	public void insertforjsp() {
		System.out.println("*******新增*******");
		int sno_ran = (int) (Math.random()*100000);
		String sno = String.valueOf(sno_ran);
		int name_ran = (int) (Math.random()*26)+65;
		String name =String.valueOf((char)name_ran); 
		int year_ran =(int) (Math.random()*100)+1900;
		int month_ran =(int) (Math.random()*13);
		int day_ran =(int) (Math.random()*32);
		String birthday = String.valueOf(year_ran+"-"+month_ran+"-"+day_ran);
		int sex =(int) (Math.random()*2);		
		int mail_ran =(int) (Math.random()*26)+65;
		String smail=String.valueOf(mail_ran);
		int pwd_ran = (int) (Math.random()*100000);
		String spwd = String.valueOf(pwd_ran);
			

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				Student stu = new Student(sno, name, sd.parse(birthday), sex, smail, spwd);

				
				Boolean num =insertStudent(stu);
				
				
				if (num == false) {
					System.out.println("添加失敗");
					System.out.println(sno);
					flag=false;
					
				} else {
					System.out.println("添加成功");
					System.out.println("學號\t姓名\t生日\t\t性別\t信箱\t\t\t\t密碼");
					System.out.println("新增的資料" + sno + name + birthday + sex + smail + spwd);
					flag=true;
					
					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("格式錯誤");
			}
	}
//	public void insertforuser(String account,String password,String email,String name) {
//		System.out.println("*******新增*******");
//		
//		String acc = account;
//		
//		String pwd =password;
//		
//		String mail = email;
//		
//		String username=name;
//
//			
//			try {
//				Student stu = new Student(acc, pwd, mail,username);
//
//				
//				Boolean num =insertStudent(stu);
//				
//				
//				if (num == false) {
//					System.out.println("添加失敗");
//					System.out.println(sno);
//					flag=false;
//					
//				} else {
//					System.out.println("添加成功");
//					System.out.println("學號\t姓名\t生日\t\t性別\t信箱\t\t\t\t密碼");
//					System.out.println("新增的資料" + sno + name + birthday + sex + smail + spwd);
//					flag=true;
//					
//					
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				System.out.println("格式錯誤");
//			}
//	}
	
	public Student selectBySnoforlogin(String sno) {
		

		Student stu =selectBySno(sno);
		return stu;
		
	}


	public Student sendEmail(String smail) {
		// TODO Auto-generated method stub
		return null;
	}
	public void insertforRegister(String sno_,String sname ,String Sbday,int ssex,String mail,String pwd) {
	
		String sno = sno_;
		String name =sname;
		String birthday = Sbday;
		int sex = ssex;
		String smail = mail;
		String spwd = getMD5(pwd);
		System.out.println("學號\t姓名\t生日\t\t性別\t信箱\t\t\t\t密碼");
		System.out.println("新增的資料" + sno + name + birthday + sex + smail + spwd);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Student stu = new Student(sno, name, sd.parse(birthday), sex, smail, spwd);

			Boolean num = insertStudent(stu);
			System.out.println();
			if (num == false) {
				System.out.println("添加失敗");
				flag=false;
			} else {
				System.out.println("添加成功");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("格式錯誤");
			flag=false;
		}
		 
	}
	
	  public static String getMD5(String str) {
	  try {
	  // 生成一個MD5加密計算摘要
	  MessageDigest md = MessageDigest.getInstance("MD5");
	  // 計算md5函式
	  md.update(str.getBytes());
	  // digest()最後確定返回md5 hash值，返回值為8為字串。因為md5 hash值是16位的hex值，實際上就是8位的字元
	  // BigInteger函式則將8位的字串轉換成16位hex值，用字串來表示；得到字串形式的hash值
	  return new BigInteger(1, md.digest()).toString(16);
	  } catch (Exception e) {
	  System.out.println("錯誤");
	  }
	  return str;
	  }

	@Override
	public Student selectBySnoSpwd(String sno, String spwd) {
		// TODO Auto-generated method stub
		String spwdMD5 = getMD5(spwd);
		Student stu =dao.selectStudentbySnoSpwd(sno,spwdMD5);
		return stu;
	}
	
}