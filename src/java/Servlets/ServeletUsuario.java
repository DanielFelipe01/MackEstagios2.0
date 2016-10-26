/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.*;
import Entidades.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class ServeletUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("cadastro")){
            String tipo = request.getParameter("tipoUsuario");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            ControllerUsuario ctrlUsuario = new ControllerUsuario();
            
            Usuario usuario = ctrlUsuario.cadastrarUsuario(email, senha, tipo);
            
            if(usuario != null){
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("perfil.jsp");
            }else{
                response.sendRedirect("index.jsp");
            }
            
        }else if(action.equalsIgnoreCase("cadastro")){
            ControllerUsuario ctrlUsuario = new ControllerUsuario();
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            
            try {
                ctrlUsuario.alteraCadastro(request, usuario);
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex );
            }
            
        }else if(action.equalsIgnoreCase("terminaCadastro")){
            ControllerUsuario ctrlUsuario = new ControllerUsuario();
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            
            try {
                ctrlUsuario.cadastrarUsuarioTipo(request, usuario);
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex );
            }
        }
    }

}
