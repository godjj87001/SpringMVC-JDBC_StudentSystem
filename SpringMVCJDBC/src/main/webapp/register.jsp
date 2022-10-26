<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>註冊頁面</title>
</head>
<body>
 
	<center>
		<h2>註冊頁面</h2>
		<form method="post" action="register.do">
		<font>帳號 sno</font>
		<input type="text" name="sno" ><br>
		<font>密碼 spwd</font>
		<input type="password" name="spwd"><br>
		<font>信箱 smail</font>
		<input type="text" name="smail"><br>
		<font>名字 sname</font>
		<input type="text" name="sname"><br>
		<font>性別(0 or 1) ssex</font>
		<input type="text" name="ssex"><br>
		<font>生日(YYYY-MM-DD) sbday</font>
		<input type="text" name="sbday"><br>
 		<input type="submit" value="註冊" /><br>
 					<font color="green">sno檢查${sno}<br></font>
					<font color="green">email${email}<br></font>
					<font color="green">message,${message}<br></font>
					
		</form>
	</center>
</body>
</html>