package fr.JPG.ColorWheel5C.config;

import org.hibernate.Hibernate;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public DataSource maConfigDB()
    {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/ColorWheel5C");
        builder.username("postgres");
        builder.password("admin");
        return builder.build();
    }

    // Comment gérer les autres properties du fichier application.properties ?
}
