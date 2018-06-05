package com.capsule.chapitoolab.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locataires")
public class Locataire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String prenom;
    private Integer age;
    private String sexe;
    private String numero;
    private String photo;

    @ManyToMany(mappedBy = "abonnes",fetch = FetchType.LAZY)
    private Set<Agence> favoris;

    @Embedded
    private Adresse adresse;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "interesses")
    private Set<Logement> panier;
    //GETTERS SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<Agence> getFavoris() {
        return favoris;
    }

    public void setFavoris(Set<Agence> favoris) {
        this.favoris = favoris;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Logement> getPanier() {
        return panier;
    }

    public void setPanier(Set<Logement> panier) {
        this.panier = panier;
    }
}
