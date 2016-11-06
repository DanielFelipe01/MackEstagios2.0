/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Empresa;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface EmpresaDAO {
    
    public Empresa updateEmpresa(Empresa emp);
    
    public List<Empresa> selectEmpresas(String pesquisa);
    
    public Empresa selectEmpresa(int idEmpresa);
}
