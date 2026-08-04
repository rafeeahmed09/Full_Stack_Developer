package full_stack.developer.backenddeveloper.Controller;


import full_stack.developer.backenddeveloper.DTO.SignupDto;
import full_stack.developer.backenddeveloper.Service.Auth.AuthServices;
import full_stack.developer.backenddeveloper.Service.SignupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class PublicController {

    private final SignupService signupService;
    private final AuthServices services;

    @PostMapping("/register")
    public ResponseEntity<SignupDto> register(@RequestBody SignupDto signupDto) {
      SignupDto result = services.signup(signupDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @DeleteMapping("/name/{Name}")
    public ResponseEntity<Void> deletedSignup(@PathVariable("Name") String name) {
        signupService.deleteByName(name);
        return ResponseEntity.noContent().build();

    }
}