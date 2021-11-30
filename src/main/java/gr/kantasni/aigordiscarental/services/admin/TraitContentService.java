package gr.kantasni.aigordiscarental.services.admin;

import gr.kantasni.aigordiscarental.entities.language.Content;
import gr.kantasni.aigordiscarental.entities.language.Language;
import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.entities.trait.TraitType;
import gr.kantasni.aigordiscarental.repositories.LanguageRepository;
import gr.kantasni.aigordiscarental.repositories.TraitRepository;
import gr.kantasni.aigordiscarental.repositories.TraitTypeRepository;
import gr.kantasni.aigordiscarental.services.admin.requests.ContentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nikos Kantas (kantasni)
 */

@Service("CONTENT-TRAIT")
public class TraitContentService implements AdminContentService {
    @Autowired
    private TraitRepository traitRepository;

    @Autowired
    private TraitTypeRepository typeRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public void createContent(ContentDTO contentDTO) {
        Trait trait = new Trait();

        Language language = languageRepository.findByLanguage(contentDTO.getLanguage()).orElse(null);
        TraitType traitType = typeRepository.findById(contentDTO.getEntityId()).orElse(null);

        Content content = new Content(language, contentDTO.getText());
        trait.setType(traitType);
        trait.addContent(content); traitRepository.save(trait);
    }

    @Override
    public void deleteContent(ContentDTO contentDTO) {

    }
}
