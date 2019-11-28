package fr.JPG.ColorWheel5C.controllers;

import fr.JPG.ColorWheel5C.models.Expression;
import fr.JPG.ColorWheel5C.repositories.ExpressionRepository;
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

@RestController
@RequestMapping("/api/v1/expressions")
public class ExpressionController {

    @Autowired
    private ExpressionRepository expressionRepository;

    // Requête GET pour récupérer la liste complète des Expressions
    @GetMapping
    public List<Expression> list()
    {
        return expressionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Expression get(@PathVariable Long id)
    {
        return expressionRepository.getOne(id);
    }

    // Requête POST. Récupération du body via @RequestBody et enregistrement via le repository.
    // Par défaut, la requête renvoie 200 si réussi. Pour modifier la réponse HTTP, utiliser le tag @ResponseStatus et le paramètre HttpStatus
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Expression create(@RequestBody final Expression exp)
    {
        return expressionRepository.saveAndFlush(exp);
    }

    // Requête DELETE (HTTP). GET et POST sont des verbes HTTP fréquents, donc on utilise les tags correspondants.
    // Pour DELETE, c'est spécifique. A la place d'un tag prêt à l'emploi, nous avons un appel classique au tag @RequestMapping et des spécifications
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        // Attention ici, il est important de vérifier si l'enregistrement n'est pas lié à d'autres dans une autre table !
        // Dans ce modèle, la table n'a pas de relation. C'est ok.
        expressionRepository.deleteById(id);
    }

    // Ici, requête spécifique PUT (mise à jour d'un enregistement (UPDATE))
    // En mise à jour, HTTP propose PUT (mise à jour de tous les attributs) et PATCH (mise à jour de certains attributs)
    // Pour ce PUT : il est attendu de la part de la requête de fournir TOUS les attributs de table.
    // TODO : Effectuer cette vérification. S'il manque un élément, renvoyer une erreur HTTP 400 bad payload.
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Expression update(@PathVariable Long id, @RequestBody Expression exp)
    {
        // TODO : Cf. plus haut : Vérifier exp.
        Expression existant = expressionRepository.getOne(id);
        // 3eme argument : ignore la modification pour ce champ id. C'est la clé primaire !
        // Sans cette annotation, une copie placerait "null" dans la clé primaire de destination
        // et déclencherait une exception lors du saveAndFlush
        BeanUtils.copyProperties(exp,existant,"id");
        return expressionRepository.saveAndFlush(existant);
    }
}
