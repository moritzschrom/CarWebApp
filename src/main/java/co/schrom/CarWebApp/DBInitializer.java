package co.schrom.CarWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DBInitializer {

    @Autowired
    private CarRepository carRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationReady() {
        carRepository.saveAll(
            List.of(
                new Car("VW", "ID.3", LocalDate.of(2020, 1, 1)),
                new Car("BMW", "i3", LocalDate.of(2019, 1, 1))
            )
        );
    }

}
