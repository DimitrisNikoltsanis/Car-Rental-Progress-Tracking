package gr.kantasni.aigordiscarental.services;

import gr.kantasni.aigordiscarental.entities.language.Language;
import gr.kantasni.aigordiscarental.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author DimitrisNikoltsanis
 */
@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public Language createLang(Language language){ return languageRepository.save(language); }

    public Optional<Language> getLanguageById(Long languageId){ return languageRepository.findById(languageId); }

    public Optional<Language> getLanguageByLanguage(String language){ return languageRepository.findByLanguage(language); }

    public void  deleteLanguage(Long languageId){ languageRepository.deleteById(languageId); }

    public List<Language> getLanguages(){
        return languageRepository.findAll();
    }
}
