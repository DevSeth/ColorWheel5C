package fr.JPG.ColorWheel5C.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String applicationVersion;

    @GetMapping
    @RequestMapping("/")
    public Map status()
    {
        // Procédure pour enregistrer et retourner la version application (depuis le fichier de config application.properties)
        Map mapVersion = new HashMap<String,String>();
        mapVersion.put("app-version",applicationVersion);
        return mapVersion;

        // Procédure pour lire et stocker toutes les Questions et Expressions pour le test.

    }

}
