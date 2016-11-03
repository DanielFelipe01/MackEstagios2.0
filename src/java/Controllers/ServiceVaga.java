/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.VagaDBDAO;
import Entidades.Vaga;
import Factory.UsuarioFactory;

/**
 *
 * @author Cardo
 */
public class ServiceVaga {
    private VagaDBDAO vagaDBDAO;
    
    public ServiceVaga(){
        this.vagaDBDAO = new VagaDBDAO();
    }
    
    public Vaga cadastrarUsuario(Vaga newVaga){
        
        Vaga vaga;
        
        try{
            vaga = vagaDBDAO.insertObject(newVaga);
        }catch(Exception ex){
            return null;
        }
        return vaga;
    }
    
}
