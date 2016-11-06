/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Entidades.Empresa;
import Interfaces.EmpresaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class EmpresaDBDAO implements EmpresaDAO{
    private EntityManager manager;

    public EmpresaDBDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        this.manager = factory.createEntityManager();
    }
    
    @Override
    public Empresa updateEmpresa(Empresa emp) {
        manager.getTransaction().begin();
        manager.merge(emp);
        manager.getTransaction().commit();
        manager.close();

        return emp;
    }
    
    @Override
    public List<Empresa> selectEmpresas(String pesquisa) {
        List<Empresa> usuarios = manager.createQuery("select e from Empresa e where nome LIKE :pesquisa")
                .setParameter("pesquisa", pesquisa).getResultList();

        return usuarios;
    }

    @Override
    public Empresa selectEmpresa(int idEmpresa) {
        Empresa empresa = (Empresa) manager.createQuery("select e from Empresa e where idEmpresa = :idEmpresa")
                .setParameter("idEmpresa", idEmpresa).getSingleResult();

        return empresa;
    }
}
