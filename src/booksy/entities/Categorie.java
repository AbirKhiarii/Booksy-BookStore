/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.entities;

/**
 *
 * @author oumayma
 */
public class Categorie {
    private int Code_categorie;
    private String Nom_Categorie;
    private String Famille;

    public Categorie() {
    }
    

    public Categorie( int Code_categorie, String Nom_Categorie,String Famille) {
       this.Code_categorie=Code_categorie;
       this.Nom_Categorie= Nom_Categorie;
       this.Famille=Famille;
    }

    public int getCode_categorie() {
        return Code_categorie ;
    }

    public String getNom_Categorie() {
        return Nom_Categorie;
    }

    public String getFamille() {
        return Famille;
    }
    

    public void setCode_categorie(int Code_categorie) {
        this.Code_categorie = Code_categorie;
    }

    public void setNom_Categorie(String Nom_Categorie) {
        this.Nom_Categorie = Nom_Categorie;
    }

    public void setFamille(String Famille) {
        this.Famille = Famille;
    }

    @Override
    public String toString() {
        return "Categorie{" + "Code_categorie=" + Code_categorie + ", Nom_Categorie=" + Nom_Categorie + ", Famille=" + Famille + '}';
    }

    
    
}
