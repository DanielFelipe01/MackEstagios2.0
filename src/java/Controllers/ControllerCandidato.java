/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Aluno;
import Entidades.Candidato;
import Entidades.Vaga;
import Services.ServiceCandidato;
import Services.ServiceVaga;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControllerCandidato", urlPatterns = {"/ControllerCandidato"})
public class ControllerCandidato extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        ServiceCandidato serviceCandi = new ServiceCandidato();
        ServiceVaga serviceVaga = new ServiceVaga();
        
        if (action.equalsIgnoreCase("candidatar")){
            int IdVaga = Integer.parseInt(request.getParameter("idVaga"));
            
            Aluno a = (Aluno) request.getSession().getAttribute("usuario");
            Vaga v = (Vaga) serviceVaga.selecionarVaga(IdVaga);
            Candidato c = new Candidato(a,v);
            
            if (serviceCandi.candidatar(c) != null){
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }else{
            
            }
        
        }
        
    }

}
