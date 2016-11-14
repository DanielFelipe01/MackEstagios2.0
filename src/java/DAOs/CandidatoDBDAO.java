/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.Candidato;
import Interfaces.CandidatoDAO;
import java.sql.PreparedStatement;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
public class CandidatoDBDAO implements CandidatoDAO {

    private EntityManager manager;

    public CandidatoDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }

    @Override
    public Candidato insertCandidato(Candidato candidato) {
        Conexao c = new Conexao();
        
        String sql = "INSERT INTO candidatos (idAluno, idVaga) VALUES(?,?)";
        
        try{
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);
            stmt.setInt(1, candidato.getAluno().getIdAluno());
            stmt.setInt(2, candidato.getVaga().getIdVaga());

            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            c.close();
        }
        
        return candidato;
    }

    @Override
    public Candidato deleteCandidato(Candidato candidato) {
        Conexao c = new Conexao();
        
        String sql = "DELETE FROM candidatos WHERE idAluno = ? and idVaga = ? ";
        
        try{
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);
            stmt.setInt(1, candidato.getAluno().getIdAluno());
            stmt.setInt(2, candidato.getVaga().getIdVaga());

            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            c.close();
        }
        
        return null;
    }
    
    @Override
    public List<Candidato> selectCandidatos(int idVaga) {
        List<Candidato> candidatos = manager.createQuery("select c from Candidato c where idVaga = :idVaga")
                .setParameter("idVaga", idVaga).getResultList();

        return candidatos;
    }

}
