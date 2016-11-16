<%-- 
    Document   : mostrarAluno
    Created on : 01/11/2016, 14:25:38
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Perfil aluno </title>
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

            <section class="conteudo">
                <% Aluno a = (Aluno) request.getAttribute("aluno"); %>


                <div class="title"> Dados</div>
                <section class="form-group" name="dados" >
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <label for="email"><% out.write(a.getEmail());%></label>
                    </div>

                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <label for="nome"><% out.write(a.getSenha());%></label>
                    </div>
                    <div class="form-group">
                        <label for="dataNascimento">Data nascimento:</label>
                        <label for="dataNascimento"><% out.write(a.getDataNascimento());%></label>   
                    </div>
                    <div class="form-group">
                        <label for="rg">RG:</label>
                        <label for="rg"><% out.write(a.getRg());%></label>   
                    </div>
                    <div class="form-group">
                        <label for="cpf">CPF:</label>
                        <label for="cpf"><% out.write(a.getCpf());%></label>
                    </div>
                    <div class="form-group">
                        <label for="tia">TIA:</label>
                        <label for="tia"><% out.write(a.getTia());%></label>
                    </div>
                    <div class="form-group">
                        <label for="telefone">Telefone:</label>
                        <label for="telefone"><% out.write(a.getTelefone());%></label>
                    </div>
                </section>

                <div class="title">Endereço </div>
                <section class="form-group" name="endereco">
                    <div class="form-group">
                        <label for="rua">Rua/Av:</label>
                        <label for="rua"><% out.write(a.getEndereco().getRua());%></label>
                    </div>
                    <div class="form-group">
                        <label for="número">Número:</label>
                        <label for="número"><% out.write(String.valueOf(a.getEndereco().getNumero()));%></label>
                    </div>
                    <div class="form-group">
                        <label for="bairro">Bairro:</label>
                        <label for="bairro"><% out.write(a.getEndereco().getBairro());%></label>
                    </div>
                    <div class="form-group">
                        <label for="cidade">Cidade:</label>
                        <label for="cidade"><% out.write(a.getEndereco().getCidade());%></label>
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado:</label>
                        <label for="estado"><% out.write(a.getEndereco().getEstado());%></label>
                    </div>
                    <div class="form-group">
                        <label for="cep">CEP:</label>
                        <label for="cep"><% out.write(a.getEndereco().getCep());%></label>
                    </div>
                    <div class="form-group">
                        <label for="complemento">Complemento:</label>
                        <label for="complemento"><% out.write(a.getEndereco().getComplemento());%></label>
                    </div>
                </section>

                <div class="title">Formação </div>
                <section class="form-group" name="formacao">
                    <div class="form-group">
                        <label for="curso">Curso:</label>
                        <label for="curso"><% out.write(a.getFormacao().getCurso());%></label>
                    </div>
                    <div class="form-group">
                        <label for="semestre">Semestre:</label>
                        <label for="semestre"><% out.write(String.valueOf(a.getFormacao().getSemestre()));%></label>
                    </div>
                    <div class="form-group">
                        <label for="faculdade">Faculdade/Universidade:</label>
                        <label for="faculdade"><% out.write(a.getFormacao().getFaculdade());%></label>
                    </div>
                    <div class="form-group">
                        <label for="unidade">Unidade:</label>
                        <label for="unidade"><% out.write(a.getFormacao().getUnidade());%></label>
                    </div>
                </section>
            </section>
        </div>
    </body>
</html>
