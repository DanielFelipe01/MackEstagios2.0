/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Endereco;
import Interfaces.EnderecoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class EnderecoDBDAO implements EnderecoDAO{
    private EntityManager manager;

    public EnderecoDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }
    
    @Override
    public Endereco insertEndereco(Endereco end) {
        manager.getTransaction().begin();
        manager.persist(end);
        manager.getTransaction().commit();

        return end;
    }
}
