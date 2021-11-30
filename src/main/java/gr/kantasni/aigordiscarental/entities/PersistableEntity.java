package gr.kantasni.aigordiscarental.entities;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author n.kantas
 */
@Setter
@Getter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PersistableEntity {
    //Boolean active
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    //todo add annotation with security
    //  @CreatedDate
    private Date createdAt = new Date();

}
