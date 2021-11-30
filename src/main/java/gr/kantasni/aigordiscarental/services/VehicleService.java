package gr.kantasni.aigordiscarental.services;

import gr.kantasni.aigordiscarental.common.Constants;
import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import gr.kantasni.aigordiscarental.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author DimitrisNikoltsanis
 */
@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Vehicle createVehicle(Vehicle vehicle) { return repository.save(vehicle);}

    public Optional<Vehicle> getVehicle(Long id) { return repository.findById(id); }

    public List<Vehicle> getAllVehicles() { return repository.findAll();}

    public Page<Vehicle> getVehiclesPage(int pageNo) {return repository.findAll(PageRequest.of(pageNo, Constants.VEHICLES_PAGE_SIZE));}

    public List<Vehicle> getAvailable(Date pickup, Date dropoff) {
        List<Vehicle> res;
        res = repository.findAvailable(pickup, dropoff);
        if (res.isEmpty()){
            res = repository.findNew();
        }
        return res;
    }

    public void deleteVehicle(Long id) { repository.deleteById(id); }

}
