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
public class ServeletUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        ControllerUsuario ctrlUsuario = new ControllerUsuario();
        
        //CADASTRA O USUARIO
        if(action.equalsIgnoreCase("cadastro")){
            String tipo = request.getParameter("tipoUsuario");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Usuario usuario = ctrlUsuario.cadastrarUsuario(email, senha, tipo);
            
            if(usuario != null){
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("perfil.jsp");
            }else{
                response.sendRedirect("index.jsp");
            }
            
            //ALTERAR O CADASTRO DO USUARIO 
        }else if(action.equalsIgnoreCase("alterarCadastro")){
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            
            try {
                ctrlUsuario.alteraCadastro(request, usuario);
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex );
            }
            
            //CADASTRA O TIPO DE USUARIO
        }else if(action.equalsIgnoreCase("terminaCadastro")){
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            
            try {
                ctrlUsuario.cadastrarUsuarioTipo(request, usuario);
            } catch (ParseException ex) {
                System.out.println("Erro: " + ex );
            }
        
            //PESQUISA OS ALUNOS
        }else if(action.equalsIgnoreCase("pesquisaAlunos")){
            String pesquisa = "%" + request.getParameter("pesquisa") + "%";
            List<Aluno> alunos = ctrlUsuario.listarAlunos(pesquisa);
            
            request.setAttribute("alunos", alunos);
            RequestDispatcher disp = request.getRequestDispatcher("alunos.jsp");
            disp.forward(request, response);
            
            //PESQUISA AS EMPRESAS
        }else if(action.equalsIgnoreCase("pesquisaEmpresas")){
            String pesquisa = "%" + request.getParameter("pesquisa") + "%";
            List<Empresa> empresas = ctrlUsuario.listarEmpresas(pesquisa);
            
            request.setAttribute("empresas", empresas);
            RequestDispatcher disp = request.getRequestDispatcher("empresas.jsp");
            disp.forward(request, response);
            
        }else if(action.equalsIgnoreCase("aprovacao")){
            String IdEmpresa = request.getParameter("idEmpresa");
            Empresa empresa = ctrlUsuario.aprovaEmpresa(Integer.parseInt(IdEmpresa));
            
            if(empresa != null){
                //Empresa não aprovada
            }
            response.sendRedirect("empresas.jsp");
        }
        
    }

}
