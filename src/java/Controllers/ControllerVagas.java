/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.ServiceVaga;
import Entidades.Empresa;
import Entidades.Usuario;
import Entidades.Vaga;
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
        
        if (action.equalsIgnoreCase("cadastro")){
            
            Empresa empresa = (Empresa) request.getSession().getAttribute("usuario");
            String curso = request.getParameter("cursos");
            String nome = request.getParameter("nome");
            int semestre = Integer.parseInt(request.getParameter("semestre"));
            double bolsa = Integer.parseInt(request.getParameter("bolsa"));
            double refeicao = Integer.parseInt(request.getParameter("refeicao"));
            double transporte = Integer.parseInt(request.getParameter("transporte"));
            String descricao = request.getParameter("descricao");
            String atividades = request.getParameter("atividades");
            String horario = request.getParameter("horario");
            
            Vaga vaga = null;
            //= new Vaga(curso, nome, semestre, bolsa, refeicao, transporte, descricao, atividades, horario, empresa, adicionais, validade);
            
            if (serviceVaga.cadastrarVaga(vaga) != null){
                RequestDispatcher disp = request.getRequestDispatcher("vagas.jsp");
                disp.forward(request, response);
            }
            
        }else if(action.equalsIgnoreCase("pesquisaVagas")){
            String pesquisa = "%" + request.getParameter("pesquisa") + "%";
            List<Vaga> vagas = serviceVaga.listarVagas(pesquisa);

            request.setAttribute("vagas", vagas);
            RequestDispatcher disp = request.getRequestDispatcher("vagas.jsp");
            disp.forward(request, response);
        
          //MOSTRAR DADOS DA VAGA SELECIONADA
        } else if (action.equalsIgnoreCase("mostrarVaga")) {
            int IdVaga = Integer.parseInt(request.getParameter("idVaga"));
            Vaga vaga = serviceVaga.selecionarVaga(IdVaga);

            if (vaga != null) {
                request.setAttribute("vaga", vaga);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarVaga.jsp");
                disp.forward(request, response);
            } else {
                response.sendRedirect("vagas.jsp");
            }
        }
    }
}
