package meteorology.meteoapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class UserEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Setter
    @Column(nullable = false, unique = true)
    public String username;
    @Setter
    @Column(nullable = false)
    public String password;
    @Column
    public String role;

}
