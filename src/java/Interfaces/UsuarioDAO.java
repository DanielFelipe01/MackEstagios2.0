/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.*;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface UsuarioDAO {

    public Object insertObject(Object obj);

    public Object updateObject(Object obj);

    public Object deleteObject(Object obj);

    public List<Usuario> selectUsuario();
    
    public List<Aluno> selectAlunos(String pesquisa);
    
    public List<Administrador> selectAdministradores(String pesquisa);
    
    public List<Empresa> selectEmpresas(String pesquisa);
    
    public Empresa selectEmpresa(int idEmpresa);
}
