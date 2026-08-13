package full_stack.developer.backenddeveloper.Controller;



import full_stack.developer.backenddeveloper.DTO.LoginRequest;
import full_stack.developer.backenddeveloper.Entity.RefreshToken;
import full_stack.developer.backenddeveloper.Entity.Signup;
import full_stack.developer.backenddeveloper.Repository.RefreshTokenRepository;
import full_stack.developer.backenddeveloper.Repository.SignupRepository;
import full_stack.developer.backenddeveloper.Security.CookieService;
import full_stack.developer.backenddeveloper.Security.JWTServicer;
import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;
import full_stack.developer.backenddeveloper.DTO.SignupDto;
import full_stack.developer.backenddeveloper.DTO.TokenResponse;
import full_stack.developer.backenddeveloper.Service.Auth.AuthServices;
import full_stack.developer.backenddeveloper.Service.SignupService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class PublicController {

    private final SignupService signupService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper mapper;
    private final AuthServices services;
    private final CookieService cookieService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JWTServicer servicer;
    private final SignupRepository signupRepository;

    @PostMapping("/register")
    public ResponseEntity<SignupDto> register(@RequestBody SignupDto signupDto) {
      SignupDto result = services.signup(signupDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
//    @PostMapping("/Login")
//    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request){
//        Authentication authentication = autheticate(loginRequest);
//        Signup signup = signupRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new BadCredentialsException("Invalid Username or Password"));
//        if (!signup.isEnable()){
//            throw new DisabledException("User  is  disabled");
//        }
//        String Jti = UUID.randomUUID().toString();
//        var refreshToken = RefreshToken.builder()
//                .jti(Jti)
//                .signup(signup)
//                .createdAt(Instant.now())
//                .expiredAt(Instant.now())
//                .revoked(false)
//                .build();
//        refreshTokenRepository.save(refreshToken);
//        String accessToken =
//        return null;
//    }

    private Authentication autheticate(LoginRequest loginRequest) {
        try {
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.email(),
                            loginRequest.password()
                    )
            );
        }catch (BadCredentialsException ex){
            throw  new BadCredentialsException("Invalid  username or password");
        }
    }

    @DeleteMapping("/name/{Name}")
    public ResponseEntity<Void> deletedSignup(@PathVariable("Name") String name) {
        signupService.deleteByName(name);
        return ResponseEntity.noContent().build();

    }
}