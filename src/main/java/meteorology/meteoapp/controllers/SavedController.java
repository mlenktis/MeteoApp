package meteorology.meteoapp.controllers;

import meteorology.meteoapp.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SavedController {
    @Autowired
    private ForecastRepository forecastRepository;
    @GetMapping("/saved")
    public ModelAndView index() {
        var modelAndView = new ModelAndView("saved");
        var model = forecastRepository.findAll();

        modelAndView.addObject("saved", model);
        return  modelAndView;
    }
}
