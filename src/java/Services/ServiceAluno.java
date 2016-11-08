/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.AlunoDBDAO;
import DAOs.EnderecoDBDAO;
import DAOs.FormacaoDBDAO;
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
    private EnderecoDBDAO enderecoDB;
    private FormacaoDBDAO formacaoDB;

    public ServiceAluno() {
        this.factory = new UsuarioFactory();
        this.alunoDB = new AlunoDBDAO();
        this.formacaoDB = new FormacaoDBDAO();
        this.enderecoDB = new EnderecoDBDAO();
    }

    public List<Aluno> listarAlunos(String pesquisa) {
        try {
            return (List<Aluno>) alunoDB.selectAlunos(pesquisa);
        } catch (Exception ex) {
            return null;
        }
    }

    public Aluno selecionarAluno(int idAluno) {
        try {
            return (Aluno) alunoDB.selectAluno(idAluno);
        } catch (Exception ex) {
            return null;
        }
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        try {
            aluno.setTelefone("949518128");
            enderecoDB.insertEndereco(aluno.getEndereco());
            formacaoDB.insertFormacao(aluno.getFormacao());
            return alunoDB.insertAluno(aluno);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        }

    }

    public Aluno alterarAluno(Aluno aluno) {
        try {
            enderecoDB.updateEndereco(aluno.getEndereco());
            formacaoDB.updateFormacao(aluno.getFormacao());
            return (Aluno) alunoDB.updateAluno(aluno);
        } catch (Exception ex) {
            return null;
        }
    }
}
