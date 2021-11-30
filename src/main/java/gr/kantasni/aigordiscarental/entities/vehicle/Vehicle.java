package gr.kantasni.aigordiscarental.entities.vehicle;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.kantasni.aigordiscarental.entities.PersistableEntity;
import gr.kantasni.aigordiscarental.entities.reservation.Reservation;
import gr.kantasni.aigordiscarental.entities.trait.Trait;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author n.kantas
 */

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Vehicle extends PersistableEntity {

    @OneToMany(fetch = FetchType.LAZY)
//    @JsonIgnore
    private List<Reservation> reservations= new ArrayList<>();

    @Column
    private Long rate;

    @Column
    private Long currentRate;

    @Column
    private String title ="";

    @Column
    private Boolean active=true;

    private String imageUrl;

    @ManyToMany(fetch = FetchType.EAGER) /** mappedBy = "vehicle", */
    private List<Trait> traits = new ArrayList<>();

}
