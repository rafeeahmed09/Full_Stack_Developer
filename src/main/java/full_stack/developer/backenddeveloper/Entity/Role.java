package full_stack.developer.backenddeveloper.Entity;


import java.util.Optional;

public enum Role {

    USER("USER"),
    ADMIN("ADMIN");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
