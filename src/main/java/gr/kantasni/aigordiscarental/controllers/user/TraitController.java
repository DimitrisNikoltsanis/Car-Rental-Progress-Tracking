package gr.kantasni.aigordiscarental.controllers.user;

import gr.kantasni.aigordiscarental.responces.trait.TraitResponse;
import gr.kantasni.aigordiscarental.services.TraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@RestController
@RequestMapping("/traits")
public class TraitController {
    @Autowired
    private TraitService traitService;

    @GetMapping("/get")
    public List<TraitResponse> getAllTraitTypes(@RequestParam String language){

        return null;
    }
}
