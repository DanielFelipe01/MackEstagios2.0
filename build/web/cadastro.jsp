<%-- 
    Document   : cadastro
    Created on : 28/10/2016, 01:52:14
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Perfil </title>
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
        <script src='js/cadastroValidate.js'></script>
    </head>
    <body>
        <div class="container">
            <%@include  file="menu.jsp" %>

            <section class="conteudo">
                <form id="perfil-form" action="ControllerUsuario" method="post" role="form">
                    <div class="title"> Dados</div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="<% out.write(usuario.getEmail());%>" disabled="true">
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha:</label>
                        <input type="password" name="senha" id="senha" tabindex="2" class="form-control" placeholder="Senha" value="<% out.write(usuario.getSenha());%>">
                    </div>

                    <%  if (usuario.getTipo().equals("1")) { %>
                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input type="text" name="nome" id="nome" tabindex="3" class="form-control" placeholder="Nome">
                    </div>
                    <div class="form-group">
                        <label for="nivel">Nível:</label>
                        <input type="number" name="nivel" id="nivel" tabindex="4" class="form-control" placeholder="Nível" disabled="true" min="1" max="3">
                    </div>
                    <% } else if (usuario.getTipo().equals("2")) {%>
                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input type="text" name="nome" id="nome" tabindex="5" class="form-control" placeholder="Nome">
                    </div>
                    <div class="form-group">
                        <label for="dataNascimento">Data nascimento:</label>
                        <input type="date" name="dataNascimento" id="dataNascimento" tabindex="6" class="form-control" placeholder="Data de nascimento">
                    </div>
                    <div class="form-group">
                        <label for="rg">RG:</label>
                        <input type="text" name="rg" id="rg" tabindex="7" class="form-control" placeholder="RG">
                    </div>
                    <div class="form-group">
                        <label for="cpf">CPF:</label>
                        <input type="text" name="cpf" id="cpf" tabindex="8" class="form-control" placeholder="CPF">
                    </div>
                    <div class="form-group">
                        <label for="tia">TIA:</label>
                        <input type="text" name="tia" id="tia" tabindex="9" class="form-control" placeholder="tia">
                    </div>
                    <div class="form-group">
                    </div>
                    <div class="title">Endereço </div>
                    <div class="form-group">
                        <label for="rua">Rua/Av:</label>
                        <input type="text" name="rua" id="rua" tabindex="10" class="form-control" placeholder="Rua">
                    </div>
                    <div class="form-group">
                        <label for="número">Número:</label>
                        <input type="number" name="numero" id="numero" tabindex="11" class="form-control" placeholder="Número"  min="1" max="999999">
                    </div>
                    <div class="form-group">
                        <label for="bairro">Bairro:</label>
                        <input type="text" name="bairro" id="bairro" tabindex="12" class="form-control" placeholder="Bairro">
                    </div>
                    <div class="form-group">
                        <label for="cidade">Cidade:</label>
                        <input type="text" name="cidade" id="cidade" tabindex="13" class="form-control" placeholder="Cidade">
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado:</label>
                        <input type="text" name="estado" id="estado" tabindex="14" class="form-control" placeholder="Estado">
                    </div>
                    <div class="form-group">
                        <label for="cep">CEP:</label>
                        <input type="text" name="cep" id="cep" tabindex="15" class="form-control" placeholder="CEP">
                    </div>
                    <div class="form-group">
                        <label for="complemento">Complemento:</label>
                        <input type="text" name="complemento" id="complemento" tabindex="16" class="form-control" placeholder="Complemento">
                    </div>

                    <div class="title">Formação </div>
                    <div class="form-group">
                        <label for="curso">Curso:</label>
                        <input type="text" name="curso" id="curso" tabindex="17" class="form-control" placeholder="Curso">
                    </div>
                    <div class="form-group">
                        <label for="semestre">Semestre:</label>
                        <input type="number" name="semestre" id="semestre" tabindex="18" class="form-control" placeholder="Semestre" min="1" max="10">
                    </div>
                    <div class="form-group">
                        <label for="cidade">Faculdade/Universidade:</label>
                        <input type="text" name="faculdade" id="faculdade" tabindex="19" class="form-control" placeholder="Faculdade/Universidade">
                    </div>
                    <div class="form-group">
                        <label for="unidade">Unidade:</label>
                        <input type="text" name="unidade" id="unidade" tabindex="20" class="form-control" placeholder="Unidade">
                    </div>

                    <% } else if (usuario.getTipo().equals("3")) { %>
                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input type="text" name="nome" id="nome" tabindex="1" class="form-control" placeholder="Nome">
                    </div>
                    <div class="form-group">
                        <label for="cnpj">CNPJ:</label>
                        <input type="text" name="cnpj" id="cnpj" tabindex="2" class="form-control" placeholder="cnpj">
                    </div>
                    <div class="form-group">
                        <label for="telefone">Telefone:</label>
                        <input type="text" name="telefone" id="telefone" tabindex="3" class="form-control" placeholder="Telefone">
                    </div>
                    <div class="form-group">
                        <label for="site">Site</label>
                        <input type="text" name="site" id="site" tabindex="4" class="form-control" placeholder="Site">
                    </div>
                    <div class="form-group">
                    </div>
                    <section class="form-group" name="endereco">
                        <div class="title"> Endereço</div>
                        <div class="form-group">
                            <label for="rua">Rua/Av:</label>
                            <input type="text" name="rua" id="rua" tabindex="5" class="form-control" placeholder="Rua">
                        </div>
                        <div class="form-group">
                            <label for="número">Número:</label>
                            <input type="number" name="numero" id="numero" tabindex="6" class="form-control" placeholder="Número"  min="1" max="999999">
                        </div>
                        <div class="form-group">
                            <label for="bairro">Bairro:</label>
                            <input type="text" name="bairro" id="bairro" tabindex="7" class="form-control" placeholder="Bairro" >
                        </div>
                        <div class="form-group">
                            <label for="cidade">Cidade:</label>
                            <input type="text" name="cidade" id="cidade" tabindex="8" class="form-control" placeholder="Cidade">
                        </div>
                        <div class="form-group">
                            <label for="estado">Estado:</label>
                            <input type="text" name="estado" id="estado" tabindex="9" class="form-control" placeholder="Estado">
                        </div>
                        <div class="form-group">
                            <label for="cep">CEP:</label>
                            <input type="text" name="cep" id="cep" tabindex="10" class="form-control" placeholder="CEP">
                        </div>
                        <div class="form-group">
                            <label for="complemento">Complemento:</label>
                            <input type="text" name="complemento" id="complemento" tabindex="11" class="form-control" placeholder="Complemento">
                        </div>

                        <% }%>


                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-6 col-sm-offset-3">
                                    <input type="hidden" name="action" value="terminaCadastro">
                                    <input type="submit" name="register-submit" id="register-submit" tabindex="20" class="form-control btn btn-register" value="Confirmar">
                                </div>
                            </div>
                        </div>
                </form>
            </section>
        </div>
    </body>
</html>
