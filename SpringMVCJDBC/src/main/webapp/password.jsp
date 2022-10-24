<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>忘記密碼</title>
</head>
<body>
 
	<center>
		<h2>忘記密碼</h2>
		<font>請輸入帳號 <br>
		將發送密碼至您的信箱
		</font>
		<form method="post" action="mail.do">
		<input type="text" name="sno" ><br>
		<input type="submit" value="傳送至信箱" />
		</form>
	</center>
</body>
</html>