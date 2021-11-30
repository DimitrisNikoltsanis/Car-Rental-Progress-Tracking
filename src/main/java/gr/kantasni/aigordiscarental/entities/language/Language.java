package gr.kantasni.aigordiscarental.entities.language;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.kantasni.aigordiscarental.entities.PersistableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "languages")
public class Language extends PersistableEntity {

    @Column
    private String language;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Content> contents = new ArrayList<>();

    public Language(String lang) {
        this.language = lang;
    }
}
