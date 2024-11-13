<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
	<script src="js/loginPage.js"></script>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="css/loginPage.css">
</head>
<body>

<div class = "outer">
		<input type="hidden" id="error" value="${error}">	
    <form class ="form" action="<%=request.getContextPath()%>/login" method="POST">
        <label class = "label" for="username">Логин:</label>
        <input class = "input" type="text" id="username" name="username" required>

        <label class = "label" for="password">Пароль:</label>
        <input class = "input" type="password" id="password" name="password" required>

        <button class = "button" type="submit">Войти</button>
    </form>
</div>
</body>
</html>
