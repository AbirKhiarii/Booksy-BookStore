/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.interfaces;

import booksy.entities.Bookemp;
import java.util.List;

/**
 *
 * @author uuuu
 */
public interface InterfaceBookempService {
         public void ajouterBookEmp(Bookemp B);
      public void modifierBookEmp(Bookemp B, String ISBN);
      public void supprimerBookEmp(Bookemp B, String ISBN);
      public List<Bookemp> afficherBookEmp();
}
