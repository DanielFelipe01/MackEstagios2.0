<%-- 
    Document   : alunos
    Created on : 27/10/2016, 11:09:41
    Author     : Daniel
--%>

<%@page import="java.util.List"%>
<%@page import="Controllers.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Vagas </title>
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

            <div class="conteudo">
                <form action="ControllerVagas" method="Post" id="pesquisa-form" class="form-inline">
                    <% if (usuario instanceof Empresa) { %>
                    <div class="title">Minhas vagas</div>
                    <% } else { %>
                    <div class="title">Vagas</div>
                    <% } %>

                    <div class="form-group-pesquisa">
                        <% if (usuario instanceof Empresa) { %>
                        <input type="hidden" name="tipo" value="empresa">
                        <% }%>
                        <input type="text" name="pesquisa" id="pesquisa" >
                        <input type="hidden" name="action" value="pesquisaVagas"><br/>
                        <input type="radio" name="filtro" value="true">Somente vagas ativas.<br/>
                        <input type="radio" name="filtro" value="false">Somente vagas desativadas.<br/>
                        <input type="radio" name="filtro" value="todas" checked>Todas as vagas.<br/>
                        <input type="submit" name="pesquisar" id="pesquisar" class="btn btn-default" value="Buscar">
                    </div>
                </form>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Vaga</th>
                            <th>Curso</th>
                            <th>Empresa</th>
                            <th>Semestre</th>
                            <th>Bolsa</th>
                            <th>Carga Horária</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Vaga> vagas = (List<Vaga>) request.getAttribute("vagas");
                            if (vagas != null) {
                                for (Vaga v : vagas) {
                        %>

                        <tr>
                    <form method="post" action="ControllerVagas">
                        <input type="hidden" name="action" value="mostrarVaga">
                        <input type="hidden" name="idVaga" value="<% out.write(Integer.toString(v.getIdVaga())); %>">
                        <td><% out.write(v.getNome()); %></td>
                        <td><% out.write(v.getCurso()); %></td>
                        <td><% out.write(v.getEmpresa().getNome()); %></td>
                        <td><% out.write(String.valueOf(v.getSemestre())); %></td>
                        <td><% out.write(String.valueOf(v.getBolsa())); %></td>
                        <td><% out.write(v.getHorario()); %></td>
                        <td><input type="submit" value="Mostrar" class="btn btn-default"></td>
                    </form>
                    </tr>
                    <% }
                    } else { %>
                    <p class="informa"> Ops... Sem Vagas. </p>
                    <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
