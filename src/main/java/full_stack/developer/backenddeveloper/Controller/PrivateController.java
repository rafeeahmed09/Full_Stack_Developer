package full_stack.developer.backenddeveloper.Controller;

import full_stack.developer.backenddeveloper.DTO.SignupDto;
import full_stack.developer.backenddeveloper.Service.SignupService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v2/admin")
@AllArgsConstructor
public class PrivateController {

    private final SignupService signupService;

    @GetMapping("/id/{id}")
    public ResponseEntity<SignupDto> getById(@PathVariable("id") Long id) {
        SignupDto signupDto = signupService.getSignupById(id);
        return ResponseEntity.ok(signupDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SignupDto>> getAllSignupUsers() {
        return ResponseEntity.ok(signupService.getAllSignup());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SignupDto> getUserByName(@PathVariable("name") String name) {
        SignupDto signupDto = signupService.getByName(name);
        return ResponseEntity.ok(signupDto);
    }
}