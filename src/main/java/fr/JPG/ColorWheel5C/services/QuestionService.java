package fr.JPG.ColorWheel5C.services;

import fr.JPG.ColorWheel5C.models.Question;

import java.util.Collection;

public interface QuestionService {

    public abstract void addQuestion(Question question);
    public abstract Collection<Question> getQuestions();
}
