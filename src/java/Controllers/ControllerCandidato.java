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
import java.util.ArrayList;
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

        //ALUNO SE CANDIDATA A VAGA
        if (action.equalsIgnoreCase("candidatar")) {

            try {
                int IdVaga = Integer.parseInt(request.getParameter("idVaga"));

                Aluno a = (Aluno) request.getSession().getAttribute("usuario");
                Vaga v = (Vaga) serviceVaga.selecionarVaga(IdVaga);
                Candidato c = new Candidato(a, v);

                serviceCandi.candidatar(c);
                RequestDispatcher disp = request.getRequestDispatcher("ControllerVagas?action=pesquisaVagas&pesquisa=&filtro=true");
                disp.forward(request, response);

            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.getSession().setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }

            //ALUNO RETIRA CANDIDATURA DA VAGA
        } else if (action.equalsIgnoreCase("descandidatar")) {
            try {
                int IdVaga = Integer.parseInt(request.getParameter("idVaga"));

                Aluno a = (Aluno) request.getSession().getAttribute("usuario");
                Vaga v = (Vaga) serviceVaga.selecionarVaga(IdVaga);
                Candidato c = new Candidato(a, v);

                serviceCandi.descandidatar(c);
                response.sendRedirect("ControllerVagas?action=pesquisaVagas&pesquisa=");

            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.getSession().setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }

            //PESQUISA TODOS OS CANDIDATOS DE UMA VAGA
        } else if (action.equalsIgnoreCase("mostrarCandidatos")) {
            try {
                List<Candidato> candidatos = (List<Candidato>) request.getSession().getAttribute("candidatos");
                List<Aluno> a = new ArrayList<Aluno>();

                if (!candidatos.isEmpty()) {
                    for (Candidato c : candidatos) {
                        a.add(c.getAluno());
                    }
                    request.setAttribute("candidatos", a);

                } else {
                    request.setAttribute("candidatos", null);
                }
                
                RequestDispatcher disp = request.getRequestDispatcher("candidatos.jsp");
                disp.forward(request, response);

            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.getSession().setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }
        }
    }

}
