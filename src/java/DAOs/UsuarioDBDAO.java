/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.*;
import Interfaces.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
public class UsuarioDBDAO implements UsuarioDAO {

    private EntityManager manager;
    private Connection c;

    public UsuarioDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
        this.c = Conexao.getConexao();
    }

    @Override
    public Usuario insertUsuario(Usuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();

        return usuario;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {

        String sql = "UPDATE usuario set senha = ? WHERE idUsuario = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);

            stmt.setString(1, usuario.getSenha());
            stmt.setInt(2, usuario.getIdUsuario());

            stmt.execute();
            stmt.close();

        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            Conexao.close();
        }

        return usuario;
    }

    @Override
    public Usuario deleteUsuario(Usuario usuario) {
        manager.remove(usuario);
        manager.getTransaction().commit();
        manager.close();

        return usuario;
    }

    @Override
    public List<Usuario> selectUsuarios() {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u")
                .getResultList();

        return usuarios;
    }

    @Override
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

    @Override
    public Usuario selectEmailUsuario(String email) {
        Usuario usuario = new Usuario();

        try {
            usuario = (Usuario) manager.createQuery("Select u from Usuario u where u.email = :email", Usuario.class)
                    .setParameter("email", email).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
         return usuario;
    }
}
