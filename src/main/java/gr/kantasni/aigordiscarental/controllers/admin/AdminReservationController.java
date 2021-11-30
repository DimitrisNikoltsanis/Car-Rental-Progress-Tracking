package gr.kantasni.aigordiscarental.controllers.admin;

import gr.kantasni.aigordiscarental.entities.reservation.Reservation;
import gr.kantasni.aigordiscarental.responces.PagingResponse;
import gr.kantasni.aigordiscarental.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@RestController
public class AdminReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("reservations/page/{numPage}")
    public PagingResponse getReservationsPaging(@PathVariable int numPage) {

        Page<Reservation> reservationsPage = reservationService.getReservationsPage(numPage);
        return new PagingResponse(Collections.singletonList(reservationsPage.getContent()), reservationsPage.getTotalPages());
    }

    @GetMapping("/delete_reservation")
    public void deleteReservation(@RequestParam Long id){
        reservationService.deleteReservation(id);
    }
}

//1)Ena delete gia ola stelnei to id tou pros diagrafei
//2)to edit stelnei id kai to allagmeno pedio px edit trait<<to text sta ellhnika>> --> stelnei id tou trait kai to allagmeno content
//3)