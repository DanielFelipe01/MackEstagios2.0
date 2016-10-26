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
}
