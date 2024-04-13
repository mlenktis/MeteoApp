package meteorology.meteoapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class ForecastEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;
    @Column(name = "date")
    public String date;
    @Column(name = "temperature")
    public String temperature;
    @Column(name = "city")
    public String city;
    @Column(name = "userId")
    public int userId;
    @Column(name = "dateOfCreated")
    public String dateOfCreated;

    public ForecastEntity(String date, String temperature, String city, int userId) {
        this.date = date;
        this.temperature = temperature;
        this.city = city;
        this.userId = userId;
    }

    @PrePersist
    private void init() {
        dateOfCreated = String.valueOf(LocalDateTime.now());
    }


}
