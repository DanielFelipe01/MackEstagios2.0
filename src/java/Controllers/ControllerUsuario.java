/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.ServiceUsuario;
import Entidades.*;
import java.io.IOException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class ControllerUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ServiceUsuario serviceUsuario = new ServiceUsuario();

        //CADASTRA O USUARIO
        if (action.equalsIgnoreCase("cadastro")) {
            String tipo = request.getParameter("tipoUsuario");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            Usuario usuario = serviceUsuario.cadastrarUsuario(email, senha, tipo);

            if (usuario != null) {
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("cadastro.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }

        //ALTERAR O CADASTRO DO USUARIO 
        } else if (action.equalsIgnoreCase("perfil")) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

            try {
                serviceUsuario.alteraCadastro(request, usuario);
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex);
            }

        //CADASTRA O TIPO DE USUARIO
        } else if (action.equalsIgnoreCase("terminaCadastro")) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            try {
                usuario = serviceUsuario.cadastrarUsuarioTipo(request, usuario);
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("principal.jsp");
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex);
            }

        }

    }

}
