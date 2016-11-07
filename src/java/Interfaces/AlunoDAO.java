/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Aluno;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface AlunoDAO {
    
    public Aluno insertAluno(Aluno aluno);
    
    public List<Aluno> selectAlunos(String pesquisa);
    
    public Aluno selectAluno(int idAluno);
}
