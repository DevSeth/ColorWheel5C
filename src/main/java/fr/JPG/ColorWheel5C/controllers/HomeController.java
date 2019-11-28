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
        Map mapVersion = new HashMap<String,String>();
        mapVersion.put("app-version",applicationVersion);
        return mapVersion;
    }

}
