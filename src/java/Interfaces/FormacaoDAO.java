/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Formacao;

/**
 *
 * @author Daniel
 */
public interface FormacaoDAO {
    public Formacao insertFormacao(Formacao form);
    
    public Formacao updateFormacao(Formacao form);
}
