<%-- 
    Document   : menu
    Created on : 26/10/2016, 12:13:04
    Author     : Daniel
--%>

<%@page import="Entidades.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
            </div>

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
                    <li><a href="aprovarEmpresass.jsp">Empresas pendentes</a></li>
                    <li><a href="vagas.jsp">Vagas</a></li>
                    <li><a href="administradores.jsp">Administradores</a></li>
                    <li><a href="logs.jsp">Logs</a></li>
                    
                </ul>
                <% } else if (usuario instanceof Aluno) {
                %>
                <ul class="nav navbar-nav" name="aluno">
                    <li><a href="principal.jsp">Inicio</a></li>
                    <li><a href="perfil.jsp">Perfil</a></li>
                    <li><a href="empresas.jsp">Empresas</a></li>
                    <li><a href="vagas.jsp">Vagas</a></li>
                </ul>
                <% } else {
                %>
                <ul class="nav navbar-nav" name="empresa" >
                    <li><a href="principal.jsp">Inicio</a></li>
                    <li><a href="perfil.jsp">Perfil</a></li>
                    <li><a href="vagas.jsp">Vagas</a></li>
                </ul>
                <% } %>

                <form class="navbar-form navbar-right" method="post" action="ServeletLogin">
                    <% if (usuario instanceof Administrador) {
                            adm = (Administrador) usuario;
                            out.write(String.valueOf(adm.getNome()));
                        } else if (usuario instanceof Aluno) {
                            aluno = (Aluno) usuario;
                            out.write(String.valueOf(aluno.getNome()));
                        } else {
                            emp = (Empresa) usuario;
                            out.write(String.valueOf(emp.getNome()));
                        }
                    %>
                    <input type="hidden" name="action" value="sair">
                    <button type="submit" class="btn btn-default">Sair</button>
                </form>
            </div>
        </div>
    </nav>
</html>
