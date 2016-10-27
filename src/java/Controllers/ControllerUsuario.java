/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.UsuarioDBDAO;
import Entidades.*;
import Factory.*;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Daniel
 */
public class ControllerUsuario {
    
    
    public Usuario cadastrarUsuario(String email, String senha, String tipo){
        Usuario usuario = UsuarioFactory.criarUsuario(email, senha, tipo);
        UsuarioDBDAO usuarioDB = new UsuarioDBDAO();
        
        try{
            usuarioDB.insertUsuario(usuario);
        }catch(Exception ex){
            return null;
        }
        return usuario;
    }
    
    public Usuario cadastrarUsuarioTipo(HttpServletRequest request,Usuario usuario) throws ParseException{
        Usuario usuarioTipo = UsuarioFactory.criarUsuarioTipo(request, usuario);
        
        UsuarioDBDAO usuarioDB = new UsuarioDBDAO();
        try{
            usuarioDB.insertUsuario(usuarioTipo);
        }catch(Exception ex){
            return null;
        }
        
        return usuarioTipo;
    }
    
    public Usuario alteraCadastro(HttpServletRequest request,Usuario usuario) throws ParseException{
        Usuario usuarioTipo = UsuarioFactory.criarUsuarioTipo(request, usuario);
         
        UsuarioDBDAO usuarioDB = new UsuarioDBDAO();
        try{
            usuarioDB.insertUsuario(usuarioTipo);
        }catch(Exception ex){
            return null;
        }
        
        return usuarioTipo;
    }
    
    public List<Aluno> listarAlunos(String pesquisa){
        UsuarioDBDAO usuarioDB = new UsuarioDBDAO();
        try{
            return (List<Aluno>) usuarioDB.selectAlunos(pesquisa);
        }catch(Exception ex){
            return null;
        }
    }
    
    public List<Empresa> listarEmpresas(String pesquisa){
        UsuarioDBDAO usuarioDB = new UsuarioDBDAO();
        try{
            return (List<Empresa>) usuarioDB.selectEmpresas(pesquisa);
        }catch(Exception ex){
            return null;
        }
    }
    
    public Empresa aprovaEmpresa(int idEmpresa){
        UsuarioDBDAO usuarioDB = new UsuarioDBDAO();
        Empresa empresa = usuarioDB.selectEmpresa(idEmpresa);
        
        empresa.alteraSituacao();
        try{
            usuarioDB.updateUsuario(empresa);
            return empresa;
        }catch(Exception ex){
            return null;
        }
    }
}
