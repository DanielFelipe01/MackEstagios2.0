/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.*;
import Interfaces.UsuarioDAO;
import java.sql.PreparedStatement;
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
    public Usuario insertUsuario(Usuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();

        return usuario;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Conexao c = new Conexao();
        
        String sql = "UPDATE usuario set senha = ? WHERE idUsuario = ?";
        try{
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);

            stmt.setString(1, usuario.getSenha());
            stmt.setInt(2, usuario.getIdUsuario());
            
            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            c.close();
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
    public List<Usuario> selectUsuario() {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u")
                .getResultList();

        return usuarios;
    }
}
