const form = document.querySelector('form');
form.addEventListener('submit', async event => {

    event.preventDefault();

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/x-www-form-urlencoded");

    var urlencoded = new URLSearchParams(serializeForm(form));

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: urlencoded,
        redirect: 'follow'
    };

    await fetch("http://localhost:8080/Laboratorio-Eg/usuario", requestOptions)
        .then()
        .then(usuario => {
            sessionStorage.setItem('usuario', JSON.stringify(usuario));
            window.location.replace('http://localhost:8080/Laboratorio-Eg/home');
        })
        .catch(error => console.log('error', error));
})