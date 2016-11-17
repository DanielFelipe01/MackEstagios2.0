<%-- 
    Document   : empresas
    Created on : 27/10/2016, 14:12:20
    Author     : Daniel
--%>

<%@page import="java.util.List"%>
<%@page import="Controllers.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Administradores </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Daniel Felipe">
        <link rel="icon" href="img/icon.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='js/bootstrap.min.js'></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp" %>
            <div class="conteudo">
                <form action="ControllerAdm" method="Post" id="pesquisa-form" class="form-inline">
                    <div class="title"> Admistradores</div>
                    <div class="form-group-pesquisa">
                        <input type="text" name="pesquisa" id="pesquisa" >
                        <input type="hidden" name="action" value="pesquisaAdm">
                        <input type="submit" name="pesquisar" id="pesquisar" class="btn btn-default" value="Buscar">
                    </div>
                </form>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Nivel</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<Administrador> administradores = (List<Administrador>) request.getAttribute("adm");
                            if (administradores != null) {
                                for (Administrador a : administradores) {
                        %>
                        <tr>
                    <form method="post" action="ControllerAdm">
                        <input type="hidden" name="action" value="mostrarAdm">
                        <input type="hidden" name="idAdm" value="<% out.write(Integer.toString(a.getIdAdm())); %>">
                        <td><% out.write(a.getNome()); %></td>
                        <td><% out.write(a.getUsuario().getEmail()); %></td>
                        <td><% out.write(String.valueOf(a.getNivel())); %></td>
                        <td><input type="submit" value="Mostrar" class="btn btn-default"></td>
                        </tr>
                        <%    }
                        }%>
                        </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
