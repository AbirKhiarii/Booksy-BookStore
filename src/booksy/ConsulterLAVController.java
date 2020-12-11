/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.livreAVendre;
import booksy.service.LAVService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ConsulterLAVController implements Initializable {

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
    private TextField tfDeviseE;
    @FXML
    private ComboBox<String> cmbDevise;
    
                ObservableList<String> l= FXCollections.observableArrayList("EUR","USD","CAD","CHF","GBP","SEK");
    @FXML
    private TextField tfDeviseS;
    @FXML
    private Button btnPayement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
showBooks();
  this.cmbDevise.setItems(l);
        this.cmbDevise.setValue("EUR");
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

    @FXML
    private void displayData(MouseEvent event) {
          livreAVendre lv=this.tbLivresAVendre.getSelectionModel().getSelectedItem();
        if(lv!=null)
        {
            
this.tfDeviseE.setText(Double.toString(lv.getPrix())); 

        }
    }

    @FXML
    private void Conversion(ActionEvent event) {
                 
             Double x =0d;
        try{
             x =Double.parseDouble(this.tfDeviseE.getText())/3.27986;
              LAVService s = new LAVService();
                if(this.cmbDevise.getValue()=="EUR")
                {
                     double a=Math.round(x * 100);
                x = a/100;
            this.tfDeviseS.setText(x.toString());
                }
            String result=s.convert(x, this.cmbDevise.getValue());
              this.tfDeviseS.setText(result);
        }catch(Exception e)
        {
            System.out.println(e);
        }finally{
         
        }
      
    }

    @FXML
    private void Payement(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Payement.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
    }
    
}
