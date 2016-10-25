/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name="idUsuario")
@DiscriminatorValue("2")
public class Aluno extends Usuario implements Serializable{
    @Column(name = "idAluno")
    private long idAluno;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "telefone")
    private String telefone;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco", insertable = false, updatable = false)
    private Endereco endereco;
    @Column(name = "dataNascimento")
    private Date dataNascimento ;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idFormacao", referencedColumnName = "idFormacao", insertable = false, updatable = false)
    private Formacao formacao;
    @Column(name = "tia")
    private String tia;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    public Aluno(String nome, String rg, String cpf, String telefone, Endereco endereco, Date dataNascimento, Formacao formacao, String tia, String email, String senha, String tipo) {
        super(email, senha, tipo);
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.tia = tia;
    }

    public Aluno() {
    }

    public long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public String getTia() {
        return tia;
    }

    public void setTia(String tia) {
        this.tia = tia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
