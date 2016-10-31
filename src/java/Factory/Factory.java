/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Entidades.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Daniel
 */
public interface Factory {
    
    
    public Usuario criarUsuario(String email, String senha, String tipo);
    
    public Usuario criarUsuarioTipo(HttpServletRequest request, Usuario usuario);
}
