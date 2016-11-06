/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.UsuarioDBDAO;
import Entidades.*;
import Factory.*;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Daniel
 */
public class ServiceUsuario {

    private UsuarioFactory factory;
    private UsuarioDBDAO usuarioDB;

    public ServiceUsuario() {
        this.factory = new UsuarioFactory();
        this.usuarioDB = new UsuarioDBDAO();
    }

    public Usuario cadastrarUsuario(String email, String senha, String tipo) {

        Usuario usuario = factory.criarUsuario(email, senha, tipo);

        try {
            usuarioDB.insertObject(usuario);
        } catch (Exception ex) {
            return null;
        }
        return usuario;
    }

    public Usuario cadastrarUsuarioTipo(HttpServletRequest request, Usuario usuario) throws ParseException {
        Usuario usuarioTipo = factory.criarUsuarioTipo(request, usuario);
        try {
            cadastraAdicional(usuarioTipo);
            this.usuarioDB = new UsuarioDBDAO();
            usuarioDB.insertObject(usuarioTipo);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        }

        return usuarioTipo;
    }

    public void cadastraAdicional(Usuario user) {
        Empresa empresa = null;
        Aluno aluno = null;
        if (user instanceof Empresa) {
            empresa = (Empresa) user;
            usuarioDB.insertObject(empresa.getEndereco());
        } else {
            aluno = (Aluno) user;
            usuarioDB.insertObject(aluno.getFormacao());
            usuarioDB.insertObject(aluno.getEndereco());

        }
    }

    public Usuario alteraCadastro(HttpServletRequest request, Usuario usuario) throws ParseException {
        Usuario usuarioTipo = factory.criarUsuarioTipo(request, usuario);

        try {
            usuarioDB.updateObject(usuarioTipo);
        } catch (Exception ex) {
            return null;
        }

        return usuarioTipo;
    }

    
}
