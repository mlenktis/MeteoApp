package meteorology.meteoapp.controllers;

import meteorology.meteoapp.models.ForecastViewModel;
import meteorology.meteoapp.services.ForecastService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;

@Controller
public class ForecastController {
    @GetMapping("/forecast")
    public ModelAndView index(@RequestParam(required = false, defaultValue = "") String city) throws IOException {
        ModelAndView modelAndView = new ModelAndView("forecast");

        var forecasts = ForecastService.getForecasts(city);

        var forecastViewModel = new ForecastViewModel();
        forecastViewModel.forecastList = forecasts;
        forecastViewModel.selectedCity = city;

        modelAndView.addObject("forecastViewModel", forecastViewModel);

        return modelAndView;
    }
}

