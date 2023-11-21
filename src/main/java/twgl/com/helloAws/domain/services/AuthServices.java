package twgl.com.helloAws.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import twgl.com.helloAws.domain.dtos.security.AccountCredentialsDTO;
import twgl.com.helloAws.domain.dtos.security.TokenDTO;
import twgl.com.helloAws.domain.repositories.IUserRepository;
import twgl.com.helloAws.domain.services.security.JwtTokenProvider;

@Service
public class AuthServices {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private IUserRepository repository;

    public ResponseEntity signin(AccountCredentialsDTO data) {
        
        try {
            String username = data.getUsername();
            String password = data.getPassword();
            
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            
            var user = repository.findByUsername(username);

            var tokenResponse = new TokenDTO();

            if (user != null) {
                tokenResponse = tokenProvider.createAccessToken(user.getUserName(), user.getRoles());
            }
            else {
                throw new Exception("User not found");
            }

            return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}