package meteorology.meteoapp.controllers;

import meteorology.meteoapp.entities.UserEntity;
import meteorology.meteoapp.services.UserService;
import meteorology.meteoapp.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword) {

        if (PasswordValidator.isValid(password, confirmPassword)) {
            var user = new UserEntity();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            userService.save(user);
            return "redirect:/login";
        } else {
            return "redirect:/register";

        }
    }
}
