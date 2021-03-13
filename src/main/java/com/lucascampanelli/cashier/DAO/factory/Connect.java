package com.lucascampanelli.cashier.DAO.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class Connect {
    
    private static String url = "jdbc:sqlite:Cashier.db";
    private static Connection conn = null;
    
    public static void conectar(){
        try{
            Connect.conn = DriverManager.getConnection(url);
            System.out.println("Conectado");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void desconectar(){
        try{
            if (Connect.conn != null) {
                Connect.conn.close();
                System.out.println("Desconectado");
            }
            else{
                System.out.println("Sem conexão criada");
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
