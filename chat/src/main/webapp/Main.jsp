<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
<link rel="stylesheet" type="text/css" href="css/chatView.css">
<link rel="stylesheet" type="text/css" href="css/rightPanel.css">
<link rel="stylesheet" type="text/css" href="css/chatWindow.css">
</head>
<body>
<jsp:include  page="/mainPageComponents/rightPanel.jsp"></jsp:include>
<jsp:include  page="/getChatBar"></jsp:include>
<jsp:include  page="/mainPageComponents/chatWindow.jsp"></jsp:include>

</body>
</html>