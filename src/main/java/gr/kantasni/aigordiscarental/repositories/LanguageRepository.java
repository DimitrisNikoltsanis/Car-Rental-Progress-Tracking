package gr.kantasni.aigordiscarental.repositories;

import gr.kantasni.aigordiscarental.entities.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author DimitrisNikoltsanis
 */
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Optional<Language> findByLanguage(String language);
}
