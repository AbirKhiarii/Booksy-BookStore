/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.service;

import booksy.entities.Book;
import booksy.interfaces.InterfaceBookService;
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
 * @author user
 */
public class BookService implements InterfaceBookService{
   MyConnexion cnx;

    public BookService() {
        this.cnx =  MyConnexion.getInstance();
       
    }
    
    
    @Override
    public void ajouterLivre(Book p) {
      
        
        try {
           String req;
            req = "INSERT INTO booktobuy (ISBN,titre,auteur,description,edition,prix,quantite,image,marque,versionpdf ,podcast,Categorie_id )values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps= cnx.getConnexion().prepareStatement(req);
           
            ps.setObject(1,p.getISBN());
            ps.setObject(2,p.getTitre());
            ps.setObject(3,p.getAuteur());
            ps.setObject(4,p.getDescription());
            ps.setDate(5,p.getEdition());
            ps.setObject(6,p.getPrix());
            ps.setObject(7,p.getQuantite() );
            ps.setObject(8,p.getImage() );
            ps.setObject(9,p.getMarque());
            ps.setObject(10,p.getVersionpdf());
            ps.setObject(11,p.getPodcast());
            ps.setObject(12,p.getCategorie());
            ps.executeUpdate();
            System.out.println("book ajouté");
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
    }
   

    @Override
    public void supprimerLivre(String isbn) {
    try {
            String req = "DELETE FROM `booktobuy` WHERE ISBN="+"'"+isbn+"'";
            PreparedStatement ps= cnx.getConnexion().prepareStatement(req);
             ps.executeUpdate();
            //System.out.println(row);
            System.out.println("Supprimer avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ObservableList<Book> afficherLivre() {
       ObservableList<Book> l = FXCollections.observableArrayList();
        try {
            String req = "select * from booktobuy ";
            Statement s = cnx.getConnexion().createStatement();
            ResultSet rs=s.executeQuery(req);
            while (rs.next())
            { Book b = new Book() ;
                //System.out.println("ISBN "+rs.getString("ISBN")+"titre"+rs.getString("titre")+"auteur "+
                   // rs.getString("auteur")+"edition"+rs.getString("edition")+"resumé"+rs.getString("resume")+
                    //"prix"+rs.getDouble("prix")+"code à barre"+rs.getInt("codebarre"));
                    b.setISBN(rs.getString("ISBN"));
                    b.setTitre(rs.getString("titre"));
                    b.setAuteur(rs.getString("auteur"));
                    b.setDescription(rs.getString("description"));
                    b.setEdition(rs.getDate("edition"));
                    b.setPrix(rs.getDouble("prix"));
                    b.setQuantite(rs.getInt("quantite"));
                    b.setImage(rs.getString("image"));
                    b.setMarque(rs.getString("marque"));
                    b.setVersionpdf(rs.getString("versionpdf"));
                    b.setPodcast(rs.getString("podcast"));
                    b.setCategorie(rs.getInt("Categorie_id"));
                    l.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    } 
}
