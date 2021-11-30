package gr.kantasni.aigordiscarental.services;

import gr.kantasni.aigordiscarental.entities.language.Content;
import gr.kantasni.aigordiscarental.entities.language.Language;
import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.entities.trait.TraitType;
import gr.kantasni.aigordiscarental.repositories.LanguageRepository;
import gr.kantasni.aigordiscarental.repositories.TraitRepository;
import gr.kantasni.aigordiscarental.repositories.TraitTypeRepository;
import gr.kantasni.aigordiscarental.requests.admin.CreateTraitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author DimitrisNikoltsanis
 */
@Service
public class TraitService {

    @Autowired
    private TraitRepository traitRepository;

    @Autowired
    private TraitTypeRepository typeRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public Trait createTrait(CreateTraitRequest request){
        Trait trait = new Trait();

        Language language = languageRepository.findByLanguage(request.getLanguage()).orElse(null);
        TraitType traitType = typeRepository.findById(request.getTraitTypeId()).orElse(null);

        Content content = new Content(language, request.getText());
        trait.setType(traitType);
        trait.addContent(content);

        Trait save = traitRepository.save(trait);

        return null;
//        return traitRepository.save(trait); ]
        }

    public TraitType createTraitType(TraitType type){ return typeRepository.save(type); }

    public Optional<Trait> getTraitById(Long id){ return traitRepository.findById(id); }

    public List<Trait> getAllTraits(){ return traitRepository.findAll(); }

    public List<Trait> getTraitsOfTypeId(Long typeId){ return traitRepository.findByTypeId(typeId); }

    public List<Trait> getTraitsOfType(String type, String language){ return traitRepository.findByType(type, language); }

    public List<TraitType> getAllTraitTypesIn(String language){ return typeRepository.findByLanguage(language); }

    public List<TraitType> getAllTraitTypes(){ return typeRepository.findAll(); }

    public void deleteTrait(Long id){ traitRepository.deleteById(id); }

}
