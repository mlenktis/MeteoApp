package meteorology.meteoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/public", "/", "/js/**", "/css/**", "/register", "/saveForecast")
                        .permitAll() //leidžiami puslapiai be prisijungimo
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login") //jei norim naudoti default login puslapį šitą uždiseiblinam
                        .permitAll()

                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("SHA-1");
    }

}