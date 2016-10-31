/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Entidades.*;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Daniel
 */
public class UsuarioFactory implements Factory {

    @Override
    public Usuario criarUsuario(String email, String senha, String tipo) {
        return new Usuario(email, senha, tipo);
    }

    @Override
    public Usuario criarUsuarioTipo(HttpServletRequest request, Usuario usuario) {
        Endereco endereco = null;

        switch (usuario.getTipo()) {
            
            case "1":
                return new Administrador(request.getParameter("nome"), usuario.getEmail(), request.getParameter("senha"), Integer.parseInt(request.getParameter("nivel")), usuario);
            case "2":
                endereco = new Endereco(request.getParameter("rua"), request.getParameter("bairro"),
                        request.getParameter("cidade"), request.getParameter("estado"), Integer.parseInt(request.getParameter("numero")),
                        request.getParameter("complemento"), request.getParameter("cep"));

                Formacao formacao = new Formacao(request.getParameter("curso"), Integer.parseInt(request.getParameter("semestre")),
                        request.getParameter("faculdade"), request.getParameter("unidade"));

                   return new Aluno(request.getParameter("nome"), request.getParameter("rg"), request.getParameter("cpf"),
                        request.getParameter("telefone"), endereco, request.getParameter("dataNascimento"),
                        formacao, request.getParameter("tia"), request.getParameter("email"), request.getParameter("senha"), usuario.getTipo());
            case "3":
                endereco = new Endereco(request.getParameter("rua"), request.getParameter("bairro"),
                        request.getParameter("cidade"), request.getParameter("estado"), Integer.parseInt(request.getParameter("numero")),
                        request.getParameter("complemento"), request.getParameter("cep"));

                return new Empresa(request.getParameter("nome"), request.getParameter("cnpj"), request.getParameter("site"),
                        request.getParameter("telefone"), endereco, false, usuario, request.getParameter("email"), request.getParameter("senha"), usuario.getTipo());
        }

        return null;
    }
}
