package gr.kantasni.aigordiscarental.responces.trait;

import java.io.Serializable;

import gr.kantasni.aigordiscarental.entities.language.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author DimitrisNikoltsanis
 */
@Setter
@Getter
@NoArgsConstructor
public class ContentDTO implements Serializable {
    private Long id;
    private String language;
    private String text;

    public ContentDTO(Content entity) {
        this.id = entity.getId();
        this.language = entity.getLanguage().getLanguage();
        this.text = entity.getText();
    }
}
