/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.ServiceVaga;
import Entidades.Empresa;
import Entidades.Usuario;
import Entidades.Vaga;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cardo
 */
public class ControllerVagas extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        ServiceVaga ctrlVaga = new ServiceVaga();
        
        if (action.equalsIgnoreCase("cadastro")){
            
            Empresa empresa = (Empresa) request.getSession().getAttribute("usuario");
            String curso = request.getParameter("cursos");
            String nome = request.getParameter("nome");
            int semestre = Integer.parseInt(request.getParameter("semestre"));
            int bolsa = Integer.parseInt(request.getParameter("bolsa"));
            int refeicao = Integer.parseInt(request.getParameter("refeicao"));
            int transporte = Integer.parseInt(request.getParameter("transporte"));
            String descricao = request.getParameter("descricao");
            String atividade = request.getParameter("atividades");
            int horario = Integer.parseInt(request.getParameter("horario"));
            
            Vaga vaga = new Vaga(curso, nome, semestre, bolsa, descricao, atividade, horario, empresa);
            vaga.setRefeicao(refeicao);
            vaga.setTransporte(transporte);
            
            if (ctrlVaga.cadastrarUsuario(vaga) != null){
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
