<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入頁面</title>
</head>
<body>
 
	<center>
		<h2>登入頁面</h2>
		<form action="Login.do" method="post">
			<font>帳號 sno</font>
			<input type="text" name="sno" ><br>
			<font>密碼 spwd</font>
			<input type="password" name="spwd" ><br>
			<input type="submit" value="登入" />
		</form>
		<form  action="password.jsp">
			<input type="submit" value="忘記密碼" />
		</form>
					
	</center>
</body>
</html>