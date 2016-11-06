/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Aluno;
import Interfaces.AlunoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class AlunoDBDAO implements AlunoDAO{

    private EntityManager manager;

    public AlunoDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }
    
    @Override
    public List<Aluno> selectAlunos(String pesquisa) {
        List<Aluno> usuarios = manager.createQuery("select a from Aluno a where nome LIKE :pesquisa")
                .setParameter("pesquisa", pesquisa).getResultList();

        return usuarios;
    }

    @Override
    public Aluno selectAluno(int idAluno) {
        Aluno usuario = (Aluno) manager.createQuery("select a from Aluno a where idAluno = :idAluno")
                .setParameter("idAluno", idAluno).getSingleResult();

        return usuario;
    }
}
