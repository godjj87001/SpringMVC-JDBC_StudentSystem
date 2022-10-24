
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>學生頁面</title>
</head>

<body>
     <h1>登入成功</h1> 
	{學號},{姓名},{生日},{性別},{信箱},{密碼} <br>    	
<table>
<tr>
		 <td>{${stu.sno}}<td>
	     <td>{${stu.sname}}<td>
	     <td>{${stu.sbday}}<td>
	     <td>{${stu.ssex}}<td>
	     <td>{${stu.smail}}<td>
	     <td>{${stu.spwd}}<td>   
</tr>
</table>
</body>
</html>