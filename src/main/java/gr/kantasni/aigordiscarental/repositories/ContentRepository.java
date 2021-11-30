package gr.kantasni.aigordiscarental.repositories;

import gr.kantasni.aigordiscarental.entities.language.Content;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DimitrisNikoltsanis
 */
public interface ContentRepository extends JpaRepository<Content, Long> {
}
