/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.entities;


import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author uuuu
 */
public class Bookemp {
    private String ISBN ;
    private String auteur , titre , marque , image , description ;
    private Date edition;
    private Date datedebut;
    private Date datefin;
    private double prix ;
    private int quantite ;

    public Bookemp() {
    }

 
    public Bookemp(String ISBN, String auteur, String titre, String marque, String image, String description, Double prix, int quantite , Date edition) {
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.titre = titre;
        this.marque = marque;
        this.image = image;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.edition = edition;
    }

   

    
    
    

    public String getISBN() {
        return ISBN;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getMarque() {
        return marque;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public Date getEdition() {
        return edition;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public double getPrix() {
        return prix;
    }

   
    public int getQuantite() {
        return quantite;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEdition(Date edition) {
        this.edition = edition;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.ISBN);
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
        final Bookemp other = (Bookemp) obj;
        if (this.ISBN != other.ISBN) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bookemp{" + "ISBN=" + ISBN + ", auteur=" + auteur + ", titre=" + titre + ", marque=" + marque + ", image=" + image + ", description=" + description + ", edition=" + edition + ", datedebut=" + datedebut + ", datefin=" + datefin + ", prix=" + prix + ", quantite=" + quantite + '}';
    }
    
    
    
}
