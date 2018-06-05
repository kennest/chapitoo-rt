package com.capsule.chapitoolab.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "agences")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titre;
    private String numero;
    private String code;
    private String email;
    private String password;

    @OneToOne(mappedBy = "agence",fetch = FetchType.EAGER,targetEntity = User.class)
    private User user;

    @OneToMany(fetch = FetchType.EAGER,targetEntity = Logement.class,mappedBy = "agence")
    private Set<Logement> logements;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Locataire> abonnes;

    //GETTERS SETTERS


    public Set<Logement> getLogements() {
        return logements;
    }

    public void setLogements(Set<Logement> logements) {
        this.logements = logements;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Locataire> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Set<Locataire> abonnes) {
        this.abonnes = abonnes;
    }
}
