package full_stack.developer.backenddeveloper.Security;

import full_stack.developer.backenddeveloper.Entity.Signup;
import full_stack.developer.backenddeveloper.Repository.SignupRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final SignupRepository signupRepository;

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        Signup signup = signupRepository.findByEmail(Email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));


        System.out.println("Email      : " + signup.getEmail());
        System.out.println("Role       : " + signup.getRole());
        System.out.println("PasswordDB : " + signup.getPassword());
        return User.builder()
                .username(signup.getEmail())
                .password(signup.getPassword())
                .roles(signup.getRole().name())
                .build();

    }
}
