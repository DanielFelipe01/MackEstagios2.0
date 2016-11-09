/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.*;

/**
 *
 * @author Daniel
 */

@Entity
@Table(name = "candidatos")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idCandidato")
    private Integer idCandidato;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idAluno", referencedColumnName = "idAluno", insertable = false, updatable = false)
    private Aluno aluno;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idVaga", referencedColumnName = "idVaga", insertable = false, updatable = false)
    private Vaga vaga;

    public Candidato() {
    }

    public Candidato(Aluno aluno, Vaga vaga) {
        this.aluno = aluno;
        this.vaga = vaga;
    }

    public Integer getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    
    
    
}
