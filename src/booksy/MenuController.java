/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.personne;
import booksy.service.servicepersonne;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class MenuController implements Initializable {

    @FXML
    private TableColumn<personne, Integer> id;
    @FXML
    private TableColumn<personne, String> nom;
    @FXML
    private TableColumn<personne, String> prenom;
    @FXML
    private TableColumn<personne, String> sexe;
    @FXML
    private TableColumn<personne, String> email;
    @FXML
    private TableColumn<personne, String> mdp;
    @FXML
    private TableColumn<personne, Integer> telephone;
    @FXML
    private Button btnm;
    @FXML
    private Button btns;
    @FXML
    private TableView<personne> table;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfsexe;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmot;
    @FXML
    private TextField tfnumero;
    @FXML
    private Label l;
    @FXML
    private Button bts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showpersonne();
       
    } 
    public void sett(String text){
    this.l.setText(text);
     servicepersonne s= new servicepersonne();
 ObservableList<personne> a = s.affiche(l.getText());
         //System.out.println(l.getText());
       this.id.setCellValueFactory(new PropertyValueFactory<personne,Integer>("id"));
       this.nom.setCellValueFactory(new PropertyValueFactory<personne,String>("nom"));
       this.prenom.setCellValueFactory(new PropertyValueFactory<personne,String>("prenom"));
       this.sexe.setCellValueFactory(new PropertyValueFactory<personne,String>("sex"));
       this.email.setCellValueFactory(new PropertyValueFactory<personne,String>("email"));
       this.mdp.setCellValueFactory(new PropertyValueFactory<personne,String>("motdepasse"));
       this.telephone.setCellValueFactory(new PropertyValueFactory<personne,Integer>("numero"));
       this.table.setItems(a);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
 servicepersonne s=new servicepersonne();  
        if(event.getSource()==btnm){
         personne p=new personne();
         p.setId(parseInt(tfid.getText()));
         p.setNom(tfnom.getText());
        p.setPrenom(tfprenom.getText());
        p.setSex(tfsexe.getText());
        p.setEmail(tfemail.getText());
        p.setMotdepasse(tfmot.getText());
        p.setNumero(parseInt(tfnumero.getText()));
        s.modifierPersonne(p);
        showpersonne();
        s.sendMail();
        }else if(event.getSource()==btns){
         personne p=new personne();
          int id= (parseInt(tfid.getText()));
           
        s.supprimerPersonne(id);
        showpersonne();
        }

//AuthentificationController c=new AuthentificationController();
   
    
    }
    
     public void showpersonne(){

       servicepersonne s= new servicepersonne();
 ObservableList<personne> a = s.affiche(l.getText());
         //System.out.println(l.getText());
       this.id.setCellValueFactory(new PropertyValueFactory<personne,Integer>("id"));
       this.nom.setCellValueFactory(new PropertyValueFactory<personne,String>("nom"));
       this.prenom.setCellValueFactory(new PropertyValueFactory<personne,String>("prenom"));
       this.sexe.setCellValueFactory(new PropertyValueFactory<personne,String>("sex"));
       this.email.setCellValueFactory(new PropertyValueFactory<personne,String>("email"));
       this.mdp.setCellValueFactory(new PropertyValueFactory<personne,String>("motdepasse"));
      // this.telephone.setCellValueFactory(new PropertyValueFactory<personne,Integer>("numero"));
       this.telephone.setCellValueFactory(new PropertyValueFactory<personne,Integer>("numero"));
      this.table.setItems(a);
  }

    @FXML
    private void displayData(MouseEvent event) {
        
        personne p =this.table.getSelectionModel().getSelectedItem();
        if(p!=null)
        {
            this.tfid.setText(Integer.toString(p.getId()));
            this.tfnom.setText(p.getNom());
            this.tfprenom.setText(p.getPrenom());
            this.tfsexe.setText(p.getSex());
            this.tfemail.setText(p.getEmail());
            this.tfmot.setText(p.getMotdepasse());
            this.tfnumero.setText(Integer.toString(p.getNumero()));
            
        }
        
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("authentification.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
    }
    
}
