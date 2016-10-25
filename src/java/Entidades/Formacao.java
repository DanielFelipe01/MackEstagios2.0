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
@Table(name = "formacao")
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFormacao")
    private long idFormacao;
    @Column(name = "curso")
    private String curso;
    @Column(name = "semestre")
    private int semestre;
    @Column(name = "faculdade")
    private String faculdade;
    @Column(name = "unidade")
    private String unidade;

    public Formacao(String curso, int semestre, String faculdade, String unidade) {
        this.curso = curso;
        this.semestre = semestre;
        this.faculdade = faculdade;
        this.unidade = unidade;
    }

    public Formacao() {
    }
    
    
    public long getIdFormacao() {
        return idFormacao;
    }

    public void setIdFormacao(long idFormacao) {
        this.idFormacao = idFormacao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    
    
}


