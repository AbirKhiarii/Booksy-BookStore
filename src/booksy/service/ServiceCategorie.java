/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.service;

import booksy.entities.Categorie;
import booksy.interfaces.InterfaceCategorie;
import booksy.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author oumayma
 */
public class ServiceCategorie implements InterfaceCategorie {
    MyConnexion cnx;
public ServiceCategorie(){
     cnx=MyConnexion.getInstance();
    
}

    @Override
    public void AjouterCategorie(Categorie c) {
        try {
        String req= "insert into categorie (Nom_Categorie,Famille) values (?,?)";
        PreparedStatement ps = cnx.getConnection().prepareStatement(req);
        ps.setString(1, c.getNom_Categorie());
          ps.setString(2, c.getFamille());
        ps.executeUpdate(); 
        System.out.println("catégorie ajoutée");
        } catch (SQLException ex) {
           System.out.println("erreur d'ajout");
           }
    }

    @Override
    public ObservableList<Categorie>  AfficherCategorie() {
        
ObservableList<Categorie> l=FXCollections.observableArrayList();
try {
            
            String req1= "select * from categorie ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                 Categorie c = new Categorie();
                c.setCode_categorie(rs.getInt("Code_categorie"));
                c.setNom_Categorie(rs.getString("Nom_categorie"));
                c.setFamille(rs.getString("Famille"));
                l.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("erreur d'affichage");
}
      return l;     }

    @Override
    public void modifierCategorie(Categorie c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String req = "UPDATE categorie SET Nom_Categorie=? , Famille=? where Code_categorie=?" ;
        try{
        PreparedStatement ps = cnx.getConnection().prepareStatement(req);
        ps.setString(1,c.getNom_Categorie());
        ps.setString(2,c.getFamille());
        ps.setInt(3,c.getCode_categorie());
        ps.executeUpdate();
        System.out.println("modification établie");
        } catch (SQLException ex) {
        System.out.println("erreur de modification");
    }
    }

    @Override
    public void SupprimerCategorie(int c) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
            try{
     String req = "DELETE from categorie WHERE Code_categorie=" +c;
        
        Statement s = cnx.getConnection().createStatement();
        PreparedStatement ps = cnx.getConnection().prepareStatement(req);
        ps.executeUpdate();
        System.out.println("supperssion effectue");
    } catch (SQLException ex) {
        System.out.println("erreur suppression");
    }
     
    }
    
}
