package gr.kantasni.aigordiscarental.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author DimitrisNikoltsanis
 */
@Data
public class VehiclesRequest {
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Athens")
    private Date pickupDate;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Athens")
    private Date dropoffDate;
    private String pickupLocation;
    private String dropoffLocation;
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime pickupTime;
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime dropoffTime;
}
