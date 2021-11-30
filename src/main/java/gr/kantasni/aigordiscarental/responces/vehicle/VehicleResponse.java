package gr.kantasni.aigordiscarental.responces.vehicle;

import gr.kantasni.aigordiscarental.entities.trait.Trait;
import lombok.Data;

import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@Data
public class VehicleResponse {
    private Long id;
    private String name;
    private Boolean active;
    private String image;
    private List<Trait> traits;
    private String operation;
    private boolean result;

    public VehicleResponse(Long id, String name, Boolean active, String image, List<Trait> traits, String operation, boolean result) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.image = image;
        this.traits = traits;
        this.operation = operation;
        this.result = result;
    }
}
