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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Booksy extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument_LAV.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws StripeException  {
       launch(args);
        //System.out.println("hellooooooooooo");

      /*  Stripe.apiKey="sk_test_51HwAVkJlvQg8WkmgXNnqAn38uIH3YNV4Md1TpBIvWDZXX08jKCcHEOqYXVstSpHXqeElp3yKuOUzz1ukwocsXsHB00ePCvntrj";
     //create user
         Map<String, Object> customerParameter= new HashMap<String, Object>();
        customerParameter.put("email", "a@gmail.com");
        Customer c =Customer.create(customerParameter);
        System.out.println(c.getId());
     Customer a =Customer.retrieve("cus_IXcJ2viPwASdjZ");
        System.out.println(a);
                    
       //ajouter card a l'utilisateur
         Map<String, Object> cardParam= new HashMap<String, Object>();
        cardParam.put("number", "4242424242424242");
        cardParam.put("exp_month", "11");
        cardParam.put("exp_year", "2022");
        cardParam.put("cvc", "123");
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
        chargeParam.put("amount", "50");
        chargeParam.put("currency", "usd");
        chargeParam.put("customer", a.getId());
        Charge.create(chargeParam);
     Gson gson= new GsonBuilder().setPrettyPrinting().create();
                    System.out.println(gson.toJson(a));*/

        
    }
    
}
