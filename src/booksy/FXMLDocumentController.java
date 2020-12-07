/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.Commande;
import booksy.service.ServiceCommande;
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

/**
 *
 * @author lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button buttonAfficher;
    private Label labelAfficher;
    @FXML
    private TextField tfnumCommande;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfModePaiement;
    @FXML
    private TextField tfStatut;
    @FXML
    private TableView<Commande> table;
    @FXML
    private TableColumn<Commande, Integer> numCommandes;
    @FXML
    private TableColumn<Commande, Date> dates;
    @FXML
    private TableColumn<Commande, String> modePaiement;
    @FXML
    private TableColumn<Commande, String> statut;
    @FXML
    private Button bmodifier;
    @FXML
    private Button bsupprimer;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        affiche();
    }    

    @FXML
    private void ajouterCommande(ActionEvent event) {
        try {
            ServiceCommande sp=new ServiceCommande();
            Commande d=new Commande();
            d.setModepaiement(tfModePaiement.getText());
            d.setNumCommande(Integer.parseInt(tfnumCommande.getText()));
            d.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tfDate.getText()));
            d.setStatut(tfStatut.getText());
            sp.ajouterCommande(d);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @FXML
    private void affiche() {
       //System.out.println("dkubn");
       ServiceCommande sp=new ServiceCommande();
       //labelAfficher.setText(sp.afficher());
       ObservableList<Commande> l=sp.afficher();
       this.numCommandes.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("numCommande"));
       this.dates.setCellValueFactory(new PropertyValueFactory<Commande,Date>("date"));
       this.modePaiement.setCellValueFactory(new PropertyValueFactory<Commande,String>("modepaiement"));
       this.statut.setCellValueFactory(new PropertyValueFactory<Commande,String>("statut"));
       
       this.table.setItems(l);
    }
    

    @FXML
    private void supprimer(ActionEvent event) {
        try {
            ServiceCommande sp=new ServiceCommande();
            Commande d=new Commande();
            d.setModepaiement(tfModePaiement.getText());
            d.setNumCommande(Integer.parseInt(tfnumCommande.getText()));
            d.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tfDate.getText()));
            d.setStatut(tfStatut.getText());
            sp.supprimerCommande(d);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        try {
            ServiceCommande sp=new ServiceCommande();
            Commande d=new Commande();
            d.setModepaiement(tfModePaiement.getText());
            d.setNumCommande(Integer.parseInt(tfnumCommande.getText()));
            d.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tfDate.getText()));
            d.setStatut(tfStatut.getText());
            sp.modifierCommande(d);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
