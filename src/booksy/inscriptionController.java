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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class inscriptionController implements Initializable {
    
    private Label label;
    @FXML
    private Button btna;
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
    private Button btn;
    
    private void handleButtonAction(ActionEvent event) {
        servicepersonne s=new servicepersonne();
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void initialiser(ActionEvent event) {
        this.tfnom.setText("");
        this.tfprenom.setText("");
        this.tfsexe.setText("");
        this.tfemail.setText("");
        this.tfmot.setText("");
        this.tfnumero.setText("");
    }

    @FXML
    private void Ajout(ActionEvent event) throws IOException {
        servicepersonne s=new servicepersonne();
        personne p=new personne();
        p.setNom(tfnom.getText());
        p.setPrenom(tfprenom.getText());
        p.setSex(tfsexe.getText());
        p.setEmail(tfemail.getText());
        p.setMotdepasse(tfmot.getText());
        p.setNumero(parseInt(tfnumero.getText()));
        s.ajouterPersonne(p);
         FXMLLoader loader=new FXMLLoader(getClass().getResource("authentification.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
        
    }
    
}

