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
public class Book {
    private String ISBN;
    private String titre;
    private String auteur;
    private String description;
    private Date edition ;
    private double prix;
    private int quantite ;
    private String image;
    private String marque ;
    private String versionpdf;
    private String podcast ;
    private int categorie;

    public Book(String ISBN, String titre, String auteur, String description, Date edition, double prix, int quantite, String image, String marque, String podcast,int categorie) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.edition = edition;
        this.prix = prix;
        this.quantite = quantite;
        this.image = image;
        this.marque = marque;
        this.podcast = podcast;
        this.categorie=categorie;
    }

    public Book(){}

    

    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getImage() {
        return image;
    }

    public String getMarque() {
        return marque;
    }

    public String getVersionpdf() {
        return versionpdf;
    }

    public String getPodcast() {
        return podcast;
    }

    public int getCategorie() {
        return categorie;
    }
     

    public String getISBN() {
        return ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public Date getEdition() {
        return edition;
    }

   

    public double getPrix() {
        return prix;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setVersionpdf(String versionpdf) {
        this.versionpdf = versionpdf;
    }

    public void setPodcast(String podcast) {
        this.podcast = podcast;
    }

   
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setEdition(Date edition) {
        this.edition = edition;
    }

 

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Book{" + "ISBN=" + ISBN + ", titre=" + titre + ", auteur=" + auteur + ", description=" + description + ", edition=" + edition + ", prix=" + prix + ", quantite=" + quantite + ", image=" + image + ", marque=" + marque + ", versionpdf=" + versionpdf + ", podcast=" + podcast + ", categorie=" + categorie + '}';
    }

  

}
