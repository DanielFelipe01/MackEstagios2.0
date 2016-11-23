/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Daniel
 */
public class Conexao {

    private static Connection conexao;

    private Conexao() {
    }
    
    public static Connection getConexao() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            String url = "jdbc:derby://localhost:1527/MackEstagios";
            String usuario = "adm";
            String senha = "adm";

            conexao = DriverManager.getConnection(url, usuario, senha);

            return conexao;
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        }
    }

    public static void close() {
        try {
            conexao.close();
        } catch (Exception ex) {
            conexao = null;
        }
    }
}
