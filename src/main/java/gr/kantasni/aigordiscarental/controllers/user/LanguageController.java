package gr.kantasni.aigordiscarental.controllers.user;

import java.util.ArrayList;
import java.util.List;

import gr.kantasni.aigordiscarental.services.LanguageService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DimitrisNikoltsanis
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/getLanguages")
    public LanguageResponse getLanguages() {
        List<String> languages = new ArrayList<>();

        languageService.getLanguages().forEach(language -> languages.add(language.getLanguage()));

        return new LanguageResponse(languages);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private static class LanguageResponse {
        List<String> languages;
    }
}
