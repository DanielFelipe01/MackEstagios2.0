/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Usuario;
import Interfaces.UsuarioDAO;
import java.util.List;
import javax.jms.Session;
import javax.persistence.*;
import net.sf.ehcache.hibernate.HibernateUtil;


/**
 *
 * @author Daniel
 */
public class UsuarioDBDAO implements UsuarioDAO{
    
    @Override
    public Usuario insertUsuario(Usuario usuario){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
            EntityManager manager = factory.createEntityManager();

            manager.getTransaction().begin();    
            manager.persist(usuario);
            manager.getTransaction().commit();  

            manager.close();
            
            return usuario;
    }
    
    public Usuario updateUsuario(Usuario usuario){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           manager.merge(usuario);
           manager.getTransaction().commit(); 
           manager.close();
            
           return usuario;
    }
    
    public Usuario deleteUsuario(Usuario usuario){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           manager.remove(usuario);
           manager.getTransaction().commit(); 
           manager.close();
           
           return usuario;
    }
    
    public List<Usuario> selectUsuario(){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           List<Usuario> usuarios = manager.createQuery("select u from Usuario u")
                                    .getResultList();
           
           return usuarios;
    }
    
    public List<Usuario> selectAlunos(){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           List<Usuario> usuarios = manager.createQuery("select a from Aluno a")
                                    .getResultList();
           
           return usuarios;
    }
    
    public List<Usuario> selectAdministradores(){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           List<Usuario> usuarios = manager.createQuery("select a from Administrador a")
                                    .getResultList();
           
           return usuarios;
    }
    
    public List<Usuario> selectEmpresas(){
           EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
           EntityManager manager = factory.createEntityManager();
           
           List<Usuario> usuarios = manager.createQuery("select e from Empresa e")
                                    .getResultList();
           
           return usuarios;
    }
}
