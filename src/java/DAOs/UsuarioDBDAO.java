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
public class UsuarioDBDAO implements UsuarioDAO{
    
    @Override
    public Usuario insertUsuario(Usuario usuario){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
            EntityManager manager = factory.createEntityManager();
            usuario.setIdUsuario(5);
            manager.getTransaction().begin();    
            manager.persist(usuario);
            manager.getTransaction().commit();  

            manager.close();
            
            return usuario;
    }
    
    @Override
    public Usuario updateUsuario(Usuario usuario){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           manager.getTransaction().begin();
           manager.merge(usuario);
           manager.getTransaction().commit(); 
           manager.close();
            
           return usuario;
    }
    
    @Override
    public Usuario deleteUsuario(Usuario usuario){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           manager.remove(usuario);
           manager.getTransaction().commit(); 
           manager.close();
           
           return usuario;
    }
    
    @Override
    public List<Usuario> selectUsuario(){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           List<Usuario> usuarios = manager.createQuery("select u from Usuario u")
                                    .getResultList();
           
           return usuarios;
    }
    
    @Override
    public List<Aluno> selectAlunos(String pesquisa){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();

           List<Aluno> usuarios = manager.createQuery("select a from Aluno a where nome LIKE :pesquisa")
                                    .setParameter("pesquisa", pesquisa).getResultList();
           
           return usuarios;
    }
    
    @Override
    public List<Administrador> selectAdministradores(String pesquisa){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           List<Administrador> usuarios = manager.createQuery("select a from Administrador a")
                                    .getResultList();
           
           return usuarios;
    }
    
    @Override
    public List<Empresa> selectEmpresas(String pesquisa){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           List<Empresa> usuarios = manager.createQuery("select e from Empresa e where nome LIKE :pesquisa")
                                    .setParameter("pesquisa", pesquisa).getResultList();
           
           return usuarios;
    }
    
    @Override
    public Empresa selectEmpresa(int idEmpresa){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           Empresa empresa = (Empresa) manager.createQuery("select e from Empresa e where idEmpresa = :idEmpresa")
                                    .setParameter("idEmpresa", idEmpresa).getSingleResult();
           
           return empresa;
    }
    
    
}
