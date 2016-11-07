/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Empresa;
import Services.ServiceEmpresa;
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
@WebServlet(name = "ControllerEmpresa", urlPatterns = {"/ControllerEmpresa"})
public class ControllerEmpresa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ServiceEmpresa serviceEmpresa = new ServiceEmpresa();

        //PESQUISA AS EMPRESAS
        if (action.equalsIgnoreCase("pesquisaEmpresas")) {

            String pesquisa = "%" + request.getParameter("pesquisa") + "%" ;
            List<Empresa> empresas = serviceEmpresa.listarEmpresas(pesquisa);

            request.setAttribute("empresas", empresas);
            RequestDispatcher disp = request.getRequestDispatcher("empresas.jsp");
            disp.forward(request, response);

            //ADM APROVA O CADASTRO DAS EMPRESAS
        } else if (action.equalsIgnoreCase("aprovacao")) {
            String IdUsuario = request.getParameter("IdUsuario");
            Empresa empresa = serviceEmpresa.aprovaEmpresa(Integer.parseInt(IdUsuario));

            if (empresa != null) {
                request.setAttribute("empresa", empresa);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarEmpresa.jsp");
                disp.forward(request, response);
            } else {
                response.sendRedirect("empresas.jsp");
            }

            //MOSTRAR DADOS DA EMPRESA SELECIONADA
        } else if (action.equalsIgnoreCase("mostrarEmpresa")) {
            int IdUsuario = Integer.parseInt(request.getParameter("idEmpresa"));
            Empresa empresa = serviceEmpresa.selecionarEmpresa(IdUsuario);

            if (empresa != null) {
                request.setAttribute("empresa", empresa);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarEmpresa.jsp");
                disp.forward(request, response);
            } else {
                response.sendRedirect("alunos.jsp");
            }
        }
    }

}