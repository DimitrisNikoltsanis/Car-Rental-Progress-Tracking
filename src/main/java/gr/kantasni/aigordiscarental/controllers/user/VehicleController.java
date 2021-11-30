package gr.kantasni.aigordiscarental.controllers.user;

import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import gr.kantasni.aigordiscarental.repositories.VehicleRepository;
import gr.kantasni.aigordiscarental.requests.VehiclesRequest;
import gr.kantasni.aigordiscarental.responces.ImageURLsResponse;
import gr.kantasni.aigordiscarental.responces.PagingResponse;
import gr.kantasni.aigordiscarental.responces.vehicle.VehicleResponse;
import gr.kantasni.aigordiscarental.services.VehicleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/get")
    public List<Vehicle> getVehicles() {return vehicleService.getAllVehicles();}

    @GetMapping("/page/{pageNum}")
    public PagingResponse getVehiclesPage(@PathVariable int pageNum) {
        Page<Vehicle> vehiclePage = vehicleService.getVehiclesPage(pageNum);
        return new PagingResponse(Collections.singletonList(vehiclePage.getContent()), vehiclePage.getTotalPages());
    }

    @GetMapping("/get_one")
    public Vehicle getVehicle(@RequestParam Long id) {
        return vehicleService.getVehicle(id).orElse(null);
    }

    /** Returns the URLs of the images of all vehicles **/
    @GetMapping("/images")
    public ImageURLsResponse getVehicleImageURLs() {
        return new ImageURLsResponse(vehicleService.getAllVehicles());
    }

    /** NEW **/
    /** todo: Use pickup and drop off times and locations **/
    @PostMapping(value = "/search1",
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<VehicleResponse> searchVehicles(@RequestBody VehiclesRequest vehiclesRequest){
        List<Vehicle> vehicles = vehicleService.getAvailable(vehiclesRequest.getPickupDate(), vehiclesRequest.getDropoffDate());
        List<VehicleResponse> res = new ArrayList<>();
        if (vehicles != null){
            vehicles.forEach(vehicle -> res.add(new VehicleResponse(vehicle.getId(), vehicle.getTitle(), vehicle.getActive(),
                                                            vehicle.getImageUrl(), vehicle.getTraits(),
                                                        "Get Available Vehicles", true)));
        }
        return res;
    }

    /** NEW **/
    @GetMapping("/search2")
    public List<VehicleResponse> searchVehicles(@RequestParam Date pickup, Date dropoff){
        List<Vehicle> vehicles = vehicleService.getAvailable(pickup, dropoff);
        List<VehicleResponse> res = new ArrayList<>();
        if (vehicles != null){
            vehicles.forEach(vehicle -> res.add(new VehicleResponse(vehicle.getId(), vehicle.getTitle(), vehicle.getActive(),
                    vehicle.getImageUrl(), vehicle.getTraits(),
                    "Get Available Vehicles", true)));
        }
        return res;
    }

}


