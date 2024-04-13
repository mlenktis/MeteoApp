package meteorology.meteoapp.entities;

import jakarta.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, unique = true)
    public String username;

    public String password;
}
