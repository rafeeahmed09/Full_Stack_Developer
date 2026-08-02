package full_stack.developer.backenddeveloper.Controller;


import full_stack.developer.backenddeveloper.DTO.SignupDto;
import full_stack.developer.backenddeveloper.Service.SignupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @PostMapping("/Signup")
    public ResponseEntity<SignupDto> createSignup(@RequestBody
                                                    SignupDto signupDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
               signupService.createSignups(signupDto)
        );
    }
    @GetMapping("/{Id}")
    public ResponseEntity<SignupDto> getById(@PathVariable("Id") Long Id){
        SignupDto signupDto = signupService.getPatientById(Id);
        return ResponseEntity.ok(signupDto);
    }



}
