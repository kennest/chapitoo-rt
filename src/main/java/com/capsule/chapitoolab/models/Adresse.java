package com.capsule.chapitoolab.models;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public  class Adresse  implements Serializable {

    @Column(length=40)
    private String rue ;

    private Point geocoordonnees;

    @ManyToOne()
    private Commune commune ;

    // GETTERS SETTERS

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Point getGeocoordonnees() {
        return geocoordonnees;
    }

    public void setGeocoordonnees(Point geocoordonnees) {
        this.geocoordonnees = geocoordonnees;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
}