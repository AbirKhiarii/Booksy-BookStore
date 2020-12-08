/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.interfaces;

import booksy.entities.Book;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public interface InterfaceBookService {
public void ajouterLivre (Book p);
public void supprimerLivre(String p);
public ObservableList<Book> afficherLivre();
}
