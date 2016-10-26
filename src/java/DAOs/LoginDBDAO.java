/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.*;
import Interfaces.LoginDAO;
import javax.persistence.*;




/**
 *
 * @author Daniel
 */
public class LoginDBDAO implements LoginDAO{
    
    public Usuario selectUsuario(String email, String senha){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        EntityManager manager = factory.createEntityManager();

        Usuario usuario = new Usuario();
        try{
            usuario = (Usuario) manager.createQuery("Select u from Usuario u where u.email = :email and u.senha = :senha",Usuario.class).setParameter("email", email).setParameter("senha", senha).getSingleResult();

            switch(usuario.getTipo()){
                case "1":
                    Administrador adm = (Administrador) manager.createQuery("Select a from Administrador a where a.idUsuario = :idUsuario",Usuario.class).setParameter("idUsuario", usuario.getIdUsuario()).getSingleResult();
                    return adm;
                case "2":
                    Aluno aluno = (Aluno) manager.createQuery("Select a from Aluno a where a.idUsuario = :idUsuario",Usuario.class).setParameter("idUsuario", usuario.getIdUsuario()).getSingleResult();
                    return aluno;
                case "3":
                    Empresa empresa = (Empresa) manager.createQuery("Select a from Empresa a where a.idUsuario = :idUsuario",Usuario.class).setParameter("idUsuario", usuario.getIdUsuario()).getSingleResult();
                    return empresa;
                default:
                    System.out.println("Usuario invalido");
            }
            
        }catch(Exception ex){
            return null;
        }finally{
            manager.close();
        }
        
        return null;
    }
 
}
