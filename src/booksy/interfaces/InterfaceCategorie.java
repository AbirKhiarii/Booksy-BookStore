/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.interfaces;

import booksy.entities.Categorie;
import javafx.collections.ObservableList;

/**
 *
 * @author oumayma
 */
public interface InterfaceCategorie {
    public void AjouterCategorie(Categorie c);
   public ObservableList<Categorie> AfficherCategorie();
   public void modifierCategorie(Categorie c);
   public void SupprimerCategorie(int c);
    
}
