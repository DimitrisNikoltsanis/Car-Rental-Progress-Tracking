package gr.kantasni.aigordiscarental.configuration;

import gr.kantasni.aigordiscarental.entities.language.Language;
import org.springframework.web.context.annotation.SessionScope;

//this annotation means that every time a new session is created
//a new instance of the class is initialized;
@SessionScope
public class CurrentSessionConfig {

    private Language currentLanguage = new Language("English");
}
