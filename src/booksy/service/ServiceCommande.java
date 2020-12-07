/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.service;

import booksy.entities.Commande;
import booksy.interfaces.InterfaceCommande;
import booksy.utils.MyConnexion;
import java.sql.Date;
import static java.sql.JDBCType.DATE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lenovo
 */
public class ServiceCommande implements InterfaceCommande{
    MyConnexion cnx;
    
    public ServiceCommande(){
        cnx=MyConnexion.getInstance();
    }
    
    @Override
    public void ajouterCommande(Commande d) {
        /*String req="INSERT INTO `commandes`( `numCommande`, `date`, `modePaiement`, `statut`)"
                + " VALUES ("+d.getNumCommande()+",'"+new Date( d.getDate().getTime())+"','"+d.getModepaiement()+"','"+d.getStatut()+"')";*/
        String req="INSERT INTO `commandes`(`numCommande`, `date`, `modePaiement`, `statut`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps= cnx.getConnection().prepareStatement(req);             
            //Statement ps=cnx.getConnection().createStatement();
            ps.setInt(1, d.getId());
            ps.setInt(1,d.getNumCommande());
            ps.setDate(2, new Date(d.getDate().getTime()));
            ps.setString(3,d.getModepaiement());
            ps.setString(4, d.getStatut());
            ps.executeUpdate();
            System.out.println("ajoucv");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ObservableList<Commande> afficher() {
        ObservableList<Commande> l=FXCollections.observableArrayList();
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req1="Select * from commandes ";
            Statement s=cnx.getConnection().createStatement();
            ResultSet rs= s.executeQuery(req1);
             
            while(rs.next()){
              //  System.out.println("id= " + rs.getInt("id") +"numero de commande " + rs.getInt("numCommande") + "date= " + rs.getDate("date")+ "mode de paiement "+ rs.getString("modePaiement") + " Statut " + rs.getString("statut"));
              Commande d=new Commande();
              d.setId(rs.getInt("id"));
              d.setNumCommande(rs.getInt("numCommande"));
              d.setDate(rs.getDate("date"));
              d.setModepaiement(rs.getString("modePaiement"));
              d.setStatut(rs.getString("statut"));
              l.add(d);
            }
        } catch (SQLException ex) {
          ex.printStackTrace();
            
        }
       
        return l;
    }

    @Override
    public void supprimerCommande(Commande d) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req2="DELETE FROM commandes WHERE numCommande=?";
            PreparedStatement stmt=cnx.getConnection().prepareStatement(req2);
            stmt.setInt(1,d.getNumCommande());
            int i=stmt.executeUpdate();
            System.out.println(i+" records deleted");  
        } catch (SQLException ex) {
            //Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Suppression failed");
        }
    }

    @Override
    public void modifierCommande(Commande d) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req3="update commandes set statut=?,modePaiement=?,date=? where numCommande=?";
            PreparedStatement stmt=cnx.getConnection().prepareStatement(req3);
            stmt.setInt(4,d.getNumCommande());
            stmt.setDate(3,new Date(d.getDate().getTime()));
            stmt.setString(2,d.getModepaiement());
            stmt.setString(1,d.getStatut());
            
            
            int i=stmt.executeUpdate();  
            System.out.println(i+" records updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            //Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
