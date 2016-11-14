<%-- 
    Document   : mostrarEmpresa
    Created on : 01/11/2016, 14:57:34
    Author     : Daniel
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Vaga </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Daniel Felipe">
        <link rel="icon" href="img/icon.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp" %>

            <section class="conteudo">
                <% Vaga v = (Vaga) request.getAttribute("vaga"); %>

                <div class="title"> Dados da Vaga</div>
                <section class="form-group" name="dados" >
                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <label for="nome"><% out.write(v.getNome());%></label>
                    </div>

                    <div class="form-group">
                        <label for="curso">Curso:</label>
                        <label for="curso"><% out.write(v.getCurso());%></label>
                    </div>
                    <div class="form-group">
                        <label for="semestre">Semestre:</label>
                        <label for="semestre"><% out.write(String.valueOf(v.getSemestre()));%></label>   
                    </div>
                    <div class="form-group">
                        </br>
                        <label for="empresa">Empresa:</label>
                        <label for="empresa"><% out.write(v.getEmpresa().getNome());%></label>
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descrição:</label>
                        <label for="descricao"><% out.write(v.getDescricao());%></label>
                    </div>
                    <div class="form-group">
                        <label for="atividades">Atividades:</label>
                        <label for="atividades"><% out.write(v.getAtividades());%></label>
                    </div>
                    <div class="form-group">
                        <label for="horario">Horário:</label>
                        <label for="horario"><% out.write(v.getHorario());%></label>
                    </div>
                    <div class="form-group">
                        </br>
                        <label for="valor bolsa">Valor da Bolsa:</label>
                        <label for="valor bolsa">R$<% out.write(String.valueOf(v.getBolsa()));%></label>
                    </div>
                    <div class="form-group">
                        <label for="valor transporte">Valor do Vale transporte:</label>
                        <label for="valor transporte">R$<% out.write(String.valueOf(v.getTransporte()));%></label>
                    </div>
                    <div class="form-group">
                        <label for="valor refeição">Valor do Vale refeição:</label>
                        <label for="valor refeição">R$<% out.write(String.valueOf(v.getTransporte()));%></label>
                    </div>
                    <div class="form-group">
                        </br>
                        <label for="adicionais">Adicionais:</label>
                        <label for="adicionais"><% out.write(String.valueOf(v.getAdicionais()));%></label>
                    </div>
                    <div class="form-group">
                        </br></br>
                        <label for="adicionais">Validade da vaga:</label>
                        <label for="adicionais"><% out.write(String.valueOf(v.getValidade()));%></label>
                    </div>

                </section>

                <div class="linha">
                    <div id="centraliza">
                        <form action="ControllerCandidato" method="Post">
                            <input type="hidden" name="idVaga" value="<%out.write(Integer.toString(v.getIdVaga()));%>">

                            <% if (usuario instanceof Aluno) {
                                    List<Candidato> candidatosList = v.getCandidatos();
                                    Boolean excluir = false;

                                    for (Candidato cand : candidatosList) {
                                        if (cand.getAluno().getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                                            excluir = true;
                                        }
                                    }
                                    
                                    if (!excluir) {
                            %>
                            <input type="hidden" name="action" value="candidatar">
                            <input type="submit" class="btn-simples" value="Cantidatar-se">
                                    <%} else if (excluir) { %>
                            <input type="hidden" name="action" value="descandidatar">
                            <input type="submit" class="btn-simples" value="Descantidatar-se">
                                    <% }} %>
                        </form>
                        <form action="ControllerVagas" method="Post">
                            <%if (usuario instanceof Empresa) { %> 
                            <input type="hidden" name="idVaga" value="<%out.write(Integer.toString(v.getIdVaga()));%>">
                            <input type="hidden" name="action" value="trocarStatusVaga">
                                <% if (v.isStatus() == true){ %>
                                    <input type="hidden" name="operacao" value="1">
                                    <input type="submit" class="btn-simples" value="Desabilitar vaga">
                                <%} else { %>
                                    <input type="hidden" name="operacao" value="2">
                                    <input type="submit" class="btn-simples" value="Habilitar vaga">
                                <% } %>
                            <% } %>
                        </form>

                        

                        <%       if (usuario instanceof Empresa || usuario instanceof Administrador) {
                                request.getSession().setAttribute("candidatos", v.getCandidatos());

                        %>
                        <form action="ControllerCandidato" method="Post">
                            <input type="hidden" name="action" value="mostrarCandidatos">
                            <input type="submit" class="btn-simples" value="Ver candidatos">
                        </form>
                        <%}%>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
