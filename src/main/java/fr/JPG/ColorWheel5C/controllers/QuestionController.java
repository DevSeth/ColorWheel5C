package fr.JPG.ColorWheel5C.controllers;

import fr.JPG.ColorWheel5C.models.Question;
import fr.JPG.ColorWheel5C.repositories.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Pour les commentaires explicatifs à propos d'une classe contrôleur : cf. classe ExpressionController


@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public List<Question> list()
    {
        return questionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Question get(@PathVariable Long id)
    {
        return questionRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question create(@RequestBody final Question question)
    {
        return questionRepository.saveAndFlush(question);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        // Attention ici, il est important de vérifier si l'enregistrement n'est pas lié à d'autres dans une autre table !
        // Dans ce modèle, la table n'a pas de relation. C'est ok.
        questionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Question update(@PathVariable Long id, @RequestBody Question que)
    {
        // TODO : Pareil ici, vérifier que tous les attributs passés sont renseignés (méthode PUT)
        Question existant = questionRepository.getOne(id);
        BeanUtils.copyProperties(que, existant, "id");
        return questionRepository.saveAndFlush(existant);
    }

}
