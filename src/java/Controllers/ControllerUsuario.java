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
import javax.servlet.RequestDispatcher;
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
            try {
                String tipo = request.getParameter("tipoUsuario");
                String email = request.getParameter("emailTo");
                String senha = request.getParameter("senhaTo");

                Usuario usuario = null;
                usuario = serviceUsuario.cadastrarUsuario(email, senha, tipo);

                if (usuario != null) {
                    request.getSession().setAttribute("usuario", usuario);
                    request.getSession().setAttribute("erro", false);
                    response.sendRedirect("index.jsp");
                } else {
                    RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("mensagem", 2);
                    disp.forward(request, response);
                }
            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.setAttribute("mensagem", 3);
                RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                disp.forward(request, response);
            }

            //ALTERAR O CADASTRO DO USUARIO 
        } else if (action.equalsIgnoreCase("perfil")) {
            try {
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

                serviceUsuario.alteraCadastro(request, usuario);
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex);
                request.getSession().setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }

            //CADASTRA O TIPO DE USUARIO
        } else if (action.equalsIgnoreCase("terminaCadastro")) {
            try {
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

                usuario = serviceUsuario.cadastrarUsuarioTipo(request, usuario);
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("principal.jsp");
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex);
                request.getSession().setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }

        } else if (!action.equalsIgnoreCase("sair")) {
            try {
                String email, senha;
                email = request.getParameter("email");
                senha = request.getParameter("senha");

                Usuario usuario = serviceUsuario.validarUsuario(email, senha);
                if (usuario != null) {
                    request.getSession().setAttribute("usuario", usuario);

                    request.setAttribute("erro", false);
                    RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                    disp.forward(request, response);
                } else {
                    RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("mensagem", 1);
                    disp.forward(request, response);
                }
            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.setAttribute("mensagem", 3);
                RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("sair")) {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }

    }

}
