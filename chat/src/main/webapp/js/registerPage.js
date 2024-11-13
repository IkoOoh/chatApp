window.addEventListener("load", function() {
    const errorElement = document.getElementById('error');
    if (errorElement && errorElement.value === "login") {
        alert('такой пользователь уже существует');
    }
	if (errorElement && errorElement.value === "err") {
	        alert('ошибка ввода данных');
	}
});
