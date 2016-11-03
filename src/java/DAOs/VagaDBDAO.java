/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Vaga;
import Interfaces.VagaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cardo
 */
public class VagaDBDAO implements VagaDAO {
    private EntityManager manager;

    public VagaDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }

    @Override
    public Vaga insertObject(Vaga vaga) {
        manager.getTransaction().begin();
        manager.persist(vaga);
        manager.getTransaction().commit();


        return vaga;
    }
}
