<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/materialize.min.css" />
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/styles.css" />
    <link rel="stylesheet" href="http://localhost:8080/Laboratorio-Eg/css/home.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Quadro de doenças</title>
</head>

<body class="blue darken-2">
    <div class="row">
        <div class="col s12 m8 l8 offset-l2 offset-m2">
            <div class="card blue-grey darken-2">
                <div class="card-content">
                    <span class="card-title white-text center-align"><i class="material-icons">list</i> Quadro de
                        Doenças</span>
                    <div class="divider"></div>
                    <div class="row blue-grey darken-1 white-text" style="margin-top: 5px;">
                        <div class="input-field col s10">
                            <i class="material-icons prefix">search</i>
                            <input id="email" type="email" class="validate" name="email">
                            <label for="email">Pesquisar doença por nome</label>
                        </div>
                        <div class="input-field col s2">
                            <a class="waves-effect waves-light btn blue darken-2">Buscar</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="scrolable">
                            <% for(int i = 0; i < 6; i+=1) { %>
                            <div class="col s12 m6 l6 pop" style="cursor: pointer">
                                <div class="card-panel grey lighten-5 z-depth-1 hoverable">
                                    <div class="row valign-wrapper">
                                        <div class="col s4 m3 l3 avatar">
                                            <i class="large material-icons circle red white-text">bug_report</i>
                                        </div>
                                        <div class="col s9">
                                            <span class="black-text truncate modal-trigger" href="#modal_atividade">
                                                <p>Covid 19</p>
                                                <br />
                                                A COVID-19 afeta diferentes pessoas de diferentes maneiras. A maioria das pessoas infectadas apresentará sintomas leves a moderados da doença e não precisarão ser hospitalizadas.
                                                <br />
                                                </p>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <% } %>

                        </div>




                    </div>
                </div>
            </div>
        </div>





        <script src="http://localhost:8080/Laboratorio-Eg/js/materialize.min.js"></script>
        <script src="http://localhost:8080/Laboratorio-Eg/js/scripts.js"></script>
</body>

</html>