/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Candidato;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface CandidatoDAO {
    
    public Candidato insertCandidato(Candidato candidato);
    
    public Candidato deleteCandidato(Candidato candidato);
    
    public List<Candidato> selectCandidatos(int idVaga);

}
