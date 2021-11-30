package gr.kantasni.aigordiscarental.repositories;

import java.util.List;

import gr.kantasni.aigordiscarental.entities.reservation.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author n.kantas
 */
public interface ReservationRepository extends PagingAndSortingRepository<Reservation,Long> {

//    ATTENTION PAGING???
    @Query("SELECT r FROM Reservation r INNER JOIN  r.vehicle v "+
            "WHERE v.id = :vehicleId")
    public List<Reservation> findByVehicle(@Param("vehicleId") Long vehicleId);

    List<Reservation> findAll();
}
