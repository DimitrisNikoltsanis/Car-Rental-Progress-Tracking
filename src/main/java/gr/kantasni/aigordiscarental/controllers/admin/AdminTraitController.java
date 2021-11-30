package gr.kantasni.aigordiscarental.controllers.admin;

import gr.kantasni.aigordiscarental.common.EnglishTraitType;
import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.requests.admin.CreateTraitRequest;
import gr.kantasni.aigordiscarental.responces.admin.AdminTraitResponse;
import gr.kantasni.aigordiscarental.responces.trait.TraitResponse;
import gr.kantasni.aigordiscarental.responces.trait.TypeTraitResponse;
import gr.kantasni.aigordiscarental.services.TraitService;
import gr.kantasni.aigordiscarental.services.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DimitrisNikoltsanis
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminTraitController {

    @Autowired
    private TraitService traitService;

    @Autowired
    private AdminService adminService;


    @GetMapping("/trait-information")
    public AdminTraitResponse getTraitInformation(@RequestParam Long traitTypeId){

        return adminService.getTraitInformation(traitTypeId);
    }

    //todo remove
    @PostMapping("create-trait")
    public Trait createTrait(@RequestBody CreateTraitRequest request){
        traitService.createTrait(request);
       return  null;
        // return traitService.createTrait(request);
    }

    //    Maybe not useful...
    @GetMapping("/admin/get_trait")
    public Trait getTrait(@RequestParam Long traitId){ return traitService.getTraitById(traitId).orElse(null); }

    @GetMapping("/admin/get_traits")
    public List<Trait> getAllTraits(){ return traitService.getAllTraits(); }

    @GetMapping("/admin/get_traits_of_type_id")
    public TraitResponse getTraitsOfTypeId(@RequestParam Long typeId){
        return new TraitResponse(traitService.getTraitsOfTypeId(typeId));
    }

    @GetMapping("/admin/get_traits_of_type")
    public TraitResponse getTraitsOfType(@RequestParam String type){
        return new TraitResponse(traitService.getTraitsOfType(type,null));
    }

    @GetMapping("/get/types")
    public List<String> getAllTraitTypes(){
        return EnumSet.allOf(EnglishTraitType.class).stream().map(EnglishTraitType::toString).collect(Collectors.toList());
    }

    @DeleteMapping("/delete-trait")
    public void deleteTrait(@RequestParam Long traitId){
        traitService.deleteTrait(traitId);}
}
