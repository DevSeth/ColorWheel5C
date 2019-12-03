package fr.JPG.ColorWheel5C.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "proposition")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Proposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Proposition;
    @ManyToOne
    private Question question;              // Instance de Questions pour permettre le mapping de l'entité Question sur l'entité Proposition

    public Proposition() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProposition() {
        return Proposition;
    }

    public void setProposition(String proposition) {
        Proposition = proposition;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
