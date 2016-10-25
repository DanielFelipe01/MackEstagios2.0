/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Usuario;

/**
 *
 * @author Daniel
 */
public interface LoginDAO {
    public Usuario selectUsuario(String email, String senha);
}
