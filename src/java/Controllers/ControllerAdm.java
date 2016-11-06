/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Administrador;
import Services.ServiceAdm;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "ControllerAdm", urlPatterns = {"/ControllerAdm"})
public class ControllerAdm extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        ServiceAdm serviceAdm = new ServiceAdm();
        
        //Pesquisa todos os adms
        if (action.equalsIgnoreCase("pesquisaAdm")) {
            String pesquisa = "%" + request.getParameter("pesquisa") + "%";
            List<Administrador> adm = serviceAdm.listarAdm(pesquisa);

            request.setAttribute("adm", adm);
            RequestDispatcher disp = request.getRequestDispatcher("administradores.jsp");
            disp.forward(request, response);
        
        //Seleciona um adm
        }else if (action.equalsIgnoreCase("mostrarAdm")) {
            int IdUsuario = Integer.parseInt(request.getParameter("idAdm"));
            Administrador adm = serviceAdm.selecionarAdm(IdUsuario);

            if (adm != null) {
                request.setAttribute("adm", adm);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarAdm.jsp");
                disp.forward(request, response);
            } else {
                response.sendRedirect("administradores.jsp");
            }
        }
    }

}
