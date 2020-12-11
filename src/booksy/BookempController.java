/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.Bookemp;
import booksy.service.BookempService;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static java.lang.Integer.parseInt;
import javafx.scene.control.CheckBox;
import static javafx.scene.input.KeyCode.B;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class BookempController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfISBN;
    @FXML
    private TextField tfauteur;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfmarque;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfquan;
    @FXML
    private TextField tfedi;
    @FXML
    private TextField tfimage;
    @FXML
    private TableView<Bookemp> idtableview;
    @FXML
    private TableColumn<Bookemp, String> idISBN;
    @FXML
    private TableColumn<Bookemp, String> idauteur;
    @FXML
    private TableColumn<Bookemp, String> idmarque;
    @FXML
    private TableColumn<Bookemp, String> idtitre;
    @FXML
    private TableColumn<Bookemp, Double> idprix;
    @FXML
    private TableColumn<Bookemp, Integer> idquantite;
    @FXML
    private TableColumn<Bookemp, Date> idedi;
    @FXML
    private TableColumn<Bookemp, String> iddesc;
    @FXML
    private Button btajouter;
    @FXML
    private Button btsupprimer;
    @FXML
    private Button btmodifier;
    @FXML
    private Button btannuler;
    @FXML
    private TableColumn<Bookemp, String> idimage;
    @FXML
    private CheckBox idremise;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
     if (event.getSource()==this.btajouter)
     { 
          ajouterBookEmp();
         JOptionPane.showMessageDialog(null, "Ajouté avec succès");
     }
     else if (event.getSource()==this.btmodifier){
           modifierBookEmp();
             JOptionPane.showMessageDialog(null, "Modifié avec succès");
        
    }
     else if (event.getSource()==this.btsupprimer){
             supprimerBookEmp();
               JOptionPane.showMessageDialog(null, "Supprimé avec succès");
             }
     
     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
    }   
    public void afficher(){ 
       BookempService s = new BookempService();
       ObservableList<Bookemp> B  = s.afficherBookEmp();
       this.idISBN.setCellValueFactory(new PropertyValueFactory <Bookemp , String>("ISBN"));
       this.idauteur.setCellValueFactory(new PropertyValueFactory <Bookemp , String>("auteur"));
       this.idmarque.setCellValueFactory(new PropertyValueFactory <Bookemp , String>("marque"));
       this.idtitre.setCellValueFactory(new PropertyValueFactory <Bookemp , String>("titre"));
       this.idprix.setCellValueFactory(new PropertyValueFactory <Bookemp , Double>("prix"));
       this.idquantite.setCellValueFactory(new PropertyValueFactory <Bookemp , Integer>("quantite"));
       this.idedi.setCellValueFactory(new PropertyValueFactory <Bookemp , Date>("edition"));
       this.iddesc.setCellValueFactory(new PropertyValueFactory <Bookemp , String>("description"));
       this.idimage.setCellValueFactory(new PropertyValueFactory <Bookemp , String>("image"));
       this.idtableview.setItems(B);
       
     }

    private void ajouterBookEmp() throws Exception {
                 BookempService s = new BookempService();
        try {
   
            
            Bookemp B = new Bookemp();
            B.setISBN(tfISBN.getText());
            B.setAuteur(tfauteur.getText());
            B.setTitre(tftitre.getText());
            B.setMarque(tfmarque.getText());
            B.setDescription(tfdesc.getText());
            B.setQuantite(parseInt(this.tfquan.getText()));
            B.setPrix(parseDouble(tfprix.getText()));
            B.setEdition(new SimpleDateFormat("yyyy-MM-dd").parse(tfedi.getText()));
            B.setImage(tfimage.getText());
         
          s.ajouterBookEmp(B);
          
             afficher();
             s.sendMail();
        
        } catch (ParseException ex) {
            Logger.getLogger(BookempController.class.getName()).log(Level.SEVERE, null, ex);
        }
        afficher();
        }

    private void supprimerBookEmp() {
        BookempService s = new BookempService();
            
            Bookemp B = new Bookemp();
              B.setISBN(this.tfISBN.getText());
              s.supprimerBookEmp(B, this.tfISBN.getText());
              afficher();
    }

    private void modifierBookEmp()  {
        
            BookempService s =new BookempService();
            Bookemp B = new Bookemp();
            
            B.setISBN(tfISBN.getText());
            B.setAuteur(tfauteur.getText());
            B.setTitre(tftitre.getText());
            B.setMarque(tfmarque.getText());
            B.setDescription(tfdesc.getText());
            B.setQuantite(parseInt(this.tfquan.getText()));
            B.setPrix(parseDouble(tfprix.getText()));
            B.setEdition(Date.valueOf(this.tfedi.getText()));
            B.setImage(tfimage.getText());
            s.modifierBookEmp(B,this.tfISBN.getText());   
            this.afficher();
          if(this.idremise.isPressed())
              remise();
    }
    
    
    
     

   

    @FXML
    private void initialiser(ActionEvent event) {
        this.tfISBN.setText("");
        this.tfauteur.setText("");
        this.tftitre.setText("");
        this.tfdesc.setText("");
        this.tfimage.setText("");
        this.tfprix.setText("");
        this.tfquan.setText("");
         this.tfedi.setText("");
          this.tfmarque.setText("");
          this.tfimage.setText("");

    }

  

   
    @FXML
    private void afficherData(javafx.scene.input.MouseEvent event) {
        
        Bookemp B=this.idtableview.getSelectionModel().getSelectedItem();
        if(B!=null)
        {
            this.tfISBN.setText(B.getISBN());
            this.tfauteur.setText(B.getAuteur());
            this.tftitre.setText(B.getTitre());
            this.tfmarque.setText(B.getMarque());
            this.tfdesc.setText(B.getDescription());
            this.tfquan.setText(Integer.toString(B.getQuantite()));
            this.tfprix.setText(Double.toString(B.getPrix()));
            this.tfedi.setText(B.getEdition().toString());
            this.tfimage.setText(B.getImage());
 
        }
    }

  

    @FXML
    private void parcourir(ActionEvent event) throws IOException {
        
       FileChooser fc = new FileChooser();
    File select = fc.showOpenDialog(null);
    if ( select !=null)
    {Bookemp p =new Bookemp();
        String image = select.getAbsolutePath();
        this.tfimage.setText(image);
        System.out.println(image);
    
    
        /* FileChooser.ExtensionFilter typejpg = new FileChooser.ExtensionFilter("JPG filter","*.JPG");
          FileChooser.ExtensionFilter typePNG = new FileChooser.ExtensionFilter("PNG filter","*.PNG");
          fc.getExtensionFilters().addAll(typejpg,typePNG);
          File file = fc.showOpenDialog(null);
          BufferedImage bfimg=ImageIO.read(file);
          conteneurImage.setImage(image);*/
    }
    }
    @FXML
    private void remise() {
        try {
            BookempService s = new BookempService();
            Bookemp B = new Bookemp();
            B.setISBN(this.tfISBN.getText());
            s.remise(Double.parseDouble(this.tfprix.getText()) , B.getISBN());
         
            
            s.sendMail2();
        } catch (Exception ex) {
            Logger.getLogger(BookempController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



   
    

