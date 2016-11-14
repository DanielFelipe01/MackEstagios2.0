/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.VagaDBDAO;
import Entidades.Vaga;
import Factory.VagaFactory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Cardo
 */
public class ServiceVaga {
    private VagaDBDAO vagaDB;
    private VagaFactory factory;
    
    public ServiceVaga(){
        this.vagaDB = new VagaDBDAO();
        this.factory = new VagaFactory();
    }
    
    public Vaga cadastrarVaga(HttpServletRequest request){
        
        Vaga vaga = factory.criarVaga(request);
        
        try{
            vaga = vagaDB.insertVaga(vaga);
        }catch(Exception ex){
            return null;
        }
        return vaga;
    }
    
    public List<Vaga> listarVagas(String pesquisa, String empresa, String filtro){
        
        try{
            return (List<Vaga>) vagaDB.selectVagas(pesquisa, empresa, filtro);
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }
    }
    
    public Vaga selecionarVaga(int idVaga) {
        try {
            return (Vaga) vagaDB.selectVaga(idVaga);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        }
    }
    
    public Vaga changeStatusVagaVaga(int idVaga, int op) {
        try {
            Vaga v = (Vaga) vagaDB.selectVaga(idVaga);
            if (op == 1) v.setStatus(false);
            else v.setStatus(true);
            
            return (Vaga) vagaDB.changeStatusVaga(v);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        }
    }
    
}
