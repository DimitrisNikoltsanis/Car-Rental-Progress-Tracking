package gr.kantasni.aigordiscarental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AigordiscarentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AigordiscarentalApplication.class, args);
    }

}
