<%-- 
    Document   : index
    Created on : 14/10/2016, 15:12:38
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="pt-br">
	<head>
		<title> Login </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="author" content="Daniel Felipe">
   		<link rel="icon" href="img/icon.png">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
   		<link href="css/style.css" rel="stylesheet">
	</head>
    <body>
        <div class="containerLogin">
            <div class="div-login">
                    <form action="ServeletLogin" id="login-form"  method="post" >
                        <input name="action" type="hidden" value="login">
                        <div id="div-login-msg">
                            <span id="text-login-msg">Email</span>
                        </div>
                        <input id="email" name="email" class="form-controle" type="email" placeholder="Email" required>
                        <div id="div-login-msg">
                            <span id="text-login-msg">Senha</span>
                        </div>
                        <input id="senha" name="senha" class="form-controle" type="password" placeholder="Senha" required>
                        <div>
                            <button type="submit" class="btn1 btn1-primary btn1-lg btn-block">Login</button>
                        </div>
                    </form>
            </div>
        </div>

    </body>
</html>
