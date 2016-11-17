<%-- 
    Document   : mostrarAluno
    Created on : 01/11/2016, 14:25:38
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Perfil Administrador </title>
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

            <section class="conteudo">
                <% Administrador a = (Administrador) request.getAttribute("adm"); %>


                <div class="title"> Dados</div>
                <section class="form-group" name="dados" >
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <label for="email"><% out.write(a.getEmail());%></label>
                    </div>

                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <label for="nome"><% out.write(a.getNome());%></label>
                    </div>
                    <div class="form-group">
                        <label for="nivel">Nível:</label>
                        <label for="nivel"><% out.write(String.valueOf(a.getNivel()));%></label>   
                    </div>
            </section>
        </div>
    </body>
</html>
