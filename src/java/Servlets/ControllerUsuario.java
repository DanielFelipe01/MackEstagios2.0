/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.*;
import Entidades.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class ControllerUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ServiceUsuario ctrlUsuario = new ServiceUsuario();

        //CADASTRA O USUARIO
        if (action.equalsIgnoreCase("cadastro")) {
            String tipo = request.getParameter("tipoUsuario");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            Usuario usuario = ctrlUsuario.cadastrarUsuario(email, senha, tipo);

            if (usuario != null) {
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("cadastro.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }

            //ALTERAR O CADASTRO DO USUARIO 
        } else if (action.equalsIgnoreCase("perfil")) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

            try {
                ctrlUsuario.alteraCadastro(request, usuario);
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex);
            }

            //CADASTRA O TIPO DE USUARIO
        } else if (action.equalsIgnoreCase("terminaCadastro")) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            try {
                ctrlUsuario.cadastrarUsuarioTipo(request, usuario);
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex);
            }

            //PESQUISA OS ALUNOS
        } else if (action.equalsIgnoreCase("pesquisaAlunos")) {
            String pesquisa = "%" + request.getParameter("pesquisa") + "%";
            List<Aluno> alunos = ctrlUsuario.listarAlunos(pesquisa);

            request.setAttribute("alunos", alunos);
            RequestDispatcher disp = request.getRequestDispatcher("alunos.jsp");
            disp.forward(request, response);

            //PESQUISA AS EMPRESAS
        } else if (action.equalsIgnoreCase("pesquisaEmpresas")) {
            String pesquisa = "%" + request.getParameter("pesquisa") + "%";
            List<Empresa> empresas = ctrlUsuario.listarEmpresas(pesquisa);

            request.setAttribute("empresas", empresas);
            RequestDispatcher disp = request.getRequestDispatcher("empresas.jsp");
            disp.forward(request, response);

            //ADM APROVA O CADASTRO DAS EMPRESAS
        } else if (action.equalsIgnoreCase("aprovacao")) {
            String IdUsuario = request.getParameter("IdUsuario");
            Empresa empresa = ctrlUsuario.aprovaEmpresa(Integer.parseInt(IdUsuario));

            if (empresa != null) {
                request.setAttribute("empresa", empresa);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarEmpresa.jsp");
                disp.forward(request, response);
            }else{
                response.sendRedirect("empresas.jsp");
            }

            //MOSTRAR DADOS DO ALUNO SELECIONADO
        } else if (action.equalsIgnoreCase("mostrarAluno")) {
            int IdUsuario = Integer.parseInt(request.getParameter("idAluno"));
            Aluno aluno = ctrlUsuario.selecionarAluno(IdUsuario);
            
            if (aluno != null) {
                request.setAttribute("aluno", aluno);
                RequestDispatcher disp = request.getRequestDispatcher("mostrarAluno.jsp");
                disp.forward(request, response);
            } else {
                response.sendRedirect("alunos.jsp");
            }
            
            //MOSTRAR DADOS DA EMPRESA SELECIONADA
        }else if (action.equalsIgnoreCase("mostrarEmpresa")) {
            int IdUsuario = Integer.parseInt(request.getParameter("idEmpresa"));
            Empresa empresa = ctrlUsuario.selecionarEmpresa(IdUsuario);
            
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
