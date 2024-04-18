package meteorology.meteoapp.controllers;

import meteorology.meteoapp.entities.ForecastEntity;
import meteorology.meteoapp.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ForecastSaveController {
    @Autowired
    private ForecastRepository forecastRepository;

    @PostMapping("/saveForecast")
    public String saveForecast(@RequestParam String city, @RequestParam double temperature, @RequestParam String date) {
        var userID = 1;
        var forecast = new ForecastEntity(date, String.valueOf(temperature), city, userID);

        forecastRepository.save(forecast);
        return "redirect:/forecast?city=" + city;
    }

    @PostMapping("/delete")
    public String deleteForecast(@RequestParam int id) {
        forecastRepository.deleteById(id);
        return "redirect:/saved";
    }

    @PostMapping("/deleteAll")
    public String deleteAllForecasts() {
        forecastRepository.deleteAll();
        return "redirect:/saved";
    }
}

