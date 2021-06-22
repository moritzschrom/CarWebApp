package co.schrom.CarWebApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String brand;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private LocalDate buildYear;

    public Car(String brand, String name, LocalDate buildYear) {
        this(null, brand, name, buildYear);
    }

}
