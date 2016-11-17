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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="js/jquery.validate.js"></script> 
        <script src='js/bootstrap.min.js'></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp" %>

            <section class="conteudo">
                <%                     Boolean erro = false;
                    try{
                        if((Boolean)request.getSession().getAttribute("erro"))
                            erro = true;
                    }catch(Exception ex){
                        erro = false;
                    }
                    
                    if (erro) {
                %>
                <p class="informa"> Ops... Ocorreu um erro tente novamente mais tarde. </p>

                </p>
                <% } else { %>
                <p class="informa">
                    Bem vindo!
                </p>

                <% } 
                
                request.getSession().setAttribute("erro", false);%>
            </section>
        </div>
    </body>
</html>
