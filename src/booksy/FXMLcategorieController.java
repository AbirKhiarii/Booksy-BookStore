/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.Categorie;
import booksy.service.ServiceCategorie;
import static java.lang.Integer.parseInt;
import java.net.URL;
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

/**
 *
 * @author user
 */
public class FXMLcategorieController implements Initializable {
    
      @FXML
    private Label label;
    @FXML
    private TableView<Categorie> tvCategories;
    @FXML
    private TableColumn< Categorie, Integer> colcode;
    @FXML
    private TableColumn<Categorie, String> colNom;
    @FXML
    private TableColumn<Categorie, String> colFamille;
    @FXML
    private TextField tfCode_categorie;
    @FXML
    private TextField tfNom_categorie;
    @FXML
    private TextField tfFamille;
    @FXML
    private Button btnAjouterCategorie;
    @FXML
    private Button btnmodifierCategorie;
    @FXML
    private Button btnSupprimerCategorie;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCat();
        
    }    
  
    @FXML
    private void AjouterCategorie(ActionEvent event) {
        ServiceCategorie s = new ServiceCategorie();
        Categorie c = new Categorie();  
        //c.setCode_categorie ( parseInt(tfCode_categorie.getText()));
        c.setNom_Categorie(tfNom_categorie.getText());
        c.setFamille(tfFamille.getText());
        s. AjouterCategorie(c);
         showCat();
        
}



    @FXML
    private void SupprimerCategorie(ActionEvent event) {
        ServiceCategorie s = new ServiceCategorie();
      Categorie c = new Categorie(); 
       s.SupprimerCategorie(parseInt(tfCode_categorie.getText()));
       showCat();
      
        
    }

    @FXML
    private void modifierCategorie(ActionEvent event) {
          ServiceCategorie s = new ServiceCategorie();
      Categorie c = new Categorie(); 
      c.setCode_categorie(parseInt(tfCode_categorie.getText()));
        c.setNom_Categorie(tfNom_categorie.getText());
        c.setFamille(tfFamille.getText());
        s.modifierCategorie(c);
        showCat();
    }


  public void showCat()
  {
       ServiceCategorie s = new ServiceCategorie();
       ObservableList<Categorie> l=s.AfficherCategorie();
      this.colcode.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("Code_categorie"));
      this.colNom.setCellValueFactory(new PropertyValueFactory<Categorie, String>("Nom_Categorie"));
      this.colFamille.setCellValueFactory(new PropertyValueFactory<Categorie, String>("Famille"));
      this.tvCategories.setItems(l);
  }
    
}
