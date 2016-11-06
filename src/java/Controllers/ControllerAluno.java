/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Aluno;
import Services.ServiceAluno;
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
@WebServlet(name = "ControllerAluno", urlPatterns = {"/ControllerAluno"})
public class ControllerAluno extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        ServiceAluno serviceAluno = new ServiceAluno();
        
        //PESQUISA OS ALUNOS
        if (action.equalsIgnoreCase("pesquisaAlunos")) {
            String pesquisa = "%" + request.getParameter("pesquisa") + "%";
            List<Aluno> alunos = serviceAluno.listarAlunos(pesquisa);

            request.setAttribute("alunos", alunos);
            RequestDispatcher disp = request.getRequestDispatcher("alunos.jsp");
            disp.forward(request, response);

        //MOSTRAR DADOS DO ALUNO SELECIONADO
        }else if (action.equalsIgnoreCase("mostrarAluno")) {
            int IdUsuario = Integer.parseInt(request.getParameter("idAluno"));
            Aluno aluno = serviceAluno.selecionarAluno(IdUsuario);

            if (aluno != null) {
                request.setAttribute("aluno", aluno);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarAluno.jsp");
                disp.forward(request, response);
            } else {
                response.sendRedirect("alunos.jsp");
            }
        }
    }

    
}
