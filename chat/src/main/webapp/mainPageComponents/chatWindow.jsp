<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<div class = "chatWindow">
	<script src="js/chatWindow.js"></script>
	<div id="status"></div>
	<div id="activeChatContainer">
			<div class ="messageContainer" id = "messageContainer">
				<div class="message user"> 
					<p>Привет! Как дела?</p> 
				</div> 
				<div class="message other"> 
					<p>Привет! Все отлично, а у тебя?</p>
				</div>
			</div>
			<div class="chat-input">
		        <input type="text" id="messageInput" placeholder="Введите сообщение...">
		        <button class="CHbutton" onclick="sendMessage()">Отправить</button>
		    </div>	
	</div>
</div>