package full_stack.developer.backenddeveloper.Controller;

import full_stack.developer.backenddeveloper.Entity.Roles;
import full_stack.developer.backenddeveloper.Service.RolesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private final RolesService rolesService;


    public RoleController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping("/Roles-Line")
    public ResponseEntity<String> addRole(@RequestBody Roles role) {
        rolesService.addRole(role);
        return ResponseEntity.ok("DONE");
    }
}
