/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.VagaDBDAO;
import Entidades.Vaga;
import java.util.List;

/**
 *
 * @author Cardo
 */
public class ServiceVaga {
    private VagaDBDAO vagaDB;
    
    public ServiceVaga(){
        this.vagaDB = new VagaDBDAO();
    }
    
    public Vaga cadastrarVaga(Vaga newVaga){
        
        Vaga vaga;
        
        try{
            vaga = vagaDB.insertVaga(newVaga);
        }catch(Exception ex){
            return null;
        }
        return vaga;
    }
    
    public List<Vaga> listarVagas(String pesquisa, String empresa){
        
        try{
            return (List<Vaga>) vagaDB.selectVagas(pesquisa, empresa);
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
    
    public Vaga deletarVaga(int idVaga) {
        try {
            Vaga v = (Vaga) vagaDB.selectVaga(idVaga);
            return (Vaga) vagaDB.deleteVaga(v);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        }
    }
    
}
