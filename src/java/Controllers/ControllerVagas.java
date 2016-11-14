/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.ServiceVaga;
import Entidades.Empresa;
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
 * @author Cardo
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
            }
            else {
            //MOSTRAR MENSAGEM DE ERRO NA CRIAÇÂO
            }

            //PESQUISA AS VAGAS
        } else if (action.equalsIgnoreCase("pesquisaVagas")) {
            try {
                String pesquisa = "%" + request.getParameter("pesquisa") + "%";
                String tipo = request.getParameter("tipo");
                String filtro = request.getParameter("filtro");

                String empresa = null;
                try {
                    if (tipo.equals("empresa")) {
                        Empresa e = (Empresa) request.getSession().getAttribute("usuario");
                        empresa = String.valueOf(e.getIdEmpresa());
                    }
                } catch (Exception ex) {
                    System.out.println("Tipo de empresa igual a null");
                }

                List<Vaga> vagas = serviceVaga.listarVagas(pesquisa, empresa, filtro);

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
                
                Vaga vaga = serviceVaga.changeStatusVagaVaga(IdVaga, operacao);

                request.setAttribute("vaga", vaga);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarVaga.jsp");
                disp.forward(request, response);

            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
                request.setAttribute("erro", true);
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }
        }
    }
}
