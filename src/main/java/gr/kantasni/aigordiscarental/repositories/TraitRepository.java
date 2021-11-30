package gr.kantasni.aigordiscarental.repositories;

import gr.kantasni.aigordiscarental.entities.trait.Trait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
public interface TraitRepository extends JpaRepository<Trait, Long> {

    @Query("SELECT t FROM Trait t JOIN t.type typ WHERE typ.id = :typeId")
    public List<Trait> findByTypeId(Long typeId);

    @Query("SELECT t FROM Trait t JOIN t.contents c JOIN c.language lang JOIN t.type typ JOIN typ.contents con WHERE con.text = :type AND lang.language = :language")
    public List<Trait> findByType(String type, String language);

//    @Query("SELECT t FROM Trait t JOIN t.contents c JOIN c.language traitlang JOIN t.type typ " +
//            "JOIN typ.contents con JOIN con.language typelang WHERE typelang = :language AND traitlang.language = :language")
//    public List<Trait> findByLanguage(String language);

    public List<Trait> findAll();

}
