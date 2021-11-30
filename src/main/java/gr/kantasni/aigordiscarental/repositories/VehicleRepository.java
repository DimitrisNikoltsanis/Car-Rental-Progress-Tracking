package gr.kantasni.aigordiscarental.repositories;

import java.util.Date;
import java.util.List;

import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author n.kantas
 */
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle,Long> {

//    ATTENTION PAGING???
//    ->Fetch all and use Comparator Java utility interface?
//    ->Use Querydsl?
    @Query("SELECT v FROM Vehicle v JOIN v.reservations res " +
            "WHERE ((size(v.reservations) = 0) OR (res.id IS NULL) OR (:dropoffDate < res.pickupDate) OR (:pickupDate > res.dropoffDate))")
    public List<Vehicle> findAvailable(
            @Param("pickupDate") Date pickupDate,
            @Param("dropoffDate") Date dropoffDate);

    @Query("SELECT v FROM Vehicle v WHERE size(v.reservations) = 0")
    public List<Vehicle> findNew();

    @Query("SELECT v FROM Vehicle v JOIN v.traits t WHERE t.id = :traitID")
    public List<Vehicle> findALLByTraitID(@Param("traitID") Long traitID);

    public List<Vehicle> findAll();

}