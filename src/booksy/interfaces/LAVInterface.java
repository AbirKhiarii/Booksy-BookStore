/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.interfaces;

import booksy.entities.livreAVendre;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public interface LAVInterface {
    
    public void ajouterLAV(livreAVendre lav);
    public void supprimerLAV(String ISBN);
    public void modifierLAV(livreAVendre lav, String ISBN);
    public ObservableList<livreAVendre> afficher();
    
}
