/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class MyConnexion {
 private String url="jdbc:mysql://localhost:3306/booksy";
     private String login="root";
     private String pwd="";
     private Connection connexion;
     private static MyConnexion instance;
     
     
     public MyConnexion () {
         try { 
             connexion=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println("erreurrrrrrrrrrrrr");
         }
     }
     public static MyConnexion  getinstance(){
      if(instance==null)
            instance=new MyConnexion ();
        
        return instance;
     }
     public Connection getconnection(){
      return connexion;
     }    
}
