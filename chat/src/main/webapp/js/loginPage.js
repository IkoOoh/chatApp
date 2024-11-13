window.addEventListener("load", function() {
    const errorElement = document.getElementById('error');
    if (errorElement && errorElement.value === "true") {
        alert('Неправильный логин или пароль!');
    }
});
