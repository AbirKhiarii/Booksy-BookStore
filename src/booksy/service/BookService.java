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
import javafx.scene.chart.PieChart;

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
    public Boolean ajouterLivre(Book p) {
      Boolean test=false;
        
        try {
           String req;
            req = "INSERT INTO booktobuy "
                    + "(ISBN,titre,auteur,description,edition,prix,quantite,image,marque,podcast,Categorie_id, versionpdf )"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps= cnx.getConnection().prepareStatement(req);
           
            ps.setObject(1,p.getISBN());
            ps.setObject(2,p.getTitre());
            ps.setObject(3,p.getAuteur());
            ps.setObject(4,p.getDescription());
            ps.setDate(5,p.getEdition());
            ps.setObject(6,p.getPrix());
            ps.setObject(7,p.getQuantite() );
            ps.setObject(8,p.getImage() );
            ps.setObject(9,p.getMarque());
            ps.setObject(12,p.getVersionpdf());
            ps.setObject(10,p.getPodcast());
            ps.setObject(11,p.getCategorie());
            ps.executeUpdate();
            System.out.println("book ajouté");
            test= true ;
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }return test ;
        
    }
   

    @Override
    public void supprimerLivre(String isbn) {
    try {
            String req = "DELETE FROM `booktobuy` WHERE ISBN="+"'"+isbn+"'";
            PreparedStatement ps= cnx.getConnection().prepareStatement(req);
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
            Statement s = cnx.getConnection().createStatement();
            ResultSet rs=s.executeQuery(req);
            while (rs.next())
            { Book b = new Book() ;
                
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
    
     public ObservableList<PieChart.Data> getSearch(String p){
         ObservableList<PieChart.Data> data =FXCollections.observableArrayList();
       try {
           String req="select COUNT(*) from booktobuy where auteur ='"+p+"'";
           String req1="select COUNT(*) from booktobuy";
           Statement s = cnx.getConnection().createStatement();
           ResultSet rs=s.executeQuery(req);
           if (rs.next())
           {int count =rs.getInt(1);
            data.add(new PieChart.Data("Total Book "+p+" ,"+count+")",count));
           }
           rs=s.executeQuery(req1);
           if (rs.next())
           {int count =rs.getInt(1);
            data.add(new PieChart.Data("Total total ("+count+")",count));
           }
       } catch (SQLException ex) {
           Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
       }
       return data;
    }
    /*public void ajouterPdf(String p)
    {  try {
        String req = "Insert into booktobuy(versionpdf)Values(?);";
        PreparedStatement ps= cnx.getConnexion().prepareStatement(req);
        ps.setObject(1,p);
       } catch (SQLException ex) {
           Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
       }
    }*/
     public String afficherpdf(String isbn)
     {String c="";
         try {
        String req = "select versionpdf from booktobuy where ISBN='"+isbn+"'";
        Statement s = cnx.getConnection().createStatement();
            ResultSet rs=s.executeQuery(req);
            
            while (rs.next())
            {
                c=(rs.getString("versionpdf"));}
            
    
       } catch (SQLException ex) {
           Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
       }
       
     return c;
     }
        public String afficherimage(String isbn)
     {String c="";
         try {
        String req = "select image from booktobuy where ISBN='"+isbn+"'";
        Statement s = cnx.getConnection().createStatement();
            ResultSet rs=s.executeQuery(req);
            
            while (rs.next())
            {
                c=(rs.getString("image"));}
            
    
       } catch (SQLException ex) {
           Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
       }
       
     return c;
     }

    
    public void modifier(Book B,String isbn) {
      /* try{   ISBN,titre,auteur,description,edition,prix,quantite,image,marque,podcast,Categorie_id, versionpdf
       String req = " UPDATE booktobuy SET ISBN`=?,auteur`=?,`titre`=?,`marque`=?,`description`=?,`quantite`=?,`image`=? ,`prix`=?,`edition`=? WHERE ISBN="+"'"+isbn+"'";
            PreparedStatement ps =cnx.getConnexion().prepareStatement(req);
          
              
            ps.setObject(1,B.getISBN());
            ps.setObject(2,B.getTitre());
            ps.setObject(3,B.getAuteur());
            ps.setObject(4,B.getDescription());
            ps.setDate(5,B.getEdition());
            ps.setObject(6,B.getPrix());
            ps.setObject(7,B.getQuantite() );
            ps.setObject(8,B.getImage() );
            ps.setObject(9,B.getMarque());
            ps.setObject(12,B.getVersionpdf());
            ps.setObject(10,B.getPodcast());
            ps.setObject(11,B.getCategorie());
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    }*/

  
    
}
}
