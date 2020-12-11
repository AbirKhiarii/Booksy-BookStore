/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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

    @FXML
    private void login(ActionEvent event) throws IOException {
           if(tfemail.equals("") && tfmot.equals("")){
        JOptionPane.showMessageDialog(null, "aaaaaa");
        }else{
         try {
             //s.log(tfemail.getText(), tfmot.getText());
             MyConnexion cnx ;
             cnx = MyConnexion.getInstance();
             java.sql.PreparedStatement ps=cnx.getConnection().prepareStatement("select * from per where email=? and motdepasse=?");
         
             ps.setString(1, tfemail.getText());
             ps.setString(2, tfmot.getText());
             ResultSet rs= ps.executeQuery();
             
             if(rs.next()){
               try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLBook.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBook.class.getName()).log(Level.SEVERE, null, ex);
        }
            /*FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLBook.fxml"));
             Parent root1=(Parent) loader.load();
            MenuController m= loader.getController();
            m.sett(tfemail.getText());
            System.out.println(tfemail.getText());
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();*/
    
             }else{
             JOptionPane.showMessageDialog(null, "email ou mot de passe invalide");
             }
             
         } catch (SQLException ex) {
             //Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             
         }
     
        }
    }

    @FXML
    private void inscrir(ActionEvent event) throws IOException {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("inscription.fxml"));
             Parent root1=(Parent) loader.load();
             
             
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
    }

    
}
