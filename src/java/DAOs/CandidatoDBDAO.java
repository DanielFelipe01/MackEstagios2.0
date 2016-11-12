/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.Candidato;
import Interfaces.CandidatoDAO;
import java.sql.PreparedStatement;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
public class CandidatoDBDAO implements CandidatoDAO {

    private EntityManager manager;

    public CandidatoDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }

    @Override
    public Candidato insertCandidato(Candidato candidato) {

        manager.getTransaction().begin();
        manager.persist(candidato);
        manager.getTransaction().commit();

        return candidato;
    }

    @Override
    public Candidato deleteCandidato(Candidato candidato
    ) {
        try {
            manager.remove(candidato);
            manager.getTransaction().commit();
            manager.close();

            return null;
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return candidato;
        }

    }

}