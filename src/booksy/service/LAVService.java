/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.service;

import booksy.entities.livreAVendre;
import booksy.interfaces.LAVInterface;
import booksy.utils.MyConnexion;
import java.sql.Date;
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
 * @author user
 */
public class LAVService implements LAVInterface{
 MyConnexion cnx;

    public LAVService() {
        cnx=MyConnexion.getInstance();
    }
    @Override
    public void ajouterLAV(livreAVendre lav) {
try {
            String req= "INSERT INTO `livre_vente`(`ISBN`, `titre`, `auteur`, `description`, `edition`, `prix`, `quantite`, `image`, `marque`, `etat`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setString(1, lav.getISBN());
            ps.setString(2, lav.getTitre());
            ps.setString(3,lav.getAuteur() );
            ps.setString(4, lav.getDescription());
            ps.setDate(5, new Date(lav.getEdition().getTime()));
            ps.setDouble(6, lav.getPrix());
            ps.setInt(7, lav.getQuantite());
            ps.setString(8, lav.getImage());
            ps.setString(9, lav.getMarque());
            ps.setString(10, lav.getEtat());
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void supprimerLAV(String ISBN) {
 try {
            String req="DELETE FROM `livre_vente` WHERE ISBN ="+"'"+ISBN+"'";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(LAVService.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void modifierLAV(livreAVendre lav, String ISBN) {

         try {
            String req= "UPDATE `livre_vente` SET `ISBN`=?,`titre`=?,`auteur`=?,`description`=?,`edition`=?,`prix`=?,`quantite`=?,`image`=?,`marque`=?,`etat`=? WHERE `ISBN`="+"'"+ISBN+"'";    
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setString(1,lav.getISBN());
           ps.setString(2, lav.getTitre());
            ps.setString(3,lav.getAuteur() );
            ps.setString(4, lav.getDescription());
            ps.setDate(5, lav.getEdition());
            ps.setDouble(6, lav.getPrix());
            ps.setInt(7, lav.getQuantite());
            ps.setString(8, lav.getImage());
            ps.setString(9, lav.getMarque());
            ps.setString(10, lav.getEtat());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public ObservableList<livreAVendre> afficher() {
ObservableList<livreAVendre> l=FXCollections.observableArrayList();
        try {
            String req1= "SELECT `ISBN`, `titre`, `auteur`, `description`, `edition`, `prix`, `quantite`, `image`, `marque`, `etat` FROM `livre_vente` WHERE 1 ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                livreAVendre lav = new livreAVendre();
                
                lav.setISBN(rs.getString("ISBN"));
                lav.setTitre(rs.getString("titre"));
                lav.setAuteur(rs.getString("auteur"));
                lav.setDescription(rs.getString("description"));
                lav.setEdition(rs.getDate("edition"));
                lav.setPrix(rs.getDouble("prix"));
                lav.setQuantite(rs.getInt("quantite"));
                lav.setImage(rs.getString("image"));
                lav.setMarque(rs.getString("marque"));
                lav.setEtat(rs.getString("etat"));
                l.add(lav);
            }
        } catch (SQLException ex) {
            System.err.println("errrr");
        }
        return l;    } 
}
    
    

