<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<div id ="sidebar" class="sidebar">
	<script src="js/chatBar.js"></script>
	<button class = "newChatButton" id="newChatButton" onclick="createNewChat()">Новый чат</button>
	<div class= "chatContainer" id ="chatContainer">
		<c:forEach var="chat" items="${userChats}"> 
		<jsp:include page="/getChat">
		 	<jsp:param name="username" value="${chat.username}"/>
		 	<jsp:param name="unreadMessagesCount" value="${chat.unreadMessagesCount}"/>
		 	<jsp:param name="lastMessage" value="${chat.lastMessage}"/>
		</jsp:include>
		 </c:forEach>
	</div>
</div>