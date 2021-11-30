package gr.kantasni.aigordiscarental.responces.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gr.kantasni.aigordiscarental.entities.language.Language;
import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.responces.trait.TraitDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nikos Kantas (kantasni)
 */
@Setter
@Getter
@NoArgsConstructor
public class AdminTraitResponse implements Serializable {

    private List<String> languages=new ArrayList<>();

    private List<TraitDTO> traits=new ArrayList<>();

    public AdminTraitResponse(List<Language> langs, List<Trait> traits){
        langs.forEach(lang -> languages.add(lang.getLanguage()));
        traits.forEach(trait -> this.traits.add(new TraitDTO(trait)));
    }
}
