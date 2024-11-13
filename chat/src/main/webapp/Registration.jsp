<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <script src="js/registerPage.js"></script>
</head>
<body>

<div class = "outer">
		<input type="hidden" id="error" value="${error}">	
    <form class ="form" action="<%=request.getContextPath()%>/register" method="POST">
        <label class = "label" for="username">Логин:</label>
        <input class = "input" type="text" id="username" name="username" required>

        <label class = "label" for="password">Пароль:</label>
        <input class = "input" type="password" id="password" name="password" required>
		
		 <label class = "label" for="password">Подтверждение пароля:</label>
        <input class = "input" type="password" id="password" name="confirmPassword" required>
		
        <button class = "button" type="submit">Регистрация</button>
    </form>
</div>

</body>
</html>
