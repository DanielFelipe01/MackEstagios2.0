/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.Formacao;
import Interfaces.FormacaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class FormacaoDBDAO implements FormacaoDAO{
    private EntityManager manager;
    private Connection c;

    public FormacaoDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
        this.c = Conexao.getConexao();
    }
    
    @Override
    public Formacao insertFormacao(Formacao form) {
        manager.getTransaction().begin();
        manager.persist(form);
        manager.getTransaction().commit();

        return form;
    }
    
    @Override
    public Formacao updateFormacao(Formacao form) {
        
        String sql = "UPDATE formacao set curso = ?, semestre = ?, faculdade = ?, unidade = ?"
                + " WHERE idFormacao = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, form.getCurso());
            stmt.setInt(2, form.getSemestre());
            stmt.setString(3, form.getFaculdade());
            stmt.setString(4, form.getUnidade());
            stmt.setInt(5, form.getIdFormacao());

 
            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            Conexao.close();
        }
       
        return form;
    }
}
