/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.stripe.param.CustomerRetrieveParams;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PayementController implements Initializable {

    @FXML
    private TextField tfNumCarte;
    @FXML
    private TextField tfExpDate;
    @FXML
    private TextField tfExpYear;
    @FXML
    private TextField tfCvc;
    @FXML
    private Button btnPayer;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfSomme;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void payer(ActionEvent event) throws StripeException {
        
        
    Stripe.apiKey="sk_test_51HwAVkJlvQg8WkmgXNnqAn38uIH3YNV4Md1TpBIvWDZXX08jKCcHEOqYXVstSpHXqeElp3yKuOUzz1ukwocsXsHB00ePCvntrj";
     //create user
         Map<String, Object> customerParameter= new HashMap<String, Object>();
        customerParameter.put("email", this.tfmail.getText());
        Customer c =Customer.create(customerParameter);
        System.out.println(c.getId());
     Customer a =Customer.retrieve(c.getId());
        System.out.println(a);
                    
       //ajouter card a l'utilisateur
         Map<String, Object> cardParam= new HashMap<String, Object>();
        cardParam.put("number", this.tfNumCarte.getText());
        cardParam.put("exp_month", this.tfExpDate.getText());
        cardParam.put("exp_year", this.tfExpYear.getText());
        cardParam.put("cvc", this.tfCvc.getText());
              Map<String, Object> tokenParam= new HashMap<String, Object>();
              tokenParam.put("card", cardParam);
              Token token=Token.create(tokenParam);
        Map<String, Object> source= new HashMap<String, Object>();
        source.put("source", token.getId());
        CustomerRetrieveParams params = CustomerRetrieveParams.builder().addExpand("sources").build();
        a = Customer.retrieve(a.getId(), params, null);
      a.getSources().create(source);
       
       //Charge Customer
       Map<String, Object> chargeParam= new HashMap<String, Object>();
        chargeParam.put("amount", this.tfSomme.getText());
        chargeParam.put("currency", "usd");
        chargeParam.put("customer", a.getId());
        Charge.create(chargeParam);
     Gson gson= new GsonBuilder().setPrettyPrinting().create();
                    System.out.println(gson.toJson(a));
                    

        JOptionPane.showMessageDialog(null, "Payement avec succés");

        
    }
    
    
    
}
