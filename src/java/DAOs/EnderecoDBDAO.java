/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.Endereco;
import Interfaces.EnderecoDAO;
import java.sql.PreparedStatement;
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
    
    @Override
    public Endereco updateEndereco(Endereco end) {
        Conexao c = new Conexao();
        
        String sql = "UPDATE endereco set rua = ?, bairro = ?, cidade = ?, estado = ?, numero = ?, "
                + "complemento = ?, cep = ? WHERE idEndereco = ?";
        try{
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);
            stmt.setString(1, end.getRua());
            stmt.setString(2, end.getBairro());
            stmt.setString(3, end.getCidade());
            stmt.setString(4, end.getEstado());
            stmt.setInt(5, end.getNumero());
            stmt.setString(6, end.getComplemento());
            stmt.setString(7, end.getCep());
            stmt.setInt(8, end.getIdEndereco());
 
            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            c.close();
        }
       
        return end;
    }
}
