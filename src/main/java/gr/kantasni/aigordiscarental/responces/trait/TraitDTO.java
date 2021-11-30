package gr.kantasni.aigordiscarental.responces.trait;

import gr.kantasni.aigordiscarental.entities.language.Content;
import gr.kantasni.aigordiscarental.entities.trait.Trait;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@Setter
@Getter
@NoArgsConstructor
public class TraitDTO implements Serializable {
    private Long id;
    private List<ContentDTO> contents;

    public TraitDTO(Trait entity){
        this.id = entity.getId();
        this.contents = new ArrayList<ContentDTO>();

        entity.getContents().forEach(content-> this.contents.add(new ContentDTO(content)));
    }
}
