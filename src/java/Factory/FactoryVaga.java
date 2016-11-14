/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Entidades.Empresa;
import Entidades.Usuario;
import Entidades.Vaga;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Cardo
 */
public interface FactoryVaga {
    
    public Vaga criarVaga(HttpServletRequest request);
}
