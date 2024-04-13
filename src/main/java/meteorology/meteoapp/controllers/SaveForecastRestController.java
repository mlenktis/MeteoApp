package meteorology.meteoapp.controllers;

import meteorology.meteoapp.entities.ForecastEntity;
import meteorology.meteoapp.models.ForecastModel;
import meteorology.meteoapp.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveForecastRestController {
    @Autowired
    private ForecastRepository forecastRepository;
    @PostMapping(value = "/api/forecast", consumes = "application/json")

    public void index(@RequestBody ForecastModel model) {
        System.out.println("Received date: " + model.dateTime);
        System.out.println("Received temperature: " + model.temperature);

        var entity = new ForecastEntity(
                model.dateTime,
                String.valueOf(model.temperature),
                model.city,
                1);

        forecastRepository.save(entity);
    }
}
