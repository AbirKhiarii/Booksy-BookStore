/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import booksy.entities.Commande;
import booksy.service.ServiceCommande;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
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
import javafx.scene.input.MouseEvent;

/**
 *
 * @author lenovo
 */
public class OrderController implements Initializable {
    private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    
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
    @FXML
    private Button bImprimer;
    
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
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void displayData(MouseEvent event) {
        Commande lv=this.table.getSelectionModel().getSelectedItem();
        if(lv!=null)
        {
            this.tfnumCommande.setText(Integer.toString(lv.getNumCommande()));
            this.tfDate.setText(lv.getDate().toString());
            this.tfModePaiement.setText(lv.getModepaiement());
            this.tfStatut.setText(lv.getStatut());


        }
    }

    @FXML
    private void genererFacture(ActionEvent event) {
        Document document = new Document(PageSize.A4);
        String value1=tfnumCommande.getText();
        String value2=tfDate.getText();
        String value3=tfModePaiement.getText();
        
        PdfPTable table = new PdfPTable(3);
        
        try {
        PdfWriter.getInstance(document, new FileOutputStream("Facture.pdf"));
        document.open();
        Paragraph para= new Paragraph("Facture de commande",catFont);
        para.setAlignment(Element.ALIGN_RIGHT);
        addEmptyLine(para, 2);
        document.add(para);
        
        para=new Paragraph("BookStore", catFont);
        para.setAlignment(Element.ALIGN_LEFT);
        addEmptyLine(para, 2);
        document.add(para);
        
        para=new Paragraph("Esprit Charguia");
        para.setAlignment(Element.ALIGN_LEFT);
        addEmptyLine(para, 2);
        document.add(para);
        
        para=new Paragraph("Mme/Mr XXXXXX XXXXXX");
        para.setAlignment(Element.ALIGN_RIGHT);
        addEmptyLine(para, 5);
        document.add(para);
        
        PdfPCell c1 = new PdfPCell(new Phrase("Numero de commande"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Date du commande"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Mode de paiement "));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell(value1);
        table.addCell(value2);
        table.addCell(value3);
        table.addCell("");
        table.addCell("");
        table.addCell("");
        addEmptyLine(para, 5);
        document.add(table);
        addEmptyLine(para, 5);

        
        para=new Paragraph("Facture en dinars tunisien");
        para.setAlignment(Element.ALIGN_CENTER);
        document.add(para);
        
        para=new Paragraph("Total TTC       500,55");
        para.setAlignment(Element.ALIGN_RIGHT);
        document.add(para);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
        
    }
     private static void addEmptyLine(Paragraph para, int number) {
        for (int i = 0; i < number; i++) {
            para.add(new Paragraph(" "));
        }
     }
    

    
}
