/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksy.entities;

/**
 *
 * @author Hamza
 */
public class personne {
    private int id;
    private String nom;
    private String prenom;
    private String sex;
    private String email;
    private String motdepasse;
    private int numero;
    

    public personne() {}

    public personne(int id, String nom, String prenom, String sex, String email, String motdepasse, int numero) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sex = sex;
        this.email = email;
        this.motdepasse = motdepasse;
        this.numero = numero;
    }

    public personne(String nom, String prenom, String sex, String email, String motdepasse, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.sex = sex;
        this.email = email;
        this.motdepasse = motdepasse;
        this.numero = numero;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sex=" + sex + ", email=" + email + ", motdepasse=" + motdepasse + ", numero=" + numero + '}';
    }
    
    

}
