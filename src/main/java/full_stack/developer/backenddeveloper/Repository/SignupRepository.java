package full_stack.developer.backenddeveloper.Repository;


import full_stack.developer.backenddeveloper.Entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<Signup,Long> {
    boolean existsByemail(String email);

    boolean existsByEmail(String email);
}
