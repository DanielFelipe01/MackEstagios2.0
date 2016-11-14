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
        <title> Empresas </title>
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
                <form action="ControllerEmpresa" method="Post" id="pesquisa-form" class="form-inline">
                    <div class="title"> Empresas</div>
                    <div class="form-group-pesquisa">
                        <input type="text" name="pesquisa" id="pesquisa" >
                        <input type="hidden" name="action" value="pesquisaEmpresas">
                        <input type="submit" name="pesquisar" id="pesquisar" class="btn btn-default" value="Buscar">
                    </div>
                </form>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Telefone</th>
                            <th>Site</th>
                            <th>Situação</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%  List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
                            if (empresas != null) {
                                for (Empresa e : empresas) {%>
                        <tr>
                    <form method="post" action="ControllerEmpresa">
                        <input type="hidden" name="action" value="mostrarEmpresa">
                        <input type="hidden" name="idEmpresa" value="<% out.write(Integer.toString(e.getIdEmpresa())); %>">
                        <td><% out.write(e.getNome()); %></td>
                        <td><% out.write(e.getUsuario().getEmail()); %></td>
                        <td><% out.write(e.getTelefone()); %></td>
                        <td><% out.write(e.getSite()); %></td>
                        <% if (e.getSituacao().equals(true)) { %>
                        <td>Aprovada</td>
                        <%  } else { %>
                        <td>Pendente</td> 
                        <%  } %>
                        <td><input type="submit" value="Mostrar" class="btn btn-default"></td>
                    </form>
                    </tr>
                    <% }
                    } else { %>
                    <p class="informa"> Ops... Sem empresas. </p>
                    <% }%>
                    </tbody>
                </table>

            </div>
        </div>
    </body>
</html>
