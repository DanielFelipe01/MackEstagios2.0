/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.ServiceLogin;
import Entidades.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class ControllerLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if(!action.equalsIgnoreCase("sair")){
            String email, senha;
            email = request.getParameter("email");
            senha = request.getParameter("senha");

            ServiceLogin ctrlLogin = new ServiceLogin();
            Usuario usuario = ctrlLogin.validaUsuario(email, senha);
            if(usuario != null){
                
                request.getSession().setAttribute("usuario", usuario);
                
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }else{
                RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                request.setAttribute("incorreto", true);
                disp.forward(request, response);
            }
        }else{
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
