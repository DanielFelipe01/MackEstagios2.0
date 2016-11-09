/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.CandidatoDBDAO;
import Entidades.Candidato;
import Factory.UsuarioFactory;

/**
 *
 * @author Daniel
 */
public class ServiceCandidato {
   private UsuarioFactory factory;
    private CandidatoDBDAO candidatoDB;


    public ServiceCandidato() {
        this.factory = new UsuarioFactory();
        this.candidatoDB = new CandidatoDBDAO();
    }
    
    
    public Candidato candidatar(Candidato candidato){
        try {
            return candidatoDB.insertCandidato(candidato);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        }
    }
    
    public Candidato descandidatar(Candidato candidato){
        try {
            return candidatoDB.deleteCandidato(candidato);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        }
    }
}
