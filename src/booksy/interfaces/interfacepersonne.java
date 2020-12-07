/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.interfaces;

import booksy.entities.personne;

/**
 *
 * @author Hamza
 */
public interface interfacepersonne {
    public void ajouterPersonne(personne p);
    public void supprimerPersonne(int id);
   public void modifierPersonne(personne p);
    //public  ObservableList<personne> afficher();
}
