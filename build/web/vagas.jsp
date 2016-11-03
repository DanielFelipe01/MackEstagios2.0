<%-- 
    Document   : vagas
    Created on : 31/10/2016, 17:39:56
    Author     : Ramon Cardoso 41582802
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Vagas </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Ramon Cardoso">
        <link rel="icon" href="img/icon.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp" %>
            
            

            <section class="conteudo">
                <form id="perfil-form" action="ControllerVagas" method="post" role="form">
                    <div class="title"> Cadastrar Vagas</div>
                    <div class="form-group">
                        <label for="nome">Nome da vaga:</label>
                        <input type="text" name="nome" id="nome" tabindex="1" class="form-control" placeholder="Nome da vaga" required>
                    </div>
                    <div class="form-group">
                        <label for="cursos">Cursos:</label>
                        <input type="text" name="cursos" id="cursos" tabindex="1" class="form-control" placeholder="Cursos" required>
                    </div>
                    <div class="form-group">
                        <label for="Semestre">Semestre:</label>
                        <input type="number" name="semestre" id="semestre" tabindex="1" class="form-control" placeholder="Até o semestre." min="0" max="10" required>
                    </div>
                    <div class="form-group">
                        <label for="Bolsa-auxilio">Valor da bolsa:</label>
                        <input type="number" name="bolsa" id="bolsa" tabindex="1" class="form-control" placeholder="Valor da bolsa-auxilio" required>
                    </div>
                    <div class="form-group">
                        <label for="vale-refeição">Valor do vale refeição:</label>
                        <input type="number" name="refeicao" id="refeicao" tabindex="1" class="form-control" placeholder="Valor do vale refeição" required>
                    </div>
                    <div class="form-group">
                        <label for="vale-transporte">Valor do vale transporte:</label>
                        <input type="number" name="transporte" id="transporte" tabindex="1" class="form-control" placeholder="Valor do vale transporte" required>
                    </div>
                    <div class="form-group">
                        <label for="descrição">Descrição da vaga:</label>
                        <input type="text" name="descricao" id="descricao" tabindex="1" class="form-control" placeholder="Descrição da vaga" required>
                    </div>
                    <div class="form-group">
                        <label for="atividades">Atividade desenvolvidas no estágio:</label>
                        <input type="text" name="atividades" id="atividade" tabindex="1" class="form-control" placeholder="Atividades desenvolvidas no estágio" required>
                    </div>
                    <div class="form-group">
                        <label for="horario">Carga horária:</label>
                        <input type="number" name="horario" id="horario" tabindex="1" class="form-control" placeholder="Carga horária do estágio" required>
                    </div>
                    <input type="hidden" name="action" value="cadastro">
                    <input type="submit" value="Cadastrar" class="btn btn-default" style="margin-left: 40%; width: 20%;"> 
                </form>
            </section>
        </div>
    </body>
</html>
