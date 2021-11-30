package gr.kantasni.aigordiscarental.utils;

import java.util.*;

import javax.annotation.PostConstruct;

import gr.kantasni.aigordiscarental.entities.language.Content;
import gr.kantasni.aigordiscarental.entities.language.Language;
import gr.kantasni.aigordiscarental.entities.payment.Payment;
import gr.kantasni.aigordiscarental.entities.payment.PaymentMethod;
import gr.kantasni.aigordiscarental.entities.payment.PaymentStatus;
import gr.kantasni.aigordiscarental.entities.reservation.Reservation;
import gr.kantasni.aigordiscarental.entities.trait.Trait;
import gr.kantasni.aigordiscarental.entities.trait.TraitType;
import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import gr.kantasni.aigordiscarental.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author n.kantas
 */
@Component
public class MockUtils {

    private static VehicleRepository vehicleRepository;

    @Autowired
    VehicleRepository vehicleRepository0;

    @PostConstruct
    private void onPostConstruct() {
        vehicleRepository = vehicleRepository0;
    }

/**************************************************** Reservations ****************************************************/
    public static Reservation mockReservation() {


        Reservation reservation = new Reservation();
        reservation.setPickupDate(new GregorianCalendar(2021, Calendar.MARCH, 3).getTime());
        reservation.setDropoffDate(new GregorianCalendar(2021, Calendar.MARCH, 10).getTime());
        reservation.setCustomerName("Nikos");
        reservation.setCustomerLastName("Matsamplokos");
        reservation.setCustomerMail("test@yahoo.gr");
        reservation.setCustomerAddress("Aleuki");
        reservation.setCustomerCountry("Saint Saranta");
        reservation.setCustomerPhone("691242342");

        Payment payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.CASH);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        payment.setAmount(420.69);

        Vehicle vehicle = new Vehicle();
        vehicle.setTitle("Lambo");

        vehicle.getReservations().add(reservation);
        reservation.setVehicle(vehicle);
        payment.setReservation(reservation);
        reservation.setPayment(payment);

        return reservation;
    }

    public static Reservation mockReservation(Vehicle vehicle) {

        Reservation reservation = new Reservation();
        reservation.setPickupDate(new GregorianCalendar(2021, Calendar.MARCH, 3).getTime());
        reservation.setDropoffDate(new GregorianCalendar(2021, Calendar.MARCH, 10).getTime());
        reservation.setCustomerName("Nikos");
        reservation.setCustomerLastName("Matsamplokos");
        reservation.setCustomerMail("test@yahoo.gr");
        reservation.setCustomerAddress("Aleuki");
        reservation.setCustomerCountry("Saint Saranta");
        reservation.setCustomerPhone("691242342");

        Payment payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.CASH);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        payment.setAmount(420.69);

        vehicle.getReservations().add(reservation);
        reservation.setVehicle(vehicle);
        payment.setReservation(reservation);
        reservation.setPayment(payment);

        return reservation;
    }

    public static Reservation withDateAndId(Long vid, Date pickupDate, Date dropoffDate) {
        Reservation reservation = new Reservation();

        reservation.setPickupDate(pickupDate);
        reservation.setDropoffDate(dropoffDate);
        reservation.setCustomerName("Nikos_" + pickupDate.toString());
        reservation.setCustomerLastName("Matsamplokos_" + pickupDate.toString());
        reservation.setCustomerMail("test@yahoo.gr");
        reservation.setCustomerAddress("Aleuki");
        reservation.setCustomerCountry("Saint Saranta");
        reservation.setCustomerPhone("691242342");

        Payment payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.CASH);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        payment.setAmount(420.69);

        Vehicle vehicle = vehicleRepository.findById(vid).orElse(null);

        vehicle.getReservations().add(reservation);
        reservation.setVehicle(vehicle);
        payment.setReservation(reservation);
        reservation.setPayment(payment);

        return reservation;

    }

/******************************************************* Traits *******************************************************/
    private static final List<String> fuels = Arrays.asList("Petrol","Diesel");
    private static final List<String> seats = Arrays.asList("2","4","5","7");
    private static final List<String> doors = Arrays.asList("2","3","4","5");
    private static final List<String> transmissions = Arrays.asList("Manual","Auto");
    private static final List<String> airCons = Arrays.asList("Equipped", "Not equipped");
    private static final List<String> luggage = Arrays.asList("2","3","4","5","6");
    private static final List<String> extras = Arrays.asList("Sunroof", "Convertible", "Hybrid", "Tow hitch", "Cruise control", "Isofix");

    private static Trait cookTrait(String value, TraitType type, Language lang){
        Content content = new Content();
        content.setLanguage(lang);
        content.setText(value);

        Trait trait = new Trait();
        trait.setType(type);
        trait.addContent(content);
        content.setEntity(trait);

        return trait;
    }


    public static List<Trait> mockTraits(Language english, List<TraitType> types){

        List<Trait> traits = new ArrayList<>();

        for(TraitType type : types){
//            ATTENTION ¯¯¯¯¯¯¯¯¯¯¯¯¯¯↓
            switch(type.getContents().get(0).getText()){
                case "Fuel":
                    fuels.forEach(value -> traits.add(cookTrait(value, type, english)));
                    break;

                case "Seats":
                    seats.forEach(value -> traits.add(cookTrait(value, type, english)));
                    break;

                case "Doors":
                    doors.forEach(value -> traits.add(cookTrait(value, type, english)));
                    break;

                case "Transmission":
                    transmissions.forEach(value -> traits.add(cookTrait(value, type, english)));
                    break;

                case "Air conditioning":
                    airCons.forEach(value -> traits.add(cookTrait(value, type, english)));
                    break;

                case "Luggage":
                    luggage.forEach(value -> traits.add(cookTrait(value, type, english)));
                    break;

                case "Extras":
                    extras.forEach(value -> traits.add(cookTrait(value, type, english)));
                    break;
            }
        }

        return traits;
    }
}
