package gr.kantasni.aigordiscarental.requests;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@Setter
@Getter
@NoArgsConstructor
public class VehicleCreationRequest implements Serializable {
    private Long rate;
    private Long currentRate;
    private String title;
    private String image;
    private List<Long> traitIds;
}
