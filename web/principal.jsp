<%-- 
    Document   : Principal
    Created on : 14/10/2016, 16:55:29
    Author     : Daniel
--%>

<%@page import="Entidades.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title> Principal </title>
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
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <%  Usuario usuario = (Usuario) session.getAttribute("usuario");
                        if(usuario instanceof Administrador){ 
                    %>
                        <ul class="nav navbar-nav" name="administrador" style="display: block;">
                            <li><a href="alunos.jsp">Alunos</a></li>
                            <li><a href="empresas.jsp">Empresas</a></li>
                            <li><a href="aprovarEmpresass.jsp">Empresas pendentes</a></li>
                            <li><a href="vagas.jsp">Vagas</a></li>
                            <li><a href="administradores.jsp">Administradores</a></li>
                            <li><a href="logs.jsp">Logs</a></li>
                            <li><a href="logs.jsp">Perfil</a></li>
                        </ul>
                    <% }
                        else if(usuario instanceof Aluno){ 
                    %>
                        <ul class="nav navbar-nav" name="aluno">
                            <li><a href="alunos.jsp">Perfil</a></li>
                            <li><a href="empresas.jsp">Empresas</a></li>
                            <li><a href="vagas.jsp">Vagas</a></li>
                        </ul>
                    <% }
                        else{ 
                    %>
                        <ul class="nav navbar-nav" name="empresa" >
                            <li><a href="logs.jsp">Perfil</a></li>
                            <li><a href="vagas.jsp">Vagas</a></li>
                        </ul>
                    <% } %>

                        <form class="navbar-form navbar-right" method="post" action="ServeletLogin">
                             <% if(usuario instanceof Administrador){
                                    Administrador user = (Administrador) usuario;
                                    out.write(String.valueOf(user.getNome()));
                                }else if(usuario instanceof Aluno){
                                    Aluno user = (Aluno) usuario;
                                    out.write(String.valueOf(user.getNome()));  
                                }else{
                                    Empresa user = (Empresa) usuario;
                                    out.write(String.valueOf(user.getNome()));
                                }
                             %>
                            <input type="hidden" name="action" value="sair">
                            <button type="submit" class="btn btn-default">Sair</button>
                        </form>
                    </div>
                </div>
            </nav>
            <section class="conteudo">
                fasfasfa
            </section>
        </div>
    </body>
</html>
