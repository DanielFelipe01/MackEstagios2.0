/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Aluno;
import Services.ServiceVaga;
import Entidades.Empresa;
import Entidades.Usuario;
import Entidades.Vaga;
import Services.ServiceCandidato;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Cardoso
 */
public class ControllerVagas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ServiceVaga serviceVaga = new ServiceVaga();

        //CADASTRA UMA VAGA
        if (action.equalsIgnoreCase("cadastro")) {
            Vaga vaga = serviceVaga.cadastrarVaga(request);
            if (vaga != null) {
                RequestDispatcher disp = request.getRequestDispatcher("cadastrarVaga.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }

            //PESQUISA AS VAGAS
        } else if (action.equalsIgnoreCase("pesquisaVagas")) {
            try {
                String pesquisa = "%" + request.getParameter("pesquisa") + "%";
                Usuario user = (Usuario) request.getSession().getAttribute("usuario");
                String usuario = null;
                String filtro = request.getParameter("filtro") == null ? "todas" : request.getParameter("filtro");
                try {
                    if (user instanceof Empresa) {
                        Empresa e = (Empresa) request.getSession().getAttribute("usuario");
                        usuario = String.valueOf(e.getIdEmpresa());
                    }
                    else if (user instanceof Aluno){
                        usuario = "aluno";
                    }
                    else {
                        usuario = "adm";
                    }
                } catch (Exception ex) {
                    System.out.println("Tipo de empresa igual a null");
                }

                List<Vaga> vagas = serviceVaga.listarVagas(pesquisa, usuario, filtro);

                if (!vagas.isEmpty()) {
                    request.setAttribute("vagas", vagas);
                } else {
                    request.setAttribute("vagas", null);
                }

                RequestDispatcher disp = request.getRequestDispatcher("vagas.jsp");
                disp.forward(request, response);
            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }

            //MOSTRAR DADOS DA VAGA SELECIONADA
        } else if (action.equalsIgnoreCase("mostrarVaga")) {
            try {
                int IdVaga = Integer.parseInt(request.getParameter("idVaga"));
                Vaga vaga = serviceVaga.selecionarVaga(IdVaga);

                ServiceCandidato c = new ServiceCandidato();
                vaga.setCandidatos(c.listarCandidatos(vaga));

                request.setAttribute("vaga", vaga);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarVaga.jsp");
                disp.forward(request, response);

            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }

            //DESATIVA VAGA SELECIONADA
        } else if (action.equalsIgnoreCase("trocarStatusVaga")) {
            try {
                int IdVaga = Integer.parseInt(request.getParameter("idVaga"));
                int operacao = Integer.parseInt(request.getParameter("operacao"));

                Vaga vaga = serviceVaga.trocaStatusVagaVaga(IdVaga, operacao);

                request.setAttribute("vaga", vaga);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarVaga.jsp");
                disp.forward(request, response);

            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);

            }
        } else if (action.equalsIgnoreCase("alterarVaga")) {
            int IdVaga = Integer.parseInt(request.getParameter("idVaga"));

            Vaga vaga = serviceVaga.selecionarVaga(IdVaga);

            request.setAttribute("vaga", vaga);
            request.setAttribute("action", "alterarVaga");
            RequestDispatcher disp = request.getRequestDispatcher("cadastrarVaga.jsp");
            disp.forward(request, response);

        } else if (action.equalsIgnoreCase("finalizarAlterarVaga")) {

            int IdVaga = Integer.parseInt(request.getParameter("idVaga"));
            boolean op = serviceVaga.alterarVaga(IdVaga, request);

            if (op) {
                Vaga vaga = serviceVaga.selecionarVaga(IdVaga);

                request.setAttribute("pesquisa", "");
                request.setAttribute("action", "pesquisaVagas");
                RequestDispatcher disp = request.getRequestDispatcher("vagas.jsp");
                disp.forward(request, response);
            } else {
                Vaga vaga = serviceVaga.selecionarVaga(IdVaga);
                request.setAttribute("vaga", vaga);
                request.setAttribute("action", "alterarVaga");
                RequestDispatcher disp = request.getRequestDispatcher("cadastrarVaga.jsp");
                disp.forward(request, response);
            }
        }

    }
}
