package gr.kantasni.aigordiscarental.repositories;

import gr.kantasni.aigordiscarental.entities.payment.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author n.kantas
 */
public interface PaymentRepository extends CrudRepository<Payment,Long> {
}
