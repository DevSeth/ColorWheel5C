package fr.JPG.ColorWheel5C.repositories;

import fr.JPG.ColorWheel5C.models.Expression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpressionRepository extends JpaRepository<Expression, Long> {

    Expression findByType(String type);
}
