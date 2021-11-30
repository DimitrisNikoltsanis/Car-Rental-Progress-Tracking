package gr.kantasni.aigordiscarental.entities.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.kantasni.aigordiscarental.entities.PersistableEntity;
import gr.kantasni.aigordiscarental.entities.reservation.Reservation;
import lombok.Getter;
import lombok.Setter;

/**
 * @author n.kantas
 */

@Entity
@Setter
@Getter
public class Payment extends PersistableEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column
    private Double amount;

    @Column
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne
    @JsonIgnore
    private Reservation reservation;

}
