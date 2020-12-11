/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.service.BookService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GraphController implements Initializable {

    @FXML
    private TextField tfRechercher;
    private PieChart pieChart;
    @FXML
    private Pane Containerr;
    @FXML
    private HBox containersearch;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    } 
 

    @FXML
    private void calcul(MouseEvent event) {
        BookService sp = new BookService();
        String s = this.tfRechercher.getText();
        pieChart=new PieChart();
    pieChart.setData(sp.getSearch(s));
    containersearch.getChildren().add(pieChart);
        
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
    
}
