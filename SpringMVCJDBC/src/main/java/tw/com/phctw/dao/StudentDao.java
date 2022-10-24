package tw.com.phctw.dao;
//後端SQL資料
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tw.com.phctw.bean.Student;
@Repository (value ="dao")
public class StudentDao {
	// 定義全域private屬性
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/sql?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static String user = "root";
	private static String password = "1234";
	private static Connection conn= null;
	private static PreparedStatement ps = null;
	private static ResultSet res = null;

	public StudentDao() { //建構子
		super();
		try {
			Class.forName(driver);
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static Integer update(String sql, Object obj[]) {
		int num = 0;
		try {
			ps = conn.prepareStatement(sql);

			// 數據注入
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}

			num = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return num;

	}

	// 查詢 通用的查詢方法不可直接釋放資源，當調用時再釋放資源
	public static ResultSet query(String sql, Object obj[]) {

		try {
			ps = conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			res = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Student> selectStudent() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();

		String sql = "SELECT * FROM student;";
		Object obj[] = {};
		ResultSet res = StudentDao.query(sql, obj);

		try {
			while (res.next()) { // String sno, String sname,Date sbday, int ssex, String smail, String spwd
				Student student = new Student(res.getString(1), res.getString(2), res.getDate(3), res.getInt(4),
						res.getString(5), res.getString(6));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		return list;
	}
	
	public Boolean insertStudent(Student student) {
		// 創建處理對象
		PreparedStatement pstmt = null;
		try { // String sno, String sname,Date sbday, int ssex, String smail, String spwd
			pstmt = conn.prepareStatement("insert into student(SNO,Sname,Sbday,ssex,smail,spwd) " + "values(?,?,?,?,?,?)");
			pstmt.setString(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setDate(3, new java.sql.Date(student.getSbday().getTime()));
			pstmt.setInt(4, student.getSsex());
			pstmt.setString(5, student.getSmail());
			pstmt.setString(6, student.getSpwd());
			return pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} finally {

			 
		}
		return false;
	}
	
	public Integer updateStudent(Student student) {

		// update student set sno='A06',sname='dsvd',sbday='2000-04-06',ssex=0 where
		// student.sno='A00';
		String sql = "update student set sno=?,sname=?,sbday=?,ssex=?,smail=?,spwd=? where sno=?";
		Object obj[] = { student.getAltersno(), student.getSname(), student.getSbday(), student.getSsex(),
				student.getSmail(), student.getSpwd(), student.getSno() };

		int num = StudentDao.update(sql, obj);
		return num;

	}
	
	public Boolean deleteStudent(String sno) {

		PreparedStatement pstmt = null;
		try { // String sno, String sname,Date sbday, int ssex, String smail, String spwd
			pstmt = conn.prepareStatement("delete from student where sno=?");

			pstmt.setString(1, sno);

			return pstmt.executeUpdate() == 0;

		} catch (SQLException e) {
			System.out.println("刪除失敗");

			e.printStackTrace();
		} finally {

			 
		}
		return false;
	}
	
	public Student selectStudentbySno(String sno) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student where sno= ?";		
		Object obj[] = {sno};
		ResultSet res = StudentDao.query(sql, obj);
		Student student =new Student(); 
		try {
			if (res.next()) { // String sno, String sname,Date sbday, int ssex, String smail, String spwd
				student  = new Student(res.getString(1), res.getString(2), res.getDate(3), res.getInt(4),
						res.getString(5), res.getString(6));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		return student;
	}
	
	public Student selectStudentbySnoSpwd(String sno,String spwd) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student where sno= ? and spwd =?";		
		Object obj[] = {sno,spwd};
		ResultSet res = StudentDao.query(sql, obj);
		Student student =new Student(); 
		try {
			if (res.next()) { // String sno, String sname,Date sbday, int ssex, String smail, String spwd
				student  = new Student(res.getString(1), res.getString(2), res.getDate(3), res.getInt(4),
						res.getString(5), res.getString(6));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		return student;
	}

	// 關閉連接方法
	public static void close() {
		try {
			if (conn != null) {
				conn.close();
			}

			if (ps != null) {
				ps.close();
			}

			if (res != null) {
				res.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
