package gr.kantasni.aigordiscarental.responces.trait;

import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.entities.trait.TraitType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@Setter
@Getter
public class TypeTraitResponse {
    private List<TraitTypeDTO> types = new ArrayList<>();

    public TypeTraitResponse(List<TraitType> entities){
        entities.forEach(traitType -> this.types.add(new TraitTypeDTO(traitType)));
    }
}
