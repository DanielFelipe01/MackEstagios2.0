/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Conexao.Conexao;
import Entidades.Vaga;
import Interfaces.VagaDAO;
import java.sql.PreparedStatement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cardo
 */
public class VagaDBDAO implements VagaDAO {

    private EntityManager manager;

    public VagaDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }

    @Override
    public Vaga insertVaga(Vaga vaga) {
        Conexao c = new Conexao();

        String sql = "insert into vaga (curso, nome, semestre, valorbolsa, valerefeicao, valetransporte, descricao, atividades, adicionais, validade, horario, idempresa, status)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);
            stmt.setString(1, vaga.getCurso());
            stmt.setString(2, vaga.getNome());
            stmt.setInt(3, vaga.getSemestre());
            stmt.setDouble(4, vaga.getBolsa());
            stmt.setDouble(5, vaga.getRefeicao());
            stmt.setDouble(6, vaga.getTransporte());
            stmt.setString(7, vaga.getDescricao());
            stmt.setString(8, vaga.getAtividades());
            stmt.setString(9, vaga.getAdicionais());
            stmt.setString(10, vaga.getValidade());
            stmt.setString(11, vaga.getHorario());
            stmt.setInt(12, vaga.getEmpresa().getIdEmpresa());
            stmt.setBoolean(13, vaga.isStatus());

            stmt.execute();
            stmt.close();

        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            c.close();
        }

        return vaga;
    }

    @Override
    public List<Vaga> selectVagas(String pesquisa, String empresa, String filtro) {
        List<Vaga> vagas = null;
        try {
            if (!empresa.equals(null) && filtro.equalsIgnoreCase("todas")) {
                vagas = manager.createQuery("select v from Vaga v where nome LIKE :pesquisa and idEmpresa = :empresa")
                        .setParameter("pesquisa", pesquisa).setParameter("empresa", empresa).getResultList();
            }
            else if (!empresa.equals(null)){
                boolean filtroBoolean = Boolean.parseBoolean(filtro);
                vagas = manager.createQuery("select v from Vaga v where nome LIKE :pesquisa and idEmpresa = :empresa and status = :filtro")
                        .setParameter("pesquisa", pesquisa).setParameter("empresa", empresa).setParameter("filtro", filtroBoolean).getResultList();
            }
        } catch (Exception ex) {
            vagas = manager.createQuery("select v from Vaga v where nome LIKE :pesquisa")
                    .setParameter("pesquisa", pesquisa).getResultList();
        }
        return vagas;

    }

    @Override
    public Vaga selectVaga(int idVaga) {
        Vaga vaga = (Vaga) manager.createQuery("select e from Vaga e where idVaga = :idVaga")
                .setParameter("idVaga", idVaga).getSingleResult();

        return vaga;
    }

    @Override
    public Vaga changeStatusVaga(Vaga vaga) {
        Conexao c = new Conexao();
        
        String sql = "UPDATE vaga set status = ? WHERE idVaga = ?";
        try{
            PreparedStatement stmt = c.getConexao().prepareStatement(sql);
            stmt.setBoolean(1, vaga.isStatus());
            stmt.setInt(2, vaga.getIdVaga());
            
            stmt.execute();
            stmt.close();
            
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
            return null;
        }finally{
            c.close();
        }
       
        return vaga;
    }
}
