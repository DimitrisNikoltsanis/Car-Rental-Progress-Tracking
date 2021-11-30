package gr.kantasni.aigordiscarental.controllers;

import java.util.*;

import gr.kantasni.aigordiscarental.common.EnglishTraitType;
import gr.kantasni.aigordiscarental.entities.language.Content;
import gr.kantasni.aigordiscarental.entities.language.Language;
import gr.kantasni.aigordiscarental.entities.reservation.Reservation;
import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.entities.trait.TraitType;
import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import gr.kantasni.aigordiscarental.repositories.ReservationRepository;
import gr.kantasni.aigordiscarental.repositories.VehicleRepository;
import gr.kantasni.aigordiscarental.requests.admin.CreateTraitRequest;
import gr.kantasni.aigordiscarental.services.LanguageService;
import gr.kantasni.aigordiscarental.services.TraitService;
import gr.kantasni.aigordiscarental.utils.MockUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author n.kantas
 */
@RestController
public class TestController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TraitService traitService;

    @Autowired
    private LanguageService languageService;

    @GetMapping("/test")
    private void test(@RequestBody Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @GetMapping("/test2")
    private void test2(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @GetMapping("/test3")
    private void test3() {
        vehicleRepository.findAll().forEach(v -> {
            reservationRepository.save(MockUtils.mockReservation(v));
        });
    }

    @GetMapping("/test4")
    private void test4() {
        vehicleRepository.findAll().forEach(v -> System.out.println(v.getTitle()));
    }

/**********************************************************************************************************************/
    @GetMapping("/create_english")
    public void createEnglish(){
        languageService.createLang(new Language("EN"));
    }

    @GetMapping("/initialize_trait_types")
    public void initTraitTypes(){
        Optional<Language> language = languageService.getLanguageByLanguage("EN");

        language.ifPresent(lang->{
            Arrays.asList(EnglishTraitType.values()).forEach(type->{
                TraitType traitType = new TraitType();
                Content content1 = new Content();
                content1.setLanguage(lang);
                content1.setText(type.toString());
                content1.setEntity(traitType);
                traitType.getContents().add(content1);
                traitService.createTraitType(traitType);
                System.out.println();
            });
        });
    }

    @GetMapping("/create_mock_traits")
    public void createMockTraits(){
        Language english = languageService.getLanguageByLanguage("EN").get();
        List<TraitType> types = traitService.getAllTraitTypes();
        List<Trait> traits = MockUtils.mockTraits(english, types);
        traits.forEach(trait -> traitService.createTrait(new CreateTraitRequest(trait.getContents().get(0).getLanguage().getLanguage(),
                                                                                trait.getContents().get(0).getText(),
                                                                                trait.getType().getId())));
    }

    @GetMapping("/random")
    public void test(){

    }

//    @GetMapping("/temp")
//    public Vehicle getRandomVehicle(){
//
//    }

//    @GetMapping("/reservation")
//    @SneakyThrows
//    public void reservationWithDate(@RequestParam Long vid,
//                                    @RequestParam String pickupDate,
//                                    @RequestParam String dropoffDate) {
//
//        reservationRepository.save(MockUtils.withDateAndId(
//            vid, new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(pickupDate)
//            , new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(dropoffDate)
//        ));
//    }
}
