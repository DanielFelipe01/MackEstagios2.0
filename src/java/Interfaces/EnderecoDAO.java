/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Endereco;

/**
 *
 * @author Daniel
 */
public interface EnderecoDAO {
    public Endereco insertEndereco(Endereco end);
    
    public Endereco updateEndereco(Endereco end);
}
