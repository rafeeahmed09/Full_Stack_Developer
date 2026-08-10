package full_stack.developer.backenddeveloper.Security;


import full_stack.developer.backenddeveloper.Entity.Role;
import full_stack.developer.backenddeveloper.Entity.Signup;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
@Getter
@Setter
public class JWTServicer {

    private final SecretKey key;
    private final  long accessTelSeconds;
    private final long refreshTtlSeconds;
    private final String issuer;

    public JWTServicer(
            @Value("${security.jwt.secret}") String secret,
            @Value("${security.jwt.access-ttl-seconds}") long accessTelSeconds,
            @Value("${security.jwt.refresh-ttl-seconds}")long refreshTtlSeconds,
            @Value("${security.jwt.issuer}") String issuer) {

        if(secret==null || secret.length()<64){
            throw  new IllegalArgumentException("Invalid secret");
        }
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.accessTelSeconds = accessTelSeconds;
        this.refreshTtlSeconds = refreshTtlSeconds;
        this.issuer = issuer;
    }

    // TODO: Generate a Token
    public String generateToken(Signup signup) {

        Instant now = Instant.now();
        List<String> roles = signup.getRole() == null
                ? List.of()
                : List.of(signup.getRole().name());

        return Jwts.builder()
                        .subject(signup.getId().toString())
                        .issuer(issuer)
                        .issuedAt(Date.from(now))
                        .expiration(Date.from(now.plusSeconds(accessTelSeconds)))
                        .claims(Map.of(
                                "email",signup.getEmail(),
                                "roles",roles,
                                "typ","access"
                        ))
                        .signWith(key, SignatureAlgorithm.HS512)
                        .compact();
    }
}
