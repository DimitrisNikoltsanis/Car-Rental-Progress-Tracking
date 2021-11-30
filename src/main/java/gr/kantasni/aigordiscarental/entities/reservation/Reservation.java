package gr.kantasni.aigordiscarental.entities.reservation;

import java.util.Date;
import javax.persistence.*;

import gr.kantasni.aigordiscarental.entities.payment.Payment;
import gr.kantasni.aigordiscarental.entities.PersistableEntity;
import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

/**
 * @author n.kantas
 */
@Entity
@Setter
@Getter
public class Reservation extends PersistableEntity {

    @ManyToOne
    private Vehicle vehicle;

    @Column
    private Date pickupDate;

    @Column
    private Date dropoffDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @Column
    private String customerName;

    @Column
    private String customerLastName;

    @Column
    private String customerMail;

    @Column
    private String customerPhone;

    @Column
    private String customerAddress;

    @Column
    private String customerCountry;
}
