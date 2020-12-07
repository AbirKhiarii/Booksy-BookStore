/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.service.LAVService;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
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
import javafx.scene.input.MouseEvent;
import booksy.entities.livreAVendre;
import booksy.utils.MyConnexion;




/**
 *
 * @author user
 */
public class FXMLDocumentController_LAV implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TableView<livreAVendre> tbLivresAVendre;
    @FXML
    private TableColumn<livreAVendre, Integer> ColISBN;
    @FXML
    private TableColumn<livreAVendre, String> ColTitre;
    @FXML
    private TableColumn<livreAVendre, String> ColAuteur;
    @FXML
    private TableColumn<livreAVendre, String> ColDesc;
    @FXML
    private TableColumn<livreAVendre, Date> ColEdition;
    @FXML
    private TableColumn<livreAVendre, Double> ColPrix;
    @FXML
    private TableColumn<livreAVendre, Integer> ColQuantite;
    @FXML
    private TableColumn<livreAVendre, String> ColImage;
    @FXML
    private TableColumn<livreAVendre, String> ColMarque;
    @FXML
    private TableColumn<livreAVendre, String> ColEtat;
    @FXML
    private TextField tfISBN;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfAuteur;
    @FXML
    private TextField tfDesc;
    @FXML
    private TextField tfEdition;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfQuantite;
    @FXML
    private TextField tfImage;
    @FXML
    private TextField tfMarque;
    @FXML
    private TextField tfEtat;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
     if(event.getSource() == this.btnAjouter)
        {
            addBooks();
        }
     else if(event.getSource() == this.btnModifier)
     {
         
         updateBooks();
     }
      else if(event.getSource() == this.btnSupprimer)
     {
         deleteBook();
     }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBooks();
    }    
     public void showBooks()
    {
        LAVService s=new LAVService();
        ObservableList<livreAVendre> l=s.afficher();
       this.ColISBN.setCellValueFactory(new PropertyValueFactory<livreAVendre, Integer>("ISBN"));
       this.ColTitre.setCellValueFactory(new PropertyValueFactory<livreAVendre, String>("titre"));
       this.ColAuteur.setCellValueFactory(new PropertyValueFactory<livreAVendre, String>("Auteur"));
       this.ColDesc.setCellValueFactory(new PropertyValueFactory<livreAVendre, String>("description"));
       this.ColEdition.setCellValueFactory(new PropertyValueFactory<livreAVendre, Date>("edition"));
       this.ColPrix.setCellValueFactory(new PropertyValueFactory<livreAVendre, Double>("prix"));
       this.ColQuantite.setCellValueFactory(new PropertyValueFactory<livreAVendre, Integer>("quantite"));
       this.ColImage.setCellValueFactory(new PropertyValueFactory<livreAVendre, String>("image"));
       this.ColMarque.setCellValueFactory(new PropertyValueFactory<livreAVendre, String>("marque"));
       this.ColEtat.setCellValueFactory(new PropertyValueFactory<livreAVendre, String>("etat"));
       
       this.tbLivresAVendre.setItems(l);
              
    }
        public void addBooks()
    {
          LAVService s = new LAVService();
        livreAVendre lav = new livreAVendre();
        lav.setISBN(this.tfISBN.getText());
        lav.setTitre(this.tfTitre.getText());
        lav.setAuteur(this.tfAuteur.getText());
        lav.setDescription(this.tfDesc.getText());
        lav.setEdition(Date.valueOf( this.tfEdition.getText()));
        lav.setPrix(Double.parseDouble(this.tfPrix.getText()));
        lav.setQuantite(parseInt(this.tfQuantite.getText()));
        lav.setImage(this.tfImage.getText());
        lav.setMarque(this.tfMarque.getText());
        lav.setEtat(this.tfEtat.getText());
        s.ajouterLAV(lav);
        showBooks();
    }
        
        public void updateBooks()
        {
            LAVService s = new LAVService();
         livreAVendre lav = new livreAVendre();
          lav.setISBN(this.tfISBN.getText());
        lav.setTitre(this.tfTitre.getText());
        lav.setAuteur(this.tfAuteur.getText());
        lav.setDescription(this.tfDesc.getText());
        lav.setEdition(Date.valueOf( this.tfEdition.getText()));
        lav.setPrix(Double.parseDouble(this.tfPrix.getText()));
        lav.setQuantite(parseInt(this.tfQuantite.getText()));
        lav.setImage(this.tfImage.getText());
        lav.setMarque(this.tfMarque.getText());
        lav.setEtat(this.tfEtat.getText());
         s.modifierLAV(lav,this.tfISBN.getText() );
         showBooks();
        }
        
         public void deleteBook()
    {
          LAVService s = new LAVService();
          s.supprimerLAV(this.tfISBN.getText());
          showBooks();
        
    }

    @FXML
    private void displayData(MouseEvent event) {
          livreAVendre lv=this.tbLivresAVendre.getSelectionModel().getSelectedItem();
        if(lv!=null)
        {
            this.tfISBN.setText(lv.getISBN());
            this.tfTitre.setText(lv.getTitre());
            this.tfAuteur.setText(lv.getAuteur());
            this.tfDesc.setText(lv.getDescription());
            this.tfEdition.setText(lv.getEdition().toString());
            this.tfPrix.setText(Double.toString(lv.getPrix()));
            this.tfQuantite.setText(Integer.toString(lv.getQuantite()));
                       this.tfImage.setText(lv.getImage());
                       this.tfMarque.setText(lv.getMarque());
                       this.tfEtat.setText(lv.getEtat());



            

        }
    }
    
}
