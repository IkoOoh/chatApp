document.addEventListener('DOMContentLoaded', function() {
    var socket = new WebSocket('updateChat');

    socket.onopen = function() {
        console.log('WebSocket соединение установлено');
    };

	socket.onmessage = function(event) {
	    var chatContainer = document.getElementById('chatContainer');
	    var labs = JSON.parse(event.data); 
		chatContainer.innerHTML = ''
	    labs.forEach(function(lab) {
	        var chatDiv = document.createElement('div');
	        chatDiv.classList.add('chat');

	        var chatHeader = document.createElement('div');
	        chatHeader.classList.add('chat-header');
	        chatHeader.setAttribute('id', lab.username);

	        var chatUser = document.createElement('span');
	        chatUser.classList.add('chat-user');
	        chatUser.textContent = lab.username;

	        var unreadCount = document.createElement('span');
	        unreadCount.classList.add('unread-count');
	        unreadCount.textContent = lab.unreadMessagesCount;

	        var lastMessage = document.createElement('div');
	        lastMessage.classList.add('last-message');
	        lastMessage.textContent = lab.lastMessage;

	        chatHeader.appendChild(chatUser);
	        chatHeader.appendChild(unreadCount);
	        chatDiv.appendChild(chatHeader);
	        chatDiv.appendChild(lastMessage);
	        chatDiv.appendChild(document.createElement('hr'));

	        chatContainer.appendChild(chatDiv);
	    });
	};


    socket.onclose = function(event) {
        if (event.wasClean) {
            console.log('WebSocket соединение закрыто');
        } else {
            console.error('Обрыв соединения');
        }
    };

    socket.onerror = function(error) {
        console.error('Ошибка WebSocket: ' + error.message);
    };
});
