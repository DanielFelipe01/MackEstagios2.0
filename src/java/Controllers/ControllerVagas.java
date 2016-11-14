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
            //COLOQUE O TRY CATCH AQUI E TIRE ISSO DAQUI
            //----{
            Empresa empresa = (Empresa) request.getSession().getAttribute("usuario");
            String curso = request.getParameter("cursos");
            String nome = request.getParameter("nome");
            int semestre = Integer.parseInt(request.getParameter("semestre"));
            double bolsa = Integer.parseInt(request.getParameter("bolsa"));
            double refeicao = Double.parseDouble(request.getParameter("refeicao"));
            double transporte = Double.parseDouble(request.getParameter("transporte"));
            String descricao = request.getParameter("descricao");
            String atividades = request.getParameter("atividades");
            String horario = request.getParameter("horario");
            String validade = request.getParameter("validade");
            String adicionais = request.getParameter("adicionais");
            //}----

            Vaga vaga = new Vaga(curso, nome, semestre, bolsa, descricao, atividades, horario, empresa, validade, refeicao, transporte, adicionais);

            if (serviceVaga.cadastrarVaga(vaga) != null) {
                RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
                disp.forward(request, response);
            }

            //PESQUISA AS VAGAS
        } else if (action.equalsIgnoreCase("pesquisaVagas")) {
            try {
                String pesquisa = "%" + request.getParameter("pesquisa") + "%";
                String tipo = request.getParameter("tipo");

                String empresa = null;
                try {
                    if (tipo.equals("empresa")) {
                        Empresa e = (Empresa) request.getSession().getAttribute("usuario");
                        empresa = String.valueOf(e.getIdEmpresa());
                    }
                } catch (Exception ex) {
                    System.out.println("Tipo de empresa igual a null");
                }

                List<Vaga> vagas = serviceVaga.listarVagas(pesquisa, empresa);

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
        } else if (action.equalsIgnoreCase("desabilitarVaga")) {
            try {
                int IdVaga = Integer.parseInt(request.getParameter("idVaga"));
                Vaga vaga = serviceVaga.deletarVaga(IdVaga);

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
