function createNewChat() {
    var status = document.getElementById('status');
    var socket = new WebSocket('createNewChat');
	var newChatButton = document.getElementById('newChatButton');
	
    socket.onopen = function() {
        status.innerHTML = 'Выполняется поиск чата';
		newChatButton.style.display = 'none';
        console.log('WebSocket соединение установлено');
    };

    socket.onmessage = function(event) {
        var data = JSON.parse(event.data);
        console.log('Получено сообщение от сервера: ' + data);
        status.innerHTML = 'Чат создан: ' + data;
    };

    socket.onclose = function(event) {
		newChatButton.style.display = 'block'; 
    };

    socket.onerror = function(error) {
        console.error('Ошибка WebSocket: ' + error.message);
    };
}
