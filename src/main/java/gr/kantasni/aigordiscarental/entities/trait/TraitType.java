package gr.kantasni.aigordiscarental.entities.trait;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.kantasni.aigordiscarental.entities.PersistableEntity;
import gr.kantasni.aigordiscarental.entities.language.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author DimitrisNikoltsanis
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "traittype")
public class TraitType extends PersistableEntity {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Trait> traits = new ArrayList<>();

}
