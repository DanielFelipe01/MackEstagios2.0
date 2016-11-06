/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.AlunoDBDAO;
import Entidades.Aluno;
import Factory.UsuarioFactory;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ServiceAluno {
    private UsuarioFactory factory;
    private AlunoDBDAO alunoDB;
    
    
    public ServiceAluno(){
        this.factory = new UsuarioFactory();
        this.alunoDB = new AlunoDBDAO();
    }
    
    public List<Aluno> listarAlunos(String pesquisa){
        try{
            return (List<Aluno>) alunoDB.selectAlunos(pesquisa);
        }catch(Exception ex){
            return null;
        }
    }
    
    public Aluno selecionarAluno(int idAluno){
        try{
            return (Aluno) alunoDB.selectAluno(idAluno);
        }catch(Exception ex){
            return null;
        }
    }
}
