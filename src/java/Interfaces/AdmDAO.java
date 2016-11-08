/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Administrador;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface AdmDAO {
    
    public Administrador insertAdm(Administrador adm);

    public Administrador updateAdm(Administrador adm);

    public Administrador deleteAdm(Administrador adm);
    
    public List<Administrador> selectAdms(String pesquisa);
    
    public Administrador selectAdm(int idAdm);
}
