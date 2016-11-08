<%-- 
    Document   : index
    Created on : 14/10/2016, 15:12:38
    Author     : Daniel
--%>

<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="pt-br">
    <head>
        <title> Entrar </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Daniel Felipe">
        <link rel="shortcut icon" href="img/icon.ico">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="js/jquery.validate.js"></script> 
        <link href="css/loginStyle.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src='js/login.js'></script>
        <script src='js/cadastroValidate.js'></script>
    </head>
    <body>
        <div class="container">
            <%
                if ((Usuario) session.getAttribute("usuario") != null) {
                    response.sendRedirect("principal.jsp");
                } else {
            %>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="login-form-link">Entrar</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" id="register-form-link">Registrar-se</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="login-form" action="ControllerLogin" method="post" role="form" style="display: block;">
                                        <div class="form-group">
                                            <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="senha" id="senha" tabindex="2" class="form-control" placeholder="Senha">
                                        </div>
                                        <div class="form-group text-center">
                                            <%  int mensagem = 0;
                                                try {
                                                    mensagem = (Integer) request.getAttribute("mensagem");
                                                    if (mensagem == 1) { %>
                                            <label class="incorreto" for="emailErrado">
                                                Email ou senha incorretos!
                                            </label>    
                                            <%      }else if (mensagem == 2) {%>
                                            <label class="incorreto" for="emailErrado">
                                                Email já cadastrado!
                                            </label> 
                                            <%      }
                                                } catch (Exception ex) {
                                                    System.out.println(mensagem + " - " + ex);
                                                }
                                            %>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="hidden" name="action" value="login">
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Entrar">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <form id="register-form" action="ControllerUsuario" method="post" role="form" style="display: none;">
                                        <div class="form-group">
                                            <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" name="confirmaEmail" id="confirmaEmail" tabindex="1" class="form-control" placeholder="Email" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="senha" id="senha" tabindex="2" class="form-control" placeholder="Senha">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="confirmaSenha" id="confirmaSenha" tabindex="2" class="form-control" placeholder="Confirmação da senha">
                                        </div>
                                        <section class="form-group text-center">
                                            <div class="radio-inline">
                                                <label><input type="radio" name="tipoUsuario" checked="checked" value="2">Aluno</label>
                                            </div>
                                            <div class="radio-inline">
                                                <label><input type="radio" name="tipoUsuario" value="3">Empresa</label>
                                            </div>
                                        </section>
                                        
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="hidden" name="action" value="cadastro">
                                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Registrar-se agora">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <% }%>
        </div>
    </body>
</html>
