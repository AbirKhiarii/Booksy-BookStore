/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lenovo
 */
public class Commande {
    protected int id;
    protected int numCommande;
    protected Date date;
    protected String modepaiement;
    protected String statut;
    
    

    public Commande() {
    }

    public Commande( int numCommande, Date date, String modepaiement, String statut) {
        this.numCommande = numCommande;
        this.date = date;
        this.modepaiement = modepaiement;
        this.statut = statut;
    }

    

    public String getModepaiement() {
        return modepaiement;
    }

    public void setModepaiement(String modepaiement) {
        this.modepaiement = modepaiement;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.numCommande;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numCommande != other.numCommande) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", date=" + date + ", statut=" + statut + ", numCommande=" + numCommande + ", modepaiement=" + modepaiement + '}';
    }

    
    
    
    
}
