<%-- 
    Document   : alunos
    Created on : 27/10/2016, 11:09:41
    Author     : Daniel
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Alunos </title>
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
                <form action="ControllerAluno" method="Post" id="pesquisa-form" class="form-inline">
                    <div class="title"> Alunos</div>
                    <div class="form-group-pesquisa">
                        <input type="text" name="pesquisa" id="pesquisa" >
                        <input type="hidden" name="action" value="pesquisaAlunos">
                        <input type="submit" name="pesquisar" id="pesquisar" class="btn btn-default" value="Buscar">
                    </div>
                </form>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Telefone</th>
                            <th>TIA</th>
                            <th>Curso</th>
                            <th>Semestre</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
                            if (alunos != null) {
                                for (Aluno a : alunos) {
                        %>

                        <tr>
                            <form method="post" action="ControllerAluno">
                                <input type="hidden" name="action" value="mostrarAluno">
                                <input type="hidden" name="idAluno" value="<% out.write(Integer.toString(a.getIdAluno())); %>">
                                <td><% out.write(a.getNome()); %></td>
                                <td><% out.write(a.getUsuario().getEmail()); %></td>
                                <td><% out.write(a.getTelefone()); %></td>
                                <td><% out.write(a.getTia()); %></td>
                                <td><% out.write(a.getFormacao().getCurso()); %></td>
                                <td><% out.write(Integer.toString(a.getFormacao().getSemestre())); %></td>
                                <td><input type="submit" value="Mostrar" class="btn btn-default"></td>
                            </form>
                        </tr>
                    <%      }
                        }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
