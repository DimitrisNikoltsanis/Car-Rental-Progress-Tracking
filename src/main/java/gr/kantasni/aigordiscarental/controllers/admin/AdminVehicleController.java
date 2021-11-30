package gr.kantasni.aigordiscarental.controllers.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import gr.kantasni.aigordiscarental.requests.VehicleCreationRequest;
import gr.kantasni.aigordiscarental.responces.PagingResponse;
import gr.kantasni.aigordiscarental.responces.vehicle.VehicleResponse;
import gr.kantasni.aigordiscarental.services.TraitService;
import gr.kantasni.aigordiscarental.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DimitrisNikoltsanis
 */
@RestController
@RequestMapping("/admin/vehicles")
public class AdminVehicleController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private TraitService traitService;

    /** NEW **/
    @PostMapping(value="/create")
    public VehicleResponse createVehicle(@RequestBody VehicleCreationRequest vehicle){
        List<Trait> traits = new ArrayList<>();
        vehicle.getTraitIds().forEach(traitId-> traits.add(traitService.getTraitById(traitId).orElse(null)));
        return createVehicleResponse(vehicleService.createVehicle(
                new Vehicle(new ArrayList<>(), vehicle.getRate(), vehicle.getCurrentRate(), vehicle.getTitle(),
                        true, vehicle.getImage(), traits)
        ));
    }

    @GetMapping("/get")
    public List<Vehicle> getVehicles() {return vehicleService.getAllVehicles();}

    @GetMapping("/get/page/{pageNum}")
    public PagingResponse getVehiclesPage(@PathVariable int pageNum) {
        Page<Vehicle> vehiclePage = vehicleService.getVehiclesPage(pageNum);
        return new PagingResponse(Collections.singletonList(vehiclePage.getContent()), vehiclePage.getTotalPages());
    }

    //    ATTENTION : Its the same as create
    @PostMapping("/edit")
    public VehicleResponse editVehicle(@RequestParam Vehicle vehicle){
        Vehicle newVehicle = vehicleService.createVehicle(vehicle);

        return newVehicle != null ?
                new VehicleResponse(newVehicle.getId(), newVehicle.getTitle(), newVehicle.getActive(), newVehicle.getImageUrl(), newVehicle.getTraits(), "Save vehicle", true)
                : new VehicleResponse(null, null, null,null,null, "Save vehicle", false);
    }

   //    Check if deleted
    @GetMapping("/delete")
    public void deleteVehicle(@RequestParam Long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
    }


    private VehicleResponse createVehicleResponse(Vehicle vehicle){
        return vehicle != null ?
                new VehicleResponse(vehicle.getId(), vehicle.getTitle(), vehicle.getActive(), vehicle.getImageUrl(), vehicle.getTraits(), "Save vehicle", true)
                : new VehicleResponse(null, null, null,null, null,"Save vehicle", false);
    }
}
