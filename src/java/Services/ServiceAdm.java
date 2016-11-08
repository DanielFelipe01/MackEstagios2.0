/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.AdmDBDAO;
import Entidades.Administrador;
import Factory.UsuarioFactory;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ServiceAdm {
    
    private UsuarioFactory factory;
    private AdmDBDAO admDB;
    
    
    public ServiceAdm(){
        this.factory = new UsuarioFactory();
        this.admDB = new AdmDBDAO();
    }
    public List<Administrador> listarAdm(String pesquisa){
        try{
            return (List<Administrador>) admDB.selectAdms(pesquisa);
        }catch(Exception ex){
            return null;
        }
    }
    
    public Administrador selecionarAdm(int idEmpresa){
        try{
            return (Administrador) admDB.selectAdm(idEmpresa);
        }catch(Exception ex){
            return null;
        }
    }
    
    public Administrador alterarAdm(Administrador adm){
       try{
            return (Administrador) admDB.updateAdm(adm);
        }catch(Exception ex){
            return null;
        } 
    }
}
