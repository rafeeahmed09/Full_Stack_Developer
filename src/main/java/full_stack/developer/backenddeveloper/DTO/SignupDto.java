package full_stack.developer.backenddeveloper.DTO;

import full_stack.developer.backenddeveloper.Entity.Provider;
import full_stack.developer.backenddeveloper.Entity.Role;
import jakarta.persistence.*;

import java.time.Instant;

public class SignupDto {

    private Long id;
    private String email;
    private String name;
    private String password;
    private String image;
    private boolean enable = true;
    private Instant createdAT  = Instant.now();
    private Instant updateAT  = Instant.now();
    private Provider provider = Provider.LOCAL;
    private Role Roles;

    public SignupDto(Long id, String email, String name, String password, String image, boolean enable, Instant createdAT, Instant updateAT, Provider provider, Role roles) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.image = image;
        this.enable = enable;
        this.createdAT = createdAT;
        this.updateAT = updateAT;
        this.provider = provider;
        Roles = roles;
    }

    public SignupDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Instant getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(Instant createdAT) {
        this.createdAT = createdAT;
    }

    public Instant getUpdateAT() {
        return updateAT;
    }

    public void setUpdateAT(Instant updateAT) {
        this.updateAT = updateAT;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Role getRoles() {
        return Roles;
    }

    public void setRoles(Role roles) {
        Roles = roles;
    }
}
