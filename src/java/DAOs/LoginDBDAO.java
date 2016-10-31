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
public class LoginDBDAO implements LoginDAO {
    private EntityManager manager;

    public LoginDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }
    
    
    public Usuario selectUsuario(String email, String senha) {
        Usuario user = null;
        Usuario usuario = new Usuario();

        try {
            usuario = (Usuario) manager.createQuery("Select u from Usuario u where u.email = :email and u.senha = :senha", Usuario.class).setParameter("email", email).setParameter("senha", senha).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
        
        if (usuario.equals(null)) {
            return null;
        } else {
            try {
                switch (usuario.getTipo()) {
                    case "1":
                        user = (Administrador) manager.createQuery("Select a from Administrador a where a.idUsuario = :idUsuario", Usuario.class).setParameter("idUsuario", usuario.getIdUsuario()).getSingleResult();
                        break;
                    case "2":
                        user = (Aluno) manager.createQuery("Select a from Aluno a where a.idUsuario = :idUsuario", Usuario.class).setParameter("idUsuario", usuario.getIdUsuario()).getSingleResult();
                        break;
                    case "3":
                        user = (Empresa) manager.createQuery("Select a from Empresa a where a.idUsuario = :idUsuario", Usuario.class).setParameter("idUsuario", usuario.getIdUsuario()).getSingleResult();
                        break;
                    default:
                        System.out.println("Usuario invalido");
                }
            } catch (Exception ex) {
                return usuario;
            } finally {
                manager.close();
            }
        }

        return user;

    }

}
