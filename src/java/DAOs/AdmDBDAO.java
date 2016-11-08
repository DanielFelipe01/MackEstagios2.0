/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.Administrador;
import Interfaces.AdmDAO;
import java.sql.PreparedStatement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class AdmDBDAO implements AdmDAO{
    
     private EntityManager manager;

    public AdmDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }
    
    @Override
    public Administrador insertAdm(Administrador adm) {
        manager.getTransaction().begin();
        manager.persist(adm);
        manager.getTransaction().commit();

        return adm;
    }

    @Override
    public Administrador updateAdm(Administrador adm) {
        Conexao c = new Conexao();
        
        String sql = "UPDATE administrador set nome = ?, nivel = ? WHERE idAdm = ?";
        try{
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);
            stmt.setString(1, adm.getNome());
            stmt.setInt(2, adm.getNivel());
            stmt.setInt(3, adm.getIdAdm());
 
            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            c.close();
        }
       
        return adm;
    }

    @Override
    public Administrador deleteAdm(Administrador adm) {
        manager.remove(adm);
        manager.getTransaction().commit();
        manager.close();

        return adm;
    }
    
    @Override
    public List<Administrador> selectAdms(String pesquisa) {
        List<Administrador> usuarios = manager.createQuery("select a from Administrador a where nome LIKE :pesquisa")
                .setParameter("pesquisa", pesquisa).getResultList();

        return usuarios;
    }
    
    @Override
    public Administrador selectAdm(int idAdm) {
        Administrador adm = (Administrador) manager.createQuery("select a from Administrador a where idAdm = :idAdm")
                .setParameter("idAdm", idAdm).getSingleResult();

        return adm;
    }
}
