package gr.kantasni.aigordiscarental.services;
import java.util.List;
import java.util.Optional;

import gr.kantasni.aigordiscarental.common.Constants;
import gr.kantasni.aigordiscarental.entities.reservation.Reservation;
import gr.kantasni.aigordiscarental.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author n.kantas
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public Optional<Reservation> getReservation(Long id){
        return repository.findById(id);
    }

    public Reservation createReservation(Reservation reservation){
        return repository.save(reservation);
    }

    public void deleteReservation(Long id){
        repository.deleteById(id);
    }

    public List<Reservation> getReservations(){
        return repository.findAll();
    }

    public Page<Reservation> getReservationsPage(int numPage){
       return repository.findAll(PageRequest.of(numPage-1, Constants.RESERVATIONS_PAGES));
    }
}
