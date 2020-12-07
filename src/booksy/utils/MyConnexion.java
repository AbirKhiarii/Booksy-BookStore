/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class MyConnexion {
    private String url="jdbc:mysql://localhost:3306/booksy" ;
    private String login = "root";
    private String mdp="";
    private Connection connex;
    private static MyConnexion instance;
    

    private MyConnexion() {
        try {
            connex = DriverManager.getConnection(url,login,mdp);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connexion échoué");
        }
        
    }
    public static MyConnexion getInstance()
    {if (instance==null)
        {  instance = new MyConnexion();}
        return instance ;
    }
    public Connection getConnexion()
    {return connex;}
}
