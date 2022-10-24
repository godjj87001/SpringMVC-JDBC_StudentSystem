package tw.com.phctw.service;



import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
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




	    public static void sendMail(String smail, String subject,String emailMsg)
	            throws AddressException, MessagingException {
	        //创建配置文件
	        Properties props = new Properties();
	        //设置发送时遵从SMTP协议
	        props.setProperty("mail.transport.protocol", "SMTP");
	        /*
	         * 发送邮件的域名
	         * smtp.xx.com
	         * smtp.qq.com则代表发送邮件时使用的邮箱域名来自qq
	         * smtp.163.com则代表发送邮件时使用的邮箱域名来自163
	         */
	        props.setProperty("mail.host", "smtp.qq.com");
	        //设置用户的认证方式auth
	        props.setProperty("mail.smtp.auth", "true");
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                //return new PasswordAuthentication("用户名", "密码");
	                //注意qq邮箱需要去qq邮箱的设置中获取授权码，并将授权码作为密码来填写
	                return new PasswordAuthentication("xxxxx@qq.com", "nilbnqjekzmtbcgd");
	            }
	        };
	        //创建session域
	        Session session = Session.getInstance(props, auth);
	        Message message = new MimeMessage(session);
	        //设置邮件发送者,与PasswordAuthentication中的邮箱一致即可
	        message.setFrom(new InternetAddress("xxxxx@qq.com"));
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
	        //设置邮件主题
	        message.setSubject(subject);
	        //设置邮件内容
	        message.setContent(emailMsg, "text/html;charset=utf-8");
	        //发送邮件
	        Transport.send(message);
	    }
	
}