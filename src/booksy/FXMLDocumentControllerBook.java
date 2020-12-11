/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.Book;
import booksy.service.BookService;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class FXMLDocumentControllerBook implements Initializable {
    
    private Label label;
    @FXML
    private Button window;
    @FXML
    private Button window2;
    @FXML
    private ImageView conteneurImage;
    @FXML
    private ImageView conteneurImage1;
    @FXML
    private Button parcourirPDF1;
    @FXML
    private Button parcourirImage1;
    @FXML
    private TextField tfISBN1;
    @FXML
    private TextField tfEdition1;
    @FXML
    private TextField tfTitre1;
    @FXML
    private TextField tfAuteur1;
    @FXML
    private TextField tfPrix1;
    @FXML
    private TextField tfMarque1;
    @FXML
    private TextField tfQuantite1;
    @FXML
    private TextField tfCategorie1;
    @FXML
    private TextField tfPodcastt1;
    @FXML
    private TextField tfVersion1;
    @FXML
    private TextField tfImagee1;
    @FXML
    private TextArea tfResume1;
    @FXML
    private Label ftISBN;
    @FXML
    private Button btnAjouter1;
    @FXML
    private Label ftISBN2;
    @FXML
    private Label ftISBN3;
    @FXML
    private Label ftISBN31;
    @FXML
    private Label ftISBN311;
    @FXML
    private Label ftISBN312;
    @FXML
    private Label ftISBN3121;
    @FXML
    private Label ftISBN31211;
    @FXML
    private Label ftISBN312111;
    @FXML
    private Label ftISBN312112;
    @FXML
    private Label ftISBN3121121;
    @FXML
    private Label ftISBN31211211;
    @FXML
    private Button bcompte;
    @FXML
    private Button bcompte1;
    @FXML
    private Button window21;
    @FXML
    private Button window211;
    
       /* public void ShowData(){
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
        
    }    */

    @FXML
    private void AjouterLivreAchat(ActionEvent event) {
    BookService s = new BookService();
    String isbn = (tfISBN1.getText());
    String auteur =(tfAuteur1.getText());
    String titre = (tfTitre1.getText());
    String description = (tfResume1.getText());
    
    String image = tfImagee1.getText();
    String marque = tfMarque1.getText();
    String versionpdf = tfVersion1.getText();
    String podcast=tfPodcastt1.getText();
    int categorie =Integer.parseInt(tfCategorie1.getText());
    Date edition =Date.valueOf( this.tfEdition1.getText());
    double prix =Double.parseDouble(tfPrix1.getText());
    int quantite = Integer.parseInt(tfQuantite1.getText());
    Book p = new Book (isbn,auteur,titre,description,edition,prix,quantite,image,marque,podcast,categorie);
    p.setVersionpdf(versionpdf);
    Boolean x =s.ajouterLivre(p);
    if (x== true)
    JOptionPane.showMessageDialog(null, "ajouté avec succées");
    else 
        JOptionPane.showMessageDialog(null, "Verifiez vos champs");
    }

    /*private void SupprimerLivreAchat(ActionEvent event) {
        BookService sp = new BookService();
        Book p =new Book();
        p.setISBN(tfISBN.getText());
        String isbn=(p.getISBN());
        sp.supprimerLivre(isbn);
       
    }*/


    private void handleButtonAction(MouseEvent event) {
         
    }

 

   

    @FXML
    private void afficheWindow1(MouseEvent event) {
       try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Graph.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
     
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affichewindow2(MouseEvent event) {
       try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("affichage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* private void displayData(MouseEvent event) {
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
    }*/

   /* private void OpenPDF(MouseEvent event) throws IOException {
        BookService sp = new BookService();
      
        String isbn=(tfISBN.getText());
        String url =sp.afficherpdf(isbn);
        try{
        Desktop.getDesktop().open(new java.io.File(url));}
        catch(Exception e)
        {e.printStackTrace();
        }
        
    }*/

 

    @FXML
    private void ParccourirPDF(MouseEvent event) {
          FileChooser fc = new FileChooser();
          FileChooser.ExtensionFilter typepdf = new FileChooser.ExtensionFilter("pdf filter","*.PDF");
          fc.getExtensionFilters().addAll(typepdf);
    File select = fc.showOpenDialog(null);
    if ( select !=null)
    {Book p =new Book();
        String versionpdf = select.getAbsolutePath();
        this.tfVersion1.setText(versionpdf);
        System.out.println(versionpdf);
   
    }
    }

    @FXML
    private void Parcourimage(MouseEvent event) throws IOException {
          FileChooser fc = new FileChooser();
          FileChooser.ExtensionFilter typejpg = new FileChooser.ExtensionFilter("JPG filter","*.JPG");
          FileChooser.ExtensionFilter typePNG = new FileChooser.ExtensionFilter("PNG filter","*.PNG");
          fc.getExtensionFilters().addAll(typejpg,typePNG);
          File file = fc.showOpenDialog(null);
          BufferedImage bfimg=ImageIO.read(file);
          Image image =SwingFXUtils.toFXImage(bfimg, null);
          conteneurImage.setImage(image);
 
    if ( file !=null)
    {Book p =new Book();
        String imagepath = file.getAbsolutePath();
        this.tfImagee1.setText(imagepath);
        System.out.println(imagepath);
    
    }
    }

  
   /* private void openImg(MouseEvent event) {
          BookService sp = new BookService();
       Book p =new Book();
       p.setImage(tfImage.getText());
        String isbn=(tfISBN.getText());
        String url =sp.afficherimage(isbn);
        System.out.println(url);
        try {
            Image img =new Image(url);
            conteneurImage.setImage(img);
        }catch(Exception e)
        {e.printStackTrace();
    }
    }
*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }

    @FXML
    private void affichrcompte(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void afficherbookemp(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Bookemp.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void vendreLv(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConsulterLAV.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void passerCommande(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
    


    

   

    

   

 

    
    

    

  

   


