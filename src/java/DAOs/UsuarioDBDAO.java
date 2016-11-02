/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.*;
import Interfaces.UsuarioDAO;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
public class UsuarioDBDAO implements UsuarioDAO {
    private EntityManager manager;

    public UsuarioDBDAO() {
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
    public List<Usuario> selectUsuario() {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u")
                .getResultList();

        return usuarios;
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

    @Override
    public List<Administrador> selectAdms(String pesquisa) {
        List<Administrador> usuarios = manager.createQuery("select a from Administrador a where nome LIKE :pesquisa")
                .setParameter("pesquisa", pesquisa).getResultList();

        return usuarios;
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
    public Administrador selectAdm(int idAdm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
