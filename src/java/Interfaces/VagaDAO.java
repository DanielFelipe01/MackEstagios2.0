/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Vaga;
import java.util.List;

/**
 *
 * @author Cardo
 */
public interface VagaDAO {
    
    public Vaga insertVaga(Vaga vaga);
    
    public List<Vaga> selectVagas(String pesquisa, String empresa, String filtro);
    
    public Vaga selectVaga(int idVaga);
    
    public Vaga changeStatusVaga(Vaga vaga);
    
}
