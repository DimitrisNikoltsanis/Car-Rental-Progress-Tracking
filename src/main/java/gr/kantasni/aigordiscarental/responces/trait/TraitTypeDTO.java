package gr.kantasni.aigordiscarental.responces.trait;

import java.util.ArrayList;
import java.util.List;

import gr.kantasni.aigordiscarental.entities.trait.TraitType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author DimitrisNikoltsanis
 */
@Setter
@Getter
public class TraitTypeDTO {
    private String type;
    private List<TraitDTO> traits = new ArrayList<>();

    public TraitTypeDTO(TraitType entity){
        this.type = entity.getContents().get(0).getText();
        entity.getTraits().forEach(trait-> this.traits.add(new TraitDTO(trait)));
    }
}
