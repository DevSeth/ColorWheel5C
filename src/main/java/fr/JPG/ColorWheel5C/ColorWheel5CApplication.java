package fr.JPG.ColorWheel5C;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ColorWheel5CApplication extends SpringBootServletInitializer {			// Extension indispensable pour tout packaging en WAR file, pour la compatibilité avec les conteneurs externes web de production
																					// En effet, dans ce cas de figure, le conteneur web attend un fichier web.xml qui retranscrit la config web. Cette extension fournit cette info de base au conteneur web.
	public static void main(String[] args) {
		SpringApplication.run(ColorWheel5CApplication.class, args);
	}

}
