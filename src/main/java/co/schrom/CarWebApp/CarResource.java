package co.schrom.CarWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resources/cars")
public class CarResource {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> getAll() {
        return carRepository.findAll();
    }

}
