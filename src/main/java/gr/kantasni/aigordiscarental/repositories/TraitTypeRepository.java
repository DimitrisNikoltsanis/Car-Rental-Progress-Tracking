package gr.kantasni.aigordiscarental.repositories;

import gr.kantasni.aigordiscarental.entities.trait.TraitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author DimitrisNikoltsanis
 */
public interface TraitTypeRepository extends JpaRepository<TraitType, Long> {
    public List<TraitType> findAll();

    @Query("SELECT typ FROM TraitType typ JOIN typ.contents c JOIN c.language typelang JOIN typ.traits t " +
            "JOIN t.contents con JOIN con.language traitlang WHERE typelang = :language AND traitlang.language = :language")
    public List<TraitType> findByLanguage(String language);
}
