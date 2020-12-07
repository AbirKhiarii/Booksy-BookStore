/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.entities;

import booksy.entities.Commande;
import booksy.service.ServiceCommande;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.xml.bind.DatatypeConverter.parseDate;

/**
 *
 * @author lenovo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Commande d;
        try {
            d = new Commande(1,new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-16"),"aaa","bbbb");
        Commande d1=new Commande(23,new SimpleDateFormat("yyyy-MM-dd").parse("1997-05-16"),"ghada","loukil");
        ServiceCommande ds=new ServiceCommande();
        ds.ajouterCommande(d);
        ds.ajouterCommande(d1);
        ds.afficher();
        //ds.supprimerCommande(d);
        //d1.setModepaiement("Meleeek");
        //d1.setId(60);
        //ds.modifierCommande(d1);
        ds.afficher();
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
