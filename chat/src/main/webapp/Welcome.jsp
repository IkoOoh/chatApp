<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/welcomePage.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class = "mainForm">

<a class = "button" href ="<%=request.getContextPath()%>/login"> Войти </a>

<a class = "button" href ="<%=request.getContextPath()%>/register"> Зарегистрироваться </a>

</div>
</body>
</html>