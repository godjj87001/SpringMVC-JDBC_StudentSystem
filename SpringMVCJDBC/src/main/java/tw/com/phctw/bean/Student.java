package tw.com.phctw.bean;

import java.util.Date;

//類名 --表名
public class Student {
	// 屬性 --字段
	private String sno;
	private String sname;
	private Date sbday;
	private int ssex;
	private String smail;
	private String spwd;
	private String altersno;
//	private String acc;
//	private  String pwd; 
//	private String mail;
//	private String username;
//	public String getAcc() {
//		return acc;
//	}
//
//	public void setAcc(String acc) {
//		this.acc = acc;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public String getMail() {
//		return mail;
//	}
//
//	public void setMail(String mail) {
//		this.mail = mail;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	public Student() {
		super();
	}

	public Student(String sno, String sname, Date sbday, int ssex, String smail, String spwd) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sbday = sbday;
		this.ssex = ssex;
		this.smail = smail;
		this.spwd = spwd;

	}

	public Student(String sno, String sname, Date sbday, int ssex, String smail, String spwd, String altersno) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sbday = sbday;
		this.ssex = ssex;
		this.smail = smail;
		this.spwd = spwd;
		this.altersno = (altersno);
	}

//	public Student(String acc, String pwd, String mail, String username) {
//		this.acc=acc;
//		this.pwd=pwd;
//		this.mail=mail;
//		this.username=username;
//		
//	}

	public Date getSbday() {
		return sbday;
	}

	public void setSbday(Date sbday) {
		this.sbday = sbday;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSsex() {
		return ssex;
	}

	public void setSsex(int ssex) {
		this.ssex = ssex;
	}

	public String getSmail() {
		return smail;
	}

	public void setSmail(String smail) {
		this.smail = smail;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getAltersno() {
		return altersno;
	}

	public void setAltersno(String altersno) {
		this.altersno = altersno;
	}

}
