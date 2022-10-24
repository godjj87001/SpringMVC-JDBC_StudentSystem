package tw.com.phctw.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.StudentDao;
import tw.com.phctw.service.StudentServiceImpl;

public class JdbcDemo {

	StudentServiceImpl ssi = new StudentServiceImpl();
	
	Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		JdbcDemo jdbc = new JdbcDemo();		
		try {
			jdbc.logging();
		} catch (Exception e) {
		}
	}

	public void select() {
		List<Student> list = ssi.selectStudent();
		System.out.println("學號\t姓名\t生日\t\t性別\t信箱\t\t\t\t密碼");
		for (Student student : list) {
			System.out.println(student.getSno() + "\t" + student.getSname() + "\t" + student.getSbday() + "\t"
					+ student.getSsex() + "\t" + student.getSmail() + "\t" + student.getSpwd());
		}

	}

	public List<Student> selectall() {

		List<Student> list = ssi.selectStudent();
		System.out.println("學號\t姓名\t生日\t\t性別\t信箱\t\t\t\t密碼");

		return list;
	}

	public void insert() {
		System.out.println("*******新增*******");
		System.out.print("輸入p繼續動作，或輸入任意鍵退出新增程序。" + "\n" + "繼續或退出: ");
		if (scn.next().equals("p")) {
			System.out.println("請輸入學號");
			String sno = scn.next();

			System.out.println("請輸入姓名");
			String name = scn.next();
			System.out.println("請輸入生日 yyyy-MM-dd");
			String birthday = scn.next();
			System.out.println("請輸入性別 1 or 0");
			int sex = scn.nextInt();
			System.out.println("信箱xxx@xxx.com");
			String smail = scn.next();
			System.out.println("密碼");
			String spwd = scn.next();
			System.out.println("學號\t姓名\t生日\t\t性別\t信箱\t\t\t\t密碼");
			System.out.println("新增的資料" + sno + name + birthday + sex + smail + spwd);
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Student stu = new Student(sno, name, sd.parse(birthday), sex, smail, spwd);

				Boolean num = ssi.insertStudent(stu);
				System.out.println();
				if (num == false) {
					System.out.println("添加失敗");
				} else {
					System.out.println("添加成功");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("格式錯誤");
			}
		} else {
			System.out.println("退出新增");
		}
	}

	public void update() {
		System.out.println("*******修改*******");
		System.out.print("輸入p繼續動作，或輸入任意鍵退出修改程序。" + "\n" + "繼續或退出: ");
		if (scn.next().equals("p")) {
			System.out.println("請輸入你要修改的學生學號");
			String sno = scn.next();

			Student student = new Student();
			student.setSno(sno); // where sno
			System.out.println("修改的sno=" + sno);

			System.out.println("請輸入修改後的學號sno");
			String altersno = scn.next();
			student.setAltersno(altersno);
			System.out.println("請輸入修改後的姓名");
			String name = scn.next();
			student.setSname(name);
			System.out.println("請輸入修改後的生日");
			String birthday = scn.next();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			try {
				student.setSbday(sd.parse(birthday));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("請輸入修改後的性別");
			int sex = scn.nextInt();
			student.setSsex(sex);
			System.out.println("請輸入修改後的MAIL");
			String smail = scn.next();
			student.setSmail(smail);
			System.out.println("請輸入修改後的PWD");
			String pwd = scn.next();
			student.setSpwd(pwd);

			Object obj[] = { student.getAltersno(), student.getSname(), student.getSbday(), student.getSsex(),
					student.getSmail(), student.getSpwd(), student.getSno() };
			System.out.println("學號\t姓名\t生日\t\t性別\t信箱\t\t\t\t密碼");
			for (Object i : obj) {
				System.out.print(i + "\t");
			}

			System.out.println("請問確定修改嗎? (y / n)");
			String qd = scn.next();
			if (qd.equalsIgnoreCase("y")) {
				int num = ssi.updateStudent(student);
				if (num == 0) {

					System.out.println("修改失敗");
				} else {
					System.out.println("修改成功");
				}
			} else if (qd.equalsIgnoreCase("n")) {
				System.out.println("修改撤銷成功");
			} else {
				System.out.println("選擇錯誤，請重新操作");
			}
		} else {
			System.out.println("退出修改");
		}

	}

	public void selectBySno() {

		System.out.println("請輸入你要查詢的學生資料學號");
		String sno = scn.next();

		StudentServiceImpl sdi = new StudentServiceImpl();
		Student stu =sdi.selectBySno(sno);

		
		System.out.println("學號\t姓名\t生日\t\t性別\t信箱\t\t\t\t密碼");
		System.out.println(stu.getSno()+"\t"+stu.getSname()+"\t"+stu.getSbday()+"\t"+stu.getSsex()+"\t"+stu.getSmail()+"\t"+stu.getSpwd());

	}

	public void delete() {
		System.out.println("*******刪除*******");
		System.out.print("輸入p繼續動作，或輸入任意鍵退出修改程序。" + "\n" + "繼續或退出: ");
		if (scn.next().equals("p")) {
			System.out.println("請輸入要刪除的學生編號");
			String sno = scn.next();
			System.out.println("學號");
			System.out.println(sno);

			System.out.println("確定刪除嗎?()Y/N");
			String qd = scn.next();
			if (qd.equalsIgnoreCase("y")) {
				Boolean num = ssi.deleteStudent(sno);
				if (num == false) {
					System.out.println("刪除成功");
				} else {
					System.out.println("刪除失敗");
				}
			} else if (qd.equalsIgnoreCase("n")) {
				System.out.println("刪除撤銷成功");
			} else {
				System.out.println("選擇錯誤，請重新操作");
			}
		} else {
			System.out.println("退出刪除");
		}

	}

	public void logging() {

		while (true) {
			System.out.println("*******************");
			System.out.println("1:查詢");
			System.out.println("2:新增");
			System.out.println("3:修改");
			System.out.println("4:刪除");
			System.out.println("5:退出");
			System.out.println("*******************");
			System.out.print("請輸入選擇:");
			int n = scn.nextInt();

			if (n == 1) {
				select();
			} else if (n == 2) {
				insert();
			} else if (n == 3) {
				update();
			} else if (n == 4) {
				delete();
			} else if (n == 5) {
				System.out.println("退出成功!");
				scn.close();
				StudentDao.close();
				System.exit(0);
			}else if (n==6) {
				selectBySno();
			}

			else {
				System.out.println("選擇錯誤,重新輸入");
				break;
			}

		}

	}

}
