/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */

@Entity
@Table(name = "Empresa")
@PrimaryKeyJoinColumn(name="idUsuario")
@DiscriminatorValue("3")
public class Empresa extends Usuario implements Serializable{
 
    @Column(name = "idEmpresa")
    private Integer idEmpresa;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "site")
    private String site;
    @Column(name = "telefone")
    private String telefone;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco", insertable = false, updatable = false)
    private Endereco endereco;
   
    @Column(name = "situacao")
    private Boolean situacao;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    public Empresa(String nome, String cnpj, String site, String telefone, Endereco endereco, Boolean situacao, Usuario usuario, String email, String senha, String tipo) {
        super(email, senha, tipo);
        this.nome = nome;
        this.cnpj = cnpj;
        this.site = site;
        this.telefone = telefone;
        this.endereco = endereco;
        this.situacao = situacao;
        this.usuario = usuario;
    }

    public Empresa() {
    }
    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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

    public Boolean getSituacao() {
        return situacao;
    }

    public void alteraSituacao() {
        if(this.situacao)
            this.situacao = false;
        else
            this.situacao = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    

}
