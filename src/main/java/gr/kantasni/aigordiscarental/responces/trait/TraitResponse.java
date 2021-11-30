package gr.kantasni.aigordiscarental.responces.trait;

import gr.kantasni.aigordiscarental.entities.trait.Trait;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@Setter
@Getter
public class TraitResponse {
    private List<TraitDTO> traits = new ArrayList<>();

    public TraitResponse(List<Trait> entities){
        entities.forEach(trait-> this.traits.add(new TraitDTO(trait)));
    }
}
