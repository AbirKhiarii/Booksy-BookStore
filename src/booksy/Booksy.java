/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.Book;
import booksy.service.BookService;
import java.sql.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Booksy extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBook.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       /* BookService sp =new BookService();
        Book p = new Book("ISBN","titre"," auteur","",new Date(2020,1,1), 1.15, 5, "image", "marque", " versionpdf", "odcast","categorie");
        sp.ajouterLivre(p);
        sp.supprimerLivre("azertt");
        sp.afficherLivre();*/
    }
    
}
