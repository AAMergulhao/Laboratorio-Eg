<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/materialize.min.css" />
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/styles.css" />
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/cadastrar_doenca.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Quadro de doenças</title>
</head>

<body class="blue darken-2">
    <div class="row">
        <div class="col s12 m8 l8 offset-l2 offset-m2">
            <div class="card blue-grey darken-2">
                <div class="card-content">
                    <span class="card-title white-text center-align"><i class="material-icons">bug_report</i>Covid
                        19</span>
                    <div class="divider"></div>
                    <div class="row">
                        <form class="col s12">
                            <div class="scrolable">
                                <div class="row white-text">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">title</i>
                                        <input id="titulo" type="text" class="white-text" data-length="40">
                                        <label for="titulo">Titulo</label>
                                    </div>
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">create</i>
                                        <textarea id="descricao" class="materialize-textarea white-text"
                                            data-length="420" style="height: 134px;"></textarea>
                                        <label for="descricao">Descrição da doença</label>
                                    </div>

                                    <div class="col s6 blue-grey darken-1">
                                        <table class="highlight centered">
                                            <thead>
                                                <tr>
                                                    <th>Sintoma</th>
                                                    <th>Descrição</th>
                                                </tr>
                                            </thead>
                                            <tbody class="scrolable">
                                                <tr>
                                                    <td>Alvin</td>
                                                    <td>Lorem ipsum dolor sit amet consectetur adipisicing elit. Error,
                                                        consequuntur. Saepe reiciendis aliquam minima, commodi beatae
                                                        aliquid animi.</td>
                                                </tr>
                                                <tr>
                                                    <td>Alan</td>
                                                    <td>Lorem ipsum dolor sit amet consectetur adipisicing elit. Error,
                                                        consequuntur. Saepe reiciendis aliquam minima, commodi beatae
                                                        aliquid animi.</td>
                                                </tr>
                                                <tr>
                                                    <td>Jonathan</td>
                                                    <td>Lorem ipsum dolor sit amet consectetur adipisicing elit. Error,
                                                        consequuntur. Saepe reiciendis aliquam minima, commodi beatae
                                                        aliquid animi.</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="col s4 offset-s1 blue-grey darken-1">
                                        <table class="highlight centered">
                                            <thead>
                                                <tr>
                                                    <th>Sintomas Selecionados</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody class="scrolable">
                                                <tr>
                                                    <td>Alvin</td>
                                                    <td> <a class="btn-floating btn-small waves-effect waves-light red"><i
                                                                class="material-icons">delete</i></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Alvin</td>
                                                    <td> <a class="btn-floating btn-small waves-effect waves-light red"><i
                                                                class="material-icons">delete</i></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Alvin</td>
                                                    <td> <a class="btn-floating btn-small waves-effect waves-light red"><i
                                                                class="material-icons">delete</i></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Alvin</td>
                                                    <td> <a class="btn-floating btn-small waves-effect waves-light red"><i
                                                                class="material-icons">delete</i></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Alvin</td>
                                                    <td> <a class="btn-floating btn-small waves-effect waves-light red"><i
                                                                class="material-icons">delete</i></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Alvin</td>
                                                    <td> <a class="btn-floating btn-small waves-effect waves-light red"><i
                                                                class="material-icons">delete</i></a>
                                                    </td>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
                <div class="card-action">
                    <a class="waves-effect waves-light btn green"><i class="material-icons left">add</i>Cadastrar Doença</a>
                </div>
            </div>
        </div>






        <script src="http://localhost:8080/Laboratorio-Eg/js/jquery-3.5.1.min.js"></script>
        <script src="http://localhost:8080/Laboratorio-Eg/js/materialize.min.js"></script>
        <script src="http://localhost:8080/Laboratorio-Eg/js/scripts.js"></script>
        <script src="http://localhost:8080/Laboratorio-Eg/js/cadastrar_doenca.js"></script>
</body>

</html>