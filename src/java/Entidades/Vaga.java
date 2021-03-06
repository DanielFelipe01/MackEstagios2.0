/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Cardo
 */

@Entity
@Table(name = "vaga")
@PrimaryKeyJoinColumn(name="idEmpresa")

public class Vaga  implements Serializable{
    @Id
    @Column(name = "idVaga")
    private Integer idVaga;
    
    @Column(name = "curso")
    private String curso;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "semestre")
    private int semestre;
    
    @Column(name = "valorBolsa")
    private double bolsa;
    
    @Column(name = "valeRefeicao")
    private double refeicao;
    
    @Column(name = "valeTransporte")
    private double transporte;
    
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "atividades")
    private String atividades;
    @Column(name = "horario")
    private String horario;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa", insertable = false, updatable = false)
    private Empresa empresa;
    
    @Column(name = "adicionais")
    private String adicionais;
    
    @Column(name = "validade")
    private String validade;
    
    @Column(name = "status")
    private boolean status;
    
    @Transient
    private List<Candidato> candidatos;

    public Vaga() {
    }

       
    public Vaga(String curso,String nome, int semestre, double bolsa, String descricao, String atividades, String horario, Empresa idEmpresa, String validade, double refeicao,double transporte,String adicionais) {
        this.curso = curso;
        this.nome = nome;
        this.semestre = semestre;
        this.bolsa = bolsa;
        this.descricao = descricao;
        this.atividades = atividades;
        this.horario = horario;
        this.empresa = idEmpresa;
        this.refeicao = refeicao;
        this.transporte = transporte; 
        this.adicionais = adicionais;
        this.validade = validade;
        this.status = true;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    
    
    public Integer getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Integer idVaga) {
        this.idVaga = idVaga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getBolsa() {
        return bolsa;
    }

    public void setBolsa(double bolsa) {
        this.bolsa = bolsa;
    }

    public double getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(double refeicao) {
        this.refeicao = refeicao;
    }

    public double getTransporte() {
        return transporte;
    }

    public void setTransporte(int transporte) {
        this.transporte = transporte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
