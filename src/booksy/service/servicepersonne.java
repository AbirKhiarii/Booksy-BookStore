/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.service;

import booksy.entities.personne;
import booksy.interfaces.interfacepersonne;
import booksy.utils.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hamza
 */
public class servicepersonne implements interfacepersonne {
    
   MyConnexion cnx ;
    public servicepersonne(){
    cnx = MyConnexion .getinstance();
    //  WSystem.out.println("connexion etablie");
    }
    
    @Override
    public void ajouterPersonne(personne p){
        try {
            String req="INSERT INTO `per`(`nom`, `prenom`, `sexe`, `email`, `motdepasse`, `telephone`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.getconnection().prepareStatement(req);
            ps.setString(1 , p.getNom());
            ps.setString(2 , p.getPrenom());
            ps.setString(3 , p.getSex());
            ps.setString(4 , p.getEmail());
            ps.setString(5 , p.getMotdepasse());
            ps.setInt(6 , p.getNumero());
            ps.executeUpdate();
            System.out.println("élément ajouté avec succées");
        } catch (SQLException ex) {
            Logger.getLogger(servicepersonne.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("erreur");
        }
     }

    /*@Override
    public  ObservableList<personne> afficher() {
      // ArrayList<personne> l= new ArrayList();
      ObservableList<personne> l = FXCollections.observableArrayList();
        try {
            String req1="select * from per ";
            Statement s = cnx.getconnection().createStatement();
          
            ResultSet rs = s.executeQuery(req1);
            while(rs.next()){
             //System.out.println("ID "+rs.getInt("id")+"Nom "+rs.getString("nom")+" prenom: "+rs.getString("prenom")+" sex: "+rs.getString("sexe")+" email: "+rs.getString("email")+" mot de passe: "+rs.getString("motdepasse")+" numero:"+rs.getString("telephone"));
             //System.out.println("ID "+rs.getInt("id")+"Nom "+rs.getString("nom")+" prenom "+rs.getString("prenom"));
            personne p=new personne();
            p.setId(rs.getInt("id"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setSex(rs.getString("sexe"));
            p.setEmail(rs.getString("email"));
            p.setMotdepasse(rs.getString("motdepasse"));
            p.setNumero(rs.getInt("telephone"));
                l.add(p);
            }
        } catch (SQLException ex) {
       ex.printStackTrace();
        }
      
      return l;
     
    }*/
    
    

   
 /*public void modifierpersonne(personne p){
        try {
            String req3= "update table personne set nom=? where id=?";
            PreparedStatement ps = cnx.getconnection().prepareStatement(req3);
             ps.setString(1 , p.getNom());
             ps.setInt(2 , p.getId());
             ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(servicepersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
 }*/
    @Override
    public void supprimerPersonne(int id)  {
        try {
            String req2 = "delete from per where id ="+id;
            PreparedStatement ps = cnx.getconnection().prepareStatement(req2);
             ps.executeUpdate();
             System.out.println("élément supprimé avec succées");
        } catch (SQLException ex) {
              System.err.println("errrr");
        }
            
    }

    @Override
    public void modifierPersonne(personne p) {
        try {
            String req3= "update `per` set `nom`=?,`prenom`=?,`sexe`=?,`email`=?,`motdepasse`=?,`telephone`=? where id=?";
             PreparedStatement ps = cnx.getconnection().prepareStatement(req3);
             ps.setString(1 , p.getNom());
             ps.setString(2 , p.getPrenom());
             ps.setString(3 , p.getSex());
             ps.setString(4 , p.getEmail());
             ps.setString(5 , p.getMotdepasse());
             ps.setInt(6 , p.getNumero());
             ps.setInt(7 , p.getId());
             ps.executeUpdate();
             System.out.println("élément modifié avec succées");

        } catch (SQLException ex) {
            //System.out.println("erreur");
            ex.printStackTrace();
        }
    }

  

   
}

