/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.Empresa;
import Interfaces.EmpresaDAO;
import java.sql.PreparedStatement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class EmpresaDBDAO implements EmpresaDAO{
    private EntityManager manager;

    public EmpresaDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }
    
    @Override
    public Empresa updateEmpresa(Empresa emp) {
        Conexao c = new Conexao();
        
        String sql = "UPDATE empresa set nome = ?, cnpj = ?, site = ?, telefone = ?, situacao = ? WHERE idEmpresa = ?";
        try{
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);
            stmt.setString(1, emp.getNome());
            stmt.setString(2, emp.getCnpj());
            stmt.setString(3, emp.getSite());
            stmt.setString(4, emp.getTelefone());
            stmt.setBoolean(5, emp.getSituacao());
            stmt.setInt(6, emp.getIdEmpresa());
 
            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            c.close();
        }
       
        return emp;
    }
    
    @Override
    public List<Empresa> selectEmpresas(String pesquisa) {
        List<Empresa> usuarios = manager.createQuery("select e from Empresa e where nome LIKE :pesquisa")
                .setParameter("pesquisa", pesquisa).getResultList();

        return usuarios;
    }

    @Override
    public Empresa selectEmpresa(int idEmpresa) {
        Empresa empresa = (Empresa) manager.createQuery("select e from Empresa e where idEmpresa = :idEmpresa")
                .setParameter("idEmpresa", idEmpresa).getSingleResult();

        return empresa;
    }
    
    @Override
    public Empresa insertEmpresa(Empresa emp) {
        Conexao c = new Conexao();
        
        String sql = "INSERT INTO empresa (idEmpresa, idUsuario, nome, cnpj, site, telefone, idEndereco,"
                + " situacao) VALUES(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);
            stmt.setInt(1, emp.getUsuario().getIdUsuario());
            stmt.setInt(2, emp.getUsuario().getIdUsuario());
            stmt.setString(3, emp.getNome());
            stmt.setString(4, emp.getCnpj());
            stmt.setString(5, emp.getSite());
            stmt.setString(6, emp.getTelefone());
            stmt.setInt(7, emp.getEndereco().getIdEndereco());
            stmt.setBoolean(8, false);

            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            c.close();
        }

        return emp;
    }
}
