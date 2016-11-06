/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Administrador;
import Interfaces.AdmDAO;
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
    public Object insertObject(Object obj) {
        manager.getTransaction().begin();
        manager.persist(obj);
        manager.getTransaction().commit();

        return obj;
    }

    @Override
    public Object updateObject(Object obj) {
        manager.getTransaction().begin();
        manager.merge(obj);
        manager.getTransaction().commit();
        manager.close();

        return obj;
    }

    @Override
    public Object deleteObject(Object obj) {
        manager.remove(obj);
        manager.getTransaction().commit();
        manager.close();

        return obj;
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
