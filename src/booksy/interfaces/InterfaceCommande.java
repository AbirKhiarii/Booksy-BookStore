/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.interfaces;

import booksy.entities.Commande;
import javafx.collections.ObservableList;

/**
 *
 * @author lenovo
 */
public interface InterfaceCommande {
    public void ajouterCommande(Commande d);
    public ObservableList<Commande> afficher();
    public void supprimerCommande(Commande d);
    public void modifierCommande(Commande d);
}
