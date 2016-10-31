<%-- 
    Document   : menus
    Created on : 31/10/2016, 01:02:01
    Author     : Daniel
--%>

<%@page import="Entidades.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img src="img/icon.png" alt="Logo">
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <%  Usuario usuario = (Usuario) session.getAttribute("usuario");
                        Administrador adm = null;
                        Aluno aluno = null;
                        Empresa emp = null;
                        if (usuario instanceof Administrador) {
                    %>
                    <ul class="nav navbar-nav" name="administrador" style="display: block;">
                        <li><a href="principal.jsp">Inicio</a></li>
                        <li><a href="perfil.jsp">Perfil</a></li>
                        <li><a href="alunos.jsp">Alunos</a></li>
                        <li><a href="empresas.jsp">Empresas</a></li>
                        <li><a href="vagas.jsp">Vagas</a></li>
                        <li><a href="administradores.jsp">Administradores</a></li>
                    </ul>
                    <% } else if (usuario instanceof Aluno) {
                    %>
                    <ul class="nav navbar-nav" name="aluno">
                        <li><a href="principal.jsp">Inicio</a></li>
                        <li><a href="perfil.jsp">Perfil</a></li>
                        <li><a href="vagas.jsp">Vagas</a></li>
                    </ul>
                    <% } else if (usuario instanceof Empresa) {
                    %>
                    <ul class="nav navbar-nav" name="empresa" >
                        <li><a href="principal.jsp">Inicio</a></li>
                        <li><a href="perfil.jsp">Perfil</a></li>
                        <li><a href="vagas.jsp">Vagas</a></li>
                    </ul>
                    <% } else {%>
                    <ul class="nav navbar-nav" name="empresa" >
                        <li><a href="principal.jsp">Inicio</a></li>
                        <li><a href="cadastro.jsp">Completar cadastro</a></li>
                    </ul>
                    <% }%>

                    <form method="post" action="ServeletLogin" class="navbar-form navbar-right">
                        <% if (usuario instanceof Administrador) {
                                adm = (Administrador) usuario;
                                out.write(String.valueOf(adm.getNome()));
                            } else if (usuario instanceof Aluno) {
                                aluno = (Aluno) usuario;
                                out.write(String.valueOf(aluno.getNome()));
                            } else if (usuario instanceof Empresa) {
                                emp = (Empresa) usuario;
                                out.write(String.valueOf(emp.getNome()));
                            } else {
                                out.write(String.valueOf(usuario.getTipo()));
                            }
                        %>
                        <input type="hidden" name="action" value="sair">
                        <button type="submit" class="btn btn-default" id="btnSair">Sair</button>
                    </form>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </body>
</html>
