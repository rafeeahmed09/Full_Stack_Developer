package full_stack.developer.backenddeveloper.Controller;

import full_stack.developer.backenddeveloper.Service.SignupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/AMEND")
@AllArgsConstructor
public class SignupControllers {

    @Autowired
    private final SignupService signupService;
}
