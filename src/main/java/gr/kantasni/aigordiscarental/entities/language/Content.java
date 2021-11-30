package gr.kantasni.aigordiscarental.entities.language;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.kantasni.aigordiscarental.entities.language.Language;
import gr.kantasni.aigordiscarental.entities.PersistableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="contents")
public class Content extends PersistableEntity {

    @ManyToOne
    Language language;

    String text;

    @ManyToOne
    @JsonIgnore
    PersistableEntity entity;

    public Content(Language language, String text) {
        this.language = language;
        this.text = text;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PersistableEntity getEntity() {
        return entity;
    }

    public void setEntity(PersistableEntity entity) {
        this.entity = entity;
    }
}
