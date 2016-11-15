<%-- 
    Document   : vagas
    Created on : 31/10/2016, 17:39:56
    Author     : Ramon Cardoso 41582802
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Cadastrar vagas </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Ramon Cardoso">
        <link rel="icon" href="img/icon.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="js/jquery.validate.js"></script> 
        <script src='js/cadastroValidate.js'></script>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp" %>
            

            <section class="conteudo">
                <%                
                Empresa e = (Empresa) session.getAttribute("usuario");
                String situacao = (String) request.getAttribute("action");
                if (e.getSituacao() && situacao != null && situacao.equalsIgnoreCase("alterarVaga")) { %>                        
                        <form id="vaga-form" action="ControllerVagas" method="post" role="form">
                            <% Vaga vaga = (Vaga) request.getAttribute("vaga"); %>
                            <div class="title"> Alterar Vagas</div>
                            <div class="form-group">
                                <label for="nome">Nome da vaga:</label>
                                <input type="text" name="nome" id="nome" tabindex="1" class="form-control" placeholder="Nome da vaga" value="<% out.write(vaga.getNome()); %> ">
                            </div>
                            <div class="form-group">
                                <label for="cursos">Cursos:</label>
                                <input type="text" name="cursos" id="cursos" tabindex="2" class="form-control" placeholder="Cursos" value="<% out.write(vaga.getCurso()); %>">
                            </div>
                            <div class="form-group">
                                <label for="Semestre">Semestre:</label>
                                <input type="number" name="semestre" id="semestre" tabindex="3" class="form-control" placeholder="Até o semestre." min="0" max="10" value="<% out.write(String.valueOf(vaga.getSemestre()));%>">
                            </div>
                            <div class="form-group">
                                <label for="Bolsa-auxilio">Valor da bolsa:</label>
                                <input type="number" name="bolsa" id="bolsa" tabindex="4" class="form-control" placeholder="Valor da bolsa-auxilio" value="<% out.write(String.valueOf(vaga.getBolsa()));%>">
                            </div>
                            <div class="form-group">
                                <label for="vale-refeição">Valor do vale refeição:</label>
                                <input type="number" name="refeicao" id="refeicao" tabindex="5" class="form-control" placeholder="Valor do vale refeição" value="<% out.write(String.valueOf(vaga.getRefeicao()));%>">
                            </div>
                            <div class="form-group">                            
                                <label for="vale-transporte">Valor do vale transporte:</label>
                                <input type="number" name="transporte" id="transporte" tabindex="6" class="form-control" placeholder="Valor do vale transporte" value="<% out.write(String.valueOf(vaga.getTransporte())); %>">
                            </div>
                            <div class="form-group">
                                <label for="adicionais">Adicionais da vaga:</label>
                                <input type="text" name="adicionais" id="adicionais" tabindex="7" class="form-control" placeholder="Adicionais da vaga" value="<% out.write(vaga.getAdicionais()); %>">
                            </div>
                            <div class="form-group">
                                <label for="descrição">Descrição da vaga:</label>
                                <input type="text" name="descricao" id="descricao" tabindex="8" class="form-control" placeholder="Descrição da vaga" value="<% out.write(vaga.getDescricao()); %>">
                            </div>
                            <div class="form-group">
                                <label for="atividades">Atividade desenvolvidas no estágio:</label>
                                <input type="text" name="atividades" id="atividade" tabindex="9" class="form-control" placeholder="Atividades desenvolvidas no estágio" value="<% out.write(vaga.getAtividades()); %>">
                            </div>
                            <div class="form-group">
                                <label for="horario">Carga horária:</label>
                                <input type="number" name="horario" id="horario" tabindex="10" class="form-control" placeholder="Carga horária do estágio" value="<% out.write(vaga.getHorario());%>">
                            </div>
                            <div class="form-group">
                                <label for="validade">Validade da vaga:</label>
                                <input type="date" name="validade" id="validade" tabindex="11" class="form-control" value="<% out.write(String.valueOf(vaga.getValidade())); %>">
                            </div>
                            <input type="hidden" name="action" value="finalizarAlterarVaga">
                            <input type="hidden" name="idVaga" value="<% out.write(String.valueOf(vaga.getIdVaga()));%>">
                            <input type="submit" value="Alterar vaga" class="btn btn-default" style="margin-left: 40%; width: 20%;"> 
                        </form>
                    <%} else if (e.getSituacao()){ %>
                            <form id="vaga-form" action="ControllerVagas" method="post" role="form">
                            <div class="title"> Cadastrar Vagas</div>
                            <div class="form-group">
                                <label for="nome">Nome da vaga:</label>
                                <input type="text" name="nome" id="nome" tabindex="1" class="form-control" placeholder="Nome da vaga">
                            </div>
                            <div class="form-group">
                                <label for="cursos">Cursos:</label>
                                <input type="text" name="cursos" id="cursos" tabindex="2" class="form-control" placeholder="Cursos">
                            </div>
                            <div class="form-group">
                                <label for="Semestre">Semestre:</label>
                                <input type="number" name="semestre" id="semestre" tabindex="3" class="form-control" placeholder="Até o semestre." min="0" max="10">
                            </div>
                            <div class="form-group">
                                <label for="Bolsa-auxilio">Valor da bolsa:</label>
                                <input type="number" name="bolsa" id="bolsa" tabindex="4" class="form-control" placeholder="Valor da bolsa-auxilio">
                            </div>
                            <div class="form-group">
                                <label for="vale-refeição">Valor do vale refeição:</label>
                                <input type="number" name="refeicao" id="refeicao" tabindex="5" class="form-control" placeholder="Valor do vale refeição" >
                            </div>
                            <div class="form-group">
                                <label for="vale-transporte">Valor do vale transporte:</label>
                                <input type="number" name="transporte" id="transporte" tabindex="6" class="form-control" placeholder="Valor do vale transporte">
                            </div>
                            <div class="form-group">
                                <label for="adicionais">Adicionais da vaga:</label>
                                <input type="text" name="adicionais" id="adicionais" tabindex="7" class="form-control" placeholder="Adicionais da vaga" >
                            </div>
                            <div class="form-group">
                                <label for="descrição">Descrição da vaga:</label>
                                <input type="text" name="descricao" id="descricao" tabindex="8" class="form-control" placeholder="Descrição da vaga">
                            </div>
                            <div class="form-group">
                                <label for="atividades">Atividade desenvolvidas no estágio:</label>
                                <input type="text" name="atividades" id="atividade" tabindex="9" class="form-control" placeholder="Atividades desenvolvidas no estágio">
                            </div>
                            <div class="form-group">
                                <label for="horario">Carga horária:</label>
                                <input type="number" name="horario" id="horario" tabindex="10" class="form-control" placeholder="Carga horária do estágio">
                            </div>
                            <div class="form-group">
                                <label for="validade">Validade da vaga:</label>
                                <input type="date" name="validade" id="validade" tabindex="11" class="form-control">
                            </div>
                            <input type="hidden" name="action" value="cadastro">
                            <input type="submit" value="Cadastrar" class="btn btn-default" style="margin-left: 40%; width: 20%;"> 
                        </form>
                <%}else{%>
                <p class="informa"> Ops... Sua empresa ainda não foi aprovada. </p>
                <%}%>
            </section>
                
            
        </div>
    </body>
</html>
