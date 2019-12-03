package fr.JPG.ColorWheel5C.services;

import fr.JPG.ColorWheel5C.models.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

    // Stockage des Questions : un id en String et une Question Object
    private Map<String,Question> questionRepo = new HashMap<String,Question>();

    @Override
    public void addQuestion(Question question) {
        int nbElts = questionRepo.size();
        questionRepo.put(String.valueOf(nbElts+1),question);
    }

    @Override
    public Collection<Question> getQuestions() {
        return questionRepo.values();
    }
}
