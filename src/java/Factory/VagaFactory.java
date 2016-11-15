/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Entidades.Empresa;
import Entidades.Vaga;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Cardo
 */
public class VagaFactory implements FactoryVaga {

    @Override
    public Vaga criarVaga(HttpServletRequest request) {
        try{
            Empresa empresa = (Empresa) request.getSession().getAttribute("usuario");
            String curso = request.getParameter("cursos");
            String nome = request.getParameter("nome");
            int semestre = Integer.parseInt(request.getParameter("semestre"));
            double bolsa = Double.parseDouble(request.getParameter("bolsa"));
            double refeicao = Double.parseDouble(request.getParameter("refeicao"));
            double transporte = Double.parseDouble(request.getParameter("transporte"));
            String descricao = request.getParameter("descricao");
            String atividades = request.getParameter("atividades");
            String horario = request.getParameter("horario");
            String validade = request.getParameter("validade");
            String adicionais = request.getParameter("adicionais");
            
            Vaga vaga = new Vaga(curso, nome, semestre, bolsa, descricao, atividades, horario, empresa, validade, refeicao, transporte, adicionais);
            
            return vaga;
        }catch (Exception ex){
            System.out.println("ERROR: -------------- "+ex);
            return null;
        }
    }
   
}
