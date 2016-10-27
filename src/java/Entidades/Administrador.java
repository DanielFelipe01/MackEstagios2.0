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
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name="idUsuario")
@DiscriminatorValue("1")
public class Administrador extends Usuario implements Serializable{
    @Column(name = "idAdm")
    private Integer idAdm;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nivel")
    private int nivel;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;
    
    public Administrador( String nome, String email, String senha, int nivel, Usuario usuario) {
        super(nome, email, senha);
        this.nome = nome;
        this.nivel = nivel;
        this.usuario = usuario;
    }

    public Administrador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    
    
    
    

    
    
}
