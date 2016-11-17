<%-- 
    Document   : mostrarEmpresa
    Created on : 01/11/2016, 14:57:34
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Perfil Empresa </title>
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
                <% Empresa e = (Empresa) request.getAttribute("empresa"); %>


                <div class="title"> Dados</div>
                <section class="form-group" name="dados" >
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <label for="email"><% out.write(e.getEmail());%></label>
                    </div>

                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <label for="nome"><% out.write(e.getNome());%></label>
                    </div>
                    <div class="form-group">
                        <label for="cnpj">CNPJ:</label>
                        <label for="cnpj"><% out.write(e.getCnpj());%></label>   
                    </div>
                    <div class="form-group">
                        <label for="telefone">Telefone:</label>
                        <label for="telefone"><% out.write(e.getTelefone());%></label>
                    </div>
                    <div class="form-group">
                        <label for="site">Site:</label>
                        <label for="site"><% out.write(e.getSite());%></label>
                    </div>
                </section>

                <div class="title">Endereço </div>
                <section class="form-group" name="endereco">
                    <div class="form-group">
                        <label for="rua">Rua/Av:</label>
                        <label for="rua"><% out.write(e.getEndereco().getRua());%></label>
                    </div>
                    <div class="form-group">
                        <label for="número">Número:</label>
                        <label for="número"><% out.write(String.valueOf(e.getEndereco().getNumero()));%></label>
                    </div>
                    <div class="form-group">
                        <label for="bairro">Bairro:</label>
                        <label for="bairro"><% out.write(e.getEndereco().getBairro());%></label>
                    </div>
                    <div class="form-group">
                        <label for="cidade">Cidade:</label>
                        <label for="cidade"><% out.write(e.getEndereco().getCidade());%></label>
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado:</label>
                        <label for="estado"><% out.write(e.getEndereco().getEstado());%></label>
                    </div>
                    <div class="form-group">
                        <label for="cep">CEP:</label>
                        <label for="cep"><% out.write(e.getEndereco().getCep());%></label>
                    </div>
                    <div class="form-group">
                        <label for="complemento">Complemento:</label>
                        <label for="complemento"><% out.write(e.getEndereco().getComplemento());%></label>
                    </div>
                </section>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">    
                        <form action="ControllerEmpresa" method="Post">
                            <input type="hidden" name="action" value="aprovacao">
                            <input type="hidden" name="IdUsuario" value="<%out.write(Integer.toString(e.getIdEmpresa()));%>">
                            <% if (e.getSituacao().equals(true)) { %>
                            <input type="submit" class="form-control btn btn-default" value="Desaprovar">
                            <%  } else { %>
                            <input type="submit" class="form-control btn btn-default" value="Aprovar">
                            <% }%> 
                        </form>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
