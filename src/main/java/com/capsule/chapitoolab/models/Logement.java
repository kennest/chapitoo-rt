package com.capsule.chapitoolab.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "logements")
public class Logement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer nombrePieces;
    private Float superficie;
    private Integer niveau;

    @OneToMany(fetch = FetchType.EAGER,targetEntity = Picture.class)
    private Set<Picture> images;

    @OneToOne(fetch = FetchType.EAGER,targetEntity = Video.class)
    private Video video;

    @ManyToOne(targetEntity = Agence.class,fetch = FetchType.EAGER)
    private Agence agence;

    @Embedded
    private Adresse adresse;

    //GETTERS SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Integer getNombrePieces() {
        return nombrePieces;
    }

    public void setNombrePieces(Integer nombrePieces) {
        this.nombrePieces = nombrePieces;
    }

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Set<Picture> getImages() {
        return images;
    }

    public void setImages(Set<Picture> images) {
        this.images = images;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
