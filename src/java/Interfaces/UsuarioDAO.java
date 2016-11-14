/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.*;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface UsuarioDAO {

    public Usuario insertUsuario(Usuario usuario);

    public Usuario updateUsuario(Usuario usuario);

    public Usuario deleteUsuario(Usuario usuario);

    public List<Usuario> selectUsuarios();
    
    public Usuario selectUsuario(String email, String senha);
    
    public Usuario selectEmailUsuario(String email);


}
