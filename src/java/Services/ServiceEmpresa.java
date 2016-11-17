/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.EmpresaDBDAO;
import DAOs.EnderecoDBDAO;
import Entidades.Empresa;
import Factory.UsuarioFactory;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ServiceEmpresa {
    private UsuarioFactory factory;
    private EmpresaDBDAO empresaDB;
    private EnderecoDBDAO enderecoDB;


    public ServiceEmpresa() {
        this.factory = new UsuarioFactory();
        this.empresaDB = new EmpresaDBDAO();
        this.enderecoDB = new EnderecoDBDAO();
    }
    
    public List<Empresa> listarEmpresas(String pesquisa) {
        try {
            return (List<Empresa>) empresaDB.selectEmpresas(pesquisa);
        } catch (Exception ex) {
            return null;
        }
    }

    public Empresa selecionarEmpresa(int idEmpresa) {
        try {
            return (Empresa) empresaDB.selectEmpresa(idEmpresa);
        } catch (Exception ex) {
            return null;
        }
    }

    public Empresa aprovaEmpresa(int idUsuario) {
        Empresa empresa = empresaDB.selectEmpresa(idUsuario);

        empresa.alteraSituacao();
        try {
            empresaDB.updateEmpresa(empresa);
            return empresa;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public Empresa cadastrarEmpresa(Empresa empresa){
        
        try {
            enderecoDB.insertEndereco(empresa.getEndereco());
            return empresaDB.insertEmpresa(empresa);
        } catch (Exception ex) {
            return null;
        }
    
    }
    
    public Empresa alterarEmpresa(Empresa empresa){
       try{
            enderecoDB.updateEndereco(empresa.getEndereco());
            return (Empresa) empresaDB.updateEmpresa(empresa);
        }catch(Exception ex){
            return null;
        } 
    }
}
