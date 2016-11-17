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
        Usuario user = null;
        try {
            user = usuarioDB.selectEmailUsuario(email);
            if (user.equals(null));
            
            return null;
        } catch (Exception ex) {
            Usuario usuario = factory.criarUsuario(email, senha, tipo);
            usuarioDB.insertUsuario(usuario);

            return usuario;
        }
    }

    public Usuario cadastrarUsuarioTipo(HttpServletRequest request, Usuario usuario) throws ParseException {
        ServiceAluno alunoServ = new ServiceAluno();
        ServiceEmpresa empresaServ = new ServiceEmpresa();

        Usuario usuarioTipo = factory.criarUsuarioTipo(request, usuario);

        if (usuarioTipo instanceof Aluno) {
            Aluno a = (Aluno) usuarioTipo;
            return alunoServ.cadastrarAluno(a);
        } else {
            Empresa e = (Empresa) usuarioTipo;
            return empresaServ.cadastrarEmpresa(e);
        }

    }

    public Usuario alteraCadastro(HttpServletRequest request, Usuario usuario) throws ParseException {
        Usuario usuarioTipo = factory.criarUsuarioTipo(request, usuario);

        usuario.setSenha(request.getParameter("senha"));
        usuarioDB.updateUsuario(usuario);

        if (usuarioTipo instanceof Aluno) {
            ServiceAluno alunoServ = new ServiceAluno();
            Aluno a = (Aluno) usuarioTipo;
            Aluno user = (Aluno) usuario;

            a.getEndereco().setIdEndereco(user.getEndereco().getIdEndereco());
            a.getFormacao().setIdFormacao(user.getFormacao().getIdFormacao());
            a.setIdAluno(user.getIdAluno());

            return alunoServ.alterarAluno(a);
        } else if (usuarioTipo instanceof Empresa) {
            ServiceEmpresa empresaServ = new ServiceEmpresa();
            Empresa e = (Empresa) usuarioTipo;
            Empresa user = (Empresa) usuario;
            
            e.getEndereco().setIdEndereco(user.getEndereco().getIdEndereco());
            e.setIdEmpresa(user.getIdEmpresa());

            return empresaServ.alterarEmpresa(e);
        } else {
            ServiceAdm admServ = new ServiceAdm();
            Administrador adm = (Administrador) usuarioTipo;
            Administrador user = (Administrador) usuario;

            adm.setIdAdm(user.getIdAdm());

            return admServ.alterarAdm(adm);
        }
    }

    public Usuario validarUsuario(String email, String senha) {
        try {
            return usuarioDB.selectUsuario(email, senha);
        } catch (Exception ex) {
            return null;
        }
    }

}
