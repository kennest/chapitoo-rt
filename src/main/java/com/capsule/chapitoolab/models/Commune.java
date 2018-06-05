package com.capsule.chapitoolab.models;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "communes")
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;

    private Point geocoordonnees;

    @OneToMany()
    private Set<Locataire> locataires;
    //GETTERS SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Point getGeocoordonnees() {
        return geocoordonnees;
    }

    public void setGeocoordonnees(Point geocoordonnees) {
        this.geocoordonnees = geocoordonnees;
    }

}
