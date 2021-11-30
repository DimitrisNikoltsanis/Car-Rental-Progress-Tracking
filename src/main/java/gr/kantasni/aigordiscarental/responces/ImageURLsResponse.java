package gr.kantasni.aigordiscarental.responces;

import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@Setter
@Getter
public class ImageURLsResponse implements Serializable {
    List<VehicleImage> imageURLs = new ArrayList<>();

    public ImageURLsResponse(List<Vehicle> vehicles){
        vehicles.forEach(vehicle -> imageURLs.add(new VehicleImage(vehicle.getId(), vehicle.getImageUrl())));
    }

    @AllArgsConstructor
    @Setter
    @Getter
    private static class VehicleImage{
        private Long id;
        private String imageUrl;
    }
}
