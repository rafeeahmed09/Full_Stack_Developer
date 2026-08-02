package full_stack.developer.backenddeveloper.Service;


import full_stack.developer.backenddeveloper.DTO.SignupDto;
import full_stack.developer.backenddeveloper.Entity.Provider;
import full_stack.developer.backenddeveloper.Entity.Signup;
import full_stack.developer.backenddeveloper.Exception.DuplicateResourceException;
import full_stack.developer.backenddeveloper.Exception.ResourceNotFoundException;
import full_stack.developer.backenddeveloper.Repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SignupService {

   private final SignupRepository signupRepository;
   private final ModelMapper mapper;

    public SignupService(SignupRepository signupRepository, ModelMapper mapper) {
        this.signupRepository = signupRepository;
        this.mapper = mapper;
    }

    @Transactional
    public SignupDto createSignups(SignupDto signupDto) {

        if (signupDto.getEmail() == null || signupDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (signupRepository.existsByEmail(signupDto.getEmail())) {
            throw new DuplicateResourceException(
                    "Email already exists: " + signupDto.getEmail());
        }

        Signup signup = mapper.map(signupDto, Signup.class);

        signup.setProvider(
                signupDto.getProvider() != null
                        ? signupDto.getProvider()
                        : Provider.LOCAL
        );

        Signup savedSignup = signupRepository.save(signup);

        return mapper.map(savedSignup, SignupDto.class);
    }

    public SignupDto getPatientById(Long id){
        Signup signup = signupRepository.findById(id)
                .orElseThrow(()
                -> new ResourceNotFoundException("User not found with given id"));

        return mapper.map(signup,SignupDto.class);
    }
}
