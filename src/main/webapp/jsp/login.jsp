<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/materialize.min.css" />
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/styles.css" />
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/login.css" />
</head>
<style>

</style>

<body class="blue darken-2">
    <div class="container pop" style="margin-top: 10%;">
        <div class="row">
            <div class="col s12 m6 l6 offset-m3 offset-l3">
                <div class="card blue-grey darken-2">
                    <div class="card-panel blue-grey darken-2">
                        <div class="row">
                            <form class="col s12" method="post">
                                <div class="row white-text">
                                    <input hidden id="action" type="text" value="logar" name="action">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">email</i>
                                        <input id="email" type="email" class="validate" name="email">
                                        <label for="email">E-mail</label>
                                    </div>
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">lock</i>
                                        <input id="password" type="password" class="validate" name="senha">
                                        <label for="senha">Senha</label>
                                    </div>
                                    <div class="section"></div>
                                    <button class="btn blue darken-2 waves-effect waves-light col s12" type="submit"
                                        name="action">Entrar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script src="http://localhost:8080/Laboratorio-Eg/js/materialize.min.js"></script>
    <script src="http://localhost:8080/Laboratorio-Eg/js/scripts.js"></script>
    <script src="http://localhost:8080/Laboratorio-Eg/js/login.js"></script>
</body>

</html>