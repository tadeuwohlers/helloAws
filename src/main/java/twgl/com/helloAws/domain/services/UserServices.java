package twgl.com.helloAws.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import twgl.com.helloAws.domain.entities.User;
import twgl.com.helloAws.domain.repositories.IUserRepository;

@Service
public class UserServices implements UserDetailsService {
    
    @Autowired
    IUserRepository repository;

    public UserServices(IUserRepository repository) {
        this.repository = repository;
    }
   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // return null;
        
        User user = repository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

}