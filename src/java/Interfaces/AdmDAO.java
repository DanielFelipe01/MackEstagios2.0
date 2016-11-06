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
    
    public Object insertObject(Object obj);

    public Object updateObject(Object obj);

    public Object deleteObject(Object obj);
    
    public List<Administrador> selectAdms(String pesquisa);
    
    public Administrador selectAdm(int idAdm);
}
