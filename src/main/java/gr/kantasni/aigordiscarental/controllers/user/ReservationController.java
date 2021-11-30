package gr.kantasni.aigordiscarental.controllers.user;

import java.util.Collections;
import java.util.List;

import gr.kantasni.aigordiscarental.entities.reservation.Reservation;
import gr.kantasni.aigordiscarental.responces.PagingResponse;
import gr.kantasni.aigordiscarental.services.ReservationService;
import gr.kantasni.aigordiscarental.utils.MockUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author n.kantas
 */
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create_reservation")
    public ReservationResponse createReservation() {
        Reservation reservation = MockUtils.mockReservation();
        Reservation savedReservation = reservationService.createReservation(reservation);

        return savedReservation != null
            ? new ReservationResponse(
            reservation.getId(),
            reservation.getCustomerName() + " " + reservation.getCustomerLastName(),
            "Save Reservation", true)
            : new ReservationResponse(null, null, "Save Reservation", false);
    }

    @GetMapping("/get_reservation")
    public Reservation getReservation(@RequestParam Long id) {
        return reservationService
            .getReservation(id)
            .orElse(null);
    }

    @Data
//    @AllArgsConstructor
    private static class ReservationResponse {
        private Long id;
        private String name;
        private String operation;
        private boolean result;

        public ReservationResponse(Long id, String name, String operation, boolean result) {
            this.id = id;
            this.name = name;
            this.operation = operation;
            this.result = result;
        }
    }

    @Data
//    @AllArgsConstructor
    private static class AbstractResponse {
        private Object object;
        private boolean result;

        public AbstractResponse(Object object, boolean result) {
            this.object = object;
            this.result = result;
        }
    }
}
