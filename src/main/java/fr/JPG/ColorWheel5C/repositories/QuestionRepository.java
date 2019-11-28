package fr.JPG.ColorWheel5C.repositories;

import fr.JPG.ColorWheel5C.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
