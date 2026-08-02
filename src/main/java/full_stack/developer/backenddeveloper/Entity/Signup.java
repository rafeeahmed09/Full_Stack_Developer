package full_stack.developer.backenddeveloper.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.Instant;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "Signup_Authentication"
)
public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Signup_id")
    private Long id;
    @Column(name = "Signup_email" , unique = true, length = 300, nullable = false)
    private String email;
    @Column(name = "Signup_name", length = 200)
    private String name;
    @Column(name = "Signup_Password" , unique = true, nullable = false)
    private String password;
    private String image;
    private boolean enable = true;
    private Instant createdAT  = Instant.now();
    private Instant updateAT  = Instant.now();
    @Enumerated(EnumType.STRING)
    private  Provider provider = Provider.LOCAL;

    @Enumerated(EnumType.STRING)
    private Role Roles;

    @PrePersist
    protected void OnCreate() {

        createdAT = Instant.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updateAT = Instant.now();
    }


}
