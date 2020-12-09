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
 * @author lenovo
 */
public class MyConnexion {


     private String url="jdbc:mysql://localhost:3306/Booksy";
    private String user = "root";
    private String pwd = "";
    private Connection connexion;
    private static MyConnexion instance;
    
    private MyConnexion()
        {
        try {
            connexion= DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablit");
        } catch (SQLException ex) {
            //Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Vous ne pouvez pas se connecter");
        }
        }
    
    public static MyConnexion getInstance(){
        if (instance==null){
            instance= new MyConnexion();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return connexion;
    }
}
