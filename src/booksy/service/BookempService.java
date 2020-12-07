/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.service;

import booksy.entities.Bookemp;
import booksy.interfaces.InterfaceBookempService;
import booksy.utils.MyConnexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author uuuu
 */
public class BookempService implements InterfaceBookempService {
     MyConnexion cnx ; 
    
    public BookempService(){ 
        cnx=MyConnexion.getInstance();
    }

    @Override
    public void ajouterBookEmp(Bookemp B) {
       
       try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
            String req = "insert into bookemp (ISBN , auteur , titre , marque , description , quantite ,image , prix , edition ) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps =cnx.getConnection().prepareStatement(req);
            ps.setString(1,B.getISBN() );
            ps.setString(2,B.getAuteur());
            ps.setString(3,B.getTitre());
            ps.setString(4,B.getMarque());
            ps.setString(5,B.getDescription());
            ps.setInt(6, B.getQuantite());
            ps.setString(7,B.getImage());
            ps.setDouble(8, B.getPrix());
            ps.setDate(9, new Date(B.getEdition().getTime()));
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void modifierBookEmp(Bookemp B, String ISBN) {
       try{   
       String req = " UPDATE `bookemp` SET `ISBN`=?,`auteur`=?,`titre`=?,`marque`=?,`description`=?,`quantite`=?,`prix`=?,`edition`=? WHERE ISBN="+"'"+ISBN+"'";
            PreparedStatement ps =cnx.getConnection().prepareStatement(req);
          
            ps.setString(1,B.getISBN() );
            ps.setString(2,B.getAuteur());
            ps.setString(3,B.getTitre());
            ps.setString(4,B.getMarque());
            ps.setString(5,B.getDescription());
            ps.setInt(6, B.getQuantite());
           // ps.setString(7,B.getImage());
            ps.setDouble(7, B.getPrix());
            ps.setDate(8,new Date (B.getEdition().getTime()));      
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    }

    @Override
    public void supprimerBookEmp(Bookemp B, String ISBN) {
        try{   
       String req = " delete from bookemp where ISBN=?";
            PreparedStatement ps =cnx.getConnection().prepareStatement(req);
               ps.setString(1,B.getISBN() );
                ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    }

    
    public ObservableList<Bookemp> afficherBookEmp() {
        ObservableList<Bookemp> B=FXCollections.observableArrayList();
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req = "Select ISBN , auteur , marque , titre , prix , quantite , edition , description   from bookemp";
            Statement s =cnx.getConnection().createStatement();
            ResultSet res =s.executeQuery(req);
            while (res.next()){
            
            Bookemp B1 = new  Bookemp ();
                B1. setISBN(res.getString("ISBN"));
                B1.setAuteur(res.getString("auteur"));
                B1.setMarque(res.getString("marque"));
                B1.setTitre(res.getString("titre"));
                
             
                B1.setQuantite(res.getInt("quantite"));
                   B1.setEdition(res.getDate("edition"));
                B1.setPrix(res.getDouble("prix"));
               
                
                B1.setDescription(res.getString("description"));
                          
                
                B.add(B1);}
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
   return  B ;
    }

   
    
    
}
