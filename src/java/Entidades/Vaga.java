/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Cardo
 */
@Entity
@Table(name = "vaga")
public class Vaga  implements Serializable{
    @Id
    @Column(name = "idvaga")
    private Integer idVaga;
    @Column(name = "curso")
    private String curso;
    @Column(name = "nome")
    private String nome;
    @Column(name = "semestre")
    private int semestre;
    @Column(name = "valorbolsa")
    private int bolsa;
    @Column(name = "valerefeicao")
    private int refeicao;
    @Column(name = "valetransporte")
    private int transporte;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "atividades")
    private String atividades;
    @Column(name = "horario")
    private int horario;
    
    
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idempresa", insertable = false, updatable = false)
    private Empresa idEmpresa;
    
    
    
    
    @Column(name = "adicionais")
    private String adicionais;
    @Column(name = "atavalidade")
    private String atavalidade;

    public Vaga() {
    }

    public Vaga(String curso,String nome, int semestre, int bolsa, String descricao, String atividades, int horario, Empresa idEmpresa) {
        this.curso = curso;
        this.nome = nome;
        this.semestre = semestre;
        this.bolsa = bolsa;
        this.descricao = descricao;
        this.atividades = atividades;
        this.horario = horario;
        this.idEmpresa = idEmpresa;
        this.refeicao = 0;
        this.transporte = 0; 
        this.adicionais = "";
        this.atavalidade = "";
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

    public int getBolsa() {
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }

    public int getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(int refeicao) {
        this.refeicao = refeicao;
    }

    public int getTransporte() {
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

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    
    
}
