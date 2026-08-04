package full_stack.developer.backenddeveloper.Service.Auth;

import full_stack.developer.backenddeveloper.DTO.SignupDto;
import full_stack.developer.backenddeveloper.Service.SignupService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthServices implements AuthServiceable {

    private final SignupService signupService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public SignupDto signup(SignupDto signupDto) {
        if (signupDto == null || signupDto.getPassword() == null || signupDto.getPassword().isBlank()) {
            throw new IllegalArgumentException("Signup request or password must not be null/blank");
        }

        String encodedPassword = passwordEncoder.encode(signupDto.getPassword());
        signupDto.setPassword(encodedPassword);

        SignupDto createdSignup = signupService.createNewSignup(signupDto);

        if (createdSignup == null) {
            throw new IllegalStateException("Signup service returned null result");
        }

        createdSignup.setPassword(null);

        return createdSignup;
    }
}
