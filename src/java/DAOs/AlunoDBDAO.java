/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.Aluno;
import Interfaces.AlunoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private Connection c;

    public AlunoDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
        this.c = Conexao.getConexao();
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
    public Aluno insertAluno(Aluno aluno) {
        
        String sql = "insert into aluno (idAluno, idUsuario, nome, rg, cpf, telefone, idEndereco, idFormacao, dataNascimento, tia)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, aluno.getUsuario().getIdUsuario());
            stmt.setInt(2, aluno.getUsuario().getIdUsuario());
            stmt.setString(3, aluno.getNome());
            stmt.setString(4, aluno.getRg());
            stmt.setString(5, aluno.getCpf());
            stmt.setString(6, aluno.getTelefone());
            stmt.setInt(7, aluno.getEndereco().getIdEndereco());
            stmt.setInt(8, aluno.getFormacao().getIdFormacao());
            stmt.setString(9, aluno.getDataNascimento());
            stmt.setString(10, aluno.getTia());

            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            Conexao.close();
        }
       
        return aluno;
    }
    
    @Override
    public Aluno updateAluno(Aluno aluno) {
        
        String sql = "UPDATE aluno set nome = ?, rg = ?, cpf = ?, telefone = ?, dataNascimento = ?,"
                + " tia = ? WHERE idAluno = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getRg());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getDataNascimento());
            stmt.setString(6, aluno.getTia());
            stmt.setInt(7, aluno.getIdAluno());
 
            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            Conexao.close();
        }
       
        return aluno;
    }
}
