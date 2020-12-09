/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class AuthentificationController implements Initializable {

    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmot;
    @FXML
    private Button btna;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inscrire(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("inscription.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
    }

    @FXML
    private void initialiser(ActionEvent event) {
         
        this.tfemail.setText("");
        this.tfmot.setText("");
       
    }
    
}
