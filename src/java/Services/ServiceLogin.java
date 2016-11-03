/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAOs.LoginDBDAO;
import Entidades.Administrador;
import Entidades.Usuario;

/**
 *
 * @author Daniel
 */
public class ServiceLogin {
    
    public Usuario validaUsuario(String email, String senha){
        LoginDBDAO loginDB = new LoginDBDAO();
        
        return loginDB.selectUsuario(email, senha);
    }
}
