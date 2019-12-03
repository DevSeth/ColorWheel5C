package fr.JPG.ColorWheel5C.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;


@Entity(name = "questions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int type;
    private String libelle;
    @OneToMany(mappedBy = "question")                   // Une question a plusieurs propositions. Une proposition n'appartient qu'à une question. Relation One(question) toMany(propositions)
    Collection<Proposition> listePropostions;           // Il existe donc une liste de propositions par Question. Chez les Propositions, on ajoute un objet Question pour mapper dessus, et effectuer la liaison entre la Question et les Propositions.

    public Question() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collection<Proposition> getListePropostions() {
        return listePropostions;
    }

    public void setListePropostions(Collection<Proposition> listePropostions) {
        this.listePropostions = listePropostions;
    }
}
