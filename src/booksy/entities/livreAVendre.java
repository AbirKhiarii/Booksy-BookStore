/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.entities;

import java.sql.Date;

/**
 *
 * @author user
 */
public class livreAVendre {

    
   private String ISBN;
   private String titre;
   private String auteur;
   private String description;
   private Date edition;
   private double prix;
   private int quantite;
   private String image;
   private String marque;
   private String etat;

    public livreAVendre() {
    }

    public livreAVendre(String ISBN, String titre, String auteur, String description, Date edition, double prix, int quantite, String image, String marque, String etat) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.edition = edition;
        this.prix = prix;
        this.quantite = quantite;
        this.image = image;
        this.marque = marque;
        this.etat = etat;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEdition() {
        return edition;
    }

    public void setEdition(Date edition) {
        this.edition = edition;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "livreAVendre{" + "ISBN=" + ISBN + ", titre=" + titre + ", auteur=" + auteur + ", description=" + description + ", edition=" + edition + ", prix=" + prix + ", quantite=" + quantite + ", image=" + image + ", marque=" + marque + ", etat=" + etat + '}';
    }
   
   
   
    
}

