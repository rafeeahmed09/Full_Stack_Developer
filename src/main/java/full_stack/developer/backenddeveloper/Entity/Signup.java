package full_stack.developer.backenddeveloper.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "Signup_Authentication"
)
public class Signup implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Signup_id")
    private Long id;
    @Column(name = "Signup_email" , unique = true, length = 300, nullable = false)
    private String email;
    @Column(name = "Signup_name", length = 200)
    private String name;
    @Column(name = "Signup_Password" ,  nullable = false)
    private String password;
    private String image;
    private boolean enable = true;
    private Instant createdAT  = Instant.now();
    private Instant updateAT  = Instant.now();
    @Enumerated(EnumType.STRING)
    private  Provider provider = Provider.LOCAL;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @PrePersist
    protected void OnCreate() {

        createdAT = Instant.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updateAT = Instant.now();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }
}
