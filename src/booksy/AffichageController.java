/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.Book;
import booksy.service.BookService;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AffichageController implements Initializable {

    @FXML
    private TableView<Book> table;
    @FXML
    private TableColumn<Book, String> isbn;
    @FXML
    private TableColumn<Book, String> auteur;
    @FXML
    private TableColumn<Book, Date> edition;
    @FXML
    private TableColumn<Book, Double> prix;
    @FXML
    private TableColumn<Book, String> marque;
    @FXML
    private TableColumn<Book, Integer> quantite;
    @FXML
    private TableColumn<Book, String> image;
    @FXML
    private TableColumn<Book, String> version;
    @FXML
    private TableColumn<Book, String> podcast;
    @FXML
    private TableColumn<Book, String> resume;
    @FXML
    private TableColumn<Book, String> titre;
     @FXML
    private TableColumn<Book, Integer> Categorie;
    @FXML
    private TextField tfISBN;
    @FXML
    private Label ftISBN;
    @FXML
    private TextField tfAuteur;
    @FXML
    private TextField tfEdition;
    @FXML
    private Label ftAuteur;
    @FXML
    private Label ftEdition;
    @FXML
    private Label ftResume;
    @FXML
    private TextArea tfResume;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfMarque;
    @FXML
    private Label ftMarque;
    @FXML
    private TextField tfQuantite;
    @FXML
    private TextField tfImage;
    @FXML
    private TextField tfVersion;
    @FXML
    private TextField tfPodcast;
    @FXML
    private Label ftpodcast;
    @FXML
    private TextField tfCategorie;
    @FXML
    private Label ftPrix;
    @FXML
    private Label ftISBN1;
    @FXML
    private Label ftCategorie;
    @FXML
    private Button btafficherpdf;
    @FXML
    private Button btsupp;
    @FXML
    private Button btmodif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowData();
    }    

    @FXML
    private void displayData(MouseEvent event) {
         Book lv=this.table.getSelectionModel().getSelectedItem();
        if(lv!=null)
        {
            this.tfISBN.setText(lv.getISBN());
            this.tfTitre.setText(lv.getTitre());
            this.tfAuteur.setText(lv.getAuteur());
            this.tfResume.setText(lv.getDescription());
            this.tfEdition.setText(lv.getEdition().toString());
            this.tfPrix.setText(Double.toString(lv.getPrix()));
            this.tfQuantite.setText(Integer.toString(lv.getQuantite()));
            this.tfImage.setText(lv.getImage());
            this.tfMarque.setText(lv.getMarque());
            this.tfVersion.setText(lv.getVersionpdf()); 
            this.tfPodcast.setText(lv.getPodcast());
            this.tfCategorie.setText(Integer.toString(lv.getCategorie())); 
    }
    }

    public void ShowData(){
         BookService sp= new BookService();
        ObservableList<Book> l = sp.afficherLivre();
        
       this.isbn.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));
       this.titre.setCellValueFactory(new PropertyValueFactory<Book,String>("titre"));
       this.auteur.setCellValueFactory(new PropertyValueFactory<Book,String>("auteur"));
       this.resume.setCellValueFactory(new PropertyValueFactory<Book,String>("description"));
       this.edition.setCellValueFactory(new PropertyValueFactory<Book,Date>("edition"));
       this.prix.setCellValueFactory(new PropertyValueFactory<Book,Double>("prix"));
       this.marque.setCellValueFactory(new PropertyValueFactory<Book,String>("marque"));
       this.quantite.setCellValueFactory(new PropertyValueFactory<Book,Integer>("quantite"));
       this.image.setCellValueFactory(new PropertyValueFactory<Book,String>("image"));
       this.version.setCellValueFactory(new PropertyValueFactory<Book,String>("versionpdf"));
       this.podcast.setCellValueFactory(new PropertyValueFactory<Book,String>("podcast"));
        this.Categorie.setCellValueFactory(new PropertyValueFactory<Book,Integer>("Categorie_id"));
       this.table.setItems(l);
        
    }    


    @FXML
    private void retour(MouseEvent event) {
           try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLBook.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
           
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void OpenPDF(MouseEvent event) {
          BookService sp = new BookService();
      
        String isbn=(tfISBN.getText());
        String url =sp.afficherpdf(isbn);
        try{
        Desktop.getDesktop().open(new java.io.File(url));}
        catch(Exception e)
        {e.printStackTrace();
        }
        
    }

    @FXML
    private void SupprimerLivreAchat(ActionEvent event) {
        BookService sp = new BookService();
        Book p =new Book();
        p.setISBN(tfISBN.getText());
        String isbn=(p.getISBN());
        sp.supprimerLivre(isbn);
       ShowData();
    }

    @FXML
    private void ModifierLivre(ActionEvent event) {
    }


    
}
